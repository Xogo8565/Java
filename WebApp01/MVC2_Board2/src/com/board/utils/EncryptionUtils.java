package com.board.utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class EncryptionUtils {
    // 원본 데이터가 동일한 값이면 -> 암호화된 데이터도 동일한 결과값이 나오게 됨
    public static String getSHA512(String str) throws Exception{
        //MessageDigest 클래스 인스턴스 생성(인자값 = 암호화 작업을 적용시킬 알고리즘)
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
        messageDigest.reset(); // 사용 전 초기화 과정
        messageDigest.update(str.getBytes(StandardCharsets.UTF_8)); // 변환할 원본 데이터를 UTF-8을 적용한 바이트 배열로 변환해서 update 메서드에 넘겨주면, 데이터의 암호화(128bytes 의 데이터로 변환)가 실행
        // digest() -> 암호화된 데이터(변환된 데이터)를 바이트 배열로 반환
        // 반환받은 바이트 배열을 양수인 정수형으로 변환
        BigInteger bigInteger = new BigInteger(1,messageDigest.digest());
        // 정수형을 128바이트의 문자열로 변환
        return String.format("%0128x", bigInteger);
    }
}
