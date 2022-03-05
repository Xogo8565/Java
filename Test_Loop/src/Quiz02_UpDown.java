import java.util.Scanner;

public class Quiz02_UpDown {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int winScore = 0;
        int loseScore = 0;
        int winSituation = 0;

        while(true){
            int randomNum = (int)((Math.random()*100)+1);

            System.out.println("===== UP & DOWN =====");
            System.out.println("1. Game Start");
            System.out.println("2. Game Score");
            System.out.println("3. End game");
            System.out.print("Type menu >> ");
            int menuNum = Integer.parseInt(sc.nextLine());

            if(menuNum==1){
                for(int i=0; i<10; i++){
                    winSituation = 0;
                    System.out.print("\nInput Number(1~100) >> ");
                    int inputNum = Integer.parseInt(sc.nextLine());
                    if(randomNum>inputNum){
                        System.out.println("<< Up >>");
                    } else if(randomNum<inputNum){
                        System.out.println("<< Down >>");
                    } else {
                        winSituation++;
                        break;
                    }
                } if(winSituation==0){
                    loseScore++;
                    System.out.println("\nYou Lose");
                    System.out.println("Your current score >> " + winScore +" win " +loseScore+" lose\n");
                } else {
                    winScore++;
                    System.out.println("\n<< Excellent >>");
                    System.out.println("Your current score >> " + winScore +" win " +loseScore+" lose\n");
                }

            } else if(menuNum==2){
                System.out.println("\nYour current score >> " + winScore +" win " +loseScore+" lose\n");

            } else if(menuNum==3){
                System.out.println("\nThanks for enjoy");
                break;

            } else {
                System.out.println("\nWrong Menu\n");
            }
        }
    }
}
