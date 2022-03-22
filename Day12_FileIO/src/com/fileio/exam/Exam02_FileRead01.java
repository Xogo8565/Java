package com.fileio.exam;

import java.io.FileInputStream;

public class Exam02_FileRead01 {
    public static void main(String[] args) {
        // 파일 입력 -> Stream(InputStream)
        // 파일과 관련된 객체 인스턴스를 만들었을 때에는 객체 반납을 마지막에 해줘야 함.

        // #1 try - with - resource
        /* try(자동 반납을 해주고 싶은 객체의 생성문){
        } catch (){
        }

       -> try 문이 종료되면 객체를 자동으로 반납

         */
        try(FileInputStream fis = new FileInputStream("test.txt")){
            System.out.println(fis.read()); //test.txt 첫 글자의 아스키 코드가 출력됨
        }catch(Exception e){
            e.printStackTrace();
        }


        // #2
        FileInputStream fis = null;

        try{
            fis = new FileInputStream("test.txt");

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                fis.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
