package xyz.vimtools.share.domain.model.ext;

import java.util.List;

/**
 * 区域类Dto
 *
 * @author zhangzheng
 * @version 1.0
 * @since 2017-12-5
 */
public class AreaDto {

    private String code;

    private String name;

    private String type;

    private List<AreaDto> areaList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AreaDto> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<AreaDto> areaList) {
        this.areaList = areaList;
    }
}
