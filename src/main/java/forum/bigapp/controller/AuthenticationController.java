package forum.bigapp.controller;

import forum.bigapp.dto.request.UserLoginRequestDto;
import forum.bigapp.dto.request.UserRegistrationRequestDto;
import forum.bigapp.dto.response.UserRegistrationResponseDto;
import forum.bigapp.exception.RegistrationException;
import forum.bigapp.service.AuthenticationService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("/login")
    public void login(
            @RequestBody @Valid UserLoginRequestDto dto, HttpServletResponse response) {
        service.login(dto, response);
    }

    @PostMapping("/register")
    public UserRegistrationResponseDto register(
            @RequestBody @Valid UserRegistrationRequestDto dto) {
        return service.register(dto);
    }
}