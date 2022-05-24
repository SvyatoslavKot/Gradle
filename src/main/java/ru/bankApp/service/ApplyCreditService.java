package ru.bankApp.service;

import org.springframework.stereotype.Service;
import ru.bankApp.app.bankApp.serviceBank.GenerateAccountNumber;
import ru.bankApp.app.entities.ApplyCredit;
import ru.bankApp.app.entities.accountFactory.Account;
import ru.bankApp.app.entities.creditFactory.Credit;
import ru.bankApp.dao.AccountDao;
import ru.bankApp.dao.ApplyCreditDao;

import java.util.List;

@Service
public class ApplyCreditService {
    ApplyCreditDao applyCreditDao;
    GenerateAccountNumber genAccNumber = new GenerateAccountNumber();
    CreditService creditService;

    public ApplyCreditService(ApplyCreditDao applyCreditDao,CreditService creditService) {
        this.applyCreditDao = applyCreditDao;
        this.creditService = creditService;
    }

    public List<ApplyCredit> all(){
        return applyCreditDao.allApplyCredit();
    }
    public void add(ApplyCredit applyCredit){
        applyCreditDao.add(applyCredit);
    }

    public ApplyCredit getById(int id){
        return  applyCreditDao.getById(id);
    }
    public ApplyCredit getByNum(String num){
        return applyCreditDao.getByNum(num);
    }

    public void upDate(int id , ApplyCredit ac){
        applyCreditDao.upDate(id, ac);
    }

    public void delete(int id){
        applyCreditDao.delete(id);
    }

    public String genAccNum(){
        String num;
        num = genAccNumber.genApplyNum();
        while (null != applyCreditDao.getByNum(num)){
            num = genAccNumber.accountNumber();
        }
        return num;
    }

    public void calckSolvency(ApplyCredit applyCredit){
        List<Credit> credits = creditService.getByClientId(applyCredit.getClient_id());
        double clientPayment = applyCredit.getOther_credit();
        double kof = 1;

        if (credits.size()>0){
            for (Credit credit: credits){
                clientPayment = clientPayment + credit.getPayment_month();
            }
        }

        if (applyCredit.getChild() ==1){kof = kof+ 0.2;}
        else if (applyCredit.getChild() ==2){kof = kof+ 0.3;}
        else if (applyCredit.getChild() ==3){kof = kof+ 0.4;}
        else {kof = kof+ 0.5;}

        if (applyCredit.getExperience() == 0 ){kof = kof + 0.6;}
        else if (applyCredit.getExperience() == 1 ){kof = kof + 0.5;}
        else if (applyCredit.getExperience() == 2 ){kof = kof + 0.4;}
        else if (applyCredit.getExperience() == 3 ){kof = kof + 0.3;}

        if (applyCredit.getAge() < 19){kof = kof +0.6;}
        else if (applyCredit.getAge() >= 19 && applyCredit.getAge()<21){kof = kof +0.5;}
        else if (applyCredit.getAge() >= 21 && applyCredit.getAge()<27 && applyCredit.getAge() >= 57){kof = kof +0.2;}

        double solvency = (applyCredit.getIncome() - clientPayment)/kof;
        applyCredit.setSolvency(solvency);
        applyCreditDao.upDate(applyCredit.getId(),applyCredit);
    }

}
