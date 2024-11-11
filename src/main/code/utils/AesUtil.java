package utils;

import org.jasypt.util.text.AES256TextEncryptor;

/**
 * @author Yuri
 * @since 2024/11/11 18:25
 */


public class AesUtil {

    public static void main(String[] args) {

    }

    public static String decrypt(String cipher, String key) {
        AES256TextEncryptor encryptor = new AES256TextEncryptor();
        encryptor.setPassword(key);
        return encryptor.decrypt(cipher);
    }

    public static String encrypt(String data, String key) {
        AES256TextEncryptor encryptor = new AES256TextEncryptor();
        encryptor.setPassword(key);
        return encryptor.encrypt(data);
    }

}
