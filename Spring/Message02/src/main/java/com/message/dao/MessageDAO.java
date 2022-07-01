package com.message.dao;

import com.message.dto.MessageDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MessageDAO {
    // 마이바티스를 이용해 mapper가 가지고 있는 쿼리문을 사용하기 위해 멤버필드 추가
    @Autowired
    private SqlSession sqlSession;
    public void insert(MessageDTO messageDTO) {
        // 마이바티스 쿼리문 작성핸호고 그 쿼리문을 실행시키는 메소드를 호출
        // dao 에서는 어떤 쿼리문을 실행시킬거고 그 쿼리문을 실행시키기 위해 필요한 데이터가 있다면 그 데이터만 넘겨주고 그 결과를 반환받을 것
        //insert(mapper의 이름.쿼리문의 ID, )
        sqlSession.insert("messageMapper.insert", messageDTO);
    }

    public MessageDTO selectOne(int i) throws Exception {
        return sqlSession.selectOne("messageMapper.selectOne", i);
    }

    public List<MessageDTO> selectList() throws Exception {
        return sqlSession.selectList("messageMapper.selectList");
    }

    public int delete(int no) throws Exception {
        return sqlSession.delete("messageMapper.delete", no);
    }

    public int modify(MessageDTO messageDTO) throws Exception {
        return sqlSession.update("messageMapper.modify", messageDTO);
    }

    public List<MessageDTO> search1(String keyword) throws Exception {
        return sqlSession.selectList("messageMapper.search1", keyword);
    }

    public List<MessageDTO> search2(String category, String keyword) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("category", category);
        map.put("keyword", keyword);

        return sqlSession.selectList("messageMapper.search2", map);
    }

    public List<MessageDTO> search3(String no, String nickname, String message, String keyword) throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("no", no);
        map.put("nickname", nickname);
        map.put("message", message);
        map.put("keyword", keyword);
        return sqlSession.selectList("messageMapper.search3", map);
    }
}
