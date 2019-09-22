/**
* @项目名称: UOLMyBatis
* @文件名称: MajorMapper.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.mapper;

import java.util.List;
import java.util.Map;

import com.ychs.uol.model.Info;
import com.ychs.uol.model.Major;

/**
 * MajorMapper类
 * 
 * @author: liuhao
 * @version 1.0
 */
public interface MajorMapper {

    /**
     * 添加专业
     * 
     * @param major 专业的对象
     * @return 添加成功返回1, 失败返回0
     */
    public int insertMajor(Major major);

    /**
     * 查询专业（专业，所属系部，所属的学校）
     * 
     * @param majorName 专业名称
     * @return 查询出的专业信息集合
     */
    public List<Info> seleteMajorInfo(String majorName);

    /**
     * 查询专业
     * 
     * @param map 查询条件
     * @return 返回查询出来的专业对象集合
     */
    public List<Major> selectMajor(Map<String, Object> map);

    /**
     * 根据学校名称删除其所有专业
     * 
     * @param schoolName 学校名称
     * @return 删除成功返回非零， 失败返回0
     */
    public int deleteMajor(String schoolName);

}
