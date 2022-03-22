package com.netflix.dao;

import com.netflix.dto.Membership;

import java.util.ArrayList;

public class NetflixDAO {
    ArrayList<Membership> member = new ArrayList<>();

    public void addMember(Membership memberships){
        member.add(memberships);
    }

    public boolean isIdAlreadyExist(String id){
        for(int i = 0; i<member.size(); i++){
            if(member.get(i).getId().equals(id))
                return true;
        } return false;
    }

    public boolean isNicknameAlreadyExist(String nickName){
        for(int i = 0; i<member.size(); i++){
            if(member.get(i).getNickname().equals(nickName))
                return true;
        } return false;
    }

    public Membership findMemberByID(String id){
        for(int i = 0; i<member.size(); i++){
            if(member.get(i).getId().equals(id)){
                return member.get(i);
            }
        } return null;
    }

    public Membership findMemberByNickname(String nickname){
        for(int i = 0; i<member.size(); i++){
            if(member.get(i).getNickname().equals(nickname)){
                return member.get(i);
            }
        } return null;
    }

    public void deleteMember(String id){
        for(int i = 0; i<member.size(); i++){
            if(member.get(i).getId().equals(id)){
                member.remove(i);
                break;
            }
        }
    }

    public void modifyMember(String id, String nickname, int point) {
        for(int i = 0; i<member.size(); i++){
            if(member.get(i).getId().equals(id)){
                member.get(i).setNickname(nickname);
                member.get(i).setPoint(point);
            }
        }
    }

    public ArrayList<Membership> selectAll(){
        return member;
    }

}
