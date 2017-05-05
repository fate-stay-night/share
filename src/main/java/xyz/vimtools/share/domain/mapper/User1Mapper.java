package xyz.vimtools.share.domain.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import xyz.vimtools.share.domain.model.User;
import xyz.vimtools.share.domain.model.UserExample;

import java.util.List;

public interface User1Mapper {
    @SelectProvider(type=User1SqlProvider.class, method="countByExample")
    long countByExample(UserExample example);

    @DeleteProvider(type=User1SqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    @Delete({
        "delete from user1",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into user1 (id, email, ",
        "password, nickname)",
        "values (#{id,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{nickname,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT replace(UUID(), '-', '')", keyProperty="id", before=true, resultType=String.class)
    int insert(User record);

    @InsertProvider(type=User1SqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT replace(UUID(), '-', '')", keyProperty="id", before=true, resultType=String.class)
    int insertSelective(User record);

    @SelectProvider(type=User1SqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "id, email, password, nickname",
        "from user1",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(String id);

    @UpdateProvider(type=User1SqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=User1SqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=User1SqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user1",
        "set email = #{email,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "nickname = #{nickname,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);
}