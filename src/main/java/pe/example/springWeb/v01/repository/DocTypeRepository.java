package pe.example.springWeb.v01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.example.springWeb.v01.repository.entity.DocTypeEntity;

@Repository
public interface DocTypeRepository extends JpaRepository<DocTypeEntity, Integer> {

}
