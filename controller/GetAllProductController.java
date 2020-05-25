package classicPayModel.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import classicPayModel.bll.ProductManager;
import classicPayModel.entity.Product;
import classicPayModel.entity.ProductLine;

/*
 * handles the jsp page call to getAllProducts and list out in component
 * 
 * */

public class GetAllProductController {
	
	
	private String productCode;
	private String productName;
	private String productDescription;
	private String productVendor;
	private String productScale;
	private String productLine;
	private String outcome = "success";
	
	private DataModel products = new ListDataModel();
	private Hashtable<String,String> productHashTable =  new Hashtable<String,String>();
	private ProductManager prodManager  = new ProductManager();
	
	
	//returns string of success to front end and loads front end faces components
	public String findAllProducts() {
		
		//implement for getting any field search --> createSearchTable()
		//getProductByAnyField()
		//currently basic development of crud 
		//and get all mechanisms in place
		//createSearchTable();
		List<Product> p = new ArrayList<Product>();
		p = prodManager.getProductByAll();
		
		if(p.size()>0) {  
			outcome = "success";
			products.setWrappedData( p ); 
			
		} else { 
			outcome = "failed"; System.out.println("No products available.");
		
		}
		
		return outcome;
		
	}
	public String findProductByProductCode( int code ) {
		
		Product prod = new Product();
		prod = prodManager.getProductByProductCode(code);
		
		if(prod.getProductCode() == code) {
			products.setWrappedData( prod ); 
		}
		else {
			products.setWrappedData( null ); 
			
		}
		
		return outcome = "success";
	
	}
	
	public String findProductByProductLine( int pline ) {
		
		List<Product> productListByPL = new ArrayList<Product>();
		productListByPL = prodManager.getProductsByProductLine(pline);
		if(productListByPL.size()>0) {
			products.setWrappedData(productListByPL);
		}else {
			products.setWrappedData(null); 
		}
		return outcome = "success";
	
	}
//	public void findProductByAny(String productCode,
//								 String productName,
//								 String productDescription,
//								 String productVendor,
//								 String productScale,
//								 String productLine
//								 ) {
//		//string productLine is the name of the productLine
//		ProductLine pLine = prodManager.getProductLineByProductLineName(productLine);
//		
//		List<Product> productListByPL = new ArrayList<Product>();
//		//productListByPL = prodManager.findProductsByAllFields(
//				productCode, productName, productDescription, productVendor, productScale,
//				productLine);
//		if(productListByPL.size()>0) {
//			products.setWrappedData(productListByPL);
//		}else {
//			products.setWrappedData(null);
//		}		
//				
//	}
	
	
	//for use when front end search layout is ready convert all search to searchTable
	// field value pairs
	public void createSearchTable(List<Product> productList ) {
		
		
		
		if( productCode != null && !productCode.trim().equals("") ) {
			productHashTable.put("productCode", productCode);
		}
		if(productName != null && !productName.trim().equals("") ) {
			productHashTable.put("productName", productName);
		}
		if(productDescription != null && !productDescription.trim().equals("") ) {
			productHashTable.put("productDescription", productDescription);
				}
		if(productVendor != null && !productVendor.trim().equals("") ) {
			productHashTable.put("productVendor", productVendor);
		}
		if(productScale != null && !productScale.trim().equals("") ) {
			productHashTable.put("productScale", productScale);
		}
		if(productLine != null && !productLine.trim().equals("") ) {
			productHashTable.put("productLine", productLine);
		}

		
	}


	public String getProductLine() {
		return productLine;
	}


	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}


	public String getProductCode() {
		return productCode;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductVendor() {
		return productVendor;
	}

	public void setProductVendor(String productVendor) {
		this.productVendor = productVendor;
	}

	public String getProductScale() {
		return productScale;
	}

	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	public DataModel getProducts() {
		return products;
	}


	public void setProducts(DataModel products) {
		this.products = products;
	}


	public ProductManager getProdManager() {
		return prodManager;
	}


	public void setProdManager(ProductManager prodManager) {
		this.prodManager = prodManager;
	}
	

}
