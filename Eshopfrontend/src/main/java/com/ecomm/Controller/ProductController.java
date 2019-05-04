package com.ecomm.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ecomm.DAO.CategoryDAO;
import com.ecomm.DAO.ProductDAO;
import com.ecomm.DAO.SupplierDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;

@Controller
public class ProductController {
		@Autowired
		CategoryDAO categoryDAO;
		
		@Autowired
		ProductDAO productDAO;

		@Autowired
		SupplierDAO supplierDAO;
	    @RequestMapping(value="/Productpage")
		public String displayProduct(Model m) {
			List<Product> listProducts = productDAO.listProducts();
			m.addAttribute("listProducts", listProducts);
			List<Category> listCategories=categoryDAO.getCategories();
			m.addAttribute("listCategories",listCategories);
			List<Supplier> listSuppliers = supplierDAO.getSuppliers();
			m.addAttribute("listSuppliers", listSuppliers);

			for (Product product : listProducts) {
				System.out.println(product.getProductName() + ",");
			}
			return "Productpage";
		}

		@RequestMapping(value = "/InsertProduct", method = RequestMethod.POST)
		public String addProduct(@RequestParam("productName") String productName, @RequestParam("prodDesc") String prodDesc,
				@RequestParam("price") int price,@RequestParam("stock") int stock,
				@RequestParam("catid") int catid,@RequestParam("supId") int supid,@RequestParam("pimage") MultipartFile pimage,Model m) {
			Product product=new Product();
			product.setProductName(productName);
			product.setProdDesc(prodDesc);
			product.setPrice(price);
			product.setStock(stock);
			product.setCatid(catid);
			product.setSupId(supid);
			 productDAO.addProduct(product);
	        
			 
			 List<Product> listProducts = productDAO.listProducts();
				m.addAttribute("listProducts", listProducts);
				List<Category> listCategories=categoryDAO.getCategories();
				m.addAttribute("listCategories",listCategories);
				List<Supplier> listSuppliers = supplierDAO.getSuppliers();
				m.addAttribute("listSuppliers", listSuppliers);

				return "Productpage";
			}
/*
			@RequestMapping(value="/deleteProduct/{productId}")
			public String deleteProduct(@PathVariable("productId") int productId,Model m)
			{
				Product product=productDAO.getProduct(productId);
				
				
				productDAO.deleteProduct(product);
				
				List<Product> listProducts = productDAO.listProducts();
				m.addAttribute("listProducts", listProducts);
				List<Category> listCategories=categoryDAO.getCategories();
				m.addAttribute("listCategories",listCategories);
				List<Supplier> listSuppliers = supplierDAO.getSuppliers();
				m.addAttribute("listSuppliers", listSuppliers);
				return "Productpage";
			}

			@RequestMapping(value="/updateProduct/{productId}")
			public String updateCategory(@PathVariable("productId") int productId,Model m)
			{
				Product product=productDAO.getProduct(productId);
				
				
				List<Product> listProducts = productDAO.listProducts();
				m.addAttribute("listProducts", listProducts);
				List<Category> listCategories=categoryDAO.getCategories();
				m.addAttribute("listCategories",listCategories);
				List<Supplier> listSuppliers = supplierDAO.getSuppliers();
				m.addAttribute("listSuppliers", listSuppliers);
				m.addAttribute("product",product);
				
				return "updateProduct";
			}
			
			@RequestMapping(value="/updateProductDB/{productId}",method=RequestMethod.POST)
			public String updateProductDatabase(@PathVariable("productId") int productId,@RequestParam("productName") String productName,
					@RequestParam("prodDesc") String prodDesc,@RequestParam("price") int price,@RequestParam("stock") int stock,
					@RequestParam("catid") int catid,@RequestParam("supId") int supId,@RequestParam("pimage") MultipartFile pimage,Model m)
			{
				Product product=productDAO.getProduct(productId);
				product.setProductName(productName);
				product.setProdDesc(prodDesc);
				product.setPrice(price);
				product.setStock(stock);
				product.setCatid(catid);
				product.setSupId(supId);
				
				productDAO.updateProduct(product);
				
				Category category=categoryDAO.getCategory(catid);
				Supplier supplier=supplierDAO.getSupplier(supId);
				
				List<Product> listProducts = productDAO.listProducts();
				m.addAttribute("listProducts", listProducts);
				List<Category> listCategories=categoryDAO.getCategories();
				m.addAttribute("listCategories",listCategories);
				List<Supplier> listSuppliers = supplierDAO.getSuppliers();
				m.addAttribute("listSuppliers", listSuppliers);
				
				
				return "Productpage";
			}
		
		
		
		*/
		
		
}