package org.hase;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class HaseGmbHManagement_Mockito_Test {
    @InjectMocks
    private HaseGmbHManagement haseGmbHManagement;
    @Mock
    private Authentication authentication;
    @Test
    @DisplayName("Mockito: recoverPassword")
    void TestRecoverPassword_WhenPasswordRecovered_ShouldReturnTrue() {
        Mockito.when(authentication.
                resetPassword(Mockito.anyString())).thenReturn(true);
        boolean result = haseGmbHManagement.recoverPassword("dummy");
        assertEquals(true,result, ()->"Error");
    }
}
