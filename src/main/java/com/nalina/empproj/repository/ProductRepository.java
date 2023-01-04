package com.nalina.empproj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nalina.empproj.entity.ProductEntity;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
