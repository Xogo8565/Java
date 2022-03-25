package com.network.member;

import java.util.ArrayList;

// 계정에 대한 저장소, 기능 클래스
public class AccountDAO {
    private ArrayList<AccountDTO> accountDTO = new ArrayList<>();

    public boolean checkLogin(String id, String pw){
        for(AccountDTO dto : accountDTO) {
            if(dto.getId().equals(id) && dto.getPw().equals(pw)) {
                return true;
            }
        }
        return false;
    }

    public int signUp(String id, String pw) {
        for(int i = 0; i < accountDTO.size(); i++){
            if(accountDTO.get(i).getId().equals(id)){
                return -1;
            }
        }
        accountDTO.add(new AccountDTO(id, pw));
        return 0;
    }
}
