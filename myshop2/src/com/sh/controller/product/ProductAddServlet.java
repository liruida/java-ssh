package com.sh.controller.product;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
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

import com.sh.dao.product.ProductColorDao;
import com.sh.dao.product.ProductDao;
import com.sh.dao.product.ProductTypeDao;
import com.sh.entity.Product;
import com.sh.entity.ProductType;

@Controller
@RequestMapping("/manager")
public class ProductAddServlet {
	@Resource
	private ProductDao pd;
	@Resource
	private ProductTypeDao ptd;

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String foradd(Model model) {
		List<ProductType> list=ptd.findAll();
		model.addAttribute("pts", list);
		return "addproduct";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String toadd(HttpServletRequest request,Model model) {
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		String name="";
		String color="";
		String pt="";
		String path="";
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem fi:items){
				if(fi.isFormField()){
					if(fi.getFieldName().equals("pt"))
						pt=fi.getString();
					if(fi.getFieldName().equals("name"))
						name=fi.getString("utf-8");
					if(fi.getFieldName().equals("color"))
						color=fi.getString();
				}else{
					String itemPath=request.getServletContext().getRealPath("/upload");
					File dir=new File(itemPath);
					if(!dir.exists()){
						dir.mkdir();
					}
					String extName=fi.getName().substring(fi.getName().lastIndexOf("."), fi.getName().length());
					String fileName=new Date().getTime()+extName;
					fi.write(new File(itemPath+"/"+fileName));
					path="upload/"+fileName;
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//保存数据
		Product p=new Product();
		p.setName(name);
		p.setProducttypeid(Integer.parseInt(pt));
		p.setListimg(path);
		
		this.pd.addProduct(p);
		
		String colors[]=color.split(",");
		ProductColorDao pcd=new ProductColorDao();
		for(String c:colors){
			pcd.addColor();
		}
		return "addProduct";
		
	}
	}

