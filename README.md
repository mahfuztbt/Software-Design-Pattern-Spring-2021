# Software-Design-Pattern-Spring-2021
## 基本上，这个资料库是用来向老师展示作业的
### [PPT](https://github.com/mahfuztbt/Software-Design-Pattern-Spring-2021/tree/master/PPT)
### [Homework_01](https://github.com/mahfuztbt/Software-Design-Pattern-Spring-2021/tree/master/Homework_01)



# The [Final Homework](https://github.com/mahfuztbt/Software-Design-Pattern-Spring-2021/tree/master/Final%20Homework) with Flyweight Design Pattern

## Intent
Flyweight is a structural design pattern that lets you fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object.


## Explanation
Real world example

> In stark industries lab has some super soldier and super human and some power serum. Many of the serum are the same so there is 
> no need to create new object for each of them. Instead one object instance can represent multiple 
> shelf items so memory footprint remains small.

In plain words

> It is used to minimize memory usage or computational expenses by sharing as much as possible with 
> similar objects.

[Wikipedia says](https://en.wikipedia.org/wiki/Flyweight_pattern#Overview)

> In computer programming, flyweight is a software design pattern. A flyweight is an object that 
> minimizes memory use by sharing as much data as possible with other similar objects; it is a way 
> to use objects in large numbers when a simple repeated representation would use an unacceptable 
> amount of memory.


A Flyweight Pattern says that just "to reuse already existing similar kind of objects by storing them and create new object when no matching object is found".

## Advantage of Flyweight Pattern
- It reduces the number of objects.
- It reduces the amount of memory and storage devices required if the objects are persisted.

## Structure
![Picture1](https://user-images.githubusercontent.com/67628125/120919524-aeabac80-c6ec-11eb-9b67-e9d6c7c29b3f.png)
![sequence](https://user-images.githubusercontent.com/67628125/120954351-8ae67600-c781-11eb-8655-e3e9ee8d36d5.png)


## Participants
1. Flyweight
- declares an interface through which flyweights can receive and action extrinsic state.
2. Concrete Flyweight
- implements the Flyweight interface and adds storage for intrinsic state, if any. A ConcreteFlyweight object must be sharable. Any state it stores must be intrinsic; that is, it must be independent of the ConcreteFlyweight object's context.
3. Unshared Concrete Flyweight
- not all Flyweight subclasses need to be shared. The Flyweight interface enables sharing; it doesn't enforce it. It's common for UnsharedConcreteFlyweight objects to have ConcreteFlyweight objects as children at some level in the flyweight object structure (as the Row and Column classes have).
4. Flyweight Factory
- creates and manages flyweight objects.
- ensures that flyweights are shared properly. When a client requests a flyweight, the FlyweightFactory object supplies an existing instance or creates one, if none exists.
5. Client
- maintains a refernce to flyweights
- computes or stores the extrinsic state of flyweight

## [Source Code](https://github.com/mahfuztbt/Software-Design-Pattern-Spring-2021/tree/master/Final%20Homework/src)
**Step 1:** Let's Serums Interface
```java
/**
 *
 * Interface for Serums.
 *
 */
public interface Serum {

    void push();
}
```
**Step 2:** Now let's create enum differnet types of serums
```java
/**
 *
 * Enumeration for serums types.
 *
 */
public enum SerumType {

    HEALING, INVISIBILITY, STRENGTH, HOLY_WATER, POISON, SUPERHUMAN, HULK, DEADPOOL, JACKIECHAN, WOLVERINE, FLASH, MAGNETO,
    MINECRAFT, REGENERATOR, WEAKNESS, CAP, MINDREADER
}
```

**Step 3:** Now create differnt types of surum
```java
public class BecomeHulkSerum implements Serum {

    @Override
    public void push() {
        System.out.println("You will be Hulk and get his power. (Serum=" + System.identityHashCode(this) + ")");
    }
}
```
```java
public class BeDeadpoolSerum implements Serum {

    @Override
    public void push() {
        System.out.println("You will have Deadpool power and will have chance to join Avengers. (Serum=" + System.identityHashCode(this) + ")");
    }
}
```
```java
public class BeWolverineSerum implements Serum {

    @Override
    public void push() {
        System.out.println("You will get Logan power. (Serum=" + System.identityHashCode(this) + ")");
    }
}
```
```java
public class BeJackieChanSerum implements Serum {

    @Override
    public void push() {
        System.out.println("This is the coolest power you will get, you will be the clone of jackiechan(actor, director,MA). (Serum=" + System.identityHashCode(this) + ")");
    }
}
```
**Step 4:** Then the actual Flyweight object which is the factory for creating serums
```java
/**
 
   Serum is the Flyweight in this example. It minimizes memory use by sharing object
   instances. It holds a map of potion instances and new potions are created only when none of the
   type already exists.
 
 */

import java.util.EnumMap;
import java.util.Map;

public class SerumFactory {

    private final Map<SerumType, Serum> Serums;

    public SerumFactory() {
        Serums = new EnumMap<>(SerumType.class);
    }

    Serum createPotion(SerumType type) {
        Serum serum = Serums.get(type);
        if (serum == null) {
            switch (type) {
                case HEALING:
                    serum = new HealingSerum();
                    Serums.put(type, serum);
                    break;
                case HOLY_WATER:
                    serum = new HolyWaterSerum();
                    Serums.put(type, serum);
                    break;
                case INVISIBILITY:
                    serum = new InvisibilitySerum();
                    Serums.put(type, serum);
                    break;
                case POISON:
                    serum = new PoisonSerum();
                    Serums.put(type, serum);
                    break;
                case STRENGTH:
                    serum = new StrengthSerum();
                    Serums.put(type, serum);
                    break;
                case SUPERHUMAN:
                    serum = new SuperhumanSerum();
                    Serums.put(type, serum);
                    break;
                case CAP:
                    serum = new SuperSoldierCapSerum();
                    Serums.put(type, serum);
                    break;
                case HULK:
                    serum = new BecomeHulkSerum();
                    Serums.put(type, serum);
                    break;
                case FLASH:
                    serum = new FlashSerum();
                    Serums.put(type, serum);
                    break;
                case MAGNETO:
                    serum = new MagnetoSerum();
                    Serums.put(type, serum);
                    break;
                case DEADPOOL:
                    serum = new BeDeadpoolSerum();
                    Serums.put(type, serum);
                    break;
                case WEAKNESS:
                    serum = new SerumOfWeakness();
                    Serums.put(type, serum);
                    break;
                case MINECRAFT:
                    serum = new SerumOfMinecraft();
                    Serums.put(type, serum);
                    break;
                case WOLVERINE:
                    serum = new BeWolverineSerum();
                    Serums.put(type, serum);
                    break;
                case JACKIECHAN:
                    serum = new BeJackieChanSerum();
                    Serums.put(type, serum);
                    break;
                case REGENERATOR:
                    serum = new SerumOfRegenerator();
                    Serums.put(type, serum);
                    break;
                case MINDREADER:
                    serum = new MindReaderSerum();
                    Serums.put(type, serum);
                    break;
                default:
                    break;
            }
        }
        return serum;
    }
}

```
**Step 5:** Now create stark industries lab to uses SerumFactory to provide the serums
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * Stark industry holds serum on its shelves. It uses SerumFactory to provide the serums.
 *
 */
public class StarkIndustriesLab {

    private List<Serum> lab01;
    private List<Serum> lab02;

    /**
     * Constructor
     */
    public StarkIndustriesLab() {
        lab01 = new ArrayList<>();
        lab02 = new ArrayList<>();
        fillShelves();
    }

    private void fillShelves() {

        SerumFactory factory = new SerumFactory();

        lab01.add(factory.createPotion(SerumType.INVISIBILITY));
        lab01.add(factory.createPotion(SerumType.INVISIBILITY));
        lab01.add(factory.createPotion(SerumType.STRENGTH));
        lab01.add(factory.createPotion(SerumType.HEALING));
        lab01.add(factory.createPotion(SerumType.INVISIBILITY));
        lab01.add(factory.createPotion(SerumType.STRENGTH));
        lab01.add(factory.createPotion(SerumType.MINDREADER));
        lab01.add(factory.createPotion(SerumType.MINDREADER));
        lab01.add(factory.createPotion(SerumType.HEALING));
        lab01.add(factory.createPotion(SerumType.HEALING));

        lab01.add(factory.createPotion(SerumType.HULK));
        lab01.add(factory.createPotion(SerumType.HULK));
        lab01.add(factory.createPotion(SerumType.DEADPOOL));
        lab01.add(factory.createPotion(SerumType.DEADPOOL));
        lab01.add(factory.createPotion(SerumType.JACKIECHAN));
        lab01.add(factory.createPotion(SerumType.JACKIECHAN));
        lab01.add(factory.createPotion(SerumType.WOLVERINE));
        lab01.add(factory.createPotion(SerumType.WOLVERINE));
        lab01.add(factory.createPotion(SerumType.FLASH));
        lab01.add(factory.createPotion(SerumType.FLASH));

        lab02.add(factory.createPotion(SerumType.POISON));
        lab02.add(factory.createPotion(SerumType.POISON));
        lab02.add(factory.createPotion(SerumType.POISON));
        lab02.add(factory.createPotion(SerumType.HOLY_WATER));
        lab02.add(factory.createPotion(SerumType.HOLY_WATER));
        lab02.add(factory.createPotion(SerumType.WEAKNESS));
        lab02.add(factory.createPotion(SerumType.SUPERHUMAN));

        lab02.add(factory.createPotion(SerumType.MAGNETO));
        lab02.add(factory.createPotion(SerumType.MAGNETO));
        lab02.add(factory.createPotion(SerumType.MINECRAFT));
        lab02.add(factory.createPotion(SerumType.REGENERATOR));
        lab02.add(factory.createPotion(SerumType.REGENERATOR));
        lab02.add(factory.createPotion(SerumType.REGENERATOR));
        lab02.add(factory.createPotion(SerumType.WEAKNESS));
        lab02.add(factory.createPotion(SerumType.CAP));


    }

    /**
     * Get a read-only list of all the items on the top shelf
     *
     * @return The top shelf serums
     */
    public final List<Serum> getLab01() {
        return Collections.unmodifiableList(this.lab01);
    }

    /**
     * Get a read-only list of all the items on the bottom shelf
     *
     * @return The bottom shelf serums
     */
    public final List<Serum> getLab02() {
        return Collections.unmodifiableList(this.lab02);
    }

    /**
     * Enumerate serums
     */
    public void enumerate() {


        System.out.println("Bellow the serum you will find in stark lab 1\n" +
                "if you have any problem then please contract with Ronnie\n");

        for (Serum p : lab01) {
            p.push();
        }

        System.out.println("\nBellow the serum you will find in stark lab 2\n" +
                "if you have any problem then please contract with Ronnie\n");

        for (Serum p : lab02) {
            p.push();
        }
    }
}
```
**Step 6:** It can be used as below
```java
SerumFactory factory = new SerumFactory();
factory.createSerum(SerumType.HULK).push(); // You will be Hulk and get his power. (Serum=883049899)
factory.createSerum(SerumType.WOLVERINE).push(); // You will get Logan power. (Serum=317574433)
factory.createSerum(SerumType.DEADPOOL).push(); // You will have Deadpool power and will have chance to join Avengers. (Serum=2093176254)
factory.createSerum(SerumType.HULK).push(); // You will be Hulk and get his power. (Serum=883049899)
factory.createSerum(SerumType.WOLVERINE).push(); // You will get Logan power. (Serum=317574433)
factory.createSerum(SerumType.DEADPOOL).push(); // You will have Deadpool power and will have chance to join Avengers. (Serum=2093176254)
```
**Step 7:** Create App class and run the program
```java

/**
 *
 * Flyweight pattern is useful when the program needs a huge amount of objects. It provides means to
 * decrease resource usage by sharing object instances.
 * <p>
 * In this example {@link StarkIndustriesLab} has great amount of potions on its shelves. To fill the
 * shelves {@link StarkIndustriesLab} uses {@link SerumFactory} (which represents the Flyweight in this
 * example). Internally {@link SerumFactory} holds a map of the serums and lazily creates new ones
 * when requested.
 * <p>
 * To enable safe sharing, between clients and threads, Flyweight objects must be immutable.
 * Flyweight objects are by definition value objects.
 *
 */
public class App {

    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        StarkIndustriesLab starkIndustriesLab = new StarkIndustriesLab();
        starkIndustriesLab.enumerate();
    }
}
```
```java

```

## Result 
![Result 1](https://user-images.githubusercontent.com/67628125/121007441-9f982d80-c7c4-11eb-8efa-430d48aa9b33.PNG)
![Result 2](https://user-images.githubusercontent.com/67628125/121007471-a626a500-c7c4-11eb-9b05-41ade44f234a.PNG)


## Class Diagram
![Class Diagram](https://user-images.githubusercontent.com/67628125/121008273-690ee280-c7c5-11eb-879d-747065ed6a9f.png)
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





# Below the [Abstract Facotry](https://github.com/mahfuztbt/Software-Design-Pattern-Spring-2021/tree/master/Homework_01/Abstract%20Factory%20Ex-02) example


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


