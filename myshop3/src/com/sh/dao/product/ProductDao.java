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
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Product");
		return query.list();

	}

	public Product findById(int id) {
		return this.sessionFactory.getCurrentSession().get(Product.class, id);
	}

	public void addshowcart(showcart showcart) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(showcart);
		tx.commit();
		session.close();

	}

	/**
	 * 统计数据个数
	 * 
	 * @return
	 */
	public Long findCountByPage() {
		Query query = this.sessionFactory.getCurrentSession().createQuery("select count(id) from Product");
		return (Long) query.uniqueResult();
	}

	/**
	 * 分页查询数据
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public List<Product> findByPage(int pageNum, int pageSize) {
		Query query = this.sessionFactory.getCurrentSession().createQuery("from Product");
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		return query.list();

	}

	public void deleteProduct(Product p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// this.sessionFactory.getCurrentSession().delete(p);
		session.delete(p);
		tx.commit();
		session.close();
	}

	public int addProduct(Product p) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(p);
		tx.commit();
		session.close();
		return p.getId();

	}

	/**
	 * 查询产品之颜色
	 * 
	 * @return
	 */
	public List<String> findcolorById(int productid) {
		String hql = "select name from Productcolor where productid=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, productid);
		List<String> list = (List<String>) query.list();
		return list;
	}

	/**
	 * 查询产品之尺寸
	 * 
	 * @return
	 */
	public List<String> findsizeById(int productid) {
		String hql = "select name from Productsize where productid=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, productid);
		List<String> list = (List<String>) query.list();
		return list;
	}
}
