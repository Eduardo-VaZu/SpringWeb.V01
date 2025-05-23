package pe.example.springWeb.v01.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.example.springWeb.v01.repository.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUsernameAndActive(String username, Boolean isActive);

    @Query("SELECT u FROM UserEntity u WHERE u.id=:id and u.active=:active")
    Optional<UserEntity> findByIdAndActive(@Param("id") Integer id, @Param("active") Boolean active);

    @Query("SELECT u FROM UserEntity u WHERE u.active=:active")
    List<UserEntity> findAllActive(@Param("active") Boolean active);

}
