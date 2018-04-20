package com.puke.pet.mapper;

import com.puke.pet.entity.Dog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zijiao
 * @version 18/4/20
 */
@Mapper
public interface DogMapper {

    @Select("select * from dog where id = #{id}")
    Dog findUserById(@Param("id") String id);

    @Insert("INSERT INTO " +
            "dog(name, age, sex, type) " +
            "VALUES" +
            "(#{dog.name}, #{dog.age}, #{dog.sex}, #{dog.type})")
    int insert(@Param("dog") Dog dog);

    @Select("select * from dog")
    List<Dog> findAllUsers();

}
