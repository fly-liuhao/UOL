/**
* @项目名称: UOLMyBatis
* @文件名称: UserDao.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.ychs.uol.mapper.UserMapper;
import com.ychs.uol.model.User;
import com.ychs.uol.util.DBUtil;
import com.ychs.uol.util.MyMD5Util;

/**
 * UserDao类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class UserDao {

    /**
     * 登陆验证
     * 
     * @param userName 用户名
     * @param userPwd  用户密码
     * @return 登陆成更返回true,失败返回false
     */
    public boolean checkUser(String userName, String userPwd) {
        boolean result = false;

        SqlSession sqlSession = DBUtil.getSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.checkUser(userName, userPwd);
            if (user != null) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return result;
    }

    /**
     * 添加用户
     * 
     * @param user 封装的用户对象
     * @return 添加成功返回1,失败返回0
     */
    public int inserUser(User user) {
        int result = 0;
        SqlSession sqlSession = null;

        try {
            /** 获取工厂 */
            sqlSession = DBUtil.getSession();
            // 获取UserMapper映射接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 对密码进行加密
            String userPwd = user.getUserPwd();
            user.setUserPwd(MyMD5Util.getEncryptedPwd(userPwd));
            // 调用接口中的方法
            result = userMapper.insertUser(user);
            // 提交事务commit
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            sqlSession.close();
        }

        return result;
    }

    /**
     * 删除用户
     * 
     * @param userId 用户ID
     * @return 删除成功返回1，失败返回0
     */
    public int deleteUser(String userId) {
        int result = 0;
        SqlSession sqlSession = DBUtil.getSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            result = userMapper.deleteUser(userId);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return result;
    }

    /**
     * 根据用户ID查询用户
     * 
     * @param userId 用户ID
     * @return 查询到的User对象
     */
    public User selectUserById(String userId) {
        User user = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            user = userMapper.selectUserById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return user;
    }

    /**
     * 根据用户名查询用户
     * 
     * @param userName 用户名
     * @return 查询到的User对象
     */
    public User selectUserByName(String userName) {
        User user = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            user = userMapper.selectUserByName(userName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }
        return user;
    }

    /**
     * 查询所有用户
     * 
     * @return 查询到的用户集合
     */
    public List<User> selectAllUser() {
        List<User> userList = new ArrayList<User>();
        SqlSession sqlSession = DBUtil.getSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userList = userMapper.selectAllUser();
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return userList;
    }

    /**
     * 修改用户
     * 
     * @param user 修改后的用户对象
     * @return 修改成功返回1， 失败返回0
     */
    public int modifyUser(User user) {
        int result = 0;
        SqlSession sqlSession = DBUtil.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            result = userMapper.modifyUser(user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }
        return result;
    }

    /**
     * 禁用户用
     * 
     * @param userId 用户ID
     * @return 禁用成功返回1， 失败返回0
     */
    public int banUser(String userId) {
        int result = 0;
        SqlSession sqlSession = DBUtil.getSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            result = userMapper.banUser(userId);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }
        return result;
    }

    /**
     * 查询用户并分页显示 方式一：使用MyBatis
     * 
     * @param currPage 当前页码（从1开始）
     * @param pageSize 每页的记录个数
     * @return 查询到的用户集合
     */
    public List<User> selectUserPage(int currPage, int pageSize) {
        List<User> userList = new ArrayList<User>();
        SqlSession sqlSession = DBUtil.getSession();
        // 偏移量，当前页第一条记录的序号（从0开始）
        int offset = (currPage - 1) * pageSize;
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userList = userMapper.selectUserPage(new RowBounds(offset, pageSize));
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return userList;
    }

    /**
     * 查询用户并分页显示 方式二：自己写SQL
     * 
     * @param currPage 当前页码（从1开始）
     * @param pageSize 每页的记录个数
     * @return 查询到的用户集合
     */
    public List<User> selectUserPageSql(int currPage, int pageSize) {
        List<User> userList = new ArrayList<User>();
        SqlSession sqlSession = DBUtil.getSession();
        // 当前页第一条记录的序号（从1开始）
        int begin = (currPage - 1) * pageSize + 1;
        // 当前页最后一条记录的序号
        int end = begin + (pageSize - 1);
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userList = userMapper.selectUserPageSql(begin, end);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return userList;
    }

    /**
     * 主键自增
     * 
     * @param user 用户对象
     * @return 添加成功返回1，失败返回0
     */
    public int insertUserKeyAutoInc(User user) {
        int result = 0;
        SqlSession sqlSession = DBUtil.getSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            result = userMapper.insertUserKeyAutoInc(user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return result;
    }

    /**
     * 批量删除用户
     * 
     * @param useridList 用户ID集合
     * @return 删除成功返回1，失败返回0
     */
    public int deleteUserBatch(List<String> useridList) {
        int result = 0;
        SqlSession sqlSession = DBUtil.getSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            result = userMapper.deleteUserBatch(useridList);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }
        return result;
    }

    /**
     * 多条件查询，（只能使用一个条件） 按用户名、真实姓名、性别组合查询，使用动态SQL中的choose
     * 
     * @param map Map集合
     * @return 查询到的用户集合
     */
    public List<User> selectUserMulCondition(Map<String, Object> map) {
        List<User> userList = new ArrayList<User>();
        SqlSession sqlSession = DBUtil.getSession();

        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userList = userMapper.selectUserMulCondition(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }
        return userList;
    }

    /**
     * 查询用户--模糊查询
     * 
     * @param userName 用户名（可能名字不全）
     * @return 查询到的用过户结果集
     */
    public List<User> selectUserLike(String userName) {
        List<User> userList = new ArrayList<User>();
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userList = userMapper.selectUserLike(userName);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return userList;
    }

    /**
     * 动态包含需要更新的列
     * 
     * @param map 查询条件
     * @return 修改成功返回非0数据，失败返回0
     */
    public int updateUserIfNecessary(Map<String, Object> map) {
        int result = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            result = userMapper.updateUserIfNecessary(map);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return result;
    }

    /**
     * 得到user表中的记录总条数
     * 
     * @return user表中总记录条数
     */
    public int getUserRecordNum() {
        int recordNum = 0;
        SqlSession sqlSession = null;
        
        try {
            sqlSession = DBUtil.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            recordNum = userMapper.getUserRecordNum();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return recordNum;
    }

}
