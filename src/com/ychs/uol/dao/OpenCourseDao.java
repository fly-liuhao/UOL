/**
* @项目名称: UOLMyBatis
* @文件名称: OpenCourseDao.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ychs.uol.mapper.OpenCourseMapper;
import com.ychs.uol.model.OpenCourse;
import com.ychs.uol.util.DBUtil;

import oracle.net.aso.l;

/**
 * OpenCourseDao类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class OpenCourseDao {

    /**
     * 录入公开课
     * 
     * @param course 封装的公开课对象
     * @return 添加成功返回1, 失败返回0
     */
    public int insertOpenCourse(OpenCourse course) {
        int result = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            OpenCourseMapper openCourseMapper = sqlSession.getMapper(OpenCourseMapper.class);
            result = openCourseMapper.insertOpenCourse(course);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return result;
    }

    /**
     * 查询公开课
     * 
     * @param map 查询条件
     * @return 查询到的公开课集合
     */
    public List<OpenCourse> selectOpenCourse(Map<String, Object> map) {
        List<OpenCourse> openCourseList = new ArrayList<OpenCourse>();
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            OpenCourseMapper openCourseMapper = sqlSession.getMapper(OpenCourseMapper.class);
            openCourseList = openCourseMapper.selectOpenCourse(map);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return openCourseList;
    }
}
