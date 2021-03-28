class ABC implements Bank{
    private final String BNAME;
    ABC(){
        BNAME="ABC BANK";
    }
    public String getBankName() {
        return BNAME;
    }
}