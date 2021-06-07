public class SerumOfWeakness implements Serum {

    @Override
    public void push() {
        System.out.println("Once you drink this you won't be weak anymore. (Serum=" + System.identityHashCode(this) + ")");
    }
}