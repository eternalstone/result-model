package com.example.result.controller;

import com.example.result.annotation.ResponseResult;
import com.example.result.model.ResultModel;
import com.example.result.pojo.User;
import org.springframework.web.bind.annotation.*;


/**
 * @Author lijiangzhou
 * @Date 2019/5/29  11:37
 * @ClassName: UserController
 * @Description: TODO
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping()
    public ResultModel<User> getUser(@RequestParam Long id){
        if(id == null){
            return ResultModel.failure("id不能为空",null);
        }
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setGender("男");
        user.setAge(24);
        user.setSchool("武汉大学");
        return ResultModel.success("查询成功",user);
    }

    @ResponseResult
    @GetMapping("/get")
    public User getUsers(){
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setGender("男");
        user.setAge(24);
        user.setSchool("武汉大学");
        return user;
    }


}
