package pe.example.springWeb.v01.service.impl;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;
import pe.example.springWeb.v01.controller.dto.UserItem;
import pe.example.springWeb.v01.exception.DocTypeNotFoundException;
import pe.example.springWeb.v01.exception.RolNotFoundException;
import pe.example.springWeb.v01.repository.DocTypeRepository;
import pe.example.springWeb.v01.repository.RoleRepository;
import pe.example.springWeb.v01.repository.UserRepository;
import pe.example.springWeb.v01.repository.entity.DocTypeEntity;
import pe.example.springWeb.v01.repository.entity.RoleEntity;
import pe.example.springWeb.v01.repository.entity.UserEntity;
import pe.example.springWeb.v01.service.UserService;
import pe.example.springWeb.v01.service.mapper.UserMapper;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final DocTypeRepository docTypeRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void create(UserItem userItem) {
        Optional<DocTypeEntity> docTypeEntity = docTypeRepository.findById(userItem.getDocTypeId());
        if (docTypeEntity.isEmpty()) {
            throw new DocTypeNotFoundException(String.format("No existe el tipo de documento con id %d", userItem.getDocTypeId()));
        }
        Optional<RoleEntity> roleEntity = roleRepository.findById(userItem.getRoleId());
        if (roleEntity.isEmpty()) {
            throw new RolNotFoundException(String.format("No existe el rol con id %d", userItem.getRoleId()));
        }

        UserEntity userEntity = UserMapper.fromDtoToEntity(userItem, new UserEntity());
        userEntity.setPassword(passwordEncoder.encode(userItem.getPassword()));
        userEntity.setDocTypeEntity(docTypeEntity.get());
        userEntity.setRoleEntity(roleEntity.get());
        userEntity.setActive(true);
        userRepository.save(userEntity);
    }

}
