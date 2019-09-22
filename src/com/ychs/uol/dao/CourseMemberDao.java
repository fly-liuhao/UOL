/**
* @项目名称: UOLMyBatis
* @文件名称: CourseMemberDao.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ychs.uol.mapper.CourseMemberMapper;
import com.ychs.uol.model.CourseMember;
import com.ychs.uol.util.DBUtil;

/**
 * CourseMember类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class CourseMemberDao {

    /**
     * 登记公开课人员
     * 
     * @param courseMember 封装的公开课人员对象
     * @return 添加成功返回1,失败返回0
     */
    public int insertCourseMember(CourseMember courseMember) {
        int result = 0;
        SqlSession sqlSession = DBUtil.getSession();

        try {
            CourseMemberMapper courseMemberMapper = sqlSession.getMapper(CourseMemberMapper.class);
            result = courseMemberMapper.insertCourseMember(courseMember);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return result;
    }

    /**
     * 查询参加的公开课人员
     * 
     * @param map 查询条件
     * @return 查询出的公开课人员集合
     */
    public List<CourseMember> selectCourseMember(Map<String, Object> map) {
        List<CourseMember> courseMemberList = new ArrayList<CourseMember>();
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            CourseMemberMapper courseMemberMapper = sqlSession.getMapper(CourseMemberMapper.class);
            courseMemberList = courseMemberMapper.selectCourseMember(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return courseMemberList;
    }

}
