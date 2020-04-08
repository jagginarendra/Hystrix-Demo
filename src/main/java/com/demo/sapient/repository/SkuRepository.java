package com.demo.sapient.repository;

import com.demo.sapient.model.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuRepository extends JpaRepository<Sku, Integer> {

    List<Sku> findByColor(String color);

    List<Sku> findBySize(int size);
}
