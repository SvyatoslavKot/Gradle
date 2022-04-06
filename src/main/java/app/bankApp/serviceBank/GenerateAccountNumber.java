package app.bankApp.serviceBank;

public class GenerateAccountNumber {
    public int genNum(){
        final int max = 9999;
        final int rnd = rnd(max);
        return  rnd;
    }
    private static int rnd(int max){
        return (int) (Math.random() * max);
    }
    public String accountNumber (){
        String a = genNum()  + genNum() + genNum()  + genNum() +"";
        return a;

    }
}
