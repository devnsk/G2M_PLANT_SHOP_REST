package com.plant_eshop_backend.service.impl;

import com.plant_eshop_backend.Exception.ResourceNotFound;
import com.plant_eshop_backend.dto.*;
import com.plant_eshop_backend.entity.*;
import com.plant_eshop_backend.repository.*;
import com.plant_eshop_backend.service.UserService;
import com.plant_eshop_backend.util.UserEntityIdGenerator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityIdGenerator userEntityIdGenerator;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserResponse getCheckUser(String email, String Password) {
        User user= userRepository.checkUser(email,Password);
        return user != null
                ? new UserResponse("login Successfully", true, HttpStatus.ACCEPTED, user)
                : new UserResponse("login failed", false, HttpStatus.NOT_FOUND, new User());
    }

    @Override
    public UserDto saveUser(UserDto userdto) {
        User userEntity = modelMapper.map(userdto, User.class);
        UserDetails userEntity1= modelMapper.map(userdto, UserDetails.class);
        System.out.println("saveModel mapper method called");
        String r = userdto.getRole();
        String id=userEntityIdGenerator.generateUserCustomId(r);
        Role role= roleRepository.getRoleName(r);
        userEntity.setUserId(id);
        userEntity1.setUserDetailsId(id);
        userEntity.setUrole(role);
        userEntity1.setState(userdto.getUserDetailsDto().getState());
        userEntity1.setCity(userdto.getUserDetailsDto().getCity());
        userEntity1.setCountry(userdto.getUserDetailsDto().getCountry());
        userEntity1.setPincode(userdto.getUserDetailsDto().getPincode());
        userEntity.setUdetail(userEntity1);
        User newUser= userRepository.save(userEntity);
        if(userEntity.getUserId().equals(newUser.getUserId()))
        {
            System.out.println("Execeuted..");
            return userdto;
        }else {
            return  null;
        }
    }

    @Override
    public UserDto getUserById(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFound("User not found with id: " + userId));
        if (user != null) {
            UserDto userDto1 = modelMapper.map(user, UserDto.class);

            UserDetailsDto userDetailsDto1= modelMapper.map(user.getUdetail(), UserDetailsDto.class);

            userDto1.setRole(user.getUrole().getRole_name());
            userDto1.setUserDetailsDto(userDetailsDto1);
            System.out.println("USERDTO1"+userDto1);
            System.out.println("USERDetailDTOEX"+userDetailsDto1);
            return userDto1;
        } else {
            return null;
        }
    }

    @Override
    public UserDto updateUserById(String userId, UserDto userDto) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFound("User not found with id: " + userId));
        User updatedUser = modelMapper.map(userDto, User.class);
        updatedUser.setUserId(existingUser.getUserId());
        Role role = roleRepository.getRoleName(userDto.getRole());
        if (role == null) {
            System.out.println("Role is null!");
        } else {
            updatedUser.setUrole(role);
        }
        UserDetailsDto userDetailsDto = userDto.getUserDetailsDto();
        UserDetails updatedUserDetails = modelMapper.map(userDetailsDto, UserDetails.class);
        updatedUserDetails.setUserDetailsId(existingUser.getUdetail().getUserDetailsId());
        updatedUser.setUdetail(updatedUserDetails);
        System.out.println("Updated UserDTO "+updatedUser);
        System.out.println("Updated UserDetailDTO "+updatedUserDetails);
        User savedUser = userRepository.save(updatedUser);
        if (savedUser.getUserId().equals(existingUser.getUserId())) {
            System.out.println("Updated User: " + savedUser);
            System.out.println("Updated Role: " + savedUser.getUrole());
            System.out.println("Updated UserDetails: " + savedUser.getUdetail());
            return userDto;
        } else {
            return null;
        }
        }
}
