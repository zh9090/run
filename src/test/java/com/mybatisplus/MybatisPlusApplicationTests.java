package com.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.mapper.UserMapper;
import com.mybatisplus.pojo.User;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void selById() {
        User user = userMapper.selectById(7);
        System.out.println(user);
    }
    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        for (User u:users
             ) {
            System.out.println(u);
        }
        System.out.println(users);
        users.forEach(System.out::println);
    }
    @Test
    void testInsert(){
        User u1 = new User();
        u1.setId("8");
        u1.setName("user1");
        u1.setAge(10);
        u1.setEmail("aaaaafzx@126.com");
        int insert = userMapper.insert(u1);//会自动生成id
        System.out.println(insert);
    }
    @Test
    void testUpdate(){
        User u1 = new User();
        u1.setId("1343509260696289286");
        u1.setName("user2");
        u1.setAge(10);
        u1.setEmail("aaaaafzx@126##########.com");
        int insert = userMapper.updateById(u1);//会自动生成id
        System.out.println(insert);
    }

    //测试乐观锁
    @Test
    public void testOptimisticLockerInnerInterceptor(){
        User user = userMapper.selectById("1");
        user.setEmail("xxxxx@xxx.com");
        int i = userMapper.updateById(user);
    }
    //测试乐观锁抢先执行2
    @Test
    public void testOptimisticLockerInnerInterceptor2(){
        User user = userMapper.selectById("1");
        user.setEmail("xxxxx@xxx11111.com");
        User user2 = userMapper.selectById("1");
        user2.setEmail("xxxxx@xxx222222.com");
        int i2 = userMapper.updateById(user2);
        int i = userMapper.updateById(user);
    }
    //批量查询
    @Test
    public void selByBatchId(){
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }
    //条件查询
    @Test
    public void selByMap(){
        Map m = new HashMap<String,String>();
        m.put("name","user1");
        m.put("age","10");
        List<User> users = userMapper.selectByMap(m);
        users.forEach(System.out::println);
    }
    //分页查询
    @Test
    public void selByPage(){
        Page<User> objectPage = new Page<>(2, 5);
        userMapper.selectPage(objectPage, null);
        List<User> records = objectPage.getRecords();
        records.forEach(System.out::println);
        System.out.println(objectPage.getTotal());
    }
    @Test
    public void deleteById(){
        userMapper.deleteById(7);
    }
    @Test
    public void deleteBatch(){
        userMapper.deleteBatchIds(Arrays.asList(1,2));
        Map m = new HashMap();
        m.put("name","user1");
        userMapper.deleteByMap(m);
    }

    @Test
    public void testQueryWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name")
                .eq("email","aa");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
