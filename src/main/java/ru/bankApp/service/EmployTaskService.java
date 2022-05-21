package ru.bankApp.service;

import org.springframework.stereotype.Service;
import ru.bankApp.app.entities.EmployTask;
import ru.bankApp.dao.EmployTasksDao;

@Service
public class EmployTaskService {
    EmployTasksDao employTasksDao;

    public EmployTaskService(EmployTasksDao employTasksDao) {
        this.employTasksDao = employTasksDao;
    }

    public void add(EmployTask employTask){
        employTasksDao.add(employTask);
    }
}
