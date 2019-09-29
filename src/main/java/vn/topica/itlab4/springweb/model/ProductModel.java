package vn.topica.itlab4.springweb.model;

public class ProductModel {
	
	private int id;
	private String type;
	private String name;
	private long price;
	private String img;
	
	private static int index = 0;
	
	
	public ProductModel() {
		index++;
		id = index;
	}
	
	public ProductModel(String type, String name, long price, String img) {
		index++;
		this.id = index;
		this.type = type;
		this.name = name;
		this.price = price;
		this.img = img;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	

}
