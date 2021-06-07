public class SerumOfMinecraft implements Serum {

    @Override
    public void push() {
        System.out.println("You can read anyone mind. (Serum=" + System.identityHashCode(this) + ")");
    }
}