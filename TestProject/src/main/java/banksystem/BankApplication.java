package banksystem;

import java.util.Scanner;

public class BankApplication {
    private AccountService accountService = new AccountService();

    private void Header() {
        System.out.println("========================================================");
        System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료|6.파일읽기|7.파일저장");
        System.out.println("========================================================");
    }

    private int option(Scanner scan) throws Exception {
        System.out.print("선택 > ");
        String a = scan.nextLine();
        return Integer.parseInt(a);
    }

    private void addAccount(Scanner scan) throws Exception {
        System.out.println("--------");
        System.out.println("계좌생성");
        System.out.println("--------");

        System.out.print("계좌번호:");
        String accountNumber = scan.nextLine();
        System.out.print("계좌주:");
        String name = scan.nextLine();
        System.out.print("초기입금액:");
        String currentMoney = scan.nextLine();
        long money = Long.parseLong(currentMoney);

        this.accountService.addAccount(new Account(name, accountNumber, money));
    }

    private void printAccount(){
        for(Account account : this.accountService.getAllAccount()){
            System.out.println(account.toString());
        }
    }

    private Account getscanConsole(Scanner scan, String title) {
        System.out.println("--------");
        System.out.println(title);
        System.out.println("--------");

        System.out.print("계좌번호:");
        String accountNumber = scan.nextLine();
        Account account = this.accountService.findAccountNumber(accountNumber);
        if ( account == null ) {
            return null;
        }
        System.out.print(title + "액:");
        String depositMoney = scan.nextLine();
        long money = Long.parseLong(depositMoney);

        return new Account("임시명", accountNumber, money);
    }

    private void tryDeposit(Scanner scan){
        Account objectDeposit =getscanConsole(scan,"예금");
            if( objectDeposit == null){
                System.out.println("계좌가 존재하지 않습니다.");
                return;
            }
            if(this.accountService.depositMoney(objectDeposit.getAccountNumber(), objectDeposit.getCurrentMoney())){
                System.out.println("예금이 성공했습니다.");
            }
            else{
                System.out.println("예금이 실패했습니다.\n1원 이상 금액을 넣어주세요.");
            }
    }

    private void tryWithdraw(Scanner scan){
        Account objectDeposit = getscanConsole(scan,"출금");
        if( objectDeposit == null){
            System.out.println("계좌가 존재하지 않습니다.");
            return;
        }
        if(this.accountService.withdrawMoney(objectDeposit.getAccountNumber(), objectDeposit.getCurrentMoney())){
            System.out.println("출금이 성공했습니다.");
        }
        else{
            System.out.println("출금이 실패했습니다.");
        }
    }


    public static void main(String[] args) {
        try{
            BankApplication bank = new BankApplication();
            Scanner scan = new Scanner(System.in);

            boolean run = true;
            while(run){
                bank.Header();
                int option = bank.option(scan);

                switch (option) {
                    case 1:
                        bank.addAccount(scan);
                        break;
                    case 2:
                        bank.printAccount();
                        break;
                    case 3:
                        bank.tryDeposit(scan);
                        break;
                    case 4:
                        bank.tryWithdraw(scan);
                        break;
                    case 5:
                        run = false;
                        break;
                    default:
                        System.out.println("!!! 잘못된 입력입니다. !!!");
                        break;
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}




