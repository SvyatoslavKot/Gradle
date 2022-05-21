package ru.bankApp.service;

import org.springframework.stereotype.Service;
import ru.bankApp.app.entities.creditFactory.Credit;
import ru.bankApp.dao.CreditDao;

@Service
public class CreditService {
    CreditDao creditDao;

    public CreditService(CreditDao creditDao) {
        this.creditDao = creditDao;
    }

    public void add (Credit credit){
        creditDao.add(credit);
    }
}
