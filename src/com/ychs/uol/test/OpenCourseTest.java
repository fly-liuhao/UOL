/**
* @项目名称: UOLMyBatis
* @文件名称: OpenCourseTest.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.sun.istack.internal.logging.Logger;
import com.ychs.uol.dao.OpenCourseDao;
import com.ychs.uol.model.OpenCourse;

/**
 * OpenCourse测试类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class OpenCourseTest {
    Logger logger = Logger.getLogger(OpenCourseTest.class);
    OpenCourseDao openCourseDao = new OpenCourseDao();

    /**
     * 测试录入公开课
     */
//    @Test
    public void testInsertOpenCourse() {
        OpenCourse course = new OpenCourse("2019-07-23", "Oracle数据库操作", "吴老师", "刘浩", "电子楼603", "太原工业学院", "计算机工程系", "大三",
                "java1012", "英才汇硕公司");
        int result = openCourseDao.insertOpenCourse(course);
        logger.info(result + "");
    }

    /**
     * 测试查询公开课
     */
//    @Test
    public void testSelectOpenCourse() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startDate", "2019-7-17");
        map.put("endDate", "2019-7-20");
//        map.put("school", "太原工业学院");
//        map.put("department", "化工系");
//        map.put("grade", "大二");
        List<OpenCourse> openCourseList = openCourseDao.selectOpenCourse(map);
        for (OpenCourse course : openCourseList) {
            System.out.println(course);
        }
        logger.info(openCourseList.size() + "");
    }

}
