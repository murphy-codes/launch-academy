package com.launchacademy.mallmadness.repositories;

import com.launchacademy.mallmadness.models.Store;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends PagingAndSortingRepository<Store, Integer> {
  public boolean existsByName(String storeName);
  public Store findFirstById(Integer storeId);
}