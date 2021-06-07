public class SerumOfNightvision implements Serum {

    @Override
    public void push() {
        System.out.println("You will able to see clear at night. (Serum=" + System.identityHashCode(this) + ")");
    }
}