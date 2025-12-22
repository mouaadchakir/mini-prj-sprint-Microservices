package com.boudaa.user_service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Long idUser;

    private String username;

    private String firstName;

    private String lastName;

    private String email;
}
