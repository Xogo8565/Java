package com.kh.cafe;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);
        CafeDAO cafeDao = new CafeDAO();

        while (true){
            System.out.print("\n== 카페 매뉴 ==\n1. 메뉴 등록 \n2. 메뉴 수정\n3. 메뉴 삭제\n4. 메뉴 조회\n5. 프로그램 종료\n>> " );
            int menu = Integer.parseInt(sc.nextLine());

            if(menu == 1){ // 메뉴 등록
                System.out.print("\n== 메뉴 등록 ==\n제품명을 입력하세요\n>> ");
                String name = sc.nextLine();
                System.out.print("가격을 입력하세요\n>> ");
                int price = Integer.parseInt(sc.nextLine());
                CafeDTO dto = new CafeDTO(0,name,price,null);

                try {
                    int rs = cafeDao.insert(dto);
                    if(rs > 0) System.out.println("메뉴를 등록했습니다.");
                    else System.out.println("메뉴 등록에 실패했습니다.");
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("DB 접속 오류");
                }

            } else if (menu == 2){// 메뉴 수정
                System.out.print("\n== 메뉴 수정 ==\n수정하실 제품 번호를 입력하세요\n>> ");
                int no = Integer.parseInt(sc.nextLine());
                System.out.print("제품명을 입력하세요\n>> ");
                String name = sc.nextLine();
                System.out.print("가격을 입력하세요\n>> ");
                int price = Integer.parseInt(sc.nextLine());
                CafeDTO dto = new CafeDTO(no,name,price,null);

                try{
                    int rs = cafeDao.update(dto);
                    if(rs>0) System.out.println("메뉴를 수정했습니다.");
                    else System.out.println("메뉴 수정에 실패했습니다.");
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("DB 접속 오류");
                }

            } else if (menu == 3){ //메뉴 삭제
                System.out.print("\n== 메뉴 삭제 ==\n제품번호를 입력하세요\n>> ");
                int no = Integer.parseInt(sc.nextLine());
                try{
                    int rs = cafeDao.delete(no);
                    if (rs > 0) System.out.println("메뉴를 삭제했습니다.");
                    else System.out.println("메뉴 삭제에 실패했습니다.");
                } catch (Exception e){
                    e.printStackTrace();
                    System.out.println("DB 접속 오륲");
                }

            } else if (menu == 4){ // 메뉴 조회
                System.out.print("\n== 메뉴 조회 ==\n1. 전체 메뉴 조회\n2. 선택 메뉴 조회\n>> ");
                int select = Integer.parseInt(sc.nextLine());
                if(select == 1){
                    try{for (int i = 0; i < 1000; i++){
                        ArrayList<CafeDTO> list = cafeDao.selectAll();
                        if(list!=null){
                            for(CafeDTO cafeDTO : list){
                                System.out.println(cafeDTO.toString());
                            }
                        }
                    }
                    } catch (Exception e){
                        e.printStackTrace();
                        System.out.println("DB 접속 오류");
                    }
                } else if(select == 2){
                    System.out.print("조회하실 메뉴의 번호를 입력하세요\n>> ");
                    int no = Integer.parseInt(sc.nextLine());
                    try{
                        CafeDTO rs = cafeDao.select(no);
                        if(rs != null) System.out.println(rs);
                        else System.out.println("데이터 조회 실패");
                    } catch (Exception e){
                        e.printStackTrace();
                        System.out.println("DB 접속 오류");
                    }
                }
            } else if (menu == 5){
                System.out.println("프로그램 종료");
                break;
            }
        }
    }


}
