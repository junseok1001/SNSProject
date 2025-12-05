package com.sourjelly.snsproject.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256HashingEncoder {

    // 비밀번호가 데이터베이스에 바로 보여지지 않게 해주기 위한 암호화 sha-256
    public static String encode(String message){

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("sha256");

            byte[] bytes = message.getBytes();

            messageDigest.update(bytes);

            byte[] digest = messageDigest.digest();


            StringBuilder result = new StringBuilder();
            for(int i = 0; i < digest.length; i++){
                result.append(Integer.toHexString(digest[i] & 0xff));
            }


            return result.toString();

        } catch (NoSuchAlgorithmException e) {
            return null;
        }

    }
}
