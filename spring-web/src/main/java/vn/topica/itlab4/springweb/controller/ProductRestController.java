package vn.topica.itlab4.springweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vn.topica.itlab4.springweb.model.ProductModel;
import vn.topica.itlab4.springweb.services.IProductService;

@RestController
public class ProductRestController {

	@Autowired
	IProductService productService;

	@RequestMapping(value = "/api/products", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<ProductModel> getProducts() {
		List<ProductModel> productList = productService.getAllProduct();
		return productList;
	}

	// get product by id
	@RequestMapping(value = "/api/product/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ProductModel getProduct(@PathVariable("id") Integer id) {
		return productService.findProductById(id);
	}
	
	// create product
	@RequestMapping(value = "/api/product", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
	})
	@ResponseBody
	public ProductModel addProduct(@RequestBody ProductModel productModel) {
		
			return productService.insertProduct(productModel);
	}
	
	
	// update product
	@RequestMapping(value = "/api/product", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
	})
	public ProductModel updateProduct(@RequestBody ProductModel productModel) {
		return productService.updateProduct(productModel);
	}
	
	
	// delete product
	@RequestMapping(value = "/api/product/{id}", method = RequestMethod.DELETE, produces = {
			 MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE
	})
	@ResponseBody
	public void deleteProduct(@PathVariable("id") Integer id) {
		productService.deleteProduct(id);
	}
	

}
