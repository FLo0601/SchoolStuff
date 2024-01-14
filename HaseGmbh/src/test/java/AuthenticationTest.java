import org.hase.Authentication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class AuthenticationTest {

    public Authentication auth;
    @BeforeEach
    public void initAuth() {
        auth = Authentication.getInstance();
    }
    @Test
    public void TestGetInstance() {
        assertInstanceOf(Authentication.class, auth);
    }

    @Test
    @CsvSource({"Tester", "test", "test@mail.com"})
    public void TestAddAccount(String username, String password, String email) {
        auth.addAccount(username, password, email);
    }
}
