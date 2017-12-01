package com.skishop.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.skishop.dao.BaseDao;
import com.skishop.entity.Product;
import com.skishop.entity.Productcolor;
import com.skishop.entity.Productsize;
import com.skishop.entity.showcart;

public class ProductDao {
	public void addProduct(Product p){
		try{
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("insert into product(name,producttypeid,listimg) values(?,?,?)");
			pstm.setString(1, p.getName());
			pstm.setInt(2, p.getProductTypeId());
			pstm.setString(3, p.getListimg());
			pstm.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

		public Product findById(int id){
			try{
				Connection con=BaseDao.getCon();
				PreparedStatement pstm=con.prepareStatement("SELECT * FROM ski_db.product where id=?");
				pstm.setInt(1, id);
				ResultSet rs=pstm.executeQuery();
				Product p=new Product();
				while(rs.next()){
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setDescription(rs.getString(3));
					p.setPrice(rs.getInt(4));
					p.setImg1(rs.getString(7));
					p.setImg2(rs.getString(8));
					p.setImg3(rs.getString(9));
					p.setProductTypeId(rs.getInt(10));
				}
				return p;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		
		/**
		 * 查询产品之颜色
		 * @return
		 */
		public List findcolorById(int productid){
			try{
				Connection con=BaseDao.getCon();
				PreparedStatement pstm=con.prepareStatement("SELECT * FROM ski_db.productcolor where productid=?");
				pstm.setInt(1, productid);
				ResultSet rs=pstm.executeQuery();
				List list=new ArrayList();
				while(rs.next()){
					Productcolor pc=new Productcolor();
					pc.setId(rs.getInt(1));
					pc.setName(rs.getString(2));
					pc.setProductid(rs.getInt(3));
					list.add(pc);
					}
				
				return list;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
			
		}
		
		/**
		 * 查询产品之尺寸
		 * @return
		 */
		public List findsizeById(int productid){
			try{
				Connection con=BaseDao.getCon();
				PreparedStatement pstm=con.prepareStatement("SELECT * FROM ski_db.productsize where productid=?");
				pstm.setInt(1, productid);
				ResultSet rs=pstm.executeQuery();
				List listsize=new ArrayList();
				while(rs.next()){
					Productsize pc=new Productsize();
					pc.setId(rs.getInt(1));
					pc.setName(rs.getString(2));
					pc.setProductid(rs.getInt(3));
					listsize.add(pc);
					}
				
				return listsize;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		
		
		/**
		 * 统计数据个数
		 * @return
		 */
		public int findCountByPage(){
			try{
				Connection con=BaseDao.getCon();
				PreparedStatement pstm=con.prepareStatement("select count(id) from product");
				ResultSet rs=pstm.executeQuery();
				int count=0;
				while(rs.next()){
					count=rs.getInt(1);
				}
				return count;
			}catch(Exception e){
				e.printStackTrace();
				return 0;
			}
		}
		
		/**
		 * 分页查询数据
		 * @param pageNum
		 * @param pageSize
		 * @return
		 */
		public List<Product> findByPage(int pageNum, int pageSize){
			try{
				List<Product> list=new ArrayList<Product>();
				Connection con=BaseDao.getCon();
				PreparedStatement pstm=con.prepareStatement("select * from product limit ?,?");
				pstm.setInt(1, (pageNum-1)*pageSize);
				pstm.setInt(2, pageSize);
				ResultSet rs=pstm.executeQuery();
				while(rs.next()){
					Product p=new Product();
					p.setId(rs.getInt(1));
					p.setName(rs.getString(2));
					p.setDescription(rs.getString(3));
					p.setPrice(rs.getInt(4));
					p.setDiscountprince(rs.getInt(5));
					
					list.add(p);
				}
				return list;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		
		public void deleteProduct(int id){
			try{
				Connection con=BaseDao.getCon();
				PreparedStatement pstm=con.prepareStatement("delete from product where id=?");
				pstm.setInt(1, id);
				pstm.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		public void addshowcart(showcart s){
			try{
				Connection con=BaseDao.getCon();
				PreparedStatement pstm=con.prepareStatement("insert into showcart(id,productname,count) values(?,?,?)");
				pstm.setInt(1, s.getId());
				pstm.setString(2, s.getProductname());
				pstm.setInt(3, s.getCount());
				pstm.executeUpdate();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		/**
		 * 查询全部产品
		 * @return
		 */
	public List<Product> findAll(){
		try{
			List<Product> list=new ArrayList<Product>();
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("SELECT * FROM ski_db.product p;");
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				Product p=new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				list.add(p);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
