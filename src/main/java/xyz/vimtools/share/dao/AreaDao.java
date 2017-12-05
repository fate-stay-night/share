package xyz.vimtools.share.dao;

import org.springframework.stereotype.Repository;
import xyz.vimtools.share.domain.mapper.AreaMapper;
import xyz.vimtools.share.domain.model.Area;
import xyz.vimtools.share.domain.model.AreaExample;
import javax.annotation.Resource;
import java.util.List;

/**
 * 区域类Dao层
 *
 * @author zhangzheng
 * @version 1.0
 * @since 2017-12-5
 */
@Repository
public class AreaDao {

    @Resource
    private AreaMapper areaMapper;

    public Area selectById(Integer id) {
        return areaMapper.selectByPrimaryKey(id);
    }

    public List<Area> selectByParent(Integer parent) {
        AreaExample areaExample = new AreaExample();
        if (parent == null) {
            areaExample.createCriteria().andParentIsNull();
        } else {
            areaExample.createCriteria().andParentEqualTo(parent);
        }
        return areaMapper.selectByExample(areaExample);
    }
}
