package com.lxd.crm.action;

import com.lxd.crm.domain.Department;
import com.lxd.crm.domain.Post;
import com.lxd.crm.service.HomeService;
import com.lxd.crm.service.impl.HomeServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by dllo on 17/11/2.
 */
public class HomeAction extends ActionSupport {

    private HomeService service;

    // 用来接收jsp传递过来的部门id
    private int deptId;

    private List<Department> departments;
    private List<Post> posts;

    public HomeAction() {
        service = new HomeServiceImpl();
    }

    public String home(){
        departments = service.getDepartments();

        return SUCCESS;
    }


    public String getPostByDeptId(){

        // 根据部门id获取对应的职位
        posts = service.getPostByDeptId(deptId);
        return SUCCESS;

    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
