

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