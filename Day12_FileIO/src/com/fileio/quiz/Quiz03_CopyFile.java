package com.fileio.quiz;

import java.io.*;

public class Quiz03_CopyFile {
    public static void copyFile(String from, String to){
        try(FileReader fr = new FileReader(from);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(to)){

            String str = "";
            while ((str=br.readLine())!=null){
                fw.write(str+"\n");
            }
            fw.flush();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("forSale.txt");
            FileOutputStream fos = new FileOutputStream("forSaleCopy.txt");){

            byte[] bytes = new byte[fis.available()];

            fis.read(bytes); // bytes 배열에 저장
            fos.write(bytes); // 텍스트 파일에 내보내기

        } catch (Exception e){
            e.printStackTrace();
        }

        copyFile("forSaleKR.txt","forSaleKrWrite02.txt");
    }
}
