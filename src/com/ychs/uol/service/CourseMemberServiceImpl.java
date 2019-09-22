/**
* @项目名称: J1012Web
* @文件名称: CourseMemberServiceImpl.java
* @Date: 2019年7月29日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.service;

import java.util.List;
import java.util.Map;

import com.ychs.uol.dao.CourseMemberDao;
import com.ychs.uol.model.CourseMember;

/**
 * 公开课成员Service接口的实现类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class CourseMemberServiceImpl implements CourseMemberService {
    CourseMemberDao courseMemberDao = new CourseMemberDao();

    @Override
    public int addCourseMember(CourseMember courseMember) {
        return courseMemberDao.insertCourseMember(courseMember);
    }

    @Override
    public List<CourseMember> selectCourseMember(Map<String, Object> map) {
        return courseMemberDao.selectCourseMember(map);
    }

}
