package com.plant_eshop_backend.service.impl;

import com.plant_eshop_backend.dto.UserDetailsDto;
import com.plant_eshop_backend.dto.UserDto;
import com.plant_eshop_backend.entity.Role;
import com.plant_eshop_backend.entity.User;
import com.plant_eshop_backend.entity.UserDetails;
import com.plant_eshop_backend.repository.RoleRepository;
import com.plant_eshop_backend.repository.UserRepository;
import com.plant_eshop_backend.service.UserService;
import com.plant_eshop_backend.util.EntityIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityIdGenerator entityIdGenerator;

    @Override
    public User checkUserRole(String email, String Password) {
        return roleRepository.checkRole(email,Password);
    }

    @Override
    public UserDto saveUser(UserDto userdto) {
        System.out.println("save method called");
        String r = userdto.getRole();
        String id=entityIdGenerator.generateStringId(r);
        Role role= roleRepository.getRoleName(r);
        User user = new User();
        user.setUserId(id);
        user.setUserEmail(userdto.getUserEmail());
        user.setUserPassword(userdto.getUserPassword());
        user.setUrole(role);
        UserDetailsDto userDetailsDto= userdto.getUserDetailsDto();
        UserDetails userDetails= new UserDetails();
        userDetails.setUserDetailsId(id);
        userDetails.setUserFirstName(userDetailsDto.getUserFirstName());
        userDetails.setUserLastName(userDetailsDto.getUserLastName());
        userDetails.setUserAddress(userDetailsDto.getUserAddress());
        userDetails.setCountry(userDetailsDto.getCountry());
        userDetails.setState(userDetailsDto.getState());
        userDetails.setCity(userDetailsDto.getCity());
        userDetails.setUserMobile(userDetailsDto.getUserMobile());
        userDetails.setPincode(userDetailsDto.getPincode());
        user.setUdetail(userDetails);
        userRepository.save(user);
        System.out.println("Role :"+r);
        if(userdto.getUserId().equals(user.getUserId()))
        {
            return userdto;
        }else {
            return  null;
        }
    }

    @Override
    public UserDto getUserById(String userId) {
        User user = userRepository.findByUserId(userId);

        if (user != null) {
            UserDto userDto = new UserDto();
            userDto.setUserId(user.getUserId());
            userDto.setUserEmail(user.getUserEmail());
            userDto.setUserPassword(user.getUserPassword());
            userDto.setRole(user.getUrole().getRole_name());

            UserDetailsDto userDetailsDto = new UserDetailsDto();
            UserDetails userDetails = user.getUdetail();
            userDetailsDto.setUserDetailsId(userDetails.getUserDetailsId());
            userDetailsDto.setUserFirstName(userDetails.getUserFirstName());
            userDetailsDto.setUserLastName(userDetails.getUserLastName());
            userDetailsDto.setUserAddress(userDetails.getUserAddress());
            userDetailsDto.setCountry(userDetails.getCountry());
            userDetailsDto.setState(userDetails.getState());
            userDetailsDto.setCity(userDetails.getCity());
            userDetailsDto.setUserMobile(userDetails.getUserMobile());
            userDetailsDto.setPincode(userDetails.getPincode());

            userDto.setUserDetailsDto(userDetailsDto);

            return userDto;
        } else {
            return null;
        }
    }


    @Override
    public UserDto updateUserById(String userId, UserDto userDto) {
        User user = userRepository.findByUserId(userId);

        if (user!=null) {
            user.setUserEmail(userDto.getUserEmail());
            user.setUserPassword(userDto.getUserPassword());

            Role role = roleRepository.getRoleName(userDto.getRole());
            user.setUrole(role);

            UserDetails userDetails = user.getUdetail();
            UserDetailsDto userDetailsDto = userDto.getUserDetailsDto();

            userDetails.setUserFirstName(userDetailsDto.getUserFirstName());
            userDetails.setUserLastName(userDetailsDto.getUserLastName());
            userDetails.setUserAddress(userDetailsDto.getUserAddress());
            userDetails.setCountry(userDetailsDto.getCountry());
            userDetails.setState(userDetailsDto.getState());
            userDetails.setCity(userDetailsDto.getCity());
            userDetails.setUserMobile(userDetailsDto.getUserMobile());
            userDetails.setPincode(userDetailsDto.getPincode());

            userRepository.save(user);

            return userDto;
        } else {
            return null;
        }
    }
}
