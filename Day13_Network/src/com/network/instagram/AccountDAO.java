package com.network.instagram;

import java.util.ArrayList;

public class AccountDAO {

    ArrayList<AccountDTO> accounts = new ArrayList<>();

    public int Login(String id, String pw){
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).getId().equals(id)&& accounts.get(i).getPw().equals(pw)){
                return 0;
            }
        } return -1;

    }

    public int signUp(String id, String pw, String nickname){
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).getId().equals(id)){
                return -1;
            } else if (accounts.get(i).getNickname().equals(nickname)){
                return -2;
        }
    }   accounts.add(new AccountDTO(id,pw,nickname));
        return 0;
    }

    public AccountDTO getAccount(String id, String pw){
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).getId().equals(id)&&accounts.get(i).getPw().equals(pw)){
                return accounts.get(i);
            }
        } return null;

    }
}
