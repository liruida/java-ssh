package com.hibernate.ui;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.hibernate.entity.User;
import com.hibernate.util.HibernateUtil;

public class Test {
    public static void main(String[] args) {
        testHQL();
    }

    public static void testHQL() {
        Session session = null;
        Transaction tran = null;
        try {
            session = HibernateUtil.openSession();
            tran = session.beginTransaction();
            // ---------------------------------

            // 检索所有记录
            // String hql = "from User";
            // String hql = "select u from User u";
            // Query query = session.createQuery("select u from User u");
            // List userList = query.list();
            // System.out.println(userList);

            // 检索单独字段，list()返回结果中List元素类型为该字段类型
            // String hql = "select u.userName from User u";
            // Query query = session.createQuery(hql);
            // List userList = query.list();
            // System.out.println(userList);

            //检索多个字段，list()返回结果中List元素类型为Object数组
//            String hql = "select u.userName, u.password from User u"; 
//            Query query = session.createQuery(hql);
//            List<Object[]> userList = query.list();
//            Iterator<Object[]> it = userList.iterator();
//            while(it.hasNext()){
//                Object[] val = it.next();
//                System.out.println(val[0]);
//                System.out.println(val[1] + "\n");
//            }

            //查询多个字段，并将list()返回结果中List元素改为User对象引用，需在User中添加相应的构造方法
//            String hql = "select new User(u.userName, u.password) from User u";
//            Query query = session.createQuery(hql);
//            List<User> userList = query.list();
//            System.out.println(userList);

            //where子句
//            String hql = "from User u where u.userName='张三'";
//            Query query = session.createQuery(hql);
//            List<User> userList = query.list();
//            System.out.println(userList);
            
            //返回单个对象
//            String hql = "from User u where u.userName='张三'";
//            Query query = session.createQuery(hql);
//            User user = (User) query.uniqueResult();
//            System.out.println(user);

            //group by 子句
//            String hql = "select count(u) from User u group by u.age";
//            Query query = session.createQuery(hql);
//            List<User> userList = query.list();
//            System.out.println(userList);

            //order by子句
//            String hql = "from User u Order by u.userName";
//            String hql = "from User u Order by u.userName desc";
//            String hql = "from User u Order by u.userName, u.id desc";
//            Query query = session.createQuery(hql);
//            List<User> userList = query.list();
//            System.out.println(userList);

            //having子句
//            String hql = "from User u group by u.age having u.id < 5";
//            Query query = session.createQuery(hql);
//            List<User> userList = query.getResultList();
//            System.out.println(userList);
            
            //参数绑定
//            String hql = "from User u where u.userName=?";
//            String hql = "from User u where u.userName=:userName";
//            Query query = session.createQuery(hql);
//            User user = new User();
//            user.setUserName("张三");
//            query.setProperties(user);
//            query.setParameter(0, user);
//            List<User> userList = query.list();
//            System.out.println(userList);            

             //delete语句
//             String hql = "delete from Users where id = ?";
//             Query queryDelete = session.createQuery(hql);
//             queryDelete.setParameter("id", 1);
//             int num = queryDelete.executeUpdate();
//             System.out.println(num);

             //update语句
//             String hql = "update User set userName=:name where id=:id";
//             Query queryUpdate = session.createQuery(hql);
//             queryUpdate.setParameter("name", "lucy");
//             queryUpdate.setParameter("id", new Integer(2));
//             int row = queryUpdate.executeUpdate();
//             System.out.println(row);
            
            //where子句中嵌入子查询
//            String hql = "from User u where (select count(o) from u.orderSet o) > 0";
//            Query query = session.createQuery(hql);
//            List userList = query.list();
//            System.out.println(userList);

            //分页查询
//             String hql = "from User";
//             Query query = session.createQuery(hql);
//             query.setFirstResult(0);
//             query.setMaxResults(3);
//             List<User> userList = query.list();
//             System.out.println(userList);

             //引用查询
//            Query query = session.createNamedQuery("findUser", User.class);
//            List userList = query.list();
//            System.out.println(userList);
            
            //QBC
//            Criteria criteria=session.createCriteria(User.class);
//            Criterion c1= Restrictions.eq("userName", "张三");
//            criteria.add(c1);
//            List result = criteria.list();
//            System.out.println(result);
            
            //本地SQL
            String sql="select * from  user";
            NativeQuery query = session.createNativeQuery(sql, User.class);
            List list = query.list();
            System.out.println(list);
 
            // ---------------------------------
            tran.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tran.rollback();
        } finally {
            if (null != session) {
                session.close();
            }
        }
    }
}
