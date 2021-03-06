//package com.message.contoller;
//
//
//import com.message.dto.MessageDTO;
//import com.message.service.MessageService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//@Controller
//public class HomeController {
//    Logger logger = LoggerFactory.getLogger(HomeController.class);
//    @Autowired
//    private MessageService messageService;
//
//    @GetMapping("/")
//    public String toHome() {
//        return "home";
//    }
//
//    @GetMapping(value = "/toError")
//    public String toError() {
//        logger.info("error");
//        return "error";
//    }
//
//    @GetMapping("/input")
//    public String toInput() {
//        logger.info("input");
//        return "input";
//    }
//
//    @PostMapping("/input")
//    public String input(MessageDTO messageDTO) throws Exception {
//        messageService.insert(messageDTO);
//        logger.info(messageDTO.toString());
//
//        return "redirect:/input";
//    }
//
//    @GetMapping("/output")
//    public String output(Model model) throws Exception {
//        logger.info("output");
//        MessageDTO messageDTO = messageService.selectOne(3);
//        model.addAttribute("messageDTO", messageDTO);
//
//        return "output";
//    }
//
//    @GetMapping("/output2")
//    public String outputList(Model model) throws Exception {
//        logger.info("outputList");
//        List<MessageDTO> list = messageService.selectList();
//        model.addAttribute("list", list);
//
//        return "output2";
//    }
//
//    @GetMapping("/output3")
//    public String output3(Model model) throws Exception {
//        logger.info("output2");
//        List<Map<String, Object>> list = messageService.select2();
//        model.addAttribute("list", list);
//
//        return "output3";
//    }
//
////    @DeleteMapping("/delete/{no}")
////    public String delete(@PathVariable(value = "no") int no) throws Exception {
////        logger.info("delete : " + no);
////        messageService.delete(no);
////
////        return "redirect:/outputList";
////    }
//
//    @ResponseBody
//    @RequestMapping("/delete")
//    public void delete(@RequestParam(value="no[]") int[] no) throws Exception {
//        for(int i : no){
//            logger.info("del : " + i);
//        }
//        messageService.delete(no);
//    }
//
//    @PutMapping("/modify")
//    public String modify(MessageDTO messageDTO) throws Exception {
//        logger.info("modify : no=" +messageDTO.getNo() + " , message = " + messageDTO.getMessage() );
//        messageService.modify(messageDTO);
//        return "redirect:/outputList";
//    }
//
//    @ResponseBody
//    @GetMapping("/search1")
//    public List<MessageDTO> search1(String keyword) throws Exception {
//        return  messageService.search1(keyword);
//    }
//
//    @ResponseBody
//    @GetMapping("/search2")
//    public List<MessageDTO> search1(String category,String keyword) throws Exception {
//        logger.info("search=>"+ category+ " : " + keyword);
//        return  messageService.search2(category,keyword);
//    }
//
//    @ResponseBody
//    @GetMapping("/search3")
//    public List<MessageDTO> search1(String no, String nickname, String message,String keyword) throws Exception {
//        logger.info("search3 >" + no + " : " +nickname + " : " +message + " : " + keyword);
//        return messageService.search3(no,nickname,message,keyword);
//    }
//
//
//    //ExceptionHandler ??? ?????? ???????????? controller ????????? ????????? ?????? ????????? ???????????? ????????? ????????? ???????????? ?????????.
//    @ExceptionHandler
//    public String errorHandler(Exception e) {
//        e.printStackTrace();
//        return "redirect:/toError";
//    }
//}
