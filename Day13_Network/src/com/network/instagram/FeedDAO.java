package com.network.instagram;

import java.util.ArrayList;

public class FeedDAO {

    ArrayList<FeedDTO> feedList = new ArrayList<>();

    public void newFeed(String feedName, String feedContent, String nickname){
        feedList.add(new FeedDTO(feedName,feedContent,nickname));
    }

    public String showAllFeed(){

        String allFeed = "";
        for(int i =0; i< feedList.size(); i++){
            allFeed += i +"\t" + feedList.get(i).getNickname() + "\t" + feedList.get(i).getTitle()+"\t"+feedList.get(i).getContent();
        }
        return allFeed;
    }

    public String showSelectFeed(int seq) {
        String selectedFeed = "";
        return selectedFeed += seq + "\t" + feedList.get(seq).getNickname()+  "\t" + feedList.get(seq).getTitle()+"\t"+feedList.get(seq).getContent();
    }

}
