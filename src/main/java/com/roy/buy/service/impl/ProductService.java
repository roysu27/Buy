package com.roy.buy.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.multipart.MultipartFile;

import com.roy.buy.dao.IProductDao;
import com.roy.buy.entity.Product;
import com.roy.buy.service.IProductService;
import com.roy.buy.utils.Utils;

@Service
public class ProductService implements IProductService {
	
	/**
	 * 自動注入ProductDao
	 */
	@Autowired
	private IProductDao productDao;

	@Autowired
	private HibernateTransactionManager transactionManager;

	@Override
	public void createProduct(Product product) {
		productDao.save(product);
	}

	@Override
	public List<Product> getProductList(int categoryId) {
		return productDao.findProductList(categoryId);
	}

	@Override
	public Product getProductDetail(int productId) {
		return productDao.findById(productId);
	}

	@Override
	public List<Product> searchProduct(String searchStr) {
		return productDao.findProductListByLikeStr(searchStr);
	}

	@Override
	public int countProductTotal(int[] productIdArray, int[] prductQuantityArray) {
		int total = 0;
		for (int i = 0; i < prductQuantityArray.length; i++) {
			Product product = productDao.findById(productIdArray[i]);
			total += product.getDiscountsPrice() * prductQuantityArray[i];
		}
		return total;
	}

	@Override
	public void updateProduct(Product product) {
		productDao.update(product);
	}

	@Override
	public List<Product> getProductListByIdList(List<Integer> idList) {
		return productDao.findProductListByProductIdList(idList);
	}

	@Override
	public void addProductImage(int id, MultipartFile image, String webappRootPath) throws IOException {
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
		definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManager.getTransaction(definition);

		try {
			// 新增商品圖片
			String photoDir = webappRootPath + "/resources/image/";
			String filename = id + Utils.getFileExtension(image.getOriginalFilename());
			String fileNameAndPath = photoDir + filename;
			saveFile(image.getInputStream(), fileNameAndPath);
	
			// 儲存商品圖片網址
			String imageUrl = "http://localhost:8080/resources/image/" + filename;
			Product product = productDao.findById(id);
			product.setImageUrl(imageUrl);
			productDao.update(product);
			transactionManager.commit(status);
		}
		catch(Exception e) {
			transactionManager.rollback(status);
			throw e;
		}
	}
	
	/**
	 * 儲存檔案
	 * @param intputStream
	 * @param filePathAndName
	 * @throws IOException
	 */
	private void saveFile(InputStream intputStream, String filePathAndName) throws IOException {
		FileOutputStream fos = new FileOutputStream(filePathAndName);
		byte[] buffer = new byte[1024 * 1024];
		int byteread = 0;
		while((byteread = intputStream.read(buffer)) != -1) {
			fos.write(buffer, 0, byteread);
			fos.flush();
		}
		fos.close();
		intputStream.close();
	}

	@Override
	public List<Product> getProductList() {
		return productDao.findAll();
	}

	@Override
	public void deductBuyProduct(int[] productIdArray, int[] prductQuantityArray) {
		for (int i = 0; i < productIdArray.length; i++) {
			Product product = productDao.findById(productIdArray[i]);
			int reserve = product.getReserve() - prductQuantityArray[i];
			product.setReserve(reserve);
			productDao.update(product);
		}
	}

}
