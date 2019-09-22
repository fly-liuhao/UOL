/**
* @项目名称: UOLMyBatis
* @文件名称: UserMapper.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import com.ychs.uol.model.User;

/**
 * UserMapper接口
 * 
 * @author: liuhao
 * @version 1.0
 */
public interface UserMapper {

    /**
     * 登陆验证
     * 
     * @param userName 用户名
     * @param userPwd  用户密码
     * @return 返回查询到的User对象
     */
    public User checkUser(@Param("userName") String userName, @Param("userPwd") String userPwd);

    /**
     * 添加用户
     * 
     * @param user 封装的用户对象
     * @return 添加成功返回1,失败返回0
     */
    public int insertUser(User user);

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
     * 根据用户名查询用户
     * 
     * @param userName 用户名
     * @return 查询到的User对象
     */
    public User selectUserByName(String userName);

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
     * 查询用户并分页显示 方式一：使用MyBatis自带分页类
     * 
     * @param rowBounds (MyBatis自带分页类对象)
     * @return 含有一页数据的集合
     */
    public List<User> selectUserPage(RowBounds rowBounds);

    /**
     * 查询用户并分页显示 方式二：自己写SQL
     * 
     * @param begin 开始的记录序号
     * @param end   结束的记录序号
     * @return 查询到的用户集合
     */
    public List<User> selectUserPageSql(int begin, int end);

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
     * 查询用户--模糊查询
     * 
     * @param userName 用户名（可能名字不全）
     * @return 查询到的用过户结果集
     */
    public List<User> selectUserLike(String userName);

    /**
     * 动态包含需要更新的列
     * 
     * @param map 查询条件
     * @return 修改成功返回非0数据，失败返回0
     */
    public int updateUserIfNecessary(Map<String, Object> map);

    /**
     * 得到user表中的记录总条数
     * 
     * @return user表中的总记录条数
     */
    public int getUserRecordNum();

}
