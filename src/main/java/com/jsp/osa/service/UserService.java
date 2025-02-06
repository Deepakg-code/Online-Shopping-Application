package com.jsp.osa.service;

import com.jsp.osa.requestdto.UserRequest;
import com.jsp.osa.responsedto.UserResponse;

public interface UserService {
    UserResponse registerUser(UserRequest userRequest);
}
