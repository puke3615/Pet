package com.puke.pet.dao;

import com.puke.pet.entity.Dog;
import com.puke.pet.entity.DogExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface DogMapper {
    @SelectProvider(type=DogSqlProvider.class, method="countByExample")
    long countByExample(DogExample example);

    @DeleteProvider(type=DogSqlProvider.class, method="deleteByExample")
    int deleteByExample(DogExample example);

    @Delete({
        "delete from Dog",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into Dog (id, name, ",
        "age, sex, type)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{age,jdbcType=INTEGER}, #{sex,jdbcType=INTEGER}, #{type,jdbcType=VARCHAR})"
    })
    int insert(Dog record);

    @InsertProvider(type=DogSqlProvider.class, method="insertSelective")
    int insertSelective(Dog record);

    @SelectProvider(type=DogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR)
    })
    List<Dog> selectByExample(DogExample example);

    @Select({
        "select",
        "id, name, age, sex, type",
        "from Dog",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR)
    })
    Dog selectByPrimaryKey(Integer id);

    @UpdateProvider(type=DogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Dog record, @Param("example") DogExample example);

    @UpdateProvider(type=DogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Dog record, @Param("example") DogExample example);

    @UpdateProvider(type=DogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Dog record);

    @Update({
        "update Dog",
        "set name = #{name,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER},",
          "sex = #{sex,jdbcType=INTEGER},",
          "type = #{type,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Dog record);
}