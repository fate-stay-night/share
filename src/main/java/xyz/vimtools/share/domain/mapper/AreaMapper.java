package xyz.vimtools.share.domain.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import xyz.vimtools.share.domain.model.Area;
import xyz.vimtools.share.domain.model.AreaExample;

public interface AreaMapper {
    @SelectProvider(type=AreaSqlProvider.class, method="countByExample")
    long countByExample(AreaExample example);

    @DeleteProvider(type=AreaSqlProvider.class, method="deleteByExample")
    int deleteByExample(AreaExample example);

    @Delete({
        "delete from area",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into area (code, name, ",
        "type, parent)",
        "values (#{code,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR}, #{parent,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Area record);

    @InsertProvider(type=AreaSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Area record);

    @SelectProvider(type=AreaSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent", property="parent", jdbcType=JdbcType.INTEGER)
    })
    List<Area> selectByExample(AreaExample example);

    @Select({
        "select",
        "id, code, name, type, parent",
        "from area",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="parent", property="parent", jdbcType=JdbcType.INTEGER)
    })
    Area selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AreaSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Area record, @Param("example") AreaExample example);

    @UpdateProvider(type=AreaSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Area record, @Param("example") AreaExample example);

    @UpdateProvider(type=AreaSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Area record);

    @Update({
        "update area",
        "set code = #{code,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=VARCHAR},",
          "parent = #{parent,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Area record);
}