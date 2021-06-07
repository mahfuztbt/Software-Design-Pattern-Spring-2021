public class SuperhumanSerum implements Serum {

    @Override
    public void push() {
        System.out.println("You will become super human(like superman). (Serum=" + System.identityHashCode(this) + ")");
    }
}