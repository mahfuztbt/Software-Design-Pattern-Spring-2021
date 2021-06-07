public class SuperSoldierCapSerum implements Serum {

    @Override
    public void push() {
        System.out.println("using this you will be powerful like (captain america). (Serum=" + System.identityHashCode(this) + ")");
    }
}