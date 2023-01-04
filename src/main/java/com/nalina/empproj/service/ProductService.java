package com.nalina.empproj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nalina.empproj.dto.ProductDto;
import com.nalina.empproj.entity.ProductEntity;
import com.nalina.empproj.repository.ProductRepository;
import com.nalina.empproj.utility.ProductUtility;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductUtility productUtility;

	public ProductDto inserProduct(ProductDto productDto) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setName(productDto.getName());
		productEntity.setDescription(productDto.getDescription());
		productEntity.setOriginalPrice(productDto.getOriginalPrice());
//		float onlyDiscount = productUtility.calculateDiscount(productDto.getOriginalPrice());
		productEntity.setDiscount(productUtility.calculateDiscount(productDto.getOriginalPrice()));
//		float onlyGST = productUtility.calculateGST(productDto.getOriginalPrice());
		productEntity.setGst(productUtility.calculateGST(productDto.getOriginalPrice()));
//		float totalPrice = productEntity.getOriginalPrice()-onlyDiscount +onlyGST;
//		float totalPrice = productEntity.getOriginalPrice()-productEntity.getDiscount() + productEntity.getGst();
		productEntity
				.setTotalPrice(productEntity.getOriginalPrice() - productEntity.getDiscount() + productEntity.getGst());
		productDto.setGst(productEntity.getGst());
		productDto.setDiscount(productEntity.getDiscount());
		productDto.setTotalPrice(productEntity.getTotalPrice());
		productRepository.save(productEntity);
		productDto.setId(productEntity.getId());
		return productDto;
	}

	public List<ProductEntity> fetchAll() {
		return productRepository.findAll();
	}

	public ProductDto getById(long id) {
		Optional<ProductEntity> byId = productRepository.findById(id);
		if (byId.isPresent()) {
			ProductEntity row = byId.get();
			ProductDto productDto = new ProductDto();
			productDto.setId(row.getId());
			productDto.setName(row.getName());
			productDto.setDescription(row.getDescription());
			productDto.setDiscount(row.getDiscount());
			productDto.setGst(row.getGst());
			productDto.setOriginalPrice(row.getOriginalPrice());
			productDto.setTotalPrice(row.getTotalPrice());
			return productDto;
		}
		return null;
	}

	public ProductEntity modifyProd(ProductEntity productEntity) {
		return productRepository.save(productEntity);
	}
	
	public void deleteById(long id) {
		productRepository.deleteById(id);
	}
}
