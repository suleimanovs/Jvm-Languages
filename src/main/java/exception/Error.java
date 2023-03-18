package exception;

public class Error {

    /**
     * Пытаться ловить error бесполезно. Так как мы не занем в какой момент какой error может быть выброшено.
     * И часто, error выбрасываются из-за device. Ошибки уровня VirtualMachineError ловить никак. Если слетел jvm
     * то программа развалится
     * VirtualMachineError:
     * @see OutOfMemoryError
     * @see StackOverflowError
     * @see java.util.zip.ZipError
     * @see UnknownError
     * @see InternalError
     */
    //StackOverflowError
    void recursive(){
        System.out.println(new Object());
        recursive();
    }

    public static void main(String[] args) {
        var error = new Error();
        error.recursive();
    }
}
