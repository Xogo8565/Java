package com.board.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;


@RequestMapping(value = "/member")
@Controller
public class MemberController {
    Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;
    @Autowired
    private HttpSession httpSession;

    @RequestMapping(value = "/toSignup")
    public String toSignup() {
        logger.info("회원가입 페이지 요청");
        return "member/signup";
    }

    @RequestMapping(value = "/signup")
    public String signup(MemberDTO memberDTO, MultipartFile img, HttpSession session) throws Exception{ // MultipartFile -> 파일 가져오기, DTO 변수명과 다르게
        logger.info("회원가입 요청 : " + memberDTO.getId() + " : " +memberDTO.getPw());
        logger.info("프로필 이미지 : " + img);

        String path = session.getServletContext().getRealPath("profiles");
        if(!img.isEmpty()){
            String image = memberService.uploadProfileImg(img,path);
            memberDTO.setProfile_image(image);
        }
        memberService.insert(memberDTO);

        return "redirect:/";
    }

    @RequestMapping(value = "/checkIdPopUp")
    public String checkIdPopUp() {
        return "/member/popup";
    }

    @ResponseBody
    @RequestMapping(value = "/checkId")
    public int checkId(String id) throws Exception {
        return memberService.checkID(id);
    }

    @RequestMapping(value = "/login")
    public String login(String id, String pw, Model model) throws Exception {
        logger.info("로그인 요청 : "+ id + " : " + pw);
        MemberDTO memberDTO = memberService.getDTO(id, pw);

        if(memberDTO!=null) {
            logger.info("로그인 성공");
            httpSession.setAttribute("loginSession", memberDTO);
            return "redirect:/member/toWelcome";
        }
        else {
            logger.info("로그인 실패");
            model.addAttribute("loginResult", false);
            return "home";
        }
    }
    @RequestMapping(value = "/logout")
    public String logout() {
        logger.info("로그아웃 요청");
        httpSession.invalidate();
        return "redirect:/";
    }
    @RequestMapping(value = "/toWelcome")
    public String toWelcome() {
        logger.info("welcome 요청");
        return "/member/welcome";
    }
    @ResponseBody
    @RequestMapping(value = "/modifyProfile")
    public String modifyProfile(String profile_message, MultipartFile profile_image, HttpSession session) throws Exception {
        logger.info("Modify profile : profile_message = " + profile_message + " / profile_image = " + profile_image);
        if(!profile_image.isEmpty()){
            String path = session.getServletContext().getRealPath("profiles");
            String image = memberService.uploadProfileImg(profile_image, path);
            ((MemberDTO)httpSession.getAttribute("loginSession")).setProfile_image(image);
        }
        ((MemberDTO)httpSession.getAttribute("loginSession")).setProfile_message(profile_message);

        int rs = memberService.modifyProfile((MemberDTO)httpSession.getAttribute("loginSession"));

        if(rs>0) return "success";
        else return "fail";
    }

    @ResponseBody
    @RequestMapping(value = "/modifyInfo")
    public String modifyInfo(String pw, String nickname) throws Exception {
        logger.info("modify info : pw = " + pw + "/ nickname =" + pw);
        int rs = memberService.modifyInfo(((MemberDTO)httpSession.getAttribute("loginSession")).getId(), pw, nickname );
        if(rs>0) return "success";
        else return "fail";
    }
}
