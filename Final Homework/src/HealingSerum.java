public class HealingSerum implements Serum {

    @Override
    public void push() {
        System.out.println("You feel healed. (Serum=" + System.identityHashCode(this) + ")");
    }
}