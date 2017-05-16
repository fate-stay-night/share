package xyz.vimtools.share.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.vimtools.share.dao.UserDao;
import xyz.vimtools.share.domain.model.User;
import xyz.vimtools.share.domain.model.ext.UserDto;

/**
 * 用户Service层
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-4-25
 */

@Service
@Transactional
public class UserService {

    private static Logger log = LogManager.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    public String addUser(User user) {
        return userDao.insert(user);
    }

    public User findById(String id) {
        return userDao.selectById(id);
    }

    public User findByEmail(String email) {
        return userDao.selectByEmail(email);
    }

    public int modifyUser(User user) {
        return userDao.updateNickName(user);
    }

    public UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        log.info("用户信息 : {}", userDto.toString());
        return userDto;
    }
}
