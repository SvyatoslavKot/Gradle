package app.bankApp.exeption;

public class CreditExeption extends Exception{

        int balace;

        public CreditExeption(String message, int balace) {
            super(message);
            this.balace = balace;
        }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
