/**
* @项目名称: J1012Web
* @文件名称: OpenCourseServiceImpl.java
* @Date: 2019年7月29日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.service;

import java.util.List;
import java.util.Map;

import com.ychs.uol.dao.OpenCourseDao;
import com.ychs.uol.model.OpenCourse;

/**
 * 公开课 Service 接口实现类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class OpenCourseServiceImpl implements OpenCourseService {
    OpenCourseDao openCourseDao = new OpenCourseDao();

    @Override
    public int addOpenCourse(OpenCourse course) {
        return openCourseDao.insertOpenCourse(course);
    }

    @Override
    public List<OpenCourse> selectOpenCourse(Map<String, Object> map) {
        return openCourseDao.selectOpenCourse(map);
    }

}
