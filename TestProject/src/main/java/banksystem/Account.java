package banksystem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Account {
    private String name;
    private String accountNumber;
    private int firstMoney;

    public Account(){

    }

    public Account(String name,String accountNumber,int firstMoney){
        this.name=name;
        this.accountNumber=accountNumber;
        this.firstMoney=firstMoney;
    }

    @Override
    public String toString() {
        return String.format("Account{name='%s', accountNumber='%s', firstMoney='%d'}"
            ,this.name,this.accountNumber,this.firstMoney);
    }
}
