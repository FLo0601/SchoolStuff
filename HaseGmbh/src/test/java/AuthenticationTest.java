import org.hase.Authentication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(auth.addAccount(username, password, email));
    }

    @Test
    public void TestAuthenticate() {
        assertTrue(auth.authenticate("Tester", "test"));
    }

    @Test
    public void TestChangePassword() {
        assertTrue(auth.changePassword("Tester", "test", "test2"));
    }

    @Test
    public void TestResetPassword() {
        assertTrue(auth.resetPassword("Tester"));
    }
}
