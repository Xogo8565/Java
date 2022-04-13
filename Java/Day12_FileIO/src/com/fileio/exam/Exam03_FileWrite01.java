package com.fileio.exam;

import java.io.FileOutputStream;

public class Exam03_FileWrite01 {
    public static void main(String[] args) {
        // 파일 출력은 OutputStream 이 필요
        try(FileOutputStream fos = new FileOutputStream("output.txt")){
            fos.write('A');
        } catch (Exception e){
            e.printStackTrace();
        }

        try(FileOutputStream fos = new FileOutputStream("output2.txt", true)){ // append true 면 기존 파일 값을 유지한 채로 수정 내용을 추가
            fos.write('A');
        } catch (Exception e){
            e.printStackTrace();
        }

        try(FileOutputStream fos = new FileOutputStream("output3.txt")){
            byte[] fileContents = {'a','b','c','d'};
            fos.write(fileContents);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
