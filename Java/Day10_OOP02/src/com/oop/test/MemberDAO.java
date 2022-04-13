package com.oop.test;

public class MemberDAO {
    private MemberDTO[] list = new MemberDTO[10];

    public MemberDAO() { // MemberDAO 형 인스턴스가 생성되자 마자 멤버필드 list에 MemberDTO 형 인스턴스 3개 추가
        this.list[0] = new MemberDTO("user01", "1111", "유저1", 23, "01015151515");
        this.list[1] = new MemberDTO("user02", "2222", "유저2", 29, "01037373737");
        this.list[2] = new MemberDTO("user03", "3333", "유저3", 25, "01089898989");
    }

    public MemberDTO[] selectAll() {
        return this.list;
    }
}
