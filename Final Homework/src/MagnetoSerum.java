public class MagnetoSerum implements Serum {

    @Override
    public void push() {
        System.out.println("You can control metal. (Serum=" + System.identityHashCode(this) + ")");
    }
}