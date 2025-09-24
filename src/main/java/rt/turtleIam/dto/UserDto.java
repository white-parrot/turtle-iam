package rt.turtleIam.dto;

import lombok.Data;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

@Data
public class UserDto {

    private final String username;
    private final String authority;
    private final boolean enabled;
    private String password;

}
