



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