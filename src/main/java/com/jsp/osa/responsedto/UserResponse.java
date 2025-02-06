package com.jsp.osa.responsedto;

import com.jsp.osa.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private int userId;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private boolean isEmailVerified;
    private Role role;
    private boolean isDeleted;
}
