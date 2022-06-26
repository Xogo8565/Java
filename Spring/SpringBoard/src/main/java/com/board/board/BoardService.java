package com.board.board;

import com.board.utils.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {
    @Autowired
    private BoardDAO boardDAO;
    @Autowired
    private FileDAO fileDAO;
    private Pagination pagination = new Pagination();

    public int write(int seq_board, BoardDTO boardDTO) throws Exception {
        boardDTO.setSeq_board(nextSeq());

        return boardDAO.write(seq_board, boardDTO);
    }

    public HashMap<String, Object> pagination(int recordPerPage, int naviCntPerPage, int curPage) throws Exception {
        int totalCnt = boardDAO.countAll();
        return pagination.getPageNavi(totalCnt, recordPerPage, naviCntPerPage, curPage);
    }

    public ArrayList<BoardDTO> selectAll() throws Exception {
        return boardDAO.selectAll();
    }

    public List<String> uploadFile(List<MultipartFile> multipartFile, String path) throws Exception {
        File dir = new File(path);
        List<String> fileList = new ArrayList<>();

        if(!dir.exists()) dir.mkdir();
        for(MultipartFile file : multipartFile){
            String ori_name = file.getOriginalFilename();;
            String sys_name = UUID.randomUUID() + "_" + ori_name;

            file.transferTo(new File(path+File.separator+sys_name));
            fileList.add(sys_name);
        }

        return fileList;
    }

    public int nextSeq () throws Exception {
        return boardDAO.nextSeq();
    }

    // 테이블에 넣는
    public void insertFile(int seq_board, List<String> file_list) throws Exception {
        for(String file : file_list){
            fileDAO.insert(seq_board, file);
        }
    }

    public BoardDTO detail(int seq_board) throws Exception {
        boardDAO.increaseViewCount(seq_board);
        return boardDAO.detail(seq_board);
    }

    public ArrayList<FileDTO> getFileList(int seq_board) throws Exception {
        return fileDAO.getFileList(seq_board);
    }

    public int delete(int seq_board) throws Exception {
        return boardDAO.delete(seq_board);
    }

    public void deleteFile(String[] files) throws Exception {
        for(String str : files){
            fileDAO.delete(str);
        }
    }

    public int modify(BoardDTO boardDTO) throws Exception {

        return boardDAO.modify(boardDTO);
    }

    public void download(String path, String file_name, HttpServletResponse response) throws Exception {
        File dir = new File(path);
        File file = new File(path+File.separator+file_name);
        int length = (int)file.length();
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
        }

    }

    public int deleteFile(String file_name) throws Exception {
       return fileDAO.delete(file_name);
    }

//    public int countAll() throws Exception {
//        return boardDAO.countAll();
//    }
}
