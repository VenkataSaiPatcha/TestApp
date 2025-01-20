package AtmProject;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account {
    Scanner sc = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();

    /* Validate Login information: customer number and pin number */
    public void getLogin() {
        int x = 1; // Control variable for retry logic

        do {
            try {
                data.put(98485858, 4321);
                data.put(91216005, 9121);

                System.out.println("Welcome to the ATM Project!");
                System.out.println("Enter your Customer Number:");
                setCustomerNumber(sc.nextInt());

                System.out.println("Enter your PIN Number:");
                setPinNumber(sc.nextInt());

                for (Entry<Integer, Integer> entry : data.entrySet()) {
                    if (entry.getKey().equals(getCustomerNumber()) && entry.getValue().equals(getPinNumber())) {
                        getAccountType();
                        return;
                    }
                }
                System.out.println("\nWrong Customer Number or PIN Number\n");
            } catch (Exception e) {
                System.out.println("\nInvalid character(s). Only numbers are allowed.\n");
                sc.nextLine(); // Clear invalid input
                x = 2;
            }
        } while (x == 1);
    }

    /* Display Account Type Menu with selection */
    public void getAccountType() {
        System.out.println("Select the Account you want to access:");
        System.out.println("Type 1 - Checking Account");
        System.out.println("Type 2 - Saving Account");
        System.out.println("Type 3 - Exit");
        System.out.println("Choice:");

        int selection = sc.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank you for using this ATM!");
                break;

            default:
                System.out.println("\nInvalid choice\n");
                getAccountType();
        }
    }

    /* Display Checking Account Menu with selection */
    public void getChecking() {
        System.out.println("Checking Account:");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice:");

        int selection = sc.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using this ATM!");
                break;

            default:
                System.out.println("\nInvalid choice.\n");
                getChecking();
        }
    }

    /* Display Saving Account Menu with selection */
    public void getSaving() {
        System.out.println("Saving Account:");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdraw Funds");
        System.out.println("Type 3 - Deposit Funds");
        System.out.println("Type 4 - Exit");
        System.out.println("Choice:");

        int selection = sc.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using this ATM!");
                break;

            default:
                System.out.println("\nInvalid choice.\n");
                getSaving();
        }
    }
}











