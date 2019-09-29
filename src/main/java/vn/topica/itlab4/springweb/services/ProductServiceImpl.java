package vn.topica.itlab4.springweb.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.topica.itlab4.springweb.dao.IProductDAO;
import vn.topica.itlab4.springweb.model.ProductModel;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private IProductDAO productDAO;

	@Override
	public ProductModel insertProduct(ProductModel productModel) {
		return productDAO.insertProduct(productModel);
	}

	@Override
	public ProductModel updateProduct(ProductModel productModel) {
		return productDAO.updateProduct(productModel);
	}

	@Override
	public void deleteProduct(int id) {
		
		productDAO.deleteProduct(id);
		
	}

	@Override
	public ProductModel findProductById(int id) {
		return productDAO.findProductById(id);
	}

	@Override
	public List<ProductModel> getAllProduct() {
		return productDAO.getAllProduct();
	}

	@Override
	public Set<String> getAllTypeOfProduct() {
		// TODO Auto-generated method stub
		return productDAO.getAllTypeOfProduct();
	}

	@Override
	public List<ProductModel> findProductByName(String productName) {
		// TODO Auto-generated method stub
		return productDAO.findProductByName(productName);
	}
	
	
	
	

}
