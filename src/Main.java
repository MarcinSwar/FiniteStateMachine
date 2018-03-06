

import java.util.Scanner;

public class Main {
    public enum State {
        INIT,
        DURING_LOGIN,
        DURING_REGISTRATION,
        LOGGED_IN,
        STOP
    }

   // private static User currentUser = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        State state = State.INIT;

        while(state != State.STOP) {
            switch (state) {
                case INIT: {
                    state = handleInit(scanner);
                    break;
                }

                case DURING_LOGIN: {
                    state = handleDuringLogin(scanner);
                    break;
                }
            }
        }
        System.out.println("koniec");

    }

    private static State handleInit(Scanner scanner) {
        System.out.println("Dzień dobry");
        System.out.println("Co chcesz zrobić?");
        System.out.println("1 - zalogować się");
        System.out.println("2 - zarejestrować się");
        System.out.println("3 - wyjść z programu");

        int answer = scanner.nextInt();
        switch (answer) {
            case 1:
                return State.DURING_LOGIN;
            case 2:
                return State.DURING_REGISTRATION;
            case 3:
                return State.STOP;
            default:
                System.out.println("Podano złą opcję");
                return State.INIT;
        }
    }


    private static State handleDuringLogin(Scanner scanner) {
        System.out.println("Podaj login");
        String username = scanner.nextLine();
        System.out.println("Podaj hasło");
        String password = scanner.nextLine();

        System.out.println("LoggedIn");
        return State.LOGGED_IN;

//        UserService userService = new UserService();
//
//        try {
//            currentUser = userService.login(username, password);
//            return State.LOGGED_IN;
//        } catch (InvalidUserException e) {
//            return State.INIT;
//        }
    }
}