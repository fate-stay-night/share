package xyz.vimtools.share.domain.model.ext;

import java.util.Date;

/**
 * 用户数据传输对象
 *
 * @author zhangzheng
 * @version 1.0.0
 * @date 2017-5-5
 */
public class UserDto {

    /**
     * 数据库主键UUID（32位）
     */
    private String id;

    /**
     * 用户email
     */
    private String email;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户创建时间
     */
    private Date createTime;

    /**
     * 用户信息更新时间
     */
    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
