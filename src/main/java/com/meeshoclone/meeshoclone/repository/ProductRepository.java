package com.meeshoclone.meeshoclone.repository;

import com.meeshoclone.meeshoclone.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
