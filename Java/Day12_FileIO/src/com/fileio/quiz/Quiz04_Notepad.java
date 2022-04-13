package com.fileio.quiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Quiz04_Notepad {

    static ArrayList<String> memoList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("\n=== 콘솔 메모장 ===\n1. 메모하기\n2. 메모장 보기\n3. 메모 수정하기\n4. 프로그램 종료\n>> ");
            String select = sc.nextLine();
            if (select.equals("1")) {

                System.out.print("메모 입력\n>> ");
                String memo = sc.nextLine();
                System.out.print("저장할 파일의 이름을 입력하세요.\n>> ");
                String fileName = sc.nextLine();

                memoList.add(fileName);
                saveFile(fileName, memo);

            } else if (select.equals("2")) {
                if (memoList.size() != 0) {
                    System.out.println(memoList());

                    System.out.print("열어볼 파일의 이름을 입력하세요\n>> ");
                    String fileName = sc.nextLine();
                    if(isFileExist(fileName)) System.out.println(memoContents(fileName));
                    else System.out.println("없는 파일명입니다.");
                } else System.out.println("=== 저장된 파일 목록 ===\n 저장된 메모가 없습니다.");

            } else if (select.equals("3")) {

                System.out.println(memoList());

                System.out.print("수정할 파일의 이름을 입력하세요\n>> ");
                String fileName = sc.nextLine();
                if(isFileExist(fileName)){
                    System.out.print("수정 방식을 선택하세요.\n1. 덮어쓰기\n2. 이어쓰기\n>> ");
                    String modifyOpt = sc.nextLine();
                    if(modifyOpt.equals("1")){
                        System.out.print("덮어쓸 내용을 입력하세요\n>> ");
                        String memo = sc.nextLine();
                        overWrite(fileName,memo);
                    } else if(modifyOpt.equals("2")){
                        System.out.print("수정할 내용을 입력하세요\n>> ");
                        String memo = sc.nextLine();
                        modify(fileName,memo);
                    }
                } else System.out.println("없는 파일명입니다.");
            } else if (select.equals("4")) {
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }

    }

        public static void saveFile (String fileName, String memo){
            try (FileWriter fw = new FileWriter(fileName)) {
                fw.write(memo);
                fw.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public static String memoContents (String fileName){
            try (FileReader fr = new FileReader(fileName);
                 BufferedReader br = new BufferedReader(fr)) {
                return br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public static void overWrite (String fileName, String memo){
            try (FileWriter fw = new FileWriter(fileName)) {
                fw.write(memo);
                fw.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static void modify(String fileName, String memo){
            try (FileWriter fw = new FileWriter(fileName,true)) {
                fw.write(memo);
                fw.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public static boolean isFileExist (String fileName){
            for (int i = 0; i < memoList.size(); i++) {
                if (memoList.get(i).equals(fileName)) return true;
            }
            return false;
        }

        public static String memoList() {
            String list = "=== 저장된 메모 목록 ===\n";
            for(int i=0; i<memoList.size(); i++){
            list += (i+1)+". "+ memoList.get(i)+"\n";
            }
            return list;
        }
}


