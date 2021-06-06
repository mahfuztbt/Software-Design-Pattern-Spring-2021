# Software-Design-Pattern-Spring-2021
## 基本上，这个资料库是用来向老师展示作业的
### [PPT](https://github.com/mahfuztbt/Software-Design-Pattern-Spring-2021/tree/master/PPT)
### [Homework_01](https://github.com/mahfuztbt/Software-Design-Pattern-Spring-2021/tree/master/Homework_01)



# The Final Homework with Flyweight Design Pattern

## Intent
Use sharing to support large numbers of fine-grained objects efficiently.

## Explanation
Real world example

> Alchemist's shop has shelves full of magic potions. Many of the potions are the same so there is 
> no need to create new object for each of them. Instead one object instance can represent multiple 
> shelf items so memory footprint remains small.

In plain words

> It is used to minimize memory usage or computational expenses by sharing as much as possible with 
> similar objects.

Wikipedia says

> In computer programming, flyweight is a software design pattern. A flyweight is an object that 
> minimizes memory use by sharing as much data as possible with other similar objects; it is a way 
> to use objects in large numbers when a simple repeated representation would use an unacceptable 
> amount of memory.


A Flyweight Pattern says that just "to reuse already existing similar kind of objects by storing them and create new object when no matching object is found".

## Advantage of Flyweight Pattern
- It reduces the number of objects.
- It reduces the amount of memory and storage devices required if the objects are persisted.

## Structure

## Perticipants
1. Flyweight
- declares an interface through which flyweights can receive and action extrinsic state.
2. Concrete Flyweight
- implements the Flyweight interface and adds storage for intrinsic state, if any. A ConcreteFlyweight object must be sharable. Any state it stores must be intrinsic; that is, it must be independent of the ConcreteFlyweight object's context.
4. Unshared Concrete Flyweight
- not all Flyweight subclasses need to be shared. The Flyweight interface enables sharing; it doesn't enforce it. It's common for UnsharedConcreteFlyweight objects to have ConcreteFlyweight objects as children at some level in the flyweight object structure (as the Row and Column classes have).
6. Flyweight Factory
- creates and manages flyweight objects.
- ensures that flyweights are shared properly. When a client requests a flyweight, the FlyweightFactory object supplies an existing instance or creates one, if none exists.
8. Client
- maintains a refernce to flyweights
- computes or stores the extrinsic state of flyweight

**Step 1:**
**Step 2:**
**Step 3:**
**Step 4:**
**Step 5:**
**Step 6:**
**Step 7:**
**Step 8:**
**Step 9:**
**Step 10:**


## Applicability

The Flyweight pattern's effectiveness depends heavily on how and where it's used. Apply the 
Flyweight pattern when all of the following are true:

* An application uses a large number of objects.
* Storage costs are high because of the sheer quantity of objects.
* Most object state can be made extrinsic.
* Many groups of objects may be replaced by relatively few shared objects once extrinsic state is 
removed.
* The application doesn't depend on object identity. Since flyweight objects may be shared, identity 
tests will return true for conceptually distinct objects.








## Below the [Abstract Facotry](https://github.com/mahfuztbt/Software-Design-Pattern-Spring-2021/tree/master/Homework_01/Abstract%20Factory%20Ex-02) example


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


