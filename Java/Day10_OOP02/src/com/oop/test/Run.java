package com.oop.test;

public class Run {
    public static void main(String[] args) {
        MemberDAO dao = new MemberDAO();

        System.out.println("=== 회원 정보 출력 프로그램 ===");
        System.out.println("******** 회원 목록 ********");
        System.out.println("아이디\t비밀번호\t이름\t나이\t전화번호");
        MemberDTO[] memberList = dao.selectAll();

        for (int i = 0; i < memberList.length; i++) {
            if(memberList[i]!=null)
            System.out.println(memberList[i].getId()
                    + "\t" + memberList[i].getPw()
                    + "\t" + memberList[i].getName()
                    + "\t" + memberList[i].getAge()
                    + "\t" + memberList[i].getPhone());
        }
    }
}
