/**
* @项目名称: UOLMyBatis
* @文件名称: DepartmentMapper.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.mapper;

import java.util.List;
import java.util.Map;

import com.ychs.uol.model.Department;

/**
 * DepartmentMapper类
 * 
 * @author: liuhao
 * @version 1.0
 */
public interface DepartmentMapper {

    /**
     * 添加院系
     * 
     * @param department 封装的院系对象
     * @return 添加成功返回1, 失败返回0
     */
    public int insertDepartment(Department department);

    /**
     * 根据学校名称删除其专业
     * 
     * @param schoolName 学校名称
     * @return 删除成功返回非零， 失败返回0
     */
    public int deleteDepartment(String schoolName);

    /**
     * 查询院系
     * 
     * @param map 查询条件
     * @return 返回查询出来的院系对象集合
     */
    public List<Department> selectDepartment(Map<String, Object> map);

}
