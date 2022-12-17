package classes;


import java.io.Serializable;


final class SomeKClass2 {

    public static final class Inner implements Serializable {

        public static final SomeKClass2.Inner INSTANCE;

        public final void todo() {
            System.out.println();
        }

        private Inner() {}

        static {
            INSTANCE = new SomeKClass2.Inner();
        }
    }


    public static final class Empty {

        public static final SomeKClass2.Empty INSTANCE;

        private Empty() {}

        static {
            INSTANCE = new SomeKClass2.Empty();
        }
    }
}

final class TestKt {
    public static final void main() {
        SomeKClass2.Empty var10000 = SomeKClass2.Empty.INSTANCE;
    }

    // $FF: synthetic method
    public static void main(String[] var0) {
    }
}




