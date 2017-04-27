package xyz.vimtools.share.dao;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import xyz.vimtools.share.domain.mapper.UserMapper;
import xyz.vimtools.share.domain.model.User;
import xyz.vimtools.share.domain.model.UserExample;
import xyz.vimtools.share.global.code.UserCode;
import xyz.vimtools.share.global.exception.ExceptionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-4-25
 */

@Repository
public class UserDao {

    @Resource
    private UserMapper userMapper;

    public String insert(User user) {
        //这里设置了数据库email唯一，所以在插入时要捕获email不唯一的异常
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            ExceptionUtils.throwResponseException(UserCode.HAVE_EXIST);
        }
        return user.getId();
    }

    public User selectById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User selectByEmail(String email) {

        UserExample userExample = new UserExample();
        userExample.createCriteria().andEmailEqualTo(email);
        List<User> userList = userMapper.selectByExample(userExample);
        if (!CollectionUtils.isEmpty(userList)) {
            return userList.get(0);
        }
        return null;
    }
}
