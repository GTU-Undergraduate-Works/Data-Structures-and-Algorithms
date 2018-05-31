import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class to test Hotel Managament System classes
 *
 * @author Efkan Durakli
 */
public class Main {




    private static Scanner input = new Scanner(System.in);

    public static void main(String [] args) {

        System.out.println("******************************************");
        System.out.println("*   WELCOME TO HOTEL MANAGAMENT SYSTEM   *");
        System.out.println("******************************************");

        ManagamentSystem system = new ManagamentSystem();
        printIntroMenu();
        try {
            int number;
            boolean flag = false;
            //Scanner input = new Scanner(System.in);
            while (!flag) {
                number = Integer.parseInt(input.nextLine());
                switch (number) {
                    case 1:
                        TestForRegisterNewUser(system);
                        printIntroMenu();
                        flag = false;
                        break;
                    case 2:
                        TestForLogIn(system, UserType.GUEST);
                        printIntroMenu();
                        break;
                    case 3:
                        TestForLogIn(system, UserType.RECEPTIONIST);
                        printIntroMenu();
                        break;
                    case 4:
                        flag = true;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        System.out.print("Choose again: ");
                        break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Input is not a number");
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * prints introduction menu of Hotel Managamanet System
     */
    private static void printIntroMenu() {
        System.out.println("-----------------MENU---------------------");
        System.out.println("1. Register for New Guest");
        System.out.println("2. Login as a guest");
        System.out.println("3. Login as a recepionist");
        System.out.println("4. Exit");
        System.out.println("Choose one from Menu: ");
        return;
    }

    /**
     * test method to test registerTosystem method of HotelGuest
     * @param system ManagamentSystem object to register
     */
    private static void TestForRegisterNewUser(ManagamentSystem system) {
        System.out.println("Enter User Name: ");
        String username = input.nextLine();
        System.out.println("Enter password: ");
        String password = input.nextLine();
        HotelGuest guest = new HotelGuest(username,password);
        guest.registerToSystem(system);
        return;
    }

    /**
     * test method to test logIn method
     * @param system ManagamanentSystem object to log-in
     * @param userType type of user to login
     */
    private static void TestForLogIn(ManagamentSystem system, UserType userType) {

        System.out.println("Enter User Name: ");
        String username = input.nextLine();
        System.out.println("Enter password: ");
        String password = input.nextLine();

        try {

            if (userType == UserType.GUEST) {
                HotelGuest guest = new HotelGuest(username, password);
                guest.setReservedRoomNumbers(system);
                if (guest.logInToSystem(system)) {
                    int number;
                    printGuestMenu();
                    boolean flag = false;
                    while (!flag) {
                        number = Integer.parseInt(input.nextLine());
                        switch (number) {

                            case 1:
                                system.printHotelRooms();
                                System.out.println("Choose room number: ");
                                int roomNumber = Integer.parseInt(input.nextLine());
                                guest.bookRoom(system, roomNumber, null);
                                printGuestMenu();
                                break;
                            case 2:
                                if (system.printReservations(guest)) {
                                    System.out.println("Enter room number to cancel reservation: ");
                                    guest.cancelReservation(system, Integer.parseInt(input.nextLine()));
                                }
                                printGuestMenu();
                                break;
                            case 3:
                                if (guest.logOutFromSystem(system))
                                    System.out.println("You logged out from system sucessfully.");
                                flag = true;
                                break;
                            default:
                                System.out.println("Invalid choice!");
                                break;
                        }
                    }

                }

            }
            else if (userType == UserType.RECEPTIONIST) {

                Receptionist receptionist = new Receptionist(username, password);
                if (receptionist.logInToSystem(system)) {
                    int number;
                    printRecepcionistMenu();
                    boolean flag = false;
                    while (!flag) {
                        number = Integer.parseInt(input.nextLine());
                        int roomNumber = 0;
                        String guestName = null;
                        switch (number) {
                            case 1:
                                system.printHotelRooms();
                                System.out.println("Enter Room number to book Room: ");
                                roomNumber = Integer.parseInt(input.nextLine());
                                System.out.println("Enter Guest Name to book Room: ");
                                guestName = input.nextLine();
                                receptionist.bookRoom(system, roomNumber, guestName);
                                printRecepcionistMenu();
                                break;
                            case 2:
                                system.printHotelRooms();
                                System.out.println("Enter room number to cancel reservation: ");
                                receptionist.cancelReservation(system, Integer.parseInt(input.nextLine()));
                                printRecepcionistMenu();
                                break;
                            case 3:
                                system.printHotelRooms();
                                System.out.println("Enter Room number to chek in: ");
                                roomNumber = Integer.parseInt(input.nextLine());
                                System.out.println("Enter Guest Name to chek in: ");
                                guestName = input.nextLine();
                                receptionist.chekIn(system, roomNumber, guestName);
                                printRecepcionistMenu();
                                break;
                            case 4:
                                system.printHotelRooms();
                                System.out.println("Enter Room number to chek out: ");
                                roomNumber = Integer.parseInt(input.nextLine());
                                receptionist.checkOut(system, roomNumber);
                                printRecepcionistMenu();
                                break;
                            case 5:
                                if (receptionist.logOutFromSystem(system)) {
                                    System.out.println("You logged out from system sucessfully.");
                                }
                                flag = true;
                                break;
                        }
                    }

                }

            }
        } catch (NumberFormatException e) {
            System.out.println("Input is not a number");
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * prints guest menu on screen
     */
    private static void printGuestMenu() {
        System.out.println("---- GUEST MENU ----");
        System.out.println("1. Book a Room.");
        System.out.println("2. Cancel Reservation.");
        System.out.println("3. Logout");
        System.out.println("Choose one from Menu: ");
    }

    /**
     * prints receptionist menu on screen
     */
    private static void printRecepcionistMenu() {
        System.out.println("---- RECEPCIONIST MENU ----");
        System.out.println("1. Book a Room.");
        System.out.println("2. Cancel Reservation.");
        System.out.println("3. Chek-in");
        System.out.println("4. Check-out");
        System.out.println("5. Logout");
        System.out.println("Choose one from Menu: ");
    }
}
