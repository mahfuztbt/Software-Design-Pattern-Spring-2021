public class FlashSerum implements Serum {

    @Override
    public void push() {
        System.out.println("you will get superSpeed. (Serum=" + System.identityHashCode(this) + ")");
    }
}