package ru.bankApp.service;

import org.springframework.stereotype.Service;
import ru.bankApp.app.entities.EmployTask;
import ru.bankApp.dao.ApplyTaskDao;

@Service
public class ApplyTaskService {
    ApplyTaskDao employTasksDao;

    public ApplyTaskService(ApplyTaskDao employTasksDao) {
        this.employTasksDao = employTasksDao;
    }

    public void add(EmployTask employTask){
        employTasksDao.add(employTask);
    }

    public synchronized EmployTask getTask(){
        return employTasksDao.getTask();
    }

    public void delete(int id){
        employTasksDao.delete(id);
    }
}
