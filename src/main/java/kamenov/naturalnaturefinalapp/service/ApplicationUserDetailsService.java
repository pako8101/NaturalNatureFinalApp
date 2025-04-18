package kamenov.naturalnaturefinalapp.service;


import kamenov.naturalnaturefinalapp.entity.UserEntity;
import kamenov.naturalnaturefinalapp.entity.UserRoleEnt;
import kamenov.naturalnaturefinalapp.repositories.UserRepository;

import kamenov.naturalnaturefinalapp.user.AppUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class ApplicationUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public ApplicationUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found!"));
    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return
//                userRepository.
//                        findByUsername(username).
//                        map(ApplicationUserDetailsService::map).
//                        orElseThrow(() -> new UsernameNotFoundException("User with name " + username + " not found!"));
//    }
    private UserDetails map(UserEntity userEntity) {
        if (userEntity == null) {
            throw new IllegalArgumentException("UserEntity cannot be null");
        }
        return new AppUserDetails(userEntity.getUsername(),
                userEntity.getPassword(),
                extractAuthorities(userEntity))
                .setFullName(userEntity.getFullName());
    }

    private List<GrantedAuthority> extractAuthorities(UserEntity userEntity) {
        if (userEntity.getRoles() == null || userEntity.getRoles().isEmpty()) {
            return Collections.emptyList();
        }
        return userEntity.getRoles().stream()
                .map(this::mapRole)
                .collect(Collectors.toList());
    }

    private GrantedAuthority mapRole(UserRoleEnt userRoleEntity) {
        return new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getRole().name());
    }

    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }
//
//    private static   UserDetails map(UserEntity userEntity) {
//        if (userEntity == null) {
//            throw new IllegalArgumentException("UserEntity cannot be null");
//        }
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        return new org.springframework.security.core.
//                userdetails.User(userEntity.getUsername(),
//                userEntity.getPassword(), authorities);
////        return new AppUserDetails(
////                userEntity.getUsername(),
////                userEntity.getPassword(),
////                extractAuthorities(userEntity)
////        ).
////                setFullName(userEntity.getFullName());
//
//    }
//
//
//    private static List<GrantedAuthority> extractAuthorities(UserEntity userEntity) {
//        return userEntity.
//                getRoles().
//                stream().
//                map(ApplicationUserDetailsService::mapRole).
//                toList();
//    }
//
//    private static GrantedAuthority mapRole(UserRoleEnt userRoleEntity) {
//        return new SimpleGrantedAuthority("ROLE_" + userRoleEntity.getRole());
//    }
//    public void saveUser(UserEntity user) {
//        userRepository.save(user);
//    }
}
