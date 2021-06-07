

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