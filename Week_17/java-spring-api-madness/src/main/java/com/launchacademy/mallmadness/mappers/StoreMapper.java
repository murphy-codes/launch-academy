package com.launchacademy.mallmadness.mappers;

import com.launchacademy.mallmadness.dtos.StoreDTO;
import com.launchacademy.mallmadness.models.Store;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

@Component
@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR, componentModel = "spring")
public interface StoreMapper {

  @Mapping(target = "averageCost", qualifiedByName = "averageCostConverter")
  StoreDTO storeToStoreDTO(Store store);
  List<StoreDTO> storesToStoreDtos(List<Store> stores);

  @Named("averageCostConverter")
  static String averageCostToString(Integer averageCost) {
    String[] averageCostStringValues = {"Bargain", "Good Deals", "Good Value","Pricey but Worth it", "Upscale"};
    return averageCostStringValues[averageCost-1];
  }
}
