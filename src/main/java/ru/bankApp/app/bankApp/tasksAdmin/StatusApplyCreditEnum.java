package ru.bankApp.app.bankApp.tasksAdmin;

public enum StatusApplyCreditEnum {
    PENDING("Apply pending"),
    PREV_APPROVED("Предварительно одобрено"),
    PREV_DENIED("Предварительно отклонено"),
    APPROVED("Apply approved"),
    CHANGE_APPROVED("Одобрено с изменениями"),
    DENIED("Apply denied");

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
