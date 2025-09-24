package rt.turtleIam.config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import rt.turtleIam.entity.TurtleUser;
import rt.turtleIam.repository.TurtleUserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurtleUserDetailsService implements UserDetailsService {

    private final TurtleUserRepository tUserRepository;

    public TurtleUserDetailsService(TurtleUserRepository tUserRepository) {
        this.tUserRepository = tUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TurtleUser tUser = tUserRepository.findUserByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Email Id not Found"));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(tUser.getRole()));

        return new User(tUser.getEmail(), tUser.getPassword(), authorities);
    }
}
