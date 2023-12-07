package com.davidrl.sap.entity.repositories;

import com.davidrl.sap.entity.entities.Item;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

  List<Item> findByCategoryId(Long categoryId);
}
