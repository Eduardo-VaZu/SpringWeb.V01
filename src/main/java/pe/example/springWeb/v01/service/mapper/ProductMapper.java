package pe.example.springWeb.v01.service.mapper;

import pe.example.springWeb.v01.controller.dto.ProductItem;
import pe.example.springWeb.v01.repository.entity.ProductEntity;

public class ProductMapper {

    private ProductMapper() {};

    public static ProductEntity fromDtoToEntity(ProductItem item, ProductEntity entity) {

        entity.setName(item.getName());
        entity.setDescription(item.getDescription());
        entity.setPrice(item.getPrice());
        entity.setStorage(item.getStorage());

        return entity;
    }

    public static ProductItem fromEntityToDto(ProductEntity entity, ProductItem item) {
        item.setId(entity.getId());
        item.setName(entity.getName());
        item.setDescription(entity.getDescription());
        item.setPrice(entity.getPrice());
        item.setStorage(entity.getStorage());

        return item;
    }
}
