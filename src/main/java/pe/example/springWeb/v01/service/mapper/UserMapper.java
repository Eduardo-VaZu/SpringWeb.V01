package pe.example.springWeb.v01.service.mapper;


import org.springframework.stereotype.Component;

import pe.example.springWeb.v01.controller.dto.UserItem;
import pe.example.springWeb.v01.repository.entity.UserEntity;

@Component
public class UserMapper {

    private UserMapper(){};

    public static UserEntity fromDtoToEntity(UserItem userItem, UserEntity userEntity){
        userEntity.setUsername(userItem.getUsername());
        userEntity.setFirstName(userItem.getFirstName());
        userEntity.setLastName(userItem.getLastName());
        userEntity.setDocNumber(userItem.getDocNumber());
        return userEntity;
    }
    
}
