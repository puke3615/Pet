package com.puke.pet;

import com.puke.pet.base.Result;
import com.puke.pet.entity.Dog;
import com.puke.pet.mapper.DogMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zijiao
 * @version 18/4/20
 */
@RestController
public class DogController {

    @Resource
    private DogMapper dogMapper;

    @RequestMapping("/findAll")
    public Result<List<Dog>> findAll() {
        List<Dog> dogs = dogMapper.findAllUsers();
        return Result.success(dogs);
    }

    @RequestMapping(value = "/add")
    public Result<Void> add(Dog dog) {
        System.out.println(dog);
        dogMapper.insert(dog);
        return Result.success();
    }

}
