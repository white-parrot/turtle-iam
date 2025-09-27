package rt.turtleIam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
@AutoConfigureMockMvc
public class SecurityConfigTest {

//    @Autowired
    private MockMvc mockMvc;

    private final static String BASE_URL = "/api";

//    @Test
    void requestWithValidCredentials_shouldBeAuthenticated() throws Exception {
        mockMvc.perform(get(BASE_URL+"/health")
                .with(httpBasic("admin", "passwd")))
                .andExpect(status().isOk());
    }

//    @Test
    void requestWithInvalidCredentials_shouldBeRejected() throws Exception {
        mockMvc.perform(get(BASE_URL+"/health")
                .with(httpBasic("admin", "wrong")))
                .andExpect(status().isUnauthorized());
    }

//    @Test
    void requestWithoutCredentials_shouldRedirectToLogin() throws Exception {
        mockMvc.perform(get(BASE_URL+"/health"))
                .andExpect(status().isUnauthorized());
    }
}
