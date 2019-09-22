/**
* @项目名称: UOLMyBatis
* @文件名称: LabMemberDao.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ychs.uol.mapper.LabMemberMapper;
import com.ychs.uol.model.LabMember;
import com.ychs.uol.util.DBUtil;

/**
 * LabMemberDao类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class LabMemberDao {

    /**
     * 添加实验室成员
     * 
     * @param member 实验室成员对象
     * @return 添加成功返回1, 失败返回0
     */
    public int insertLabMember(LabMember member) {
        int result = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            LabMemberMapper labMemberMapper = sqlSession.getMapper(LabMemberMapper.class);
            result = labMemberMapper.insertLabMember(member);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return result;
    }

    /**
     * 根据成员ID查询实验室成员
     * 
     * @param memberId 成员ID
     * @return 查到实验室成员对象
     */
    public LabMember selectLabMemberById(String memberId) {
        LabMember labMember = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            LabMemberMapper labMemberMapper = sqlSession.getMapper(LabMemberMapper.class);
            labMember = labMemberMapper.selectLabMemberById(memberId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return labMember;
    }

    /**
     * 多条件组合查询，查询实验室成员
     * 
     * @param map 参数集合
     * @return 查询出的集合
     */
    public List<LabMember> selectLabMember(Map<String, Object> map) {
        List<LabMember> labMemberList = new ArrayList<LabMember>();
        SqlSession sqlSession = DBUtil.getSession();

        try {
            LabMemberMapper labMemberMapper = sqlSession.getMapper(LabMemberMapper.class);
            labMemberList = labMemberMapper.selectLabMember(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return labMemberList;
    }

    /**
     * 修改实验室成员信息
     * 
     * @param member 修改信息后的实验室成员对象
     * @return 修改成功返回1，失败返回0
     */
    public int modifyLabMember(LabMember member) {
        int result = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            LabMemberMapper labMemberMapper = sqlSession.getMapper(LabMemberMapper.class);
            result = labMemberMapper.modifyLabMember(member);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return result;
    }

}
