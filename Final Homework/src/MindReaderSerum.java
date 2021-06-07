public class MindReaderSerum implements Serum {

    @Override
    public void push() {
        System.out.println("After taking this serum you can read anyone mind. (Serum=" + System.identityHashCode(this) + ")");
    }
}