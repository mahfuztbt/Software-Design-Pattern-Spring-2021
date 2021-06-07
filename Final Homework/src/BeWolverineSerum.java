public class BeWolverineSerum implements Serum {

    @Override
    public void push() {
        System.out.println("You will get Logan power. (Serum=" + System.identityHashCode(this) + ")");
    }
}