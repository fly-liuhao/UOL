/**
* @项目名称: J1012Web
* @文件名称: UserServiceImpl.java
* @Date: 2019年7月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.service;

import java.util.List;
import java.util.Map;

import com.ychs.uol.dao.UserDao;
import com.ychs.uol.model.User;

/**
 * UserService实现类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDao();

    @Override
    public int addUser(User user) {
        int result = userDao.inserUser(user);
        return result;
    }

    @Override
    public boolean checkUser(String userName, String userPwd) {
        boolean result = userDao.checkUser(userName, userPwd);
        return result;
    }

    @Override
    public int deleteUser(String userId) {
        return userDao.deleteUser(userId);
    }

    @Override
    public User selectUserById(String userId) {
        return userDao.selectUserById(userId);
    }

    @Override
    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public int modifyUser(User user) {
        return userDao.modifyUser(user);
    }

    @Override
    public int banUser(String userId) {
        return userDao.banUser(userId);
    }

    @Override
    public List<User> selectUserPage(int currPage, int pageSize) {
        return userDao.selectUserPage(currPage, pageSize);
    }

    @Override
    public List<User> selectUserPageSql(int currPage, int pageSize) {
        return userDao.selectUserPageSql(currPage, pageSize);
    }

    @Override
    public int insertUserKeyAutoInc(User user) {
        return userDao.insertUserKeyAutoInc(user);
    }

    @Override
    public int deleteUserBatch(List<String> useridList) {
        return userDao.deleteUserBatch(useridList);
    }

    @Override
    public List<User> selectUserMulCondition(Map<String, Object> map) {
        return userDao.selectUserMulCondition(map);
    }

    @Override
    public boolean checkUserName(String userName) {
        boolean result = false;
        User user = userDao.selectUserByName(userName);
        if (user != null) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public int getUserRecordNum() {
        return userDao.getUserRecordNum();
    }

}
