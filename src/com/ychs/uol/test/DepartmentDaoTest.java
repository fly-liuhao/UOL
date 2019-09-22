/**
* @项目名称: UOLMyBatis
* @文件名称: DepartmentDaoTest.java
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
import com.ychs.uol.dao.DepartmentDao;
import com.ychs.uol.model.Department;

/**
 * DepartmentDao测试类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class DepartmentDaoTest {

    Logger logger = Logger.getLogger(DepartmentDaoTest.class);
    DepartmentDao departmentDao = new DepartmentDao();

//    @Test
    public void testInsertDepartment() {
        Department department = new Department("中文系", "有古代文学专业", "003");
        int result = departmentDao.insertDepartment(department);
        logger.info(result + "");
    }

    /**
     * 测试查询系部
     */
//    @Test
    public void testSelectDepartment() {
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("deptId", "5");
//        map.put("deptName", "计算机工程系");
//        map.put("schoolId", "1");
        List<Department> departmentList = departmentDao.selectDepartment(map);
        for (Department department : departmentList) {
            System.out.println(department);
        }
        logger.info(departmentList.size() + "");
    }

}
