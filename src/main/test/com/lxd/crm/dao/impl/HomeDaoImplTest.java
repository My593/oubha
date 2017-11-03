package com.lxd.crm.dao.impl;

import com.lxd.crm.dao.HomeDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by dllo on 17/11/2.
 */
public class HomeDaoImplTest {

    private HomeDao dao;

    @Before
    public void setUp() throws Exception {
        dao = new HomeDaoImpl();
    }

    @Test
    public void getDepartments() throws Exception {
        Assert.assertEquals(dao.getDepartments().size(),2);
    }

    @Test
    public void getPostByDeptId() throws Exception {
        Assert.assertEquals(dao.getPostByDeptId(1).size(),3);
    }

    @Test
    public void getStaffByDeptIdAndPostId() throws Exception {
        Assert.assertEquals(dao.getStaffByDeptIdAndPostId(2,5).size(),2);
    }

    @Test
    public void getStaffByDeptId() throws Exception {
        Assert.assertEquals(dao.getStaffByDeptId(1).size(),5);
    }

    @Test
    public void getStaffs() throws Exception {
        Assert.assertEquals(dao.getStaffs().size(),8);
    }

}