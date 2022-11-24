package otherUsefulThing;


public class Finalize {

    public static void main(String[] args) {
        Finalize finalize;
        for (int i = 0; i < 5000; i++) {
            System.gc();
            finalize= new Finalize();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this+" - умирает...");
    }
}
