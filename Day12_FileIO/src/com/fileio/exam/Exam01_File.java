package com.fileio.exam;

import java.io.File;

public class Exam01_File {
    public static void main(String[] args) {

        // 파일을 객체로 만들어(인스턴스화) 사용
        File file = new File("/Volumes/My Passport/WorkSpace/Day12_FileIO/src/test.txt"); // 파일 생성자의 인자값 = HDD 해당 파일의 경로 값 + 파일명 + 확장자

        System.out.println("파일의 존재 여부 : " + file.exists());
        System.out.println("파일 여부 : " + file.isFile());
        System.out.println("폴더 여부 : " + file.isDirectory());
        System.out.println("파일의 크기 : " + file.length());
        System.out.println("파일의 절대 경로 : " + file.getAbsolutePath());
        System.out.println("파일의 이름 : " + file.getName());

        //코드로 파일 생성
        File newFile = new File("new.txt");
        //Checked Exception : 코드가 실제 실행되기도 전에 에러가 발생할 수 있다고 보여지는 에러
        if(!newFile.exists())
            try {
                newFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }

        //코드로 폴더 생성

        File newFolder = new File("newFolder");
        if(!newFolder.exists()) newFolder.mkdir();

        // 입력과 출력 -> Stream 이 존재(데이터가 흐르는 통로)
        // 입력 : 프로그램에서 데이터를 불러들이는 것
        // 출력 : 프로그램에서 데이터를 내보내는 것.
    }
}
