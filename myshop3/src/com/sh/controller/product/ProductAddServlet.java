package com.sh.controller.product;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.io.FileOutputStream;

import java.io.InputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sh.dao.product.ProductColorDao;
import com.sh.dao.product.ProductDao;
import com.sh.dao.product.ProductTypeDao;
import com.sh.entity.Product;
import com.sh.entity.ProductType;
import com.sh.entity.Productcolor;

@Controller
@RequestMapping("/manager")
public class ProductAddServlet {
	@Resource
	private ProductDao pd;
	@Resource
	private ProductTypeDao ptd;
	@Resource
	private ProductColorDao pcd;

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String foradd(Model model) {
		List<ProductType> list = ptd.findAll();
		model.addAttribute("pts", list);
		return "addproduct";
	}

	@RequestMapping("/postaddProduct")
	public String toadd(@RequestParam(value="name") String name,@RequestParam(value="pt") String pt,@RequestParam(value="description") String description,
			@RequestParam(value="price") String price,@RequestParam(value="discountprice") String discountprice,@RequestParam(value="color") String color, @RequestParam(value="listimg") MultipartFile file,HttpServletRequest request,Model model) {
		String rootPath=request.getServletContext().getRealPath("/static");
		if(!file.isEmpty()){
			try {
				InputStream is=file.getInputStream();
				FileOutputStream fos=new FileOutputStream(
						rootPath+"/"+"images/"
						+file.getOriginalFilename());
				byte []cache=new byte[is.available()];
				fos.write(cache);
				is.close();
				fos.flush();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//保存数据
		Product p=new Product();
		p.setName(name);
		p.setDescription(description);
		Object objprice=price;
		int Price=Integer.parseInt(objprice.toString());
		p.setPrice(Price);
		Object objdiscountprice=discountprice;
		int Discountprice=Integer.parseInt(objdiscountprice.toString());
		p.setDiscountprice(Discountprice);
        Object objpt=pt;
		int Producttypeid=Integer.parseInt(objpt.toString());
		p.setProducttypeid(Producttypeid);
		p.setListimg("images/"+file.getOriginalFilename());
		System.out.println("图片名称："+"images/"+file.getOriginalFilename());
		System.out.println("图片路径："+rootPath+"/"+"static/images/"+file.getOriginalFilename());
		int id=this.pd.addProduct(p);
		
		String colors[]=color.split(",");
		for(String c:colors){
			Productcolor pc=new Productcolor();
			pc.setName(c);
			pc.setProductid(id);
			pcd.addColor(pc);
		}
		return "redirect:/manager/addProduct";
		
	}
}
