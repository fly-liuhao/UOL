/**
* @项目名称: UOLMyBatis
* @文件名称: SchoolDao.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ychs.uol.mapper.DepartmentMapper;
import com.ychs.uol.mapper.MajorMapper;
import com.ychs.uol.mapper.SchoolMapper;
import com.ychs.uol.model.School;
import com.ychs.uol.util.DBUtil;

/**
 * 
 * @author: liuhao
 * @version 1.0
 */
public class SchoolDao {

    /**
     * 添加院校
     * 
     * @param school 封装学校实体
     * @return 添加成功返回1, 失败返回0
     */
    public int insertSchool(School school) {
        int result = 0;
        SqlSession sqlSesson = null;

        try {
            sqlSesson = DBUtil.getSession();
            SchoolMapper schoolMapper = sqlSesson.getMapper(SchoolMapper.class);
            result = schoolMapper.insertSchool(school);
            sqlSesson.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSesson.close();
        }

        return result;
    }

    /**
     * 删除学校
     * 
     * @param schoolName 学校名称
     * @return 删除成功返回1， 失败返回0
     */
    public int deleteSchool(String schoolName) {
        int result = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            SchoolMapper schoolMapper = sqlSession.getMapper(SchoolMapper.class);
            DepartmentMapper departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
            MajorMapper majorMapper = sqlSession.getMapper(MajorMapper.class);
            majorMapper.deleteMajor(schoolName);
            departmentMapper.deleteDepartment(schoolName);
            result = schoolMapper.deleteSchool(schoolName);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }
        return result;
    }

    /**
     * 删除学校，通过触发器
     * 
     * @param schoolName 学校名称
     * @return 删除成功返回1， 失败返回0
     */
    public int deleteSchoolByTrigger(String schoolName) {
        int result = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            SchoolMapper schoolMapper = sqlSession.getMapper(SchoolMapper.class);
            result = schoolMapper.deleteSchool(schoolName);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }
        return result;
    }

    /**
     * 查询学校
     * 
     * @param map 查询条件
     * @return 查询到的学校对象集合
     */
    public List<School> selectSchool(Map<String, Object> map) {
        List<School> schoolList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            SchoolMapper schoolMapper = sqlSession.getMapper(SchoolMapper.class);
            schoolList = schoolMapper.selectSchool(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return schoolList;
    }
}
