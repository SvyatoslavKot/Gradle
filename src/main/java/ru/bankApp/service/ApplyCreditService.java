package ru.bankApp.service;

import org.springframework.stereotype.Service;
import ru.bankApp.app.bankApp.serviceBank.GenerateAccountNumber;
import ru.bankApp.app.entities.ApplyCredit;
import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.dao.AccountDao;
import ru.bankApp.dao.ApplyCreditDao;

@Service
public class ApplyCreditService {
    ApplyCreditDao applyCreditDao;
    GenerateAccountNumber genAccNumber = new GenerateAccountNumber();


    public ApplyCreditService(ApplyCreditDao applyCreditDao) {
        this.applyCreditDao = applyCreditDao;
    }

    public void add(ApplyCredit applyCredit){
        applyCreditDao.add(applyCredit);
    }

    public String genAccNum(){
        String num;
        num = genAccNumber.genApplyNum();
        while (null != applyCreditDao.getByNum(num)){
            num = genAccNumber.accountNumber();
        }
        return num;
    }

}
