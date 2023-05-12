package com.dreambamboo.service.impl;

import com.dreambamboo.repository.AccountRepository;
import com.dreambamboo.repository.impl.AccountRepositoryImpl;
import com.dreambamboo.service.AccountService;

public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository = new AccountRepositoryImpl();
    @Override
    public Object login(String username,String password, String type) {
        Object object = null;
        switch (type){
            case "reader":
                object = accountRepository.readerLogin(username,password);
                break;
            case "bookadmin":
                object = accountRepository.adminLogin(username,password);
                break;
        }
        return object;
    }
}
