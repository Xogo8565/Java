package com.oop.joption;

import javax.swing.*;

public class Run {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("1. 이름을 입력하세요.");
        JOptionPane.showMessageDialog(null,getCustomer(name));

        int memNum = Integer.parseInt(JOptionPane.showInputDialog("2. 인원 수를 입력하세요"));
        JOptionPane.showMessageDialog(null,getCustomer(memNum));

        double tem = Double.parseDouble(JOptionPane.showInputDialog("3. 체온을 입력하세요"));
        JOptionPane.showMessageDialog(null,getCustomer(tem));

        boolean eatIn = Boolean.parseBoolean(JOptionPane.showInputDialog("4. 매장 식사 여부를 입력하세요"));
        JOptionPane.showMessageDialog(null,getCustomer(eatIn));
    }

    public static String getCustomer (String name){
        return name + "님 안녕하세요!\n";
    }
    public static String getCustomer (int number){

        return "손님 "+ number+"명 입장하였습니다.\n";
    }
    public static String getCustomer (double temperature){
        String temCheck = "현재 입장한 손님의 체온은 "+ temperature+"도 입니다.\n";
        if(temperature>37) return temCheck + "입장불가 입니다\n";
        else if(temperature<36.5) return temCheck + "체온이 너무 낮습니다\n";
        else return temCheck + "정상 체온입니다\n";
    }
    public static String getCustomer (boolean eatIn){
        if(eatIn) return "매장 손님입니다.\n";
        else return "포장 손님입니다.\n";
    }
}
