package com.oop.objectArray02;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class LaptopRun {
    public static void main(String[] args) {
        //10캍 짜리 배열
        //사용자에게 입력받은 브랜드 , 가격, 색상을 이용해서 저장
        //프로그램을 실행시키면
        // === Laptop 등록 프로그램===
        // 1. 등록
        // 2. 조회
        // 3. 종료
        Scanner sc = new Scanner(System.in);
        Laptop[] laptops = new Laptop[10];

        while (true){
            System.out.print("\n=== Laptop 등록 프로그램 ===\n1. 등록\n2. 전체조회\n3. 개별조회\n4. 종료\n>>  ");
                int menuNum = Integer.parseInt(sc.nextLine());
                if(menuNum==1){
                    System.out.print("\n브랜드를 입력하세요 >> ");
                    String inputBrand =sc.nextLine();
                    System.out.print("가격을 입력하세요 >> ");
                    int inputPrice =Integer.parseInt(sc.nextLine());
                    System.out.print("색상을 입력하세요 >> ");
                    String inputColor = sc.nextLine();
                    System.out.println();
                    //배열에 값 저장
                    for(int i=0; i<laptops.length; i++){
                        if(laptops[i]==null) {
                            laptops[i] = new Laptop(inputBrand,inputPrice,inputColor);
                            break;
                        }
                    }
                } else if (menuNum==2){
                    for(int i = 0; i<laptops.length; i++){
                        if(laptops[i]!=null) System.out.println(i + "번째 제품 >> " + laptops[i].printAll());
                    }
                } else if(menuNum==3) {
                    System.out.print("조회할 제품의 인덱스 번호를 입력하세요 >>");
                    int indexNum = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < laptops.length; i++) {
                        if(laptops[i]!=null && indexNum == i) System.out.println(i + "번째 제품 >> " + laptops[i].printAll());
                        else {
                            System.out.println("존재하지 않는 제품입니다.");
                            break;
                        }
                    }
                }
                else if (menuNum == 4) break;
                    else System.out.println("\n잘못된 조작입니다.");
        }
    }
}
