public class BecomeHulkSerum implements Serum {

    @Override
    public void push() {
        System.out.println("You will be Hulk and get his power. (Serum=" + System.identityHashCode(this) + ")");
    }
}