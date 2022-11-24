package exception;

/**
 * Created by Osman on 16:23
 */
public class ExceptionTest {

    /**
     * Throwable:
     * Error
     * Exception
     */
    public static void main(String[] args) {
        someInt();
    }

    static int someInt() {


        try {
            //Выбросить ошибку в ручную можно при помощи ключевого слова throw
            int res = 0 / 12;
            return 13;
        }
        /**
         * Catch блок-ов может быть сколько угодно, но обычно следует указать от child - exception до parent.
         * то есть, сначала нужно ловить конкретную ошибку, а лишь после родительский (класс Exception например)
         */
        catch (NumberFormatException e) {
            System.err.println(e);
            return 12;
        } catch (ArithmeticException e) {
            System.err.println("Found a exception: " + e);
            return 12;
        } finally {
            /**
             * Finally блок выполняется даже в том случае, если в try или catch блоке имеется return statement
             * finally блок не выполнится только в том случае, если вы прекращаете работу программы с помощью System.exit
             * в try или catch блоке, или же, если происходит крушение JVM или например операционной системы.
             * Если return statement имеется в catch блоке и catch блоке finally, то output-ом метода будет возвращаемое
             * значение из finally блока.
             */
            System.out.println("Program is finished");
        }
    }


}
