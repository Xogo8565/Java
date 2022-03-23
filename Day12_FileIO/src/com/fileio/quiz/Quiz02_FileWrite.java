package com.fileio.quiz;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Quiz02_FileWrite {
    public static void main(String[] args) {
        String str = "For sale :\nbaby shoes. Never Worn.";
        //str 에 담긴 데이터를 txt 파일에 저장하기

        try(FileOutputStream fos = new FileOutputStream("forSaleWrite.txt");){
            //#1 byte[] 에 저장하는 방법
//            byte[] bytes = new byte[str.length()];
//            for(int i = 0; i < str.length(); i++){
//                bytes[i] = (byte)str.charAt(i);
//            }
//            fos.write(bytes);

            //#2 getBytes[] 메소드 이용
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            fos.write(bytes);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
