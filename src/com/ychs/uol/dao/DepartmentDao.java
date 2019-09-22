/**
* @项目名称: UOLMyBatis
* @文件名称: DepartmentDao.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ychs.uol.mapper.DepartmentMapper;
import com.ychs.uol.model.Department;
import com.ychs.uol.util.DBUtil;

/**
 * DepartmentDao类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class DepartmentDao {

    /**
     * 添加院系
     * 
     * @param department 封装的院系对象
     * @return 添加成功返回1, 失败返回0
     */
    public int insertDepartment(Department department) {
        int result = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            result = departmentMapper.insertDepartment(department);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return result;
    }

    /**
     * 查询院系
     * 
     * @param map 查询条件
     * @return 返回查询出来的院系对象集合
     */
    public List<Department> selectDepartment(Map<String, Object> map) {
        SqlSession sqlSession = null;
        List<Department> departmentList = null;

        try {
            sqlSession = DBUtil.getSession();
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            departmentList = departmentMapper.selectDepartment(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return departmentList;
    }

}
