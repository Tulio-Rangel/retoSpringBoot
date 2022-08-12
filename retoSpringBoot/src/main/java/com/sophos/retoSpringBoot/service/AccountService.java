package com.sophos.retoSpringBoot.service;

import com.sophos.retoSpringBoot.entity.Account;

public interface AccountService {
    Account createAccount(Account account);
    Account readAccount(Long accountId);
    Account readAllAccountByClientId(Long clientId);
    Account updateAccount(Account account);
    boolean deleteAccount(Long accountId);
}
