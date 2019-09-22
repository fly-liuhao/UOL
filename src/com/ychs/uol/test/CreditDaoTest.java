/**
* @项目名称: UOLMyBatis
* @文件名称: CreditDaoTest.java
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
import com.ychs.uol.dao.CreditDao;
import com.ychs.uol.model.Credit;

/**
 * CreditDao测试类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class CreditDaoTest {
    Logger logger = Logger.getLogger(CreditDaoTest.class);
    CreditDao creditDao = new CreditDao();

    /**
     * 测试录入学分
     */
//    @Test
    public void testInsertCredit() {
        Credit credit = new Credit("任云康", "162054125", "99", "不能给他满分");
        int result = creditDao.insertCredit(credit);
        logger.info(result + "");
    }

    /**
     * 测试查询学生学分
     */
    @Test
    public void testSelectCredit() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("stuName", "刘浩");
        map.put("stuId", "162056224");
        map.put("score", "94");

        List<Credit> creditList = creditDao.selectCredit(map);
        for (Credit credit : creditList) {
            System.out.println(credit);
        }
        logger.info(creditList.size() + "");
    }

}
