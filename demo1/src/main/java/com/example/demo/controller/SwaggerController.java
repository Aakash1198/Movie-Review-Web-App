package com.example.demo.controller;
import cn.hutool.json.JSONObject;
import com.example.demo.Sql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/swagger")
// CORS POLICY
@CrossOrigin


@Api(value = "interfaces")
public class SwaggerController {


    @Autowired
    private Sql find_tv_show;
    @PostMapping("/find_tv_show")
    @ApiOperation(value = "test")

    public JSONObject find_tv_show(Integer media_type){
        JSONObject message=find_tv_show.get_tv_show_info(media_type);
        return message;
    }

    @Autowired
    private Sql register_func;
    @PostMapping("/register")
    @ApiOperation(value = "test")

    public JSONObject register_fuc(String user_name,String user_password,String user_email, String user_phone){
        JSONObject message=register_func.register(user_name,user_password,user_email,user_phone);
        return message;
    }

    @Autowired
    private Sql login;
    @PostMapping("/login")
    @ApiOperation(value = "test")

    public JSONObject login(String user_email,String user_password){
        JSONObject message=login.login_fuc(user_email,user_password);
        return message;
    }

    @Autowired
    private Sql comment1;
    @PostMapping("/comment")
    @ApiOperation(value = "test")

    public JSONObject comment1(Integer user_id,String comment,String media_id,Integer comment_type,Integer father_id){
        JSONObject message=comment1.comment_fuc(user_id,comment,media_id,comment_type,father_id);
        return message;
    }

    @Autowired
    private Sql get_comment_by_mediaid;
    @PostMapping("/get_comment_by_mediaid")
    @ApiOperation(value = "test")

    public JSONObject get_comment_by_mediaid(Integer media_id){
        JSONObject message=get_comment_by_mediaid.get_movie_comment(media_id);
        return message;
    }

    @Autowired
    private Sql get_comment_by_userid;
    @PostMapping("/get_comment_by_userid")
    @ApiOperation(value = "test")

    public JSONObject get_comment_by_userid(Integer user_id){
        JSONObject message=get_comment_by_userid.get_user_comment(user_id);
        return message;
    }

    @Autowired
    private Sql update_user_information;
    @PostMapping("/update_user_information")
    @ApiOperation(value = "test")

    public JSONObject update_user_information(Integer user_id,String user_name,String user_password,String user_email, String user_nickname, String introduction){
        JSONObject message=update_user_information.update_user(user_id,user_name,user_password,user_email,user_nickname,introduction);
        return message;
    }
}