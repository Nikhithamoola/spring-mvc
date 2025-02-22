package com.sathya.mvc.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sathya.mvc.entity.ProductEntity;
import com.sathya.mvc.model.ProductModel;
import com.sathya.mvc.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@GetMapping("/productform")
	public String getProductForm(Model model) {
		//give the form with empty object
		ProductModel productModel=new ProductModel();
		 model.addAttribute("productModel",productModel);
		 model.addAttribute("page", "productform");
			return "index";
	}
	@PostMapping("/saveproducts")
	public String saveProductData(ProductModel productModel)
	{
		productService.saveProductData(productModel);
		return "success";
	}
	@GetMapping("/getProducts")
	public String getProducts (Model model) {
		List<ProductEntity> products= productService.getALLProducts(); 
		model.addAttribute("products",products);
		model.addAttribute("page", "getProducts");
		return "index";
		
	}
	
	@GetMapping("/searchform")
	 public String getSearchForm(Model model) {
		 ProductModel productModel = new ProductModel();
	     model.addAttribute("productModel", productModel);
	     model.addAttribute("page", "searchform");
			return "index";
	 }
	 @GetMapping("/searchProduct")
	 public String searchProduct(@RequestParam long proId, Model model) {
	     ProductEntity product = productService.getProductById(proId);
	     if (product != null) {
	         model.addAttribute("product", product);
	     } else {
	         model.addAttribute("error", "Product not found!");
	     }
	     model.addAttribute("page", "searchform");
			return "index";
	}
	@GetMapping("/delete")
    public String deleteProduct(@RequestParam Long proId) {
        productService.deleteById(proId); 
        return "redirect:/getProducts";
	}
	
	@GetMapping("/edit")
	public String getedittForm(@RequestParam("proId") Long proId ,Model model) {
		//give the form with empty object
		ProductModel productModel= productService.getProductById(proId);
		 model.addAttribute("proId",proId);
		 model.addAttribute("categories", Arrays.asList("Mobile", "Camera", "Printer", "Laptop", "Accessories"));
		 model.addAttribute("productModel",productModel);		
		return "edit";
	}
	@PostMapping("/update")
	public String updateProduct(@ModelAttribute ProductModel productModel, 
								@RequestParam Long proId) {
		productService.updateProduct(proId, productModel);

		return "redirect:/getProducts";  // Adjust the redirect path as necessary
	}
	@GetMapping("/contactus")
	public String getcontacttForm(Model model) {
		//give the form with empty object
		model.addAttribute("page", "contactus");
		return "index";
	
	}
	@GetMapping("/aboutus")
	public String getaboutForm(Model model) {
		//give the form with empty object	
		model.addAttribute("page", "aboutus");
		return "index";
	}
	@GetMapping("/")
	public String getHomepage() {
		//give the form with empty object	
		return "index";
	}
}