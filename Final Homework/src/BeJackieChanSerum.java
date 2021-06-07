public class BeJackieChanSerum implements Serum {

    @Override
    public void push() {
        System.out.println("This is the coolest power you will get, you will be the clone of jackiechan(actor, director,MA). (Serum=" + System.identityHashCode(this) + ")");
    }
}