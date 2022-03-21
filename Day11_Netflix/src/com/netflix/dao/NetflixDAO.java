package com.netflix.dao;

import com.netflix.dto.MemberShip;

import java.util.ArrayList;

public class NetflixDAO {
    ArrayList member = new ArrayList<>();

    public void addMember(MemberShip memberShips){
        member.add(memberShips);
    }

    public boolean isIdAlreadyExist(String id){
        for(int i = 0; i<member.size(); i++){
            if(((MemberShip)member.get(i)).getId().equals(id))
                return true;
        } return false;
    }

    public boolean isNickNameAlreadyExist(String nickName){
        for(int i = 0; i<member.size(); i++){
            if(((MemberShip)member.get(i)).getNickname().equals(nickName))
                return true;
        } return false;
    }

    public MemberShip findMemberByID(String id){
        for(int i = 0; i<member.size(); i++){
            if(((MemberShip)member.get(i)).getId().equals(id)){
                return (MemberShip) member.get(i);
            }
        } return null;
    }

    public MemberShip findMemberBynickName(String nickName){
        for(int i = 0; i<member.size(); i++){
            if(((MemberShip)member.get(i)).getNickname().equals(nickName)){
                return (MemberShip) member.get(i);
            }
        } return null;
    }

    public void deleteMember(String id){
        for(int i = 0; i<member.size(); i++){
            if(((MemberShip)member.get(i)).getId().equals(id)){
                member.remove(i);
                break;
            }
        }
    }

    public void modifyMember(String id, String nickName, int point) {
        for(int i = 0; i<member.size(); i++){
            if(((MemberShip)member.get(i)).getId().equals(id)){
                ((MemberShip)member.get(i)).setNickname(nickName);
                ((MemberShip)member.get(i)).setPoint(point);
            }
        }
    }

    public ArrayList selectAll(){
        return member;
    }

    public int numberConvert(String str){
        try{
            return Integer.parseInt(str);
        } catch (NumberFormatException e){
            return -1;
        }
    }

}
