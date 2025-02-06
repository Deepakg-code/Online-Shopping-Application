package com.jsp.osa.serviceimpl;

import com.jsp.osa.entity.Customer;
import com.jsp.osa.entity.Seller;
import com.jsp.osa.entity.User;
import com.jsp.osa.enums.Role;
import com.jsp.osa.repositoy.UserRepository;
import com.jsp.osa.requestdto.UserRequest;
import com.jsp.osa.responsedto.UserResponse;
import com.jsp.osa.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private User mapToUser(UserRequest userRequest, User user) {
        user.setEmail(userRequest.getEmail());
        user.setUsername(username(userRequest.getEmail()));
        user.setPassword(userRequest.getPassword());
        user.setRole(userRequest.getRole());
        return user;
    }

    private UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .isEmailVerified(user.isEmailVerified())
                .isDeleted(user.isDeleted())
                .build();
    }

    private String username(String email) {
        StringBuilder s = new StringBuilder();
        for (int i = 0;i<email.length();i++){
            if(email.charAt(i)=='@'){
                return s.toString();
            }
            else {
                s.append(email.charAt(i));
            }
        }
        throw new RuntimeException("Invalid User Name");
    }

    @Override
    public UserResponse registerUser(UserRequest userRequest) {
        User user = null;
        if (userRequest.getRole() == Role.CUSTOMER) {
            user = this.mapToUser(userRequest, new Customer());
        } else if (userRequest.getRole() == Role.SELLER){
            user = this.mapToUser(userRequest, new Seller());
        }
        user.setEmailVerified(false);
        user.setDeleted(false);
        userRepository.save(user);
        return this.mapToUserResponse(user);
    }


}
