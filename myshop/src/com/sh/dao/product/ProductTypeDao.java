package com.sh.dao.product;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sh.entity.ProductType;

public class ProductTypeDao {}
	/*public List<ProductType> findAll(){
		try{
			List<ProductType> list=new ArrayList<ProductType>();
			Connection con=BaseDao.getCon();
			PreparedStatement pstm=con.prepareStatement("select * from producttype");
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				ProductType pt=new ProductType();
				pt.setId(rs.getInt(1));
				pt.setName(rs.getString(2));
				list.add(pt);
			}
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
*/