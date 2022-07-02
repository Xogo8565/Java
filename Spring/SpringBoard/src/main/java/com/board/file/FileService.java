package com.board.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class FileService {
    /*
    * 파일 테이블에는 없지만 서버에는 잔존해 있는 파일 삭제
    * */
    Logger logger = LoggerFactory.getLogger(FileService.class);
    @Autowired
    private FileDAO fileDAO;


    public void deleteFiles(String path) throws Exception {
        List<String> list = fileDAO.selectAll(); //DB

        // 파일 객체로 경로 안에 존재하는 모든 파일 가져온 후
        // 파일 객첼르 통해 파일의 이름값을 얻으낼 수 있음
        // 해당 파일을 삭제하는 것도 가능
        File dir = new File(path);

        File[] files = new File(path).listFiles(); //Server

        if(list.size()!=0 && files.length!=0){
            for(File file : files){
                if(!list.contains(file.getName())) {
                    logger.info("Delete files : " + file.getName());
                    file.delete();
                }
            }
        }

    }
}
