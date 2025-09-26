package rt.turtleIam.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setHeader("Turtle-WWW-Authenticate", "Basic realm=\"Turtle IAM\"");
        response.setHeader("'Reason", "Access failed");
        response.setStatus(HttpStatus.FORBIDDEN.value());

        response.setContentType("application/json;chatset=UTF-8");
        String jsonResponse = "{" +
                "\"timestamp\": \"" + System.currentTimeMillis() + "\"," +
                "\"status\": \"" + HttpStatus.FORBIDDEN.value() + "\"," +
                "\"error\": \"" + accessDeniedException.getMessage() + "\"," +
                "\"message\": \"" + accessDeniedException.getMessage() + "\"," +
                "\"path\": \"/" + request.getRequestURI() + "\"" + "}";

        response.getWriter().write(jsonResponse);

    }
}
