package com.lxd.crm.utils;

import com.lxd.crm.domain.Department;
import com.lxd.crm.domain.Post;
import com.lxd.crm.domain.Staff;
import org.junit.Test;

import java.util.List;

/**
 * Created by dllo on 17/11/2.
 */
public class QueryUtilTest {

    @Test
    public void queryTest(){

        System.out.println(QueryUtil.findAll(Department.class));
        System.out.println(QueryUtil.findAll(Post.class));
        System.out.println(QueryUtil.findAll(Staff.class));

    }

    @Test
    public void queryTest2(){

        List<Staff> list = QueryUtil.queryByEqual(Staff.class,"dept",3);
        System.out.println(list);
    }


    @Test
    public void queryTest3(){
        // 多条件查询
        // 查询教学部的所有男员工
        String [] fields = {"dept","gender"};
        Object[] values = {1,"女"};

        List<Staff> staffs = QueryUtil.queryByEquals(Staff.class,fields,values);
        System.out.println(staffs);
    }

}