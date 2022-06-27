package com.board.utils;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Pagination {
    private int totalCnt;
    private int totalPage;
    private int curPage;
    private int recordPerPage;
    private int naviCntPerPage;
    private int naviStart;
    private int naviEnd;
    private int postStart;
    private int postEnd;
    private boolean prevBtn;
    private boolean nextBtn;

    public Map<String, Object> getPageNavi(int totalCnt, int recordPerPage, int naviCntPerPage, int curPage) throws Exception {
        // 총 페이지 수
        totalPage = totalCnt / recordPerPage + (totalCnt % recordPerPage == 0 ? 0 : 1);
        // 페이징 처리
        if (curPage < 1) curPage = 1;
        else if (curPage > totalPage) curPage = totalPage;

        // 네비 시작점, 끝점
        naviStart = ((curPage - 1) / naviCntPerPage) * naviCntPerPage + 1;
        naviEnd = naviStart + naviCntPerPage - 1;
        if(naviEnd>totalPage) naviEnd = totalPage;

        // prev, next 버튼
        prevBtn = (naviStart != 1);
        nextBtn = (naviEnd != totalPage);

        // 게시글 시작점, 끝점
        postStart = ((curPage - 1) * recordPerPage) + 1;
        postEnd = recordPerPage * curPage;

        Map<String, Object> map = new HashMap<>();
        map.put("totalCnt", totalCnt);
        map.put("totalPage", totalPage);
        map.put("naviStart", naviStart);
        map.put("naviEnd", naviEnd);
        map.put("prevBtn", prevBtn);
        map.put("nextBtn", nextBtn);
        map.put("start", postStart);
        map.put("end", postEnd);

        return map;

    }
}
