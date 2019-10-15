package vn.topica.itlab4.springweb.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.topica.itlab4.springweb.model.ProductModel;
import vn.topica.itlab4.springweb.services.IProductService;

@Controller
public class ProductController {
	
	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/web/product/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		
		ModelAndView modelAndView = new ModelAndView("/home/index");
		List<ProductModel> products = productService.getAllProduct();
		modelAndView.addObject("products", products);
		
		Set<String> typeProductSet = productService.getAllTypeOfProduct();
		modelAndView.addObject("types", typeProductSet);
		
		System.out.println("this is product controller");
		System.out.println("the change 2");
		System.out.println("the change 3");
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/web/product/{id}")
	public ModelAndView getProductDetail(@PathVariable("id") Integer id) {
		
		ProductModel productModel = productService.findProductById(id);
		
		ModelAndView modelAndView = new ModelAndView("/detail/index");
		modelAndView.addObject("product", productModel);
		
		return modelAndView;
	}
	
	@PostMapping(value = "/web/product")
	public ModelAndView searchProductByName(@RequestParam String productName) {
		ModelAndView modelAndView = new ModelAndView("/home/index");
		List<ProductModel> products = productService.findProductByName(productName);
		modelAndView.addObject("products", products);
		
		return modelAndView;
	}
	
	
}
