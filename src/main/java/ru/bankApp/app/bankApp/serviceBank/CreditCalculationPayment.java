package ru.bankApp.app.bankApp.serviceBank;

public class CreditCalculationPayment {

    /**
     * calculation of month payment for credit by three param
     * calculate the monthly interest rate( double ptcMonth = (ptc/12)/100) ), after calc exponentiation (double k = Math.pow((1 + ptcMonth), term) ),
     * after annuity ratio ( double coefficient = ptcMonth * k /(k-1) ), then calc payment of month ( double payment = amount * coefficient )
     * @param amount at the time of calculation
     * @param ptc per year
     * @param term for the entite period
     * @return double payment
     */
    public double calc(double amount, double ptc, int term){

        double ptcMonth = (ptc/12)/100;//месячная процентная ставка
        double k = Math.pow((1 + ptcMonth), term); // возведение в степень
        double coefficient = ptcMonth * k /(k-1);//коэфицент аннуитета
        double payment = amount * coefficient;//формула рассчёта платежа
        return payment;
    }
}
