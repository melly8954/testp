package com.melly.testproject;

import banksystem.Account;
import banksystem.AccountService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountServiceTests {
    @Test
    public void addAccountTest(){
        AccountService accountService = new AccountService();

        accountService.clear();
        accountService.addAccount("홍길동","111-111",20000);
        assertThat(accountService.size()).isEqualTo(1);

        Account find = accountService.findAccountNumber("111-111");
        assertThat(find).isNotNull();
        assertThat(find.getName()).isEqualTo("홍길동");
        assertThat(find.getFirstMoney()).isEqualTo(20000);
    }

    @Test
    public void depositTest() {
        AccountService accountService = new AccountService();
        accountService.addAccount("홍길동", "111-111", 20000);
        accountService.addAccount("이순신", "222-222", 30000);
        assertThat(accountService.size()).isEqualTo(2);

        boolean result = accountService.depositMoney("222-222", 10000);
        assertThat(result).isEqualTo(true);

        Account find = accountService.findAccountNumber("222-222");
        assertThat(find).isNotNull();
        assertThat(find.getFirstMoney()).isEqualTo(40000);

        Account find2 = accountService.findAccountNumber("444-444");
        assertThat(find2).isNull();
    }

    @Test
    public void withdrawTest() {
        AccountService accountService = new AccountService();
        accountService.addAccount("홍길동", "333-333", 40000);
        assertThat(accountService.size()).isEqualTo(1);

        boolean result = accountService.withdrawMoney("333-333", 20000);
        assertThat(result).isEqualTo(true);

        Account find = accountService.findAccountNumber("333-333");
        assertThat(find).isNotNull();
        assertThat(find.getFirstMoney()).isEqualTo(20000);

        Account find2 = accountService.findAccountNumber("555-555");
        assertThat(find2).isNull();

        boolean result2 = accountService.withdrawMoney("333-333", 30000);
        assertThat(result2).isEqualTo(false);

        Account find3 = accountService.findAccountNumber("333-333");
        assertThat(find3).isNotNull();
        assertThat(find3.getFirstMoney()).isEqualTo(20000);

    }
}
