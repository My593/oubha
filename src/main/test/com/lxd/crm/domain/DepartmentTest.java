package com.lxd.crm.domain;

import com.lxd.crm.utils.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

/**
 * Created by dllo on 17/11/2.
 */
public class DepartmentTest {

    @Test
    public void generateTable(){
        Session session = HibernateUtil.openSession();

        Department d1 = new Department("教学部");
        Department d2 = new Department("职业规划部");

        Post p1 = new Post("教学总监");
        Post p2 = new Post("教学主管");
        Post p3 = new Post("讲师");
        Post p4 = new Post("职业规划主管");
        Post p5 = new Post("职业规划师");



        Staff s1 = new Staff("孟宪义","男",12);
        s1.setDept(d1);
        s1.setPost(p1);
        Staff s2 = new Staff("李忠仁","男",15);
        s2.setDept(d1);
        s2.setPost(p2);
        Staff s3 = new Staff("肖玲玲","女",32);
        s3.setDept(d1);
        s3.setPost(p3);
        Staff s4 = new Staff("何欣","女",26);
        s4.setDept(d2);
        s4.setPost(p5);
        Staff s5 = new Staff("吴大师","男",6);
        s5.setDept(d1);
        s5.setPost(p3);
        Staff s6 = new Staff("刘明宇","男",32);
        s6.setDept(d1);
        s6.setPost(p2);
        Staff s7 = new Staff("马琳","釹",28);
        s7.setDept(d2);
        s7.setPost(p4);
        Staff s8 = new Staff("大长腿","女",115);
        s8.setDept(d2);
        s8.setPost(p5);


        p1.setDept(d1);
        p2.setDept(d1);
        p3.setDept(d1);
        p4.setDept(d2);
        p5.setDept(d2);

        session.save(p1);
        session.save(p2);
        session.save(p3);
        session.save(p4);
        session.save(p5);


        session.save(s1);
        session.save(s2);
        session.save(s3);
        session.save(s4);
        session.save(s5);
        session.save(s6);
        session.save(s7);
        session.save(s8);

        HibernateUtil.commit();

    }



}