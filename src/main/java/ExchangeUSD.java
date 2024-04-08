public class ExchangeUSD {
    private double EUR;
    private double balanceUSD;
    private double RON;

    public ExchangeUSD(double balanceUSD, double EUR, double RON) {
        this.EUR = EUR;
        this.balanceUSD = balanceUSD;
        this.RON = RON;
    }

    public double getEUR(){ return EUR; }
    public void setEUR(double EUR){ this.EUR = EUR; }
    public double getBalanceUSD(){ return balanceUSD;}
    public void setBalanceUSD(double balanceUSD){ this.balanceUSD = balanceUSD; }
    public double getRON(){ return RON;}
    public void setRON(double RON){ this.RON = RON; }

    public double toEUR(double sum) {
        return sum*EUR;
    }

    public double toRON(double sum) {
        return sum*RON;
    }
    public double updateUSD(double sum){
        if(sum>balanceUSD){
            System.out.println("ERROR! Not enough EUR in the machine to complete this transaction!");
            return 0;
        } else {
            System.out.println("Transaction successful");
            return balanceUSD-sum;
        }
    }
}
