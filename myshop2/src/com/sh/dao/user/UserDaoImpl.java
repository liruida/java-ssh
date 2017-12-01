package com.sh.dao.user;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sh.entity.User;
@Repository
public class UserDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public User findByQqNumAndPassword(int qqnum){
		 User u=this.sessionFactory.getCurrentSession().get(User.class, qqnum);
	        if(u==null){  
	          return null; 
	        }  
	        
	        return  u;
		  
      }
	public int saveUser(User u){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(u); 
       // this.sessionFactory.getCurrentSession().save(u);
		tx.commit(); 
		session.close(); 
		return u.getQqnum();
	}
}
	
