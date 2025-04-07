package pe.example.springWeb.v01.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.example.springWeb.v01.repository.entity.ProductEntity;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    Optional<ProductEntity> findByIdAndActive(Integer id, boolean isActive);

    List<ProductEntity> findByActive(boolean isActive);
}
