package com.lxd.crm.service;

import com.lxd.crm.domain.Department;
import com.lxd.crm.domain.Post;
import com.lxd.crm.domain.Staff;

import java.util.List;

/**
 * Created by dllo on 17/11/2.
 */
public interface HomeService {
    /**
     * 查询所有的部门信息
     * @return
     */
    List<Department> getDepartments();

    /**
     * 根据部门id查询所有对应的职位
     * @param deptId 部门的id
     * @return 职位的集合
     */

    List<Post> getPostByDeptId(int deptId);

    /**
     * 根据部门和职位的id查询出所有对应的员工
     * @param deptId 部门id
     * @param postId 职位id
     * @return 员工集合
     */
    List<Staff> getStaffByDeptIdAndPostId(int deptId, int postId);

    /**
     * 查询某个部门的所有员工
     * @param deptId 部门id
     * @return
     */
    List<Staff> getStaffByDeptId(int deptId);

    /**
     * 查询所有员工
     * @return
     */
    List<Staff> getStaffs();
}
