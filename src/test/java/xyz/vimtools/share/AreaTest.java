package xyz.vimtools.share;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.vimtools.share.dao.AreaDao;
import xyz.vimtools.share.domain.model.Area;
import xyz.vimtools.share.domain.model.ext.AreaDto;
import xyz.vimtools.share.util.JsonUtils;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

/**
 * 区域测试类
 *
 * @author zhangzheng
 * @version 1.0
 * @since 2017-12-5
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Share.class)
public class AreaTest {

    @Resource
    private AreaDao areaDao;

    @Test
    public void findAreaList() {
        List<Area> areaList = areaDao.selectByParent(null);
        List<AreaDto> areaDtoList = toDto(areaList);
        String string = JsonUtils.objectToJson(areaDtoList);
//        String string = JSON.toJSONString(areaDtoList);
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File("tt.json"))){
            fileOutputStream.write(string.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<AreaDto> toDto(List<Area> areaList) {
        List<AreaDto> areaDtoList = new ArrayList<>();
        areaList.forEach(area -> {
            AreaDto areaDto = new AreaDto();
            List<Area> areas = areaDao.selectByParent(area.getId());
            if (areas != null && areas.size() != 0) {
                areaDto.setAreaList(toDto(areas));
            }
            areaDto.setCode(area.getCode());
            areaDto.setName(area.getName());
            areaDto.setType(area.getType());

            areaDtoList.add(areaDto);
        });
        return areaDtoList;
    }
}
