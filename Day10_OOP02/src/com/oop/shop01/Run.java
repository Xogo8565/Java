//package com.oop.shop01;
//
//import java.util.Scanner;
//
//public class Run {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        /*
//        메뉴별로 클래스를 만들었을 때, 가게에 메뉴가 추가될 때마다 따라오는 문제점
//        1. 메뉴가 추가될 때마다 생성자, getter/setter, 멤버 필드 -> 똑같은 코드가 반복  : 상속 활용
//        2. index, add print 메소드가 연쇄적으로 증가 -> 모드 결합도 증가
//        3. 저장소(배열) 사이즈 문제, 추가, 삭제, 수정이 복잡
//         */
//        IceCream[] iceCreams = new IceCream[3];
//        Shop baskin = new Shop("BaskinRobbins31","09:00","21:00",iceCreams);
//        while (true){
//            System.out.print("===== Baskin 재고 관리 프로그램 =====\n1. 아이스크림 등록\n2. 아이스크림 목록 확인\n3. 가게 정보 확인\n0. 프로그램 종료\n>> ");
//            int selectNum = Integer.parseInt(sc.nextLine());
//
//            if(selectNum==1){
//                System.out.print("품번 입력");
//                String product_no = sc.nextLine();
//                System.out.print("이름 입력");
//                String name = sc.nextLine();
//                System.out.print("가격 입력");
//                int price = Integer.parseInt(sc.nextLine());
//
//                baskin.addIceCream(new IceCream(product_no,name,price));
//
//                baskin.getIceCream()[0] = new IceCream(product_no,name,price);
//
//            } else if(selectNum==2){
//                System.out.println(baskin.printIceCream());
//            } else if(selectNum==3){
//
//            } else if(selectNum==0){
//                break;
//            }
//
//        }
//
//    }
//}
