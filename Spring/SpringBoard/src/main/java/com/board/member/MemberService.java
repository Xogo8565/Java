package com.board.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

// dao 를 통해 데이터를 추가 삭제 조회해야 하는 경우 메서드 생성
// 요청이나 응답과는 별개로 추가적으로 가공해야 하는 데이터가 있는 경우
@Service
public class MemberService {
    /*
    * 컨트롤러 -> 클라이언트로부터 직접 요청을 받고 그 요청에 따라 추가적인 데이터 가공이 필요하거나 혹은 데이터 수정/삭제/조회/추가해야 하는 경우, controller 가 직접 dao 를 호출하지 않고 service 에게 그 작업을 전달함
    * -> service 의 호출된 메서드가 추가적으로 처리해야 하는 가공이나 dao 호출을 통해 비즈니스 로직을 수행하고 그 에 따른 결과값만 바로 controller 에체 전달해줌
    * -> controller 는 결과값을 받아서 판단에 따라 응답값을 어떻게 클라이언트에게 되돌려줄지 결정
    *
    * 즉 컨트롤러는 클라이언트으 ㅣ요청과 응답과 관련된 직접적인 일들만 처리
    * 나머지 뒤에서 보이지 않는 일들은 서비스가 처리
    * */
    @Autowired
    private MemberDAO memberDAO;

    public int login(String id, String pw) throws Exception{
       return memberDAO.checkLogin(id, pw);
    }

    public int checkID(String id) throws Exception {
        return memberDAO.checkID(id);
    }

    public int insert(MemberDTO memberDTO) throws Exception {
        return memberDAO.insert(memberDTO);
    }

    public MemberDTO getDTO(String id, String pw) throws Exception {
        return memberDAO.getDTO(id, pw);
    }


    public String uploadProfileImg(MultipartFile profile_image, String path) throws Exception {
        File dir = new File(path);
        if(!dir.exists()) dir.mkdir();
        String img_oriName = profile_image.getOriginalFilename();
        String img_sysName = UUID.randomUUID() + "_" + img_oriName;

        profile_image.transferTo(new File(dir+File.separator+img_sysName));
        
        return img_sysName;
    }

    public int modifyProfile(MemberDTO memberDTO) throws Exception {
        return memberDAO.modifyProfile(memberDTO);
    }

    public int modifyInfo(String id, String pw, String nickname) throws Exception {
       return memberDAO.modifyInfo(id, pw, nickname);
    }
}
