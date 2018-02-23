package com.talan.sou.demo.tdd.repository;

import com.talan.sou.demo.domain.Account;
import com.talan.sou.demo.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void insertNewAccountTest(){
        Account a = new Account();
        a.setBalance(100);
        a.setAccountName("souhaile");
        entityManager.merge(a);
        entityManager.flush();


        Account b = accountRepository.findByAccountName("souhaile");
        assertThat(b.getAccountName()).isEqualTo(a.getAccountName());

    }

    @Test
    public void accountOpWithdraw(){
        Account a = new Account();
        a.setBalance(100);
        a.setAccountName("souhaile");
        entityManager.merge(a);
        entityManager.flush();

        Account b = accountRepository.findByAccountName("souhaile");
        b.setBalance(b.getBalance() - 100);

        assertThat(b.getBalance()).isEqualTo(a.getBalance()-100);

    }

    @Test
    public void accountOpDeposit(){
        Account a = new Account();
        a.setAccountUID(2);
        a.setBalance(100);
        a.setAccountName("souhaile");
        entityManager.merge(a);
        entityManager.flush();

        Account b = accountRepository.findByAccountUID(2);
        b.setBalance(b.getBalance() + 100);

        assertThat(b.getBalance()).isEqualTo(a.getBalance()+100);

    }



}