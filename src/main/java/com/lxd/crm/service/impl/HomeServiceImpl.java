package com.lxd.crm.service.impl;

import com.lxd.crm.dao.HomeDao;
import com.lxd.crm.dao.impl.HomeDaoImpl;
import com.lxd.crm.domain.Department;
import com.lxd.crm.domain.Post;
import com.lxd.crm.domain.Staff;
import com.lxd.crm.service.HomeService;

import java.util.List;

/**
 * Created by dllo on 17/11/2.
 */
public class HomeServiceImpl implements HomeService {
    private HomeDao dao;

    public HomeServiceImpl() {
        dao = new HomeDaoImpl();
    }

    public List<Department> getDepartments() {
        return dao.getDepartments();
    }

    public List<Post> getPostByDeptId(int deptId) {
        return dao.getPostByDeptId(deptId);
    }

    public List<Staff> getStaffByDeptIdAndPostId(int deptId, int postId) {

        if (deptId < 1){
            return getStaffs();
        }else if (postId < 1){
            return getStaffByDeptId(deptId);
        }

        return dao.getStaffByDeptIdAndPostId(deptId,postId);
    }

    public List<Staff> getStaffByDeptId(int deptId) {
        if (deptId  < 1 ){
            return dao.getStaffs();
        }

        return dao.getStaffByDeptId(deptId);
    }

    public List<Staff> getStaffs() {
        return dao.getStaffs();
    }



}
