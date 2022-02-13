package otherUsefulThing;

import org.jetbrains.annotations.Nullable;

/**
 * Created by Osman on 12:11 PM
 */
public  class Print {

    static void print(Object obj) {
        System.out.print(obj);
    }

    static void print(int i) {
        System.out.print(i);
    }


    static void print(@Nullable String s) {
        System.out.print(s);
    }


    static void print(double d) {
        System.out.print(d);
    }

    static void print(long l) {
        System.out.print(l);
    }

    static void print(float f) {
        System.out.print(f);
    }

    static void print(char c) {
        System.out.print(c);
    }

    static void print(boolean b) {
        System.out.print(b);
    }


    static void println(Object obj) {
        System.out.println(obj);
    }

    static void println(int i) {
        System.out.println(i);
    }

    @Nullable
    static void println(String s) {
        System.out.println(s);
    }

    static void println(double d) {
        System.out.println(d);
    }

    static void println(long l) {
        System.out.println(l);
    }

    static void println(float f) {
        System.out.println(f);
    }

    static void println(char c) {
        System.out.println(c);
    }

    static void println(boolean b) {
        System.out.println(b);
    }

    static void println() {
        System.out.println();
    }

}
