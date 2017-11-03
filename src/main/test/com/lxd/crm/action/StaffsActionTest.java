package com.lxd.crm.action;

import com.lxd.crm.dao.HomeDao;
import com.lxd.crm.dao.impl.HomeDaoImpl;
import com.lxd.crm.domain.Staff;
import org.junit.Test;

import java.util.List;

/**
 * Created by dllo on 17/11/3.
 */
public class StaffsActionTest {


    @Test
    public void testQuery(){
//        HomeService service = new HomeServiceImpl();
//        List<Staff> staffs = service.getStaffByDeptIdAndPostId(1, 8);
        HomeDao dao = new HomeDaoImpl();
        List<Staff> staffs = dao.getStaffByDeptIdAndPostId(1, 2);

        System.out.println(staffs.size());
        System.out.println(staffs);

    }

}