package otherUsefulThing;

public class InitializersBlock {

    native void call();

    public InitializersBlock() {
        System.out.println("constructor");
    }

    /**
     * Есть два типа два блоков инициализаций:
     *
     * 1. Initializer block - срабатывает каждый раз, когда создается новый объект соответствующего класса. Они вызываются
     * в том порядке в котором расположены. Они вызываются до конструктора.
     *
     * 2. Static initializer block - срабатывает один раз, когда класс загружается в память.
     * Он вызывается до Initializer block - ов
     */



    {
        System.out.println("Initializer block");
    }

    static {
        System.out.println("Static Initializer block");
    }

    public static void main(String[] args) {
        InitializersBlock initializersBlock = new InitializersBlock();
    }
}
