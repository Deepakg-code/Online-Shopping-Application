package com.jsp.osa.requestdto;

import com.jsp.osa.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String email;
    private String password;
    private Role role;
}
