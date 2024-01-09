package forum.bigapp.service.impl;

import forum.bigapp.dto.request.UserLoginRequestDto;
import forum.bigapp.dto.request.UserRegistrationRequestDto;
import forum.bigapp.dto.response.UserLoginResponseDto;
import forum.bigapp.dto.response.UserRegistrationResponseDto;
import forum.bigapp.exception.RegistrationException;
import forum.bigapp.mapper.UserMapper;
import forum.bigapp.model.Role;
import forum.bigapp.model.User;
import forum.bigapp.repository.RoleRepository;
import forum.bigapp.repository.UserRepository;
import forum.bigapp.security.jwt.JwtUtil;
import forum.bigapp.service.AuthenticationService;
import forum.bigapp.service.RoleService;
import forum.bigapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserMapper userMapper;
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserRegistrationResponseDto register(UserRegistrationRequestDto requestDto) {
        if (userService.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException(
                    "Unable to complete registration");
        }
        User user = userMapper.toModelFromRegistrationRequest(requestDto);
        user.setPassword(encoder.encode(user.getPassword()));
        Role.RoleName roleName = Role.RoleName.USER;
        Role role = roleService.getByRoleName(roleName);
        user.addRole(role);
        return userMapper.toUserRegistrationResponseDtoFromUser(userService.save(user));
    }

    @Override
    public UserLoginResponseDto login(UserLoginRequestDto request) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
                );
        String token = jwtUtil.generateToken(authentication.getName());
        return new UserLoginResponseDto(token);
    }
}