package com.board.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


@RequestMapping(value = "/board")
@Controller
public class BoardController {
    Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    private BoardService boardService;
    @Autowired
    private HttpSession httpSession;

    @RequestMapping("/toBoard")
    public String toBoard(@RequestParam(value = "curPage", defaultValue = "1") int curPage, Model model) throws Exception {
        logger.info("Board 요쳥 curPage =" + curPage);

        Map<String, Object> map = boardService.selectAll(curPage);
        model.addAttribute("map", map);

        return "board/board";
    }

    @RequestMapping("/toWrite")
    public String toWrite() throws Exception {
        logger.info("to Write");

        return "board/write";
    }

    @RequestMapping("/write")
    public String write(BoardDTO boardDTO, List<MultipartFile> multipartFile, HttpSession httpSession) throws Exception {
        logger.info("게시물 등록 요청 : title = " + boardDTO.getTitle());
        String path = httpSession.getServletContext().getRealPath("file");
        int seq_board = boardService.nextSeq();

        boardService.write(seq_board, boardDTO, multipartFile, path);


        return "redirect:/board/toBoard";
    }

    @RequestMapping("/detail")
    public String detail(int seq_board, Model model) throws Exception {
        logger.info("게시글 열람 요청 : " + seq_board);
        Map<String, Object> map = boardService.detail(seq_board);

        model.addAttribute("map", map);

        return "board/detail";
    }

    @RequestMapping("/delete")
    public String delete(int seq_board) throws Exception {
        logger.info("게시물 삭제 요청 : " + seq_board);
        boardService.delete(seq_board);

        return "redirect:/board/toBoard";
    }

    @RequestMapping("/modify")
    public String modify(BoardDTO boardDTO, List<MultipartFile> multipartFile, @RequestParam(value = "files[]") String[] files, Model model) throws Exception {
        logger.info("수정 요청 : " + boardDTO.getTitle());
        String path = httpSession.getServletContext().getRealPath("file");

        boardService.modify(boardDTO, multipartFile, path, files);

        return "redirect:/board/detail?seq_board=" + boardDTO.getSeq_board();
    }

    @RequestMapping("/download")
    public void download(String file_name, HttpServletResponse response) throws Exception {
        String path = httpSession.getServletContext().getRealPath("file");
        boardService.download(path, file_name, response);
    }
}
