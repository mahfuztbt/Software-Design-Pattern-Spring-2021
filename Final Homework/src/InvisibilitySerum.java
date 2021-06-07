



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