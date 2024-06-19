package banksystem;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    /**
     * 계좌 배열 인스턴스 변수 (객체 프로퍼티, 인스턴스 필드)
     */
    private List<Account> accountList = new ArrayList<>();
    /**
     * 계좌 배열 길이를 int 형으로 리턴한다.
     * return Accounts array size (int)
     * @return : Accounts array size (int)
     */

    public int size(){
        return this.accountList.size();
    }

    public void clear(){
        this.accountList.clear();   // 계좌 전체 삭제
    }

    /**
     * 계좌(Account) 배열에 계좌정보(Account) 를 추가한다.
     * @param name : 계좌대표이름
     * @param accountNumber : 계좌번호
     * @param firstMoney : 초기금액
     * @return : true or false
     */
    public boolean addAccount(String name, String accountNumber, int firstMoney){
        return this.accountList.add(new Account(name,accountNumber,firstMoney));
                    // 클래스 Account 라서 new 사용
    }

    /**
     * 계좌(Account) 배열에 계좌정보(Account) 를 추가한다.
     * @param account : 계좌정보 Account 객체
     * @return : true or false
     */
    public boolean addAccount(Account account){
        return this.accountList.add(account);
    }

    /**
     * 계좌 배열을 리턴한다.
     * return Accounts Array List
     * @return
     */
    public List<Account> getAllAccount() {
        return this.accountList;
    }

    public Account findAccountNumber(String accountNumber){
        if(accountNumber == null || accountNumber.isEmpty()){
            return null;
        }
        for(Account account : accountList){
            if(accountNumber.equals(account.getAccountNumber())){
                return account;
            }
        }
        return null;
    }

    public boolean depositMoney(String accountNumber, int money){
        Account account = this.findAccountNumber(accountNumber);
        if( account == null){
            return false;
        }
        if( money>0){
            account.setFirstMoney(account.getFirstMoney()+money);
            return true;
        }
        else{
            return false;
        }


    }

    public boolean withdrawMoney(String accountNumber, int money){
        Account account = this.findAccountNumber(accountNumber);
        if( account == null ){
            return false;
        }
        if(account.getFirstMoney()>=money){
            account.setFirstMoney(account.getFirstMoney()-money);
            return true;
        }
        else{
            return false;
        }
    }




}
