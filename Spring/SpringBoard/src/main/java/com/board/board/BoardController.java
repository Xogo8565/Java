package com.board.board;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@RequestMapping(value = "/board")
@Controller
public class BoardController {
    Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;

    @RequestMapping("/toBoard")
    public String toBoard() throws Exception {
        logger.info("Board 요쳥");
        return "board/board";
    }

}
