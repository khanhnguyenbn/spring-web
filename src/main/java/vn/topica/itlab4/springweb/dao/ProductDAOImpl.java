package vn.topica.itlab4.springweb.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import vn.topica.itlab4.springweb.model.ProductModel;

@Repository
public class ProductDAOImpl implements IProductDAO {

	private static Map<Integer, ProductModel> productMap = initProductMap();

	@Override
	public ProductModel insertProduct(ProductModel productModel) {
		
		ProductModel newProduct = new ProductModel();
		newProduct.setName(productModel.getName());
		newProduct.setType(productModel.getType());
		newProduct.setPrice(productModel.getPrice());
		
		productMap.put(newProduct.getId(), newProduct);
		
		return productMap.get(newProduct.getId());
	}

	@Override
	public ProductModel updateProduct(ProductModel productModel) {
		
		if(productMap.get(productModel.getId()) != null) {
			productMap.put(productModel.getId(), productModel);
		}
		
		return productMap.get(productModel.getId());

	}

	@Override
	public void deleteProduct(int id) {
		
		if(productMap.containsKey(id)) {
			productMap.remove(id);
		}
	}

	@Override
	public ProductModel findProductById(int id) {
		// TODO Auto-generated method stub
		ProductModel productModel = productMap.get(id);
		
		return productModel;
		
	}

	@Override
	public List<ProductModel> getAllProduct() {
		List<ProductModel> productList = new ArrayList<ProductModel>();
		
		for (ProductModel productModel : productMap.values()) {
			productList.add(productModel);
		}
		
		return productList;
	}
	
	@Override
	public Set<String> getAllTypeOfProduct() {
		// TODO Auto-generated method stub
		Set<String> productTypeSet = new HashSet<String>();
		
		for (ProductModel productModel : productMap.values()) {
			if(!productTypeSet.contains(productModel.getType())) {
				productTypeSet.add(productModel.getType());
			}
		}
		
		return productTypeSet;
	}

	private static Map<Integer, ProductModel> initProductMap() {

		Map<Integer, ProductModel> productMap = new HashMap<Integer, ProductModel>();

		ProductModel productModel = new ProductModel("Super Car", "Lykan HyperSport", 50000, "/spring-web/resources/img/sport_car_2.jpg");
		ProductModel productModel1 = new ProductModel("Super Car", "Bugatti cranks", 70000, "/spring-web/resources/img/sport_car_3.jpg");
		
		ProductModel productModel2 = new ProductModel("SUV", "SUV 1", 18000, "/spring-web/resources/img/SUV1.jpg");
		ProductModel productModel3 = new ProductModel("SUV", "SUV 2", 18500, "/spring-web/resources/img/SUV2.jpg");
		ProductModel productModel4 = new ProductModel("SUV", "SUV 3", 19000, "/spring-web/resources/img/SUV3.jpg");
		
		ProductModel productModel5 = new ProductModel("Sedan", "Sedan 1", 18000, "/spring-web/resources/img/sedan1.jpg");
		ProductModel productModel6 = new ProductModel("Sedan", "Sedan 2", 20000, "/spring-web/resources/img/sedan2.jpg");
		ProductModel productModel7 = new ProductModel("Sedan", "Sedan 3", 21000, "/spring-web/resources/img/sedan3.jpg");

		productMap.put(productModel.getId(), productModel);
		productMap.put(productModel1.getId(), productModel1);
		productMap.put(productModel2.getId(), productModel2);
		productMap.put(productModel3.getId(), productModel3);
		productMap.put(productModel4.getId(), productModel4);
		
		productMap.put(productModel5.getId(), productModel5);
		productMap.put(productModel6.getId(), productModel6);
		productMap.put(productModel7.getId(), productModel7);
		

		return productMap;
	}

	@Override
	public List<ProductModel> findProductByName(String productName) {
		List<ProductModel> result = new ArrayList<ProductModel>();
		
		for (ProductModel productModel : productMap.values()) {
			if(productModel.getName().toLowerCase().contains(productName.toLowerCase())) {
				result.add(productModel);
			}
		}
		
		return result;
	}

	

}
