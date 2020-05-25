package classicPayModel.controller;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import classicPayModel.bll.ProductManager;
import classicPayModel.entity.Product;

//controller for front end display connection is single classes for front end. 
// makes the connection 'multithreaded' and allows modular ajax access to the data.
//jsp component calls this method
public class ProductController {

	
	private String productDescription;
	private String productName;
	private String productScale;
	private String productVendor;
	private String productLine;
	
	private ProductManager productManager = new ProductManager();
	private DataModel dataMList = new ListDataModel();
	
	
	public Product getProductByProductCode(int code) {
		Product prod = productManager.getProductByProductCode(code);
		
		
		return prod;
	}



	public String getProductDescription() {
		return productDescription;
	}



	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}



	public String getProductName() {
		return productName;
	}



	public void setProductName(String productName) {
		this.productName = productName;
	}



	public String getProductScale() {
		return productScale;
	}



	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}



	public String getProductVendor() {
		return productVendor;
	}



	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}



	public String getProductLine() {
		return productLine;
	}



	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}



	public ProductManager getProductManager() {
		return productManager;
	}



	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}



	public DataModel getDataMList() {
		return dataMList;
	}



	public void setDataMList(DataModel dataMList) {
		this.dataMList = dataMList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
