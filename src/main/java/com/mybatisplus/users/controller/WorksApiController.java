package com.mybatisplus.users.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  作品
 * </p>
 *
 * @author jobob
 * @since 2020-12-29
 */
@RestController
@RequestMapping("/works")//springMVC映射处理请求地址
@CrossOrigin//解决跨域问题
public class WorksApiController {
    /**
     * @Author GongXl
     * @Description 获得轮播图
     * @Date 2021/2/18 11:31
     * @Param []
     * @return java.util.List<java.util.Map>
     **/
    @RequestMapping("/swiperImgList")
    public List<Map> swiperImgList(){
        List<Map>  list = new ArrayList<Map>();
        Map img1 = new HashMap();
        img1.put("id","1");
        img1.put("url","");
        img1.put("img","../../static/icon/home-active.png");
        list.add(img1);
        Map img2 = new HashMap();
        img2.put("id","2");
        img2.put("url","");
        img2.put("img","../../static/icon/cart.png");
        list.add(img2);
        Map img3 = new HashMap();
        img3.put("id","3");
        img3.put("url","");
        img3.put("img","../../static/icon/home-active.png");
        list.add(img3);
        return  list;
    }
    /**
     * @Author GongXl
     * @Description 获得作品集列表
     * @Date 2021/2/18 11:32
     * @Param [pageindex]
     * @return java.util.List<java.util.Map>
     **/
    @RequestMapping("/getHotWorksList")
    public List<Map> getHotWorksList(int pageindex){
        Map user1= new HashMap();
        user1.put("name","z3");
        user1.put("age","10");
        Map user2= new HashMap();
        user2.put("name","l4");
        user2.put("age","15");
        Map user3= new HashMap();
        user3.put("name","w5");
        user3.put("age","20");
        List<Map>  userList = new ArrayList<Map>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        return userList;
    }
}

