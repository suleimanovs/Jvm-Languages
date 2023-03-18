package exception;

import java.util.Scanner;

public class CustomException {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Придумайте порол: ");
        try {
            createPassword(scanner.nextLine());
        } catch (TooLargePasswordException e) {
            System.out.println(e.getMessage());
        } catch (TooShortPasswordException e) {
            e.printStackTrace();
        } catch (PasswordException e) {
            e.printStackTrace();
        }

    }


    static void createPassword(String password) throws PasswordException {
        if (password.length() < 6) {
            throw new TooShortPasswordException();
        }
        if (password.length() > 12) {
            throw new TooLargePasswordException();
        }
    }

    static class PasswordException extends Exception {
        public PasswordException() {
            super();
        }

        public PasswordException(String message) {
            super(message);
        }
    }

    static class TooShortPasswordException extends PasswordException {

        TooShortPasswordException(String message) {
            super(message);
        }

        TooShortPasswordException() {
            super();
        }

    }

    static class TooLargePasswordException extends PasswordException {

        TooLargePasswordException(String message) {
            super(message);
        }

        TooLargePasswordException() {
            super();
        }

    }


}

