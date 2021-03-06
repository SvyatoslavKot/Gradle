package ru.bankApp.app.bankApp.tasksAdmin;

public enum StatusApplyCreditEnum {
    PENDING("На рассмотрении"),
    PREV_APPROVED("Предварительно одобрено"),
    PREV_DENIED("Предварительно отклонено"),
    APPROVED("Одобрено"),
    CHANGE_APPROVED("Одобрено с изменениями"),
    DENIED("Отклонено");

    //значение enum
    public String status;
    /**
     * constructor that sets a value enum
     * @param status
     */
    StatusApplyCreditEnum(String status){
        this.setStatus(status);
    }
    /**
     * @param status
     */
    private void setStatus(String status) {
        this.status = status;
    }
}
