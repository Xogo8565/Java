package com.message.service;

import com.message.dao.MessageDAO;
import com.message.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageDAO messageDAO;

    public void insert(MessageDTO messageDTO) throws Exception {
        messageDAO.insert(messageDTO);
    }

    public MessageDTO selectOne(int i) throws Exception {
        return messageDAO.selectOne(i);
    }

    public List<MessageDTO> selectList() throws Exception {
        return messageDAO.selectList();
    }

    public void delete(int no) throws Exception {
        messageDAO.delete(no);
    }

    public void modify(MessageDTO messageDTO) throws Exception {
        messageDAO.modify(messageDTO);
    }

    public List<MessageDTO> search1(String keyword) throws Exception {
        return messageDAO.search1(keyword);
    }

    public List<MessageDTO> search2(String category, String keyword) throws Exception {
        return messageDAO.search2(category,keyword);
    }

    public List<MessageDTO> search3(String no, String nickname, String message, String keyword) throws Exception {
        return messageDAO.search3(no, nickname, message, keyword);
    }
}
