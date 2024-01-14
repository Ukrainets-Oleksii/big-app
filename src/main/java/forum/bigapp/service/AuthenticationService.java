package forum.bigapp.service;

import forum.bigapp.dto.request.UserLoginRequestDto;
import forum.bigapp.dto.request.UserRegistrationRequestDto;
import forum.bigapp.dto.response.UserRegistrationResponseDto;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthenticationService {
    UserRegistrationResponseDto register(
            UserRegistrationRequestDto requestDto);

    void login(UserLoginRequestDto request,
                               HttpServletResponse response);
}