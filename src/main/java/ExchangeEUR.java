public class ExchangeEUR {
    private double balanceEUR;
    private double USD;
    private double RON;

    public ExchangeEUR(double balanceEUR, double USD, double RON) {
        this.balanceEUR = balanceEUR;
        this.USD = USD;
        this.RON = RON;
    }

    public double getBalanceEUR(){ return balanceEUR; }
    public void setBalanceEUR(double balanceEUR){ this.balanceEUR = balanceEUR; }
    public double getUSD(){ return USD;}
    public void setUSD(double USD){ this.USD = USD; }
    public double getRON(){ return RON;}
    public void setRON(double RON){ this.RON = RON; }

    public double toRON(double sum) {
        return sum*RON;
    }

    public double toUSD(double sum) {
        return sum*USD;
    }
    public double updateEUR(double sum){
        if(sum>balanceEUR){
            System.out.println("ERROR! Not enough EUR in the machine to complete this transaction!");
            return 0;
        } else {
            System.out.println("Transaction successful");
            return balanceEUR-sum;
        }
    }
}
