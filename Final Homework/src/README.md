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
```java
public class FlashSerum implements Serum {

    @Override
    public void push() {
        System.out.println("you will get superSpeed. (Serum=" + System.identityHashCode(this) + ")");
    }
}
```
```java
public class HealingSerum implements Serum {

    @Override
    public void push() {
        System.out.println("You feel healed. (Serum=" + System.identityHashCode(this) + ")");
    }
}
```
```java
public class HolyWaterSerum implements Serum {

    @Override
    public void push() {
        System.out.println("You feel blessed. (Serum=" + System.identityHashCode(this) + ")");
    }
}
```
```java
/**
 *
 * InvisibilitySerum
 *
 */
public class InvisibilitySerum implements Serum {

    @Override
    public void push() {
        System.out.println("You become invisible. (Serum=" + System.identityHashCode(this) + ")");
    }
}
```
```java
public class MagnetoSerum implements Serum {

    @Override
    public void push() {
        System.out.println("You can control metal. (Serum=" + System.identityHashCode(this) + ")");
    }
}
```
```java
public class MindReaderSerum implements Serum {

    @Override
    public void push() {
        System.out.println("After taking this serum you can read anyone mind. (Serum=" + System.identityHashCode(this) + ")");
    }
}
```
```java
/**
 *
 * Poison
 *
 */
public class PoisonSerum implements Serum {

    @Override
    public void push() {
        System.out.println("This is poisonous. (Serum=" + System.identityHashCode(this) + ")");
    }
}
```
```java
public class SerumOfMinecraft implements Serum {

    @Override
    public void push() {
        System.out.println("You can read anyone mind. (Serum=" + System.identityHashCode(this) + ")");
    }
}
```
```java
public class SerumOfNightvision implements Serum {

    @Override
    public void push() {
        System.out.println("You will able to see clear at night. (Serum=" + System.identityHashCode(this) + ")");
    }
}
```
```java
public class SerumOfRegenerator implements Serum {

    @Override
    public void push() {
        System.out.println("You will be able to regenerate anything from a small piece. (Serum=" + System.identityHashCode(this) + ")");
    }
}
```
```java
public class SerumOfWeakness implements Serum {

    @Override
    public void push() {
        System.out.println("Once you drink this you won't be weak anymore. (Serum=" + System.identityHashCode(this) + ")");
    }
}
```
```java
/**
 *
 * Strength
 *
 */
public class StrengthSerum implements Serum {

    @Override
    public void push() {
        System.out.println("You feel strong. (Serum=" + System.identityHashCode(this) + ")");
    }
}
```
```java
public class SuperhumanSerum implements Serum {

    @Override
    public void push() {
        System.out.println("You will become super human(like superman). (Serum=" + System.identityHashCode(this) + ")");
    }
}
```
```java
public class SuperSoldierCapSerum implements Serum {

    @Override
    public void push() {
        System.out.println("using this you will be powerful like (captain america). (Serum=" + System.identityHashCode(this) + ")");
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
**Step 6:** Create App class and run the program
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
