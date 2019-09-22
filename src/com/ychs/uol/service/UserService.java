/**
* @项目名称: J1012Web
* @文件名称: UserService.java
* @Date: 2019年7月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.service;

import java.util.List;
import java.util.Map;

import com.ychs.uol.model.User;

/**
 * 业务接口
 * 
 * @author: liuhao
 * @version 1.0
 */
public interface UserService {

    /**
     * 添加用户
     * 
     * @param user 用户对象
     * @return 成功返回1， 失败返回0
     */
    public int addUser(User user);

    /**
     * 登陆验证
     * 
     * @param userName 用户名
     * @param userPwd  用户密码
     * @return 登陆成更返回true,失败返回false
     */
    public boolean checkUser(String userName, String userPwd);

    /**
     * 删除用户
     * 
     * @param userId 用户ID
     * @return 删除成功返回1，失败返回0
     */
    public int deleteUser(String userId);

    /**
     * 根据用户ID查询用户
     * 
     * @param userId 用户ID
     * @return 查询到的User对象
     */
    public User selectUserById(String userId);

    /**
     * 查询所有用户
     * 
     * @return 查询到的用户集合
     */
    public List<User> selectAllUser();

    /**
     * 修改用户
     * 
     * @param user 修改后的用户对象
     * @return 修改成功返回1， 失败返回0
     */
    public int modifyUser(User user);

    /**
     * 禁用户用
     * 
     * @param userId 用户ID
     * @return 禁用成功返回1， 失败返回0
     */
    public int banUser(String userId);

    /**
     * 查询用户并分页显示 方式一：使用MyBatis
     * 
     * @param currPage 当前页码（从1开始）
     * @param pageSize 每页的记录个数
     * @return 查询到的用户集合
     */
    public List<User> selectUserPage(int currPage, int pageSize);

    /**
     * 查询用户并分页显示 方式二：自己写SQL
     * 
     * @param currPage 当前页码（从1开始）
     * @param pageSize 每页的记录个数
     * @return 查询到的用户集合
     */
    public List<User> selectUserPageSql(int currPage, int pageSize);

    /**
     * 增加用户，主键自增
     * 
     * @param user 用户对象
     * @return 添加成功返回1，失败返回0
     */
    public int insertUserKeyAutoInc(User user);

    /**
     * 批量删除用户
     * 
     * @param useridList 用户ID集合
     * @return 删除成功返回1，失败返回0
     */
    public int deleteUserBatch(List<String> useridList);

    /**
     * 多条件查询，（只能使用一个条件） 按用户名、真实姓名、性别组合查询，使用动态SQL中的choose
     * 
     * @param map Map集合
     * @return 查询到的用户集合
     */
    public List<User> selectUserMulCondition(Map<String, Object> map);

    /**
     * 检测用户名是否被占用
     * 
     * @param userName 用户名
     * @return 占用返回true, 没被占用返回0
     */
    public boolean checkUserName(String userName);

    /**
     * 得到user表中的记录总条数
     * 
     * @return user表中总记录条数
     */
    public int getUserRecordNum();

}
