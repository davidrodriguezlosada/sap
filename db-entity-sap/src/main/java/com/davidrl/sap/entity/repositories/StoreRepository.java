package com.davidrl.sap.entity.repositories;

import com.davidrl.sap.entity.entities.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository  extends CrudRepository<Store, Long> {

}
