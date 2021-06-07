public class BeDeadpoolSerum implements Serum {

    @Override
    public void push() {
        System.out.println("You will have Deadpool power and will have chance to join Avengers. (Serum=" + System.identityHashCode(this) + ")");
    }
}