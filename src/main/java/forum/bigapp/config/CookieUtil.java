package forum.bigapp.config;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CookieUtil {
    public static void setJwtTokenToCookie(String token, HttpServletResponse response) {
        Cookie cookie = new Cookie("jwtToken", token);
        cookie.setPath("/");
        cookie.setMaxAge(86400);

        response.addCookie(cookie);
    }

    public static Cookie findJwtCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("jwtToken")) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
