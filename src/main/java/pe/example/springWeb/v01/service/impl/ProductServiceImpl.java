package pe.example.springWeb.v01.service.impl;

import java.util.List;
import java.util.Optional;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import pe.example.springWeb.v01.controller.dto.ProductItem;
import pe.example.springWeb.v01.exception.InvalidProductIdException;
import pe.example.springWeb.v01.exception.ProductNotFoundException;
import pe.example.springWeb.v01.repository.ProductRepository;
import pe.example.springWeb.v01.repository.entity.ProductEntity;
import pe.example.springWeb.v01.service.ProductService;
import pe.example.springWeb.v01.service.mapper.ProductMapper;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductItem> list() {
        List<ProductEntity> entities = productRepository.findByActive(true);
        log.info("Lista de Productos");
        return entities
                .stream()
                .map(entity -> ProductMapper.fromEntityToDto(entity, new ProductItem()))
                .toList();
    }

    @Override
    public void create(ProductItem productItem) {
        ProductEntity entity = ProductMapper.fromDtoToEntity(productItem, new ProductEntity());
        entity.setActive(Boolean.TRUE);
        productRepository.save(entity);
    }

    @Override
    public void update(Integer id, ProductItem productItem) {
        Optional<ProductEntity> entityOpt = productRepository.findById(id);

        if (entityOpt.isEmpty()) {
            throw new ProductNotFoundException("No existe el producto con id: " + id);
        }
        if (Boolean.FALSE.equals(entityOpt.get().getActive())) {
            throw new InvalidProductIdException("El producto con id: " + id + " no está activo");
        }

        ProductEntity entity = entityOpt.get();
        ProductMapper.fromDtoToEntity(productItem, entity);
        productRepository.save(entity);
    }

    @Override
    public void delete(Integer id) {
        Optional<ProductEntity> entityOpt = productRepository.findByIdAndActive(id, true);
        if (entityOpt.isEmpty()) {
            throw new ProductNotFoundException("No existe el producto con id: " + id);
        }
        ProductEntity entity = entityOpt.get();
        entity.setActive(Boolean.FALSE);
        productRepository.save(entity);
    }

}