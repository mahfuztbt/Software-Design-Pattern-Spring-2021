

public class HolyWaterSerum implements Serum {

    @Override
    public void push() {
        System.out.println("You feel blessed. (Serum=" + System.identityHashCode(this) + ")");
    }
}