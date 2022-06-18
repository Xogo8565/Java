package com.message.controller;

import com.message.dao.MessageDAO;
import com.message.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.*;
import java.util.ArrayList;

@Controller
public class HomeController extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private MessageDAO messageDAO;

    @RequestMapping(value = "/")
    public String Home() {
        return "home";
    }

    @RequestMapping(value = "/toInput")
    public String toInput() {
        return "input";
    }

    // 클라이언트로부터 데이터를 전송받는 방법
    // 1. Servlet 처럼 HttpRequest 객체 활용
//    @RequestMapping(value = "/sendInput")
//    public String sendInput(HttpServletRequest request) {
//        String nickname = request.getParameter("nickname");
//        String msg = request.getParameter("message");
//        System.out.println(nickname + " : " + msg);
//        return "";
//    }

    // 2. 요청을 받아주는 메서드의 매개변수로 클라이언트가 넘겨주는 데이터의 name 이나 key 값과 동일한 이름의 변수를 만들어 데이터를 받아올 수 있음
    // 데이터의 name 값과 동일한 매개변수명을 사용해야 한다( 다른 매개변수 명을 사용하면 데이터를 받아주지 못함)
//    @RequestMapping(value = "/sendInput")
//    public String sendInput(String nickname, String message) {
//        System.out.println(nickname + " : " + message);
//        return "";
//    }
    // 3. command 객체로 데이터를 전달받는 방법
    // Default -> DTO 의 기본 생성자로 인스턴스를 생성
    // 클라이언트가 넘겨주는 데이터의 name 값을 이용해
    // name 값과 동일한 이름의 setter 를 찾아
    // 그 setter 를 이용해 클라이언트가 보낸 데이터를 인스턴스에 세팅하는 작업

    //controller 의 RequestMapping 된 메서드의 모든 default 리턴 방식은 forward
    @RequestMapping(value = "/sendInput")
    public String sendInput(MessageDTO messageDTO, Model model) throws Exception {
//        model.addAttribute("messageDTO", messageDTO);
//        return "output";
        //Spring 의 redirect 사용방법
        //return "redirect:요청 url"
        // RequestMapping 메서드에서 String 값을 반환 -> D.S -> View Resolver를 통해 전치사 접미사가 붙음
        // redirect 를 통해 위의 url 이 클라이언트에게 응답되면 클라이언트가 접근할 수 없는 경로이기 때문에 잘못된 값이 됨.
        // 즉 redirect 를 할 때는 ViewResolver를 거치면 안됨.
        // 결과적으로 클라이언트가 직접 요청하게 될 Url -> /toOutput
        messageDAO.insert(messageDTO);


        return "redirect:/";
    }

    @RequestMapping(value = "/toOutput")
    public String toOutput(Model model) throws Exception {
        ArrayList<MessageDTO> arrayList = messageDAO.selectAll();

        model.addAttribute("arrayList", arrayList);

        return "output";
    }

    //ajax
    @RequestMapping(value = "/toOutput2")
    public String toOutput2(Model model) throws Exception {
        ArrayList<MessageDTO> arrayList = messageDAO.selectAll();

        model.addAttribute("arrayList", arrayList);

        return "output2";
    }

    @RequestMapping(value = "/delete")
    public String delete(int seq_msg) throws Exception {

        messageDAO.delete(seq_msg);

        return "redirect:/toOutput";
    }

    //ajax 요청에 대한 응답값을 반환
    //ResponseBody 를 이용하면 반환값이 V.R 을 거치지 않고 controller 메소드를 요청한 jsp 쪽 ajax 에 그대로 반환값이 들어간다.
    @RequestMapping(value = "/deleteAjax")
    @ResponseBody
    public String deleteAjax(int seq_msg) throws Exception {
        messageDAO.delete(seq_msg);

        return "success";
    }

    @RequestMapping(value = "/modify")
    public String modify(MessageDTO messageDTO) throws Exception {

        messageDAO.modify(messageDTO);

        return "redirect:/toOutput";

    }

    @ResponseBody
    @RequestMapping(value = "/modifyAjax")
    public String modifyAjax(MessageDTO messageDTO) throws Exception {

        messageDAO.modify(messageDTO);

        return messageDTO.getMessage();
    }

    @RequestMapping(value = "/toError")
    public String toError() {
        logger.info("error");
        return "error";
    }

    //ExceptionHandler 이 붙은 메소드가 controller 내부에 있으면 해당 클래스 내부에서 발생한 예외는 여기에서 처리됨.
    @ExceptionHandler
    public String errorHandler(Exception e) {
        e.printStackTrace();
        return "redirect:/toError";
    }

    @ExceptionHandler(NullPointerException.class)
    public String nullErrorHandler(Exception e){
        logger.info("null");
        e.printStackTrace();
        return "nullException";
    }
}
