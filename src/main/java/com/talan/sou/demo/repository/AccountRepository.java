package com.talan.sou.demo.repository;

import com.talan.sou.demo.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
     Account findByAccountName(String name);
     Account findByAccountUID(long uid);
}