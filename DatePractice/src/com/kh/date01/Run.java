package com.kh.date01;

import java.util.ArrayList;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws Exception {
        //새로운 멤버 등록
        //등록된 멤버의 정보 조회
        //id, pw, birth_date 모두 다 입력받을 것
        // #1 birth_date 를 String 형으로 입력받고 - > 쿼리문에서 to_date 를 활용
        // select 문에서 반환값을 String 형으로 변환
        Scanner sc = new Scanner(System.in);
        MemberDAO memberDAO = new MemberDAO();

        System.out.print("아이디 입력 >> ");
        String id = sc.nextLine();
        System.out.print("비밀번호 입력 >> ");
        String pw = sc.nextLine();
        System.out.println("생일 입력(nnnn-MM-yy) >> ");
        String birth_date = sc.nextLine();

        MemberDTO memberDTO = new MemberDTO(id,pw,birth_date);

        int rs = memberDAO.insert(memberDTO);
        if(rs > 0) System.out.println("성공");
        else System.out.println("실패");

        ArrayList<MemberDTO> arrayList = memberDAO.selectAll();

        for(MemberDTO memberDTO1 : arrayList){
            System.out.println(memberDTO1.toString());
        }

    }

}
