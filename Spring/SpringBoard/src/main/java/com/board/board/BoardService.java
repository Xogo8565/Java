package com.board.board;

import com.board.file.FileDAO;
import com.board.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class BoardService {
    @Autowired
    private BoardDAO boardDAO;
    @Autowired
    private FileDAO fileDAO;
    @Autowired
    Pagination pagination;

    public int write(int seq_board, BoardDTO boardDTO, List<MultipartFile> multipartFile, String path) throws Exception {
        int rs = boardDAO.write(seq_board, boardDTO);

        File dir = new File(path);
        if(!dir.exists()) dir.mkdir();

        if(multipartFile.size() != 1 || !multipartFile.get(0).getOriginalFilename().equals("")){
            for(MultipartFile file : multipartFile){
                String ori_name = file.getOriginalFilename();;
                String sys_name = UUID.randomUUID() + "_" + ori_name;

                file.transferTo(new File(path+File.separator+sys_name));
                fileDAO.insert(seq_board, sys_name);
            }
        }

        return rs;
    }

    public Map<String, Object> selectAll(int curPage) throws Exception {
        int totalCnt = boardDAO.countAll();
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> page = pagination.getPageNavi(totalCnt,10,3, curPage);
        int start = (int) page.get("start");
        int end = (int) page.get("end");

        List<BoardDTO> board = boardDAO.selectAll(start,end);

        map.put("page", page);
        map.put("board", board);

        return map;
    }

    public int nextSeq () throws Exception {
        return boardDAO.nextSeq();
    }


    public Map<String, Object> detail(int seq_board) throws Exception {
        boardDAO.increaseViewCount(seq_board);
        Map<String, Object> map = new HashMap<>();
        map.put("boardDTO", boardDAO.detail(seq_board));
        map.put("fileList", fileDAO.getFileList(seq_board));
        return map;
    }

    public int delete(int seq_board) throws Exception {
        return boardDAO.delete(seq_board);
    }


    public int modify(BoardDTO boardDTO, List<MultipartFile> multipartFile, String path, String[] files) throws Exception {
        File dir = new File(path);
        if(!dir.exists()) dir.mkdir();

        if(multipartFile.size() != 1 || !multipartFile.get(0).getOriginalFilename().equals("")){
            for(MultipartFile file : multipartFile){
                String ori_name = file.getOriginalFilename();;
                String sys_name = UUID.randomUUID() + "_" + ori_name;

                file.transferTo(new File(path+File.separator+sys_name));
                fileDAO.insert(boardDTO.getSeq_board(), sys_name);
            }
        }

        if (files.length != 0 || files != null) {
            for(String file_name : files){
                fileDAO.delete(file_name);
                File file = new File(path+File.separator+ file_name);

                if(file.exists()) file.delete();
            }
        }

        return boardDAO.modify(boardDTO);
    }

    public void download(String path, String file_name, HttpServletResponse response) throws Exception {
        File dir = new File(path);
        File file = new File(path+File.separator+file_name);
        int length = (int)file.length();

        file_name = new String(file_name.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);

        response.setHeader("Content-disposition", "attachment; filename=\""+file_name +"\"");
        response.setHeader("Content-transfer-Encoding", "binary");
        response.setHeader("Content-type", "application/octet-stream");
        response.setHeader("Content-length", ""+length);
        response.setHeader("Pragma", "nocache");
        response.setHeader("expires", "-1");

        try(FileInputStream fileInputStream = new FileInputStream(file); OutputStream outputStream = response.getOutputStream()){
            int readCount = 0;
            byte[] bytes = new byte[1024];
            while ((readCount = fileInputStream.read(bytes))!=-1){
                outputStream.write(bytes,0, readCount);
            }
            outputStream.flush();
        }

    }

}
