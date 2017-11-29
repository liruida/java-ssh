package com.sh.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.sh.entity.Product;
import com.sh.entity.Productcolor;
import com.sh.entity.Productsize;
import com.sh.entity.User;
import com.sh.entity.showcart;




@Repository
public class ProductDao {
	@Resource
	private SessionFactory sessionFactory;

	/* 查询全部产品 */

	public List<Product> findAll() {
		Query query=this.sessionFactory.getCurrentSession().createQuery("from Product");
		return query.list();
	
	}
	public Product findById(int id){
		return this.sessionFactory.getCurrentSession().get(Product.class, id);
}
	public void addshowcart(showcart showcart){
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(showcart); 
		tx.commit(); 
		session.close(); 
		
	}
	
	
}
 