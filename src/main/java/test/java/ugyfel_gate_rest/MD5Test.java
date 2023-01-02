package test.java.ugyfel_gate_rest;

import com.example.idcardchecker.Classes.MD5;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static junit.framework.Assert.assertEquals;

public class MD5Test
{
    @Test
    public void givenPassword_whenHashing_thenVerifying()
            throws NoSuchAlgorithmException {
        String hash = "35454B055CC325EA1AF2126E27707052";
        String password = "ILoveJava";
        System.out.println(MD5.Translate_to_MD5_HASH(password));
        assertEquals(MD5.Translate_to_MD5_HASH(password), hash);
    }
}
