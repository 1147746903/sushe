package com.service.impl;

import com.dao.AdminDao;
import com.po.Admin;
import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 管理员service层接口实现类
 */
@Service("adminService")
@Transactional//事务的注解
public class AdminServiceImpl implements AdminService {
    //注入AdminDao
    @Autowired
    private AdminDao adminDao;

    //通过账号密码查询用户
    @Override
    public Admin CheckLogin(String username, String password) {
        Admin admin = this.adminDao.CheckLogin(username, password);
        return admin;
    }
}
