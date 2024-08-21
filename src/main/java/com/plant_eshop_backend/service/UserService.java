package com.plant_eshop_backend.service;
import com.plant_eshop_backend.dto.UserDto;
import com.plant_eshop_backend.entity.User;

import java.util.Optional;

public interface UserService {
    public User checkUserRole(String email, String Password);

    public UserDto saveUser(UserDto userDto);

    public UserDto getUserById(String userId);

    public UserDto updateUserById(String userId, UserDto userDto);
}
