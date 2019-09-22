/**
* @项目名称: J1012Web
* @文件名称: DepartmentService.java
* @Date: 2019年7月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.service;

import java.util.List;
import java.util.Map;

import com.ychs.uol.model.Department;

/**
* 
* @author: liuhao
* @version 1.0
*/
public interface DepartmentService {
    /**
     * 添加院系
     * 
     * @param department 封装的院系对象
     * @return 添加成功返回1, 失败返回0
     */
    public int addDepartment(Department department);
    
    /**
     * 查询院系
     * 
     * @param map 查询条件
     * @return 返回查询出来的院系对象集合
     */
    public List<Department> selectDepartment(Map<String, Object> map);
}
