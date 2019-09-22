/**
* @项目名称: UOLMyBatis
* @文件名称: SchoolDaoTest.java
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
import com.ychs.uol.dao.SchoolDao;
import com.ychs.uol.model.School;

/**
 * SchoolDao测试类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class SchoolDaoTest {

    Logger logger = Logger.getLogger(SchoolDaoTest.class);
    SchoolDao schoolDao = new SchoolDao();

    /**
     * 测试添加院校
     */
//    @Test
    public void testInsertSchool() {
        School school = new School("中央民族大学", "语言专业特别好,fly的朋友也在那里上学~");
        int result = schoolDao.insertSchool(school);
        logger.info(result + "");
        System.out.println(result);
    }

    /**
     * 测试删除院校
     */
//    @Test
    public void testDeleteSchool() {
        String schoolName = "运城学院3";
        int result = schoolDao.deleteSchool(schoolName);
        logger.info(result + "");
    }

    /**
     * 测试删除院校，通过触发器
     */
//    @Test
    public void testDeleteSchoolByTrigger() {
        String schoolName = "中央民族大学3";
        int result = schoolDao.deleteSchoolByTrigger(schoolName);
        logger.info(result + "");
    }
    
    /**
     * 测试查询学校
     */
    @Test
    public void testSelectSchool() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("schoolId", "3");
//        map.put("schoolName", "太原工业学院");
        List<School> schoolList = schoolDao.selectSchool(map);
        for(School school : schoolList) {
            System.out.println(school);
        }
        logger.info(schoolList.size()+"");
    }

}
