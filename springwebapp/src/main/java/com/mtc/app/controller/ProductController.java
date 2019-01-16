package com.mtc.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mtc.app.dao.IProductDAO;
import com.mtc.app.vo.Product;

@Controller
public class ProductController {

	@Autowired
	private IProductDAO productDAO;

	@RequestMapping("/allproducts")
	public String fetchAllProducts(Model model) {

		List<Product> products = productDAO.findAll();

		model.addAttribute("products",products);

		//view name
		return "product";
	}

	@RequestMapping("/searchproduct")
	public ModelAndView processSearch(HttpServletRequest request) {

		int pid = Integer.parseInt(request.getParameter("productid"));

		Product product = productDAO.findById(pid);

		// view name
		ModelAndView modelAndView = new ModelAndView("productView");

		modelAndView.addObject("product",product);

		return modelAndView;

	}
	@RequestMapping(value= "/productsbypage/{page_id}")
	public ModelAndView paginate(@PathVariable int page_id) {
		int total=10;
		if (page_id == 1) {
			page_id = page_id -1;
		}
		else {
			page_id= (page_id-1)*total; 
		}

		List<Product> productsByPage = productDAO.getpProductsByPage(page_id, total);
		return new ModelAndView("productsbypage","products",productsByPage);
	}

}
