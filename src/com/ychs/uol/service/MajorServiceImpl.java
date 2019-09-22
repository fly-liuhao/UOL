/**
* @项目名称: J1012Web
* @文件名称: MajorServiceImpl.java
* @Date: 2019年7月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package com.ychs.uol.service;

import java.util.List;
import java.util.Map;

import com.ychs.uol.dao.MajorDao;
import com.ychs.uol.model.Info;
import com.ychs.uol.model.Major;

/**
 * 
 * @author: liuhao
 * @version 1.0
 */
public class MajorServiceImpl implements MajorService {
    MajorDao majorDao = new MajorDao();

    @Override
    public int addMajor(Major major) {
        return majorDao.insertMajor(major);
    }

    @Override
    public List<Info> seleteMajorInfo(String majorName) {
        return majorDao.seleteMajorInfo(majorName);
    }
    
    @Override
    public List<Major> selectMajor(Map<String, Object> map){
        return majorDao.selectMajor(map);
    }

}
