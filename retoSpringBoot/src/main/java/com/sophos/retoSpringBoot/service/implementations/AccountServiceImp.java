package com.sophos.retoSpringBoot.service.implementations;

import com.sophos.retoSpringBoot.entity.Account;
import com.sophos.retoSpringBoot.repository.AccountRepository;
import com.sophos.retoSpringBoot.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account readAccount(Long accountId) {
        return accountRepository.findByAccountId(accountId);
    }

    @Override
    public Account readAllAccountByClientId(Long clientId) {
        return (Account) accountRepository.findAllByClientId(clientId);
    }

    @Override
    public Account updateAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long accountId) {
        accountRepository.deleteById(accountId);
    }
}
