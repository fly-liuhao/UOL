/**
* @项目名称: J1012Web
* @文件名称: OpenCourseService.java
* @Date: 2019年7月29日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.service;

import java.util.List;
import java.util.Map;

import com.ychs.uol.model.OpenCourse;

/**
 * 公开课 Service 接口
 * 
 * @author: liuhao
 * @version 1.0
 */
public interface OpenCourseService {
    /**
     * 添加公开课
     * 
     * @param course 封装的公开课对象
     * @return 添加成功返回1, 失败返回0
     */
    public int addOpenCourse(OpenCourse course);

    /**
     * 查询公开课
     * 
     * @param map 查询条件
     * @return 查询到的公开课集合
     */
    public List<OpenCourse> selectOpenCourse(Map<String, Object> map);
}
