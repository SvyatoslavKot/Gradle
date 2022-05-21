package ru.bankApp.app.entities.accountFactory;

public enum LevelOfAccount {
    LIGHT("Light"),
    STANDARD("Standard"),
    GOLD("Gold"),
    PENSION("Pension");
    String level;

    LevelOfAccount(String level) {
        this.setLevel(level);
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
