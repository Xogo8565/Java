package com.fileio.exam;

import java.io.BufferedReader;
import java.io.FileReader;

public class Exam04_FileReader02 {
    public static void main(String[] args) {
        //FileReader :  txt 파일을 character 단위로 읽어오는 클래스
        //BufferedReader : 데이터를 한 줄 단위로 읽어 들여올 수 있게 해줌
        try(FileReader fr = new FileReader("test02.txt");
        BufferedReader br = new BufferedReader(fr)){
//            System.out.println((char)fr.read());
//            System.out.println((char)fr.read());
//            System.out.println((char)fr.read());

//            System.out.println(br.readLine());
//            System.out.println(br.readLine());
//            System.out.println(br.readLine());
//            System.out.println();

            String str = "";

            while((str = br.readLine())!=null){
                System.out.println(str);
            }
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
