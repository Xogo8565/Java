package com.oop.objectArray02;

import java.util.Scanner;

public class LaptopRun_2 {
    public static void main(String[] args) {
        //10캍 짜리 배열
        //사용자에게 입력받은 브랜드 , 가격, 색상을 이용해서 저장
        Scanner sc = new Scanner(System.in);
        Laptop[] laptops = new Laptop[3];
        int count = 0;

        ask:while (true){
            if(count < laptops.length){
                System.out.print("\n브랜드를 입력하세요 >> ");
                String inputBrand =sc.nextLine();
                System.out.print("가격을 입력하세요 >> ");
                int inputPrice =Integer.parseInt(sc.nextLine());
                System.out.print("색상을 입력하세요 >> ");
                String inputColor = sc.nextLine();
                System.out.println();

                laptops[count] = new Laptop(inputBrand,inputPrice,inputColor);
                System.out.println(laptops[count].printAll());
                count++;
            } else {
                System.out.println("Laptop 등록을 종료합니다.");
                break;
            }
        }
    }
}
