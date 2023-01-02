package com.example.idcardchecker.Classes;

import jakarta.xml.bind.DatatypeConverter;
import org.jetbrains.annotations.NotNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
    public static @NotNull String Translate_to_MD5_HASH(@NotNull String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        return  DatatypeConverter.printHexBinary(digest).toUpperCase();
    }
}
