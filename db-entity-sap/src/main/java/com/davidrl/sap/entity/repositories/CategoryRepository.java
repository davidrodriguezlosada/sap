package com.davidrl.sap.entity.repositories;

import com.davidrl.sap.entity.entities.Category;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

  List<Category> findByStoreId(Long storeId);
}
