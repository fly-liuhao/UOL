/**
* @项目名称: UOLMyBatis
* @文件名称: CreditDao.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ychs.uol.mapper.CreditMapper;
import com.ychs.uol.model.Credit;
import com.ychs.uol.util.DBUtil;

/**
 * CreditDao类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class CreditDao {

    /**
     * 添加学分
     * 
     * @param credit 封装的学分对象
     * @return 添加成功返回1, 失败返回0
     */
    public int insertCredit(Credit credit) {
        int result = 0;
        SqlSession sqlSession = DBUtil.getSession();

        try {
            CreditMapper creditMapper = sqlSession.getMapper(CreditMapper.class);
            result = creditMapper.insertCredit(credit);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return result;
    }

    /**
     * 根据姓名查询学分
     * 
     * @param map 查询条件
     * @return 查询到的学生信息集合
     */
    public List<Credit> selectCredit(Map<String, Object> map) {
        List<Credit> creditList = new ArrayList<Credit>();
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            CreditMapper creditMapper = sqlSession.getMapper(CreditMapper.class);
            creditList = creditMapper.selectCredit(map);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return creditList;
    }
}
