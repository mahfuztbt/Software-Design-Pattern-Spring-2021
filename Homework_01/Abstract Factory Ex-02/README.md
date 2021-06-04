
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
            /* 
                  to calculate the monthly loan payment i.e. EMI   
                                
                  rate=annual interest rate/12*100; 
                  n=number of monthly installments;            
                  1year=12 months. 
                  so, n=years*12; 
     
                */

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
**Step 5:** Create an abstract class to get the factories for Bank and Loan Objects.
```java

```
**Step 6:** Create the factory classes that inherit AbstractFactory class to generate the object of concrete class based on given information.
```java

```
**Step 7:** Create a Factory class to get the factories by passing an informatin such as Bank or Loan.
```java

```
**Step 8:** Use the factoryCreator to get an AbstractFactory in order to get factories of concrete classes by passing an information such as type.
```java

```
**Step 2:**

**Step 2:**
