package com.oop.Jukebox;

import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JukeBox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("☆☆☆ 쥬크 박스 ☆☆☆" +
                "\n플레이하고 싶은 음악을 선택해주세요." +
                "\n1. Seagull - Everet Almond :\n2. H.O.T - Candy :\n3. IU - Blueming :\n4. 프로그램 종료" +
                "\n음악 선택 >> ");
        int menuNum = Integer.parseInt(sc.nextLine());
        try{ FileInputStream fis = null;
            if(menuNum==1){
                fis = new FileInputStream("/Users/jangseoksu/Downloads/Seagull - Everet Almond.mp3");
            } else if(menuNum==2){
                fis = new FileInputStream("/Users/jangseoksu/Downloads/H.O.T.-10-캔디 (Candy)-SM Best Album 2-128.mp3");
            } else if(menuNum==3){
                fis = new FileInputStream("/Users/jangseoksu/Downloads/아이유-03-Blueming-Love poem-192.mp3");
            } else if(menuNum==4){
                System.out.println("쥬크박스를 종료합니다.");
            }

            Player playMp3 = new Player(fis);
            playMp3.play();

            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("음악을 재생하는데 실패했습니다.");
        }

        }

}
