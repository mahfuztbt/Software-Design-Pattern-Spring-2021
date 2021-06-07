public class SerumOfRegenerator implements Serum {

    @Override
    public void push() {
        System.out.println("You will be able to regenerate anything from a small piece. (Serum=" + System.identityHashCode(this) + ")");
    }
}