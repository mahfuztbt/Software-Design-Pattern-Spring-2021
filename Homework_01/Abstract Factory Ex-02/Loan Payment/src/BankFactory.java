class BankFactory extends AbstractFactory{
    public Bank getBank(String bank){
        if(bank == null){
            return null;
        }
        if(bank.equalsIgnoreCase("ICBC")){
            return new ICBC();
        } else if(bank.equalsIgnoreCase("ABC")){
            return new ABC();
        } else if(bank.equalsIgnoreCase("PBC")){
            return new PBC();
        }
        return null;
    }
    public Loan getLoan(String loan) {
        return null;
    }
}