import java.util.Scanner;

public class Quiz01_RSP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int randomNum = (int)(Math.random()*3+1);
            String result = null;
            String userRsp;
            String comRsp;
            System.out.print("===== 가위 바위 보 게임 =====\n" +
                    "1. 가위   2.  바위   3.  보\n " +
                    ">>  ");

            int inputNum = sc.nextInt();
            sc.nextLine();

            // random -> 가위바위보 변환
            if(randomNum==1){
                comRsp = "가위";
            } else if(randomNum==2){
                comRsp= "바위";
            } else {
                comRsp = "보";
            }
            
            // input -> 가위바위보 변환
            if(inputNum==1){
                userRsp = "가위";
            } else if(inputNum==2){
                userRsp = "바위";
            } else if(inputNum ==3){
                userRsp = "보";
            } else {
                userRsp = "";
            }

            //가위바위보 결과값 저장
            if(inputNum==1){ // 사용자 가위
                if(randomNum==1){ // 컴퓨터 가위
                    result = "비겼습니다.";
                } else if(randomNum==2){ // 컴퓨터 바위
                    result = "졌습니다.";
                } else if(randomNum==3) { //컴퓨터
                    result = "이겼습니다.";
                }
            } else if(inputNum==2){// 사용자 바위
                if(randomNum==1){ // 컴퓨터 가위
                    result = "이겼습니다.";
                } else if (randomNum==2){ //컴퓨터 바위
                    result = "비겼습니다.";
                } else if (randomNum==3) {
                    result = "졌습니다.";
                }
            } else if(inputNum==3){ // 사용자 보
                if(randomNum==1){ // 컴퓨터 가위
                    result = "졌습니다.";
                } else if(randomNum==2){ // 컴퓨터 바위
                    result = "이겼습니다.";
                } else if(randomNum==3){ //컴퓨터 보
                    result = "비겼습니다.";
                } 
            } else {
                result = "잘못된 입력입니다.";
            }
            System.out.println("컴퓨터 : " + comRsp + "     사용자 : " + userRsp);
            System.out.println(result+"\n");
        }
    }
}
