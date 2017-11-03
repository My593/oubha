package com.lxd.crm.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/11/2.
 * 职位
 */
public class Post {
    private int id;
    private String name;
    private Department dept;
    private Set<Staff> staffs = new HashSet<Staff>();

    public Post() {
    }

    public Post(String name) {
        this.name = name;
    }

    public Post(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }
}
