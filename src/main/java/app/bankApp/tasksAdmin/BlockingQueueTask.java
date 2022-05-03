package app.bankApp.tasksAdmin;

import app.bankApp.DBtextformat.ReadAccount;

import java.util.ArrayList;

public class BlockingQueueTask {
    private static BlockingQueueTask queue;
    private BlockingQueueTask(){}
    public static BlockingQueueTask getInstance(){
        if(queue == null){
            queue = new BlockingQueueTask();
        }return queue;
    }

    ArrayList<Task> tasks = new ArrayList<>();

    public synchronized Task getTask(){
        while(tasks.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Task task = tasks.get(0);
        tasks.remove(task);
        return  task;
    }

    public synchronized  void put(Task task) {
        tasks.add(task);
        notify();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
