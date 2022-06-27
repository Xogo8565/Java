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

    public int write(int seq_board, BoardDTO boardDTO) throws Exception {
        return boardDAO.write(seq_board, boardDTO);
    }

    public Map<String, Object> pagination(int recordPerPage, int naviCntPerPage, int curPage) throws Exception {
        int totalCnt = boardDAO.countAll();
        return pagination.getPageNavi(totalCnt, recordPerPage, naviCntPerPage, curPage);
    }

    public List<BoardDTO> selectAll(int start, int end) throws Exception {
        return boardDAO.selectAll(start, end);
    }

    public void uploadFile(List<MultipartFile> multipartFile, String path, int seq_board) throws Exception {
        File dir = new File(path);

        if(!dir.exists()) dir.mkdir();
        for(MultipartFile file : multipartFile){
            String ori_name = file.getOriginalFilename();;
            String sys_name = UUID.randomUUID() + "_" + ori_name;

            file.transferTo(new File(path+File.separator+sys_name));
            fileDAO.insert(seq_board, sys_name);
        }
    }

    public int nextSeq () throws Exception {
        return boardDAO.nextSeq();
    }

//    public void insertFile(int seq_board, List<String> file_list) throws Exception {
//        for(String file : file_list){
//            fileDAO.insert(seq_board, file);
//        }
//    }

    public Map<String, Object> detail(int seq_board) throws Exception {
        boardDAO.increaseViewCount(seq_board);
        Map<String, Object> map = new HashMap<>();
        map.put("boardDTO", boardDAO.detail(seq_board));
        map.put("fileList", fileDAO.getFileList(seq_board));
        return map;
    }

//    public List<FileDTO> getFileList(int seq_board) throws Exception {
//        return fileDAO.getFileList(seq_board);
//    }

    public int delete(int seq_board) throws Exception {
        return boardDAO.delete(seq_board);
    }

    public void deleteFile(String[] files, String path) throws Exception {
        for(String file_name : files){
            fileDAO.delete(file_name);
            File file = new File(path+File.separator+ file_name);
            file.delete();
        }
    }

    public int modify(BoardDTO boardDTO) throws Exception {
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

//    public int countAll() throws Exception {
//        return boardDAO.countAll();
//    }
}
