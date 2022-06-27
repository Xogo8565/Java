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

        Map<String, Object> page = boardService.pagination(10,10,curPage);
        int start = (int) page.get("start");
        int end = (int) page.get("end");

        List<BoardDTO> board = boardService.selectAll(start, end);
        model.addAttribute("page", page);
        model.addAttribute("board", board);

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

        boardService.write(seq_board,boardDTO);

        if(multipartFile.size() != 1 || !multipartFile.get(0).getOriginalFilename().equals("")){
            multipartFile.forEach((item)->{
                logger.info("파일업로드" + item);
            });
            //업로드
           boardService.uploadFile(multipartFile, path, seq_board);
        }

        return "redirect:/board/toBoard";
    }
    @RequestMapping("/detail")
    public String detail(int seq_board, Model model) throws Exception {
        logger.info("게시글 열람 요청 : "+ seq_board);
        Map<String, Object> map = boardService.detail(seq_board);

        model.addAttribute("map", map);

        return "board/detail";
    }

    @RequestMapping("/delete")
    public String delete(int seq_board) throws Exception {
        logger.info("게시물 삭제 요청 : "+ seq_board);
        boardService.delete(seq_board);

        return "redirect:/board/toBoard";
    }

    @RequestMapping("/modify")
    public String modify(BoardDTO boardDTO, List<MultipartFile> multipartFile, String[] files, Model model) throws Exception {
        logger.info("수정 요청 : " + boardDTO.getTitle());
        String path = httpSession.getServletContext().getRealPath("file");

        List<String> file_name = null;

        if(multipartFile.size() != 1 || !multipartFile.get(0).getOriginalFilename().equals("")){
            multipartFile.forEach((item)->{
                logger.info("파일업로드" + item);
            });
            //업로드
            boardService.uploadFile(multipartFile, path, boardDTO.getSeq_board());
        }

        if(files!=null){
            logger.info("file 삭제 요청 : "+ files);
            boardService.deleteFile(files, path);
        }

        boardService.modify(boardDTO);

        model.addAttribute("seq_board", boardDTO.getSeq_board());

       return "redirect:/board/detail";
    }

    @RequestMapping("/download")
    public void download(String file_name, HttpServletResponse response) throws Exception {
        String path = httpSession.getServletContext().getRealPath("file");
        boardService.download(path, file_name, response);
    }
}
