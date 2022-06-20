package com.board.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(value = "/member")
@Controller
public class MemberController {
    Logger logger = LoggerFactory.getLogger(MemberController.class);

    @RequestMapping(value = "/toSignup")
    public String toSignup() {
        logger.info("회원가입 페이지 요청");
        return "member/signup";
    }

    @RequestMapping(value = "/signup")
    public String signup(MemberDTO memberDTO, MultipartFile img) throws Exception{ // MultipartFile -> 파일 가져오기, DTO 변수명과 다르게
        logger.info("가입요청 : " + memberDTO.getId() + " : " +memberDTO.getPw());
        logger.info("프로필 이미지 : " + img);
        return "";
    }
}
