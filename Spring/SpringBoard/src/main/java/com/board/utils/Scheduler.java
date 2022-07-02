package com.board.utils;

import com.board.file.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

@Component
public class Scheduler {
    Logger logger = LoggerFactory.getLogger(Scheduler.class);

    // 해당 메서드를 인자로 넘겨준 표현식에 따른 주기마다 실행시키겠다는 어노테이션
    // cron 표현식 : 스케줄러에게 어느 주기마다 스케줄러를 동작시킬건지에 대한 정보값을 넘겨주는 시간 표현식
    // 초 : 0-59
    // 분 : 0-59
    // 시 : 0-23
    // 일 : 1-31
    // 월 : 1-12
    // 요일 : 0-6(일 ~ 월), MON, WED, FRI ....
    // * : 모든 시간
    // 0/3 * * * * * : 3초마다
    // * 0/5 * * * *  : 5분다다

    //    @Scheduled(cron="30 * * * * *")
//    public void test() {
//        logger.info("scheduler");
//    }
//
//    @Scheduled(cron="0/3 * * * * *")
//    public void test2() {
//        logger.info("scheduler per every 3 seconds");
//    }
    @Autowired
    private FileService fileService;
    @Autowired
    private ServletContext servletContext;

    @Scheduled(cron = "* * * 0/7 * *")
    public void deleteFiles() throws Exception {
        logger.info("delete scheduler");
        String path = servletContext.getRealPath("file");
        fileService.deleteFiles(path);
    }

}
