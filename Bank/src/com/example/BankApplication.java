package com.example;

import java.util.Scanner;

public class BankApplication {

    private static final Account[] accountArray = new Account[100];
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;

        while (run) {
            System.out.println("--------------------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("--------------------------------------------------");
            System.out.print("선택> ");

            int selectNo = scanner.nextInt();
            scanner.nextLine();

            if (selectNo == 1) {
                createAccount();
            } else if (selectNo == 2) {
                accountList();
            } else if (selectNo == 3) {
                deposit();
            } else if (selectNo == 4) {
                withdraw();
            } else if (selectNo == 5) {
                run = false;
            }
        }
        System.out.println("프로그램 종료");
    }

    // 계좌 생성하기
    private static void createAccount() {
        System.out.println("----------");
        System.out.println("계좌 생성");
        System.out.println("----------");

        System.out.print("계좌번호: ");
        String ano = scanner.nextLine();

        System.out.print("계좌주: ");
        String owner = scanner.nextLine();

        System.out.print("초기입금액: ");
        int balance = Integer.parseInt(scanner.nextLine());

        // scanner 로 입력받은 사용자 정보를 아래의 객체로 생성
        Account account = new Account(ano, owner, balance);

        // 생성된 배열값만큼 Loop 를 돈 후 , accountArray[]가 비어있으면 입력받은 사용자 정보를 저장.
        for(int i =0; i< accountArray.length; i++){
            if(accountArray[i] == null){
                accountArray[i] = account;
                System.out.println("계좌가 생성되었습니다.");
                break;
                //break 를 넣지 않으면 비어있는 accountArray[]에  입력값이 모두 저장되므로 주의할 것
            }
        }
    }

    // 계좌 목록보기
    private static void accountList() {
        System.out.println("----------");
        System.out.println("계좌 목록");
        System.out.println("----------");

        for(int i = 0; i < accountArray.length; i++) {
            if (accountArray[i] != null){
                System.out.println(accountArray[i].getAno()+"\t"+accountArray[i].getOwner()+"\t"+accountArray[i].getBalance());
            }
        }
    }
    // 예금하기
    private static void deposit() {
        System.out.println("----------");
        System.out.println("예금");
        System.out.println("----------");

        System.out.print("계좌번호: ");
        String ano = scanner.nextLine();

        System.out.print("예금액: ");
        int balance = Integer.parseInt(scanner.nextLine());

        Account account = findAccount(ano);

        if(account != null) {   // findAccount 를 실행해서 account 의 값이 null 이 아니면
            account.setBalance(account.getBalance()+balance); // account 객체에서 balance 를 get 으로 불러와
            // 내가 입력한 값을 더해서 set 으로 다시 저장한다.
            System.out.println("결과: 예금이 성공되었습니다.");
        }else {
            System.out.println("결과: 계좌가 존재하지 않습니다.");
            // findAccount 에서 검색을 못했으면 그대로 빠져나온다.
        }


    }

    // 출금하기
    // 전반적인 로직은 예금과 동일히지만 잔액부족 로직을 추가.
    private static void withdraw() {
        System.out.println("----------");
        System.out.println("출금");
        System.out.println("----------");

        System.out.print("계좌번호: ");
        String ano = scanner.nextLine();

        System.out.print("출금액: ");
        String strBalance = scanner.nextLine();
        int balance = Integer.parseInt(strBalance);

        Account account = findAccount(ano);

        if(account != null) {
            if(account.getBalance() < balance){
                // 잔액부족 로직 추가
                System.out.println("예금액보다 많은 금액을 출금할 수 없습니다.");
            } else {
                account.setBalance(account.getBalance()- balance);
                System.out.println("결과: 출금에 성공되었습니다.");
            }
        }else {
            System.out.println("결과: 계좌가 존재하지 않습니다.");
        }

    }

    // Account 배열에서 ano 와 동일한 Account 객체 찾기
    private static Account findAccount(String ano) {
        Account account = null;
        for(int i=0; i<accountArray.length; i++) { // 배열에 저장된 객체들을 불러운 후
            if (accountArray[i]!=null) {   // 값이 null 이 아니면
                if(accountArray[i].getAno().equals(ano)) {  // 또한, accountArray[i]번째의 getAno()값이 ano 와 같으면
                    account = accountArray[i];  // 배열에 저장된 객체를 다시 account 객체에 저장한다
                    break;   // 그 후 반복문을 종료 시키고
                }
            }
        }
        return account;   // 객체값을 가지고 있는다.
    }

}
 
