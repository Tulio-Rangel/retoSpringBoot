package com.sophos.retoSpringBoot.repository;

import com.sophos.retoSpringBoot.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAccountId(Long accountId);
    List<Account> findAllByClientId(Long clientId);
}
