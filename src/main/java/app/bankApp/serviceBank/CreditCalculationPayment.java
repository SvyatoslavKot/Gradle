package app.bankApp.serviceBank;

public class CreditCalculationPayment {
    public double calc(int amount, double ptc, int term){
        double ptcMonth = (ptc/12)/100;//месячная процентная ставка
        double k = Math.pow((1 + ptcMonth), term); // возведение в степень
        double coefficient = ptcMonth * k /(k-1);//коэфицент аннуитета
        double payment = amount * coefficient;//формула рассчёта платежа
        return payment;
    }
}
