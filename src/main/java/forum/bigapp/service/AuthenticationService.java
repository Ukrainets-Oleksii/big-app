package forum.bigapp.service;

import forum.bigapp.dto.request.UserLoginRequestDto;
import forum.bigapp.dto.request.UserRegistrationRequestDto;
import forum.bigapp.dto.response.UserLoginResponseDto;
import forum.bigapp.dto.response.UserRegistrationResponseDto;

public interface AuthenticationService {
    UserRegistrationResponseDto register(UserRegistrationRequestDto
                                                 requestDto);

    UserLoginResponseDto login(UserLoginRequestDto request);
}