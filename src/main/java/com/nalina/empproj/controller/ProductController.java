package com.nalina.empproj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nalina.empproj.dto.ProductDto;
import com.nalina.empproj.entity.ProductEntity;
import com.nalina.empproj.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping
	public ProductDto insertProduct(@RequestBody ProductDto productDto) {
		return productService.inserProduct(productDto);
	}
	@GetMapping
	public List<ProductEntity> fetchAll(){
		return productService.fetchAll();
	}
	@GetMapping("/{id}")
	public ProductDto getById(@PathVariable long id) {
		return productService.getById(id);
	}
	@PutMapping("/{id}")
	public ProductEntity modifyProd(@RequestBody ProductEntity productEntity) {
		return productService.modifyProd(productEntity);
	}
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable long id) {
		productService.deleteById(id);
	}
}
