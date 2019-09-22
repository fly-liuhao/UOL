/**
* @项目名称: UOLMyBatis
* @文件名称: CourseMemberDaoTest.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.sun.istack.internal.logging.Logger;
import com.ychs.uol.dao.CourseMemberDao;
import com.ychs.uol.mapper.CourseMemberMapper;
import com.ychs.uol.model.CourseMember;

/**
 * 
 * @author: liuhao
 * @version 1.0
 */
public class CourseMemberDaoTest {
    Logger logger = Logger.getLogger(CourseMemberDaoTest.class);
    CourseMemberDao courseMemberDao = new CourseMemberDao();

    /**
     * 测试登记参加公开课的人员
     */
//    @Test
    public void testInsertCourseMember() {
        CourseMember courseMember = new CourseMember("162056224", "2019-12-31", "刘浩", "1", "太原工业学院", "计算机工程系", "大三",
                "15364925795", "15364925795@163.com");
        int result = courseMemberDao.insertCourseMember(courseMember);
        logger.info(result + "");
    }

    /**
     * 测试查询参加的公开课人员
     */
//    @Test
    public void testSelectCourseMember() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("memberName", "刘浩");
        map.put("school", "清华大学");
        map.put("grade", "大二");
        List<CourseMember> courseMemberList = courseMemberDao.selectCourseMember(map);
        for (CourseMember member : courseMemberList) {
            System.out.println(member);
        }
        logger.info(courseMemberList.size() + "");
    }
}
