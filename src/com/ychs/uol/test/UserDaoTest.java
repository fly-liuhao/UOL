/**
* @项目名称: UOLMyBatis
* @文件名称: UserDaoTest.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.test;

import com.sun.istack.internal.logging.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.ychs.uol.dao.UserDao;
import com.ychs.uol.model.User;

/**
 * UserDao 测试类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class UserDaoTest {
    Logger logger = Logger.getLogger(UserDaoTest.class);
    UserDao userDao = new UserDao();

    /**
     * 测试登陆验证
     */
//  @Test
    public void testCheckUser() {
        String userName = "fly";
        String userPwd = "56224";
        boolean result = userDao.checkUser(userName, userPwd);
        logger.info(result + "");
    }

    /**
     * 测试添加用户
     */
//    @Test
    public void testInsertUser() {
        User user = new User("1988", "李美妍", "deshan", "成德善", "女", "空姐", "fly的朋友");
        int result = userDao.inserUser(user);
        logger.info(result + "");
    }

    /**
     * 测试删除用户
     */
//    @Test
    public void testDeleteUser() {
        int result = userDao.deleteUser("1988");
        logger.info(result + "");
    }

    /**
     * 测试根据用户Id查询用户
     */
//    @Test
    public void testSelectUserId() {
        String userId = "1234";
        User user = userDao.selectUserById(userId);
        System.out.println(user);
        logger.info(user + "");
    }

    /**
     * 测试根据用户名查询用户
     */
//    @Test
    public void testSelectUserName() {
        String userName = "fly";
        User user = userDao.selectUserByName(userName);
        System.out.println(user);
        logger.info(user + "");
    }

    /**
     * 测试查询所有用户
     */
//    @Test
    public void testSelectAllUser() {
        List<User> userList = userDao.selectAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
        logger.info(userList.size() + "");
    }

    /**
     * 测试修改用户
     */
//    @Test
    public void testModifyUser() {
        User user = new User("123", "冬雪雪", "deshan", "成德善", "女", "空姐", "fly的朋友", "1");
        int result = userDao.modifyUser(user);
        logger.info(result + "");
    }

    /**
     * 测试禁用用户
     */
//  @Test
    public void testBanUser() {
        int result = userDao.banUser("1");
        logger.info(result + "");
    }

    /**
     * 测试查询用户，分页显示。 方式一：使用MyBatis自代类RowBounds实现分页
     */
//    @Test
    public void testSelectUserPage() {
        // 当前页号
        int currPage = 5;
        // 每页记录数
        int pageSize = 2;
        List<User> userList = new ArrayList<User>();
        userList = userDao.selectUserPage(currPage, pageSize);
        for (User user : userList) {
            System.out.println(user);
        }

        logger.info(userList.size() + "");
    }

    /**
     * 测试查询用户，分页显示。 方式二：自己写SQL语句
     */
//    @Test
    public void testSelectUserPageSql() {
        List<User> userList = new ArrayList<User>();
        // 当前页号
        int currPage = 5;
        // 每页记录数
        int pageSize = 2;

        userList = userDao.selectUserPageSql(currPage, pageSize);
        for (User user : userList) {
            System.out.println(user);
        }

        logger.info(userList.size() + "");
    }

    /**
     * 测试添加用户，主键自增
     */
//    @Test
    public void testInsertUserKeyAutoInc() {
        User user = new User("李美妍", "deshan", "成德善", "女", "空姐", "fly的朋友", "1");
        int result = userDao.insertUserKeyAutoInc(user);
        logger.info(result + "");
    }

    /**
     * 测试批量删除用户
     */
//    @Test
    public void testDeleteUserBatch() {
        List<String> useridList = new ArrayList<String>();
        useridList.add("666");
        useridList.add("999");
        int result = userDao.deleteUserBatch(useridList);
        logger.info(result + "");
    }

    /**
     * 测试多条件查询用户（只能使用一个条件）
     */
//    @Test
    public void TestSelectUserMulCondition() {
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("userName", "fly");
//        map.put("realName", "张三");
        map.put("sex", "男");
        List<User> userList = userDao.selectUserMulCondition(map);
        for (User user : userList) {
            System.out.println(user);
        }
        logger.info(userList.size() + "");
    }

    /**
     * 查询用户--模糊查询
     */
//    @Test
    public void testSelectUserLike() {
        String userName = "美";
        List<User> userList = userDao.selectUserLike(userName);
        for (User user : userList) {
            System.out.println(user);
        }
        logger.info(userList.size() + "");
    }

    /**
     * 测试动态更新user表
     */
//    @Test
    public void testUpdateUserIfNecessary() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", "123");
        map.put("userName", "冬雪雪");
        map.put("sex", "女");
        map.put("status", "0");
        int result = userDao.updateUserIfNecessary(map);
        logger.info(result + "");
    }

    /*
     * 测试查询user表总记录个数
     */
//    @Test
    public void testGetUserRecordNum() {
        int num = userDao.getUserRecordNum();
        logger.info(num + "");
    }

}
