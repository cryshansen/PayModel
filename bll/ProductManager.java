package classicPayModel.bll;

import java.util.Hashtable;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import classicPayModel.dao.ProductDao;
import classicPayModel.dao.ProductLineDao;
import classicPayModel.entity.Product;
import classicPayModel.entity.ProductLine;

public class ProductManager {
	
	//middleware for handling the dao connections 
	//same as junit tests
	
	private ApplicationContext ctx =	new ClassPathXmlApplicationContext("pm-spring-config.xml");
	private ProductDao productDao = (ProductDao) ctx.getBean("productDao");
	private ProductLineDao productLineDao = (ProductLineDao) ctx.getBean("productLineDao") ;
	
	
	public List<Product> getProductByAll(){
		
		List<Product> pdao = productDao.getAllProducts();
		
		return pdao;
	}
	
	
	public Product getProductByProductCode(int prodCode){
		
		Product pdao = productDao.getProductByProductCode(prodCode);
		
		return pdao;
	}
	
	public List<Product> getProductsByProductLine(int productLine) {
		List<Product> pl = productDao.getProductsByProductLine(productLine);
		return pl;
	}
	
	public List<Product> findProductsByAllFields(String productCode,
			 String productName,
			 String productDescription,
			 String productVendor,
			 String productScale,
			 int productLine

			) {
		
		ProductLine prodLine = productLineDao.getProductLineByProductLine(productLine);
		List<Product> pl = productDao.findByAllFields(productCode, 
				productName, productDescription, productScale, 
				productVendor, prodLine);

				return pl;
	}
	public ProductLine getProductLineByProductLineName(String productLine) {
		ProductLine prodLine = productDao.getProductsByProductLine(productLine);
		return prodLine;
	}

}
