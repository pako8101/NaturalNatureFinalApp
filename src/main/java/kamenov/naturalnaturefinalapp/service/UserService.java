package kamenov.naturalnaturefinalapp.service;


import kamenov.naturalnaturefinalapp.entity.UserEntity;
import kamenov.naturalnaturefinalapp.entity.dto.RegisterDto;
import kamenov.naturalnaturefinalapp.user.AppUserDetails;
import org.springframework.security.core.Authentication;

import java.util.Optional;
import java.util.function.Consumer;

public interface UserService {


    //UserEntity registerUser(UserEntity user);

//    UserEntity registerUser(RegisterDto userRegisterDto);

    UserEntity registerUser(RegisterDto userRegisterDto, Consumer<Authentication> successfulRegister);

    UserEntity findByName(String username);

    Optional<AppUserDetails> getCurrentUser();

    UserEntity findByEmail(String email);
}
