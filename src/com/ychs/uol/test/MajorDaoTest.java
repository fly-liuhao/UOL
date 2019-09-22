/**
* @项目名称: UOLMyBatis
* @文件名称: MajorDaoTest.java
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
import com.ychs.uol.dao.MajorDao;
import com.ychs.uol.model.Info;
import com.ychs.uol.model.Major;

/**
 * MajorDao测试
 * 
 * @author: liuhao
 * @version 1.0
 */
public class MajorDaoTest {
    Logger logger = Logger.getLogger(MajorDaoTest.class);
    MajorDao majorDao = new MajorDao();

//    @Test
    public void testInsertMajor() {
        Major major = new Major("土木工程", "这个清华浙大这个专业很火!", "18","9");
        int result = majorDao.insertMajor(major);
        logger.info(result + "");
    }

//    @Test
    public void testSelectMajorInfo() {
        List<Info> majorList = new ArrayList<Info>();
        String majorName = "通信工程";

        majorList = majorDao.seleteMajorInfo(majorName);
        for (Info majorInfo : majorList) {
            System.out.println(majorInfo);
        }

        logger.info(majorList.size() + "");
    }

    /**
     * 测试查询专业
     */
    @Test
    public void testSelectMajor() {
        Map<String, Object> map = new HashMap<String, Object>();
//      map.put("majorId", "5");
//      map.put("majorName", "软件工程");
//        map.put("deptId", "5");
        map.put("schoolId", "1");
        List<Major> majorList = majorDao.selectMajor(map);
        for (Major major : majorList) {
            System.out.println(major);
        }
        logger.info(majorList.size()+"");

    }

}
