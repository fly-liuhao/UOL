/**
* @项目名称: J1012Web
* @文件名称: LabMemberService.java
* @Date: 2019年7月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.service;

import java.util.List;
import java.util.Map;

import com.ychs.uol.model.LabMember;

/**
 * 实验室成员Service接口
 * 
 * @author: liuhao
 * @version 1.0
 */
public interface LabMemberService {
    /**
     * 添加实验室成员
     * 
     * @param member 实验室成员对象
     * @return 添加成功返回1, 失败返回0
     */
    public int addLabMember(LabMember member);

    /**
     * 多条件组合查询，查询实验室成员
     * 
     * @param map 参数集合
     * @return 查询出的集合
     */
    public List<LabMember> selectLabMember(Map<String, Object> map);
    
    /**
     * 根据成员ID查询，查询实验室成员
     * 
     * @param memberId 成员ID
     * @return 查询出的成员对象
     */
    public LabMember selectLabMemberById(String memberId);

    /**
     * 修改实验室成员信息
     * 
     * @param member 修改信息后的实验室成员对象
     * @return 修改成功返回1，失败返回0
     */
    public int modifyLabMember(LabMember member);
}
