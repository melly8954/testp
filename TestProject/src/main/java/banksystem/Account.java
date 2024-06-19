package banksystem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Account {
    private String name;
    private String accountNumber;
    private long currentMoney;

    public Account(){

    }

    public Account(String name,String accountNumber,long currentMoney){
        this.name=name;
        this.accountNumber=accountNumber;
        this.currentMoney = currentMoney;
    }

    @Override
    public String toString() {
        return String.format("Account{name='%s', accountNumber='%s', firstMoney='%d'}"
            ,this.name,this.accountNumber,this.currentMoney);
    }
}
