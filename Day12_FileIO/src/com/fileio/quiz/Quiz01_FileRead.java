package com.fileio.quiz;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Quiz01_FileRead {
    public static void main(String[] args) {
        // 구글에서 원하는 짧은 영어나 시나, 가사, 뉴스, 소설 하나를 구해서 프로젝트 폴더 내에 txt 파일로 저장
        // -> 그 파일을 읽으들여 콘솔로 출력
        try(FileInputStream fis = new FileInputStream("forSale.txt")){

            //#1 배열에 저장해서 출력하는 방법
            byte[] bytes = new byte[fis.available()];

            fis.read(bytes);
            System.out.println(new String(bytes)); // Casting

            //#2 반환되는 int 값을 이용하는 방법
            int readData = 0;

            while ((readData=fis.read())!= -1){
                System.out.print((char)readData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // -> FileReader/BufferedReader 이용하기

        try(BufferedReader br = new BufferedReader(new FileReader("forSaleKR.txt"))){
            String str = "";
            while((str = br.readLine()) != null){
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
