/**
* @项目名称: UOLMyBatis
* @文件名称: LabMemberDaoTest.java
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
import com.ychs.uol.dao.LabMemberDao;
import com.ychs.uol.model.LabMember;

/**
 * LabMemberDao测试类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class LabMemberDaoTest {
    Logger logger = Logger.getLogger(LabMemberDaoTest.class);
    LabMemberDao labMemberDao = new LabMemberDao();

    /**
     * 测试添加实验室成员
     */
//    @Test
    public void testInsertLabMember() {
        LabMember member = new LabMember("Dong", "162054124", "女", "大三", "山西汾阳", "15364925795", "15364925795@163.com",
                "太原工业学院", "计算机工程系", "计算机科学与技术", "学生会-办公室", "2019-10-10", "0", "1", "0", "1", "爱学习", "真的是好学生");
        int result = labMemberDao.insertLabMember(member);
        logger.info(result + "");
    }

    /**
     * 测试根据成员ID查询实验室成员
     */
//    @Test
    public void testSelectLabMemberById() {
        String memberId = "162056224";
        LabMember member = labMemberDao.selectLabMemberById(memberId);
        logger.info(member + "");
    }

    /**
     * 测试查询实验室成员 （多条件组合查询）
     */
//    @Test
    public void testSelectLabMember() {
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("memberName", "Haohao");
//        map.put("grade", "大三");
//        map.put("school", "太原工业学院");
//        map.put("schoolId", "1");
//        map.put("deptId", "4");
//        map.put("majorId", "5");

        List<LabMember> labMemberList = labMemberDao.selectLabMember(map);
        for (LabMember member : labMemberList) {
            System.out.println(member);
        }
        logger.info(labMemberList.size() + "");
    }

    /**
     * 测试修改实验室成员信息
     */
//    @Test
    public void testModifyLabMember() {
        LabMember member = new LabMember("XiuXiu", "162056225", "女", "大三", "山西汾阳", "15364925795", "15364925795@163.com",
                "太原工业学院", "计算机工程系", "计算机科学与技术", "学生会-办公室", "2019-10-10", "已领取", "正常", "管理人员", "无", "爱学习", "真的是好学生");
        int result = labMemberDao.modifyLabMember(member);
        logger.info(result + "");
    }

}
