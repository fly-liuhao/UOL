/**
* @项目名称: J1012Web
* @文件名称: LabMemberServiceImpl.java
* @Date: 2019年7月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.service;

import java.util.List;
import java.util.Map;

import com.ychs.uol.dao.LabMemberDao;
import com.ychs.uol.model.LabMember;

/**
 * 实验室成员Service接口实现类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class LabMemberServiceImpl implements LabMemberService {
    LabMemberDao labMemberDao = new LabMemberDao();

    @Override
    public int addLabMember(LabMember member) {
        return labMemberDao.insertLabMember(member);
    }

    @Override
    public List<LabMember> selectLabMember(Map<String, Object> map) {
        return labMemberDao.selectLabMember(map);
    }
    

    @Override
    public LabMember selectLabMemberById(String memberId) {
        return labMemberDao.selectLabMemberById(memberId);
    }

    @Override
    public int modifyLabMember(LabMember member) {
        return labMemberDao.modifyLabMember(member);
    }

}
