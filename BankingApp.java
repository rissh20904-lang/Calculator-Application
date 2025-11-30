import java.util.Scanner;

public class BankingApp {
    private static final int MAX_ACCOUNTS = 200;
    private Account[] accounts = new Account[MAX_ACCOUNTS];
    private int accountCount = 0;
    private int nextAccountNumber = 1001;
    private Scanner scanner = new Scanner(System.in);

    public void createAccount() {
        if (accountCount >= MAX_ACCOUNTS) {
            System.out.println("Cannot create more accounts. Limit reached.");
            return;
        }
        System.out.print("Enter account holder name: ");
        String name = readNonEmptyLine();

        double initialDeposit = readPositiveDoubleOrZero("Enter initial deposit amount: ");

        String email = readValidEmail("Enter email address: ");
        String phone = readValidPhone("Enter phone number: ");

        Account acc = new Account(nextAccountNumber++, name, initialDeposit, email, phone);
        accounts[accountCount++] = acc;
        System.out.println("Account created successfully with Account Number: " + acc.getAccountNumber());
    }

    public void performDeposit() {
        int accNo = readInt("Enter account number: ");
        Account acc = findAccountByNumber(accNo);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }
        double amount = readPositiveDouble("Enter amount to deposit: ");
        if (acc.deposit(amount)) {
            System.out.println("Deposit successful. Updated details:");
            acc.displayAccountDetails();
        }
    }

    public void performWithdrawal() {
        int accNo = readInt("Enter account number: ");
        Account acc = findAccountByNumber(accNo);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }
        double amount = readPositiveDouble("Enter amount to withdraw: ");
        if (acc.withdraw(amount)) {
            System.out.println("Withdrawal successful. Updated details:");
            acc.displayAccountDetails();
        }
    }

    public void showAccountDetails() {
        int accNo = readInt("Enter account number: ");
        Account acc = findAccountByNumber(accNo);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }
        acc.displayAccountDetails();
    }

    public void updateContact() {
        int accNo = readInt("Enter account number: ");
        Account acc = findAccountByNumber(accNo);
        if (acc == null) {
            System.out.println("Account not found.");
            return;
        }
        String email = readValidEmail("Enter new email address: ");
        String phone = readValidPhone("Enter new phone number: ");
        acc.updateContactDetails(email, phone);
        System.out.println("Contact details updated successfully.");
        acc.displayAccountDetails();
    }

    public void mainMenu() {
        while (true) {
            System.out.println("\nWelcome to the Banking Application!");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    performWithdrawal();
                    break;
                case 4:
                    showAccountDetails();
                    break;
                case 5:
                    updateContact();
                    break;
                case 6:
                    System.out.println("Thank you for using the Banking Application. Bye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose 1-6.");
            }
        }
    }

    private Account findAccountByNumber(int accNo) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accNo) return accounts[i];
        }
        return null;
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int v = Integer.parseInt(scanner.nextLine().trim());
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private String readNonEmptyLine() {
        while (true) {
            String s = scanner.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.print("Input cannot be empty. Please enter again: ");
        }
    }

    private double readPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double v = Double.parseDouble(scanner.nextLine().trim());
                if (v <= 0) {
                    System.out.println("Amount must be positive.");
                } else {
                    return v;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private double readPositiveDoubleOrZero(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double v = Double.parseDouble(scanner.nextLine().trim());
                if (v < 0) {
                    System.out.println("Amount cannot be negative.");
                } else {
                    return v;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private String readValidEmail(String prompt) {
        while (true) {
            System.out.print(prompt);
            String email = scanner.nextLine().trim();
            if (email.isEmpty()) {
                System.out.println("Email cannot be empty.");
                continue;
            }
            if (email.contains("@") && email.contains(".") && email.indexOf('@') < email.lastIndexOf('.')) {
                return email;
            } else {
                System.out.println("Invalid email format. Example: name@example.com");
            }
        }
    }

    private String readValidPhone(String prompt) {
        while (true) {
            System.out.print(prompt);
            String phone = scanner.nextLine().trim();
            String digitsOnly = phone.replaceAll("\\D", "");
            if (digitsOnly.length() < 6 || digitsOnly.length() > 15) {
                System.out.println("Enter a valid phone number (6-15 digits).");
            } else {
                return digitsOnly;
            }
        }
    }

    public static void main(String[] args) {
        BankingApp app = new BankingApp();
        app.mainMenu();
    }
}
