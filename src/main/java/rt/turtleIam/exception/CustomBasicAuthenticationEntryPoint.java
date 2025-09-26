package rt.turtleIam.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

public class CustomBasicAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setHeader("Turtle-WWW-Authenticate", "Basic realm=\"Turtle IAM\"");
        response.setHeader("'Reason", "Authentication failed");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());

        response.setContentType("application/json;chatset=UTF-8");
        String jsonResponse = "{" +
                "\"timestamp\": \"" + System.currentTimeMillis() + "\"," +
                "\"status\": \"" + HttpStatus.UNAUTHORIZED.value() + "\"," +
                "\"error\": \"" + authException.getMessage() + "\"," +
                "\"message\": \"" + authException.getMessage() + "\"," +
                "\"path\": \"/" + request.getRequestURI() + "\"" + "}";

        response.getWriter().write(jsonResponse);

    }
}
