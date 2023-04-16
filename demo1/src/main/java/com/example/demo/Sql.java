package com.example.demo;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.example.demo.classes.comment;
import com.example.demo.classes.movie;
import com.example.demo.classes.tv_shwo;
import com.example.demo.classes.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

@Component
public class Sql {
    @Autowired
    JdbcTemplate jdbcTemplate;
//    update photographer information
    public JSONObject update_photographer(String g_name,String age,String main_style, String sex){
        jdbcTemplate.update("INSERT INTO photographer (g_name,age,main_style,sex)  VALUES(?, ?, ?, ?)",g_name,age,main_style,sex);
        JSONObject res = new JSONObject();
        res.put("msg","SUCCESS");
        res.put("resultCode",200);
        return res;
    }

//    update photo information
    public JSONObject update_album(Integer id,String title,String p_style, Long price){
        jdbcTemplate.update("update album set title=?, p_style=?,price=? where id=?",title,p_style,price,id);
        JSONObject res = new JSONObject();
        res.put("msg","SUCCESS");
        res.put("resultCode",200);
        return res;
    }

//    get all photographers info
    public JSONObject grapher_list() {
        RowMapper<grapher> RM = (RowMapper<grapher>) new BeanPropertyRowMapper(grapher.class);
        List<grapher> Userlist = jdbcTemplate.query("select * from photographer", RM);
        JSONObject res = new JSONObject();
        res.put("result",Userlist);
        res.put("resultCode",200);
        return res;
    }

//    get album information by photo id
    public JSONObject get_album_info(Integer id) {
        RowMapper<album> RM = (RowMapper<album>) new BeanPropertyRowMapper(album.class);
        List<album> Userlist = jdbcTemplate.query("select * from album where id ='" + id + "'", RM);

        JSONObject res = new JSONObject();
        res.put("result",Userlist);
        res.put("resultCode",200);
        return res;
    }

//    get phtographer information by id
    public JSONObject get_grapher_info(Integer id) {
        RowMapper<grapher> RM = (RowMapper<grapher>) new BeanPropertyRowMapper(grapher.class);
        List<grapher> Userlist = jdbcTemplate.query("select * from photographer where id ='" + id + "'", RM);
        JSONObject res = new JSONObject();
        res.put("result",Userlist);
        res.put("resultCode",200);
        return res;
    }

//    获取media数据 0 for Tv show 1 for movie
    public JSONObject get_tv_show_info(Integer media_type) {
        RowMapper<grapher> RM = (RowMapper<grapher>) new BeanPropertyRowMapper(tv_shwo.class);
        if (media_type == 1) {
            RM = (RowMapper<grapher>) new BeanPropertyRowMapper(movie.class);
        }

        //        数据库获取所有电视剧数据
        List<grapher> Userlist = jdbcTemplate.query("select * from media_info where media_type ='" + media_type + "'", RM);
        JSONObject res = new JSONObject();
        res.put("result",Userlist);
        res.put("resultCode",200);
        // Extract list from JSON data
        JSONArray res_arry = res.getJSONArray("result");
        List<JSONObject> res_list = new ArrayList<>();
        for (int i = 0; i < res_arry.size(); i++) {
            res_list.add(res_arry.getJSONObject(i));
        }
// 迭代result list,通过tag id 在 media_tag表中查询对应的tag名
        for (JSONObject res1 : res_list) {
//            获取表中的media_classify
            String tag_ids = res1.getStr("media_classify");
            //            string to list
            String[] arr = tag_ids.split(",");
            List<String> tag_list = Arrays.asList(arr);
//            通过tag_id在media_tag中查询tag_name
            List<String> tags = new ArrayList<>();
            for (int i = 0; i < tag_list.size(); i++) {
                String k= tag_list.get(i);
                String sql = "SELECT tag_name FROM media_tag WHERE tag_id = %s";
                String sql1 = String.format(sql, k);
                String fieldValue = jdbcTemplate.queryForObject(sql1, String.class);
                tags.add(fieldValue);
            }
            //            获取database中的actors
            String actors = res1.getStr("actors");
            //            string to list
            String[] arr_a = actors.split(",");
            List<String> actors_list = Arrays.asList(arr_a);
            //            通过crew_id在media_crew中查询name
            List<String> actor = new ArrayList<>();
            for (int j = 0; j < actors_list.size(); j++) {
                String ac= actors_list.get(j);
                String sql2 = "SELECT name FROM media_crew WHERE crew_id = %s";
                String sql3 = String.format(sql2, ac);
                String actor_name = jdbcTemplate.queryForObject(sql3, String.class);
                actor.add(actor_name);
            }

            //            获取database中的actors
            String directors = res1.getStr("directors");
            //            string to list
            String[] arr_d = directors.split(",");
            List<String> directors_list = Arrays.asList(arr_d);
            //            通过crew_id在media_crew中查询name
            List<String> director = new ArrayList<>();
            for (int j = 0; j < directors_list.size(); j++) {
                String ac= directors_list.get(j);
                String sql2 = "SELECT name FROM media_crew WHERE crew_id = %s";
                String sql3 = String.format(sql2, ac);
                String director_name = jdbcTemplate.queryForObject(sql3, String.class);
                director.add(director_name);
            }
            res1.put("directors",director);
            res1.put("actors",actor);
            res1.put("media_classify",tags);
        }
        res.put("result",res_list);
        return res;
    }

    //    register
    public JSONObject register(String user_name,String user_password,String user_email, String user_phone){
        JSONObject res = new JSONObject();
        try {
            jdbcTemplate.update("INSERT INTO user_info (user_name,user_password,user_email,user_phone)  VALUES(?, ?, ?, ?)",user_name,user_password,user_email,user_phone);
            res.put("msg","success");
            res.put("resultCode",200);
        } catch (Exception ex) {
            res.put("msg","please fill all the information");
            res.put("resultCode",500);
        }
        return res;
    }

    //    login
    public JSONObject login_fuc(String user_email,String user_password){
        JSONObject res = new JSONObject();
            RowMapper<grapher> RM = (RowMapper<grapher>) new BeanPropertyRowMapper(user.class);
            List<grapher> Userlist = jdbcTemplate.query("select * from user_info where user_email ='" + user_email + "' and user_password ='" + user_password + "'   ", RM);
            if (Userlist.size() == 0) {
                res.put("msg","user doesnt exit");
                res.put("resultCode",500);
            }
            else {
                res.put("msg","success");
                res.put("user_information",Userlist);
                res.put("resultCode",200);
            }
        return res;
    }

//    comment function 0 for comment on the movie,1 for comment on the comment
    public JSONObject comment_fuc(Integer user_id,String comment,String media_id,Integer comment_type,Integer father_id){
        JSONObject res = new JSONObject();

        if (comment_type == 0) {
            jdbcTemplate.update("INSERT INTO comments (user_id,comment,media_id,comment_type)  VALUES(?, ?, ?, ?)",user_id,comment,media_id,comment_type);
            res.put("msg","You have successfully commented on the movie");
            res.put("resultCode",200);
        }
        if (comment_type == 1) {
            jdbcTemplate.update("INSERT INTO comments (user_id,comment,media_id,comment_type,father_id)  VALUES(?, ?, ?, ?, ?)",user_id,comment,media_id,comment_type,father_id);
            res.put("msg","You have successfully commented on the comment");
            res.put("resultCode",200);
        }
        return res;
    }

//    get comment by movie id
    public JSONObject get_movie_comment(Integer media_id){
        JSONObject res = new JSONObject();
        RowMapper<grapher> RM = (RowMapper<grapher>) new BeanPropertyRowMapper(comment.class);
        List<grapher> Userlist = jdbcTemplate.query("select * from comments where media_id ='" + media_id + "' and comment_type = 0 ", RM);
        System.out.println(Userlist);
        if (Userlist.size() == 0) {
            res.put("result","there is no comment yet");
            res.put("resultCode",404);
        }
        else {
            res.put("result",Userlist);
            res.put("resultCode",200);
            // Extract list from JSON data
            JSONArray res_arry = res.getJSONArray("result");
            List<JSONObject> res_list = new ArrayList<>();
            for (int i = 0; i < res_arry.size(); i++) {
                res_list.add(res_arry.getJSONObject(i));
            }
// 迭代result list,通过tag id 在 media_tag表中查询对应的tag名
            for (JSONObject res1 : res_list) {
                String comment_id = res1.getStr("comment_id");
//                RowMapper<grapher> RM1 = (RowMapper<grapher>) new BeanPropertyRowMapper(user.class);
                List<grapher> comment_list = jdbcTemplate.query("select * from comments where media_id ='" + media_id + "' and father_id = '" + comment_id + "' ", RM);
                if (comment_list.size() == 0) {
                    List<JSONObject> test = new ArrayList<>();
                    res1.put("sub_comment",test);
                }
                else {
                    res1.put("sub_comment",comment_list);
                    System.out.println("111111");
                }
            }
            res.put("result",res_list);
            res.put("resultCode",200);
        }
        return res;
    }

    //    get comment by user id
    public JSONObject get_user_comment(Integer user_id){
        JSONObject res = new JSONObject();
        RowMapper<grapher> RM = (RowMapper<grapher>) new BeanPropertyRowMapper(comment.class);
        List<grapher> Userlist = jdbcTemplate.query("select * from comments where user_id ='" + user_id + "' ", RM);
        System.out.println(Userlist);
        if (Userlist.size() == 0) {
            res.put("result","there is no comment yet");
            res.put("resultCode",404);
        }
        else {
            res.put("result",Userlist);
            res.put("resultCode",200);
        }
        return res;
    }

    //    update user information
    public JSONObject update_user(Integer user_id,String user_name,String user_password,String user_email, String user_phone, String introduction){
        jdbcTemplate.update("update user_info set user_name=?, user_password=?,user_email=?,user_phone=?,user_intro=? where user_id=?",user_name,user_password,user_email,user_phone,introduction,user_id);
        JSONObject res = new JSONObject();
        res.put("msg","SUCCESS");
        res.put("resultCode",200);
        return res;
    }



}
