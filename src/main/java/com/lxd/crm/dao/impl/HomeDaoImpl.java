package com.lxd.crm.dao.impl;

import com.lxd.crm.dao.HomeDao;
import com.lxd.crm.domain.Department;
import com.lxd.crm.domain.Post;
import com.lxd.crm.domain.Staff;
import com.lxd.crm.utils.QueryUtil;

import java.util.List;

/**
 * Created by dllo on 17/11/2.
 */
public class HomeDaoImpl implements HomeDao {



    public List<Department> getDepartments() {


        return QueryUtil.findAll(Department.class);
    }

    public List<Post> getPostByDeptId(int deptId) {
        return QueryUtil.queryByEqual(Post.class,"dept",deptId);
    }

    public List<Staff> getStaffByDeptIdAndPostId(int deptId, int postId) {
        String [] fields ={"dept","post"};
        Object [] values = {deptId,postId};
        return QueryUtil.queryByEquals(Staff.class,fields,values);
    }

    public List<Staff> getStaffByDeptId(int deptId) {
        return QueryUtil.queryByEqual(Staff.class,"dept",deptId);
    }

    public List<Staff> getStaffs() {
        return QueryUtil.findAll(Staff.class);
    }
}
