package com.fileio.exam;

import java.io.FileInputStream;

public class Exam02_FileRead01 {
    public static void main(String[] args) {
        // 파일 입력 -> Stream(InputStream)
        // 파일과 관련된 객체 인스턴스를 만들었을 때에는 객체 반납을 마지막에 해줘야 함.

        // #1-1 try - with - resource
        /* try(자동 반납을 해주고 싶은 객체의 생성문){
        } catch (){
        }

       -> try 문이 종료되면 객체를 자동으로 반납

         */
        try(FileInputStream fis = new FileInputStream("test.txt")){
//            System.out.println((char)fis.read()); //test.txt 첫 글자의 아스키 코드가 출력됨(int 형 반환)
//            System.out.println((char)fis.read()); //B
//            System.out.println((char)fis.read()); //B

            // 데이터를 한번에 읽어오기

            byte[] fileContents = new byte[100];
            fis.read(fileContents);  // test.txt 파일로부터 읽어들여온 int 형 데이터를 fileContents 배열 안에 저장

            //#1
            for(byte b : fileContents){
                System.out.print((char)b);
            }
            System.out.println();

            //#2
            System.out.println(new String(fileContents));

        }catch(Exception e){
            e.printStackTrace();
        }


        // #1-2
        FileInputStream fis = null;

        try{
            fis = new FileInputStream("test.txt");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{//IOException 처리
                fis.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
