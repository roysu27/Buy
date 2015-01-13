package com.roy.buy.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public int countProductTotal(int[] productIdArray) {
		List<Integer> productIdList = new ArrayList<>();
		for(int id : productIdArray) {
			productIdList.add(new Integer(id));
		}
		List<Product> productList = productDao.findProductListByProductIdList(productIdList);
		return productList.stream()
				.mapToInt(Product::getDiscountsPrice)
				.sum();
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

}
