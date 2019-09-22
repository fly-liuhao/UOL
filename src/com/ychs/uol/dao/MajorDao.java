/**
* @项目名称: UOLMyBatis
* @文件名称: MajorDao.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ychs.uol.mapper.MajorMapper;
import com.ychs.uol.model.Info;
import com.ychs.uol.model.Major;
import com.ychs.uol.util.DBUtil;

/**
 * MajorDao类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class MajorDao {

    /**
     * 添加专业
     * 
     * @param major 专业的对象
     * @return 添加成功返回1, 失败返回0
     */
    public int insertMajor(Major major) {
        int result = 0;
        SqlSession sqlSession = DBUtil.getSession();

        try {
            MajorMapper majorMapper = sqlSession.getMapper(MajorMapper.class);
            result = majorMapper.insertMajor(major);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return result;
    }

    /**
     * 查询专业（专业，所属系部，所属的学校）
     * 
     * @param majorName 专业名称
     * @return 查询出的专业信息集合
     */
    public List<Info> seleteMajorInfo(String majorName) {
        List<Info> majorInfoList = new ArrayList<Info>();
        SqlSession sqlSession = DBUtil.getSession();

        try {
            MajorMapper majorMapper = sqlSession.getMapper(MajorMapper.class);
            majorInfoList = majorMapper.seleteMajorInfo(majorName);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return majorInfoList;
    }

    /**
     * 查询专业
     * 
     * @param map 查询条件
     * @return 返回查询出来的专业对象集合
     */
    public List<Major> selectMajor(Map<String, Object> map) {
        List<Major> majorList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            MajorMapper majorMapper = sqlSession.getMapper(MajorMapper.class);
            majorList = majorMapper.selectMajor(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }
        return majorList;
    }

}
