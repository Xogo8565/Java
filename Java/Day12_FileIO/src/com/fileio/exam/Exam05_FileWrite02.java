package com.fileio.exam;

import java.io.FileWriter;

public class Exam05_FileWrite02 {
    public static void main(String[] args) {
        String str = "팝니다 아기신발\n한번도 신지않은";

        try(FileWriter fw = new FileWriter("forSaleKrWrite.txt")){
            fw.write(str);
            fw.flush(); // 버퍼에 잔여값을 방출해주는 메서드
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
