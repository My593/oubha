package com.lxd.crm.action;

import com.lxd.crm.domain.Staff;
import com.lxd.crm.service.HomeService;
import com.lxd.crm.service.impl.HomeServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/3.
 */
public class StaffsAction  extends ActionSupport{

    // 接收表单传过来的数据
    private int deptId;
    private int postId;

    private HomeService homeService;
    private List<Staff> staffs;


    public StaffsAction() {
        homeService = new HomeServiceImpl();
    }

    public String staffs(){
        // 查询所有结果
        System.out.println(deptId);
        System.out.println(postId);
        staffs = homeService.getStaffByDeptIdAndPostId(deptId,postId);
        System.out.println(staffs.size());
        return SUCCESS;

    }


    public String  staffJson(){

        staffs = homeService.getStaffByDeptIdAndPostId(deptId,postId);
        return SUCCESS;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }
}
