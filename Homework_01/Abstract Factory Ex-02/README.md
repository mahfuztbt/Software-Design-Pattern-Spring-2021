
**Step 1:** Create a Bank interface
```java
import java.io.*;
interface Bank{
    String getBankName();
} 
```
**Step 2:** Create concrete classes that implement the Bank interface
```java
class ICBC implements Bank{
    private final String BNAME;
    public ICBC(){
        BNAME="ICBC BANK";
    }
    public String getBankName() {
        return BNAME;
    }
}
```
```java
class ABC implements Bank{
    private final String BNAME;
    ABC(){
        BNAME="ABC BANK";
    }
    public String getBankName() {
        return BNAME;
    }
}
```
```java
class PBC implements Bank{
    private final String BNAME;
    public PBC(){
        BNAME="PBC BANK";
    }
    public String getBankName(){
        return BNAME;
    }
}
```
**Step 3:** Create the loan abstract class.
```java
abstract class Loan{
    protected double rate;
    abstract void getInterestRate(double rate);
    public void calculateLoanPayment(double loanamount, int years)
    {
        double EMI;
        int n;

        n=years*12;
        rate=rate/1200;
        EMI=((rate*Math.pow((1+rate),n))/((Math.pow((1+rate),n))-1))*loanamount;

        System.out.println("your monthly EMI is "+ EMI +" for the amount"+loanamount+" you have borrowed");
    }
}
```
**Step 4:** Create concrete classes that extend the loan abstract class.
```java
class EducationLoan extends Loan{
    public void getInterestRate(double r){
        rate=r;
    }
}
```
```java
class HomeLoan extends Loan{
    public void getInterestRate(double r){
        rate=r;
    }
}
```
```java
class BussinessLoan extends Loan{
    public void getInterestRate(double r){
        rate=r;
    }

}
```
**Step 5:** Create an abstract class to get the factories for Bank and Loan Objects.
```java
abstract class AbstractFactory{
    public abstract Bank getBank(String bank);
    public abstract Loan getLoan(String loan);
}
```
**Step 6:** Create the factory classes that inherit AbstractFactory class to generate the object of concrete class based on given information.
```java
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
```
```java
class LoanFactory extends AbstractFactory{
    public Bank getBank(String bank){
        return null;
    }

    public Loan getLoan(String loan){
        if(loan == null){
            return null;
        }
        if(loan.equalsIgnoreCase("Home")){
            return new HomeLoan();
        } else if(loan.equalsIgnoreCase("Business")){
            return new BussinessLoan();
        } else if(loan.equalsIgnoreCase("Education")){
            return new EducationLoan();
        }
        return null;
    }

}
```
**Step 7:** Create a Factory class to get the factories by passing an informatin such as Bank or Loan.
```java
class FactoryCreator {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Bank")){
            return new BankFactory();
        } else if(choice.equalsIgnoreCase("Loan")){
            return new LoanFactory();
        }
        return null;
    }
}
```
**Step 8:** Use the factoryCreator to get an AbstractFactory in order to get factories of concrete classes by passing an information such as type.
```java
import java.io.*;
class AbstractFactoryPatternExample {
    public static void main(String args[])throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the name of Bank from where you want to take loan amount: ");
        String bankName=br.readLine();

        System.out.print("\n");
        System.out.print("Enter the type of loan e.g. home loan or business loan or education loan : ");

        String loanName=br.readLine();
        AbstractFactory bankFactory = FactoryCreator.getFactory("Bank");
        Bank b=bankFactory.getBank(bankName);

        System.out.print("\n");
        System.out.print("Enter the interest rate for "+b.getBankName()+ ": ");

        double rate=Double.parseDouble(br.readLine());
        System.out.print("\n");
        System.out.print("Enter the loan amount you want to take: ");

        double loanAmount=Double.parseDouble(br.readLine());
        System.out.print("\n");
        System.out.print("Enter the number of years to pay your entire loan amount: ");
        int years=Integer.parseInt(br.readLine());

        System.out.print("\n");
        System.out.println("you are taking the loan from "+ b.getBankName());

        AbstractFactory loanFactory = FactoryCreator.getFactory("Loan");
        Loan l=loanFactory.getLoan(loanName);
        l.getInterestRate(rate);
        l.calculateLoanPayment(loanAmount,years);
    }
}
```

## class diagram
![java class diagram](https://user-images.githubusercontent.com/67628125/120784864-20ee8680-c55f-11eb-84e9-eaa7c6d0fdcc.png)

## result of screenshot
![Screenshot](https://user-images.githubusercontent.com/67628125/120784912-2c41b200-c55f-11eb-8755-8630b4dcc38f.PNG)

