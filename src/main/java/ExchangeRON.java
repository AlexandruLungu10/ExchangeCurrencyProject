public class ExchangeRON {
    private double EUR;
    private double USD;
    private double balanceRON;

    public ExchangeRON(double balanceRON, double EUR, double USD) {
        this.EUR = EUR;
        this.USD = USD;
        this.balanceRON = balanceRON;
    }

    public double getEUR(){ return EUR; }
    public void setEUR(double EUR){ this.EUR = EUR; }
    public double getUSD(){ return USD;}
    public void setUSD(double USD){ this.USD = USD; }
    public double getBalanceRON(){ return balanceRON;}
    public void setBalanceRON(double balanceRON){ this.balanceRON = balanceRON; }

    public double toEUR(double sum) {
        return sum*EUR;
    }

    public double toUSD(double sum) {
        return sum*USD;
    }
    public double updateRON(double sum){
        if(sum>balanceRON){
            System.out.println("ERROR! Not enough EUR in the machine to complete this transaction!");
            return 0;
        } else {
            System.out.println("Transaction successful");
            return balanceRON-sum;
        }
    }

}
