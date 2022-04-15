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

    public String accountNumber (int sizeOfCollectin){
        String a = "1338"  + genNum() + genNum()  + genAccNum(sizeOfCollectin) +"";
        return a;

    }
    public String genAccNum(int sizeOfCollectin){
        int num = sizeOfCollectin++;
        if (sizeOfCollectin < 10){
            return "000" + sizeOfCollectin;
        }else if(sizeOfCollectin < 100){
            return "00" + sizeOfCollectin;
        }else if (sizeOfCollectin < 1000){
           return "0" + sizeOfCollectin;
        }else return "" + sizeOfCollectin;
    }
}
