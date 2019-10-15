package vn.topica.itlab4.springweb.dao;

import java.util.List;
import java.util.Set;

import vn.topica.itlab4.springweb.model.ProductModel;

public interface IProductDAO {
	
	ProductModel insertProduct(ProductModel productModel);
	
	ProductModel updateProduct(ProductModel productModel);
	
	void deleteProduct(int id);
	
	ProductModel findProductById(int id);
	
	List<ProductModel> getAllProduct();
	
	Set<String> getAllTypeOfProduct();
	
	List<ProductModel> findProductByName(String productName);
}
