package electricityboardtool2;

import java.util.Scanner;

class Node<DataType> {
    DataType data;
    Node<DataType> next;

    Node(DataType data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList<AccountType> {
    private Node<AccountType> head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void add(AccountType data) {
        Node<AccountType> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<AccountType> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean remove(AccountType data) {
        if (head == null) return false;

        if (head.data.equals(data)) {
            head = head.next;
            return true;
        }

        Node<AccountType> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }

        return false;
    }

//    public Node<AccountType> search(AccountType data) {
//        Node<AccountType> current = head;
//        while (current != null) {
//            if (current.data.equals(data)) {
//                return current;
//            }
//            current = current.next;
//        }
//        return null;
//    }

    public void printList() {
        Node<AccountType> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }
    
    public Node<AccountType> returnHead() {
        return head;
    }
}

public class ElectricityBoardTool2 {
    private static SinglyLinkedList<Account> accounts = new SinglyLinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Electricity Board Management Tool");
            System.out.println("1. Add an account");
            System.out.println("2. Display all accounts");
            System.out.println("3. Search account details");
            System.out.println("4. Edit account details");
            System.out.println("5. Add bill amount");
            System.out.println("6. Update paid bill amounts");
            System.out.println("7. View account history");
            System.out.println("8. Delete an account");
            System.out.println("9. Exit");
            System.out.print("Please choose an option (1-9): ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("You chose to add an account.");
                    addAccount(scanner);
                    break;
                case 2:
                    System.out.println("You chose to display all accounts.");
                    displayAllAccounts();
                    break;
                case 3:
                    System.out.println("You chose to search account details.");
                    searchAccount(scanner);
                    break;
                case 4:
                    System.out.println("You chose to edit account details.");
                    editAccountDetails(scanner);
                    break;
                case 5:
                    System.out.println("You chose to add bill amount.");
                    addBillAmount(scanner);
                    break;
                case 6:
                    System.out.println("You chose to update paid bill amounts.");
                    updatePaidBillAmount(scanner);
                    break;
                case 7:
                    System.out.println("You chose to view account history.");
                    viewAccountHistory(scanner);
                    break;
                case 8:
                    System.out.println("You chose to delete an account.");
                    removeAccount(scanner);
                    break;
                case 9:
                    System.out.println("Exiting the tool. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println(); // For a blank line between operations
        } while (choice != 9);

        scanner.close();
    }

    private static void addAccount(Scanner scanner) {
        System.out.print("Enter Account ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Enter Account Holder's Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Account Holder's Address: ");
        String address = scanner.nextLine();

        Account newAccount = new Account(id, name, address);
        accounts.add(newAccount);

        System.out.println("Account added successfully.");
    }

    private static void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            accounts.printList();
        }
    }

    private static void searchAccount(Scanner scanner) {
        System.out.println("Search Account Details");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Address");
        System.out.print("Choose a search option (1-3): ");
        
        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        switch (searchChoice) {
            case 1:
                searchById(scanner);
                break;
            case 2:
                searchByName(scanner);
                break;
            case 3:
                searchByAddress(scanner);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    private static Account searchById(Scanner scanner) {
        System.out.print("Enter Account ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Node<Account> current = accounts.returnHead();
        while (current != null) {
            if (current.data.getId() == id) {
                System.out.println("Account found: " + current.data);
                return current.data;
            }
            current = current.next;
        }

        System.out.println("No account found with ID: " + id);
        return null;
    }


    private static Account searchByName(Scanner scanner) {
        System.out.print("Enter Account Holder's Name: ");
        String name = scanner.nextLine();

        Node<Account> current = accounts.returnHead();
        while (current != null) {
            if (current.data.getName().equalsIgnoreCase(name)) {
                System.out.println("Account found: " + current.data);
                return current.data;
            }
            current = current.next;
        }

        System.out.println("No account found with Name: " + name);
        return null;
    }
    
        private static Account searchByAddress(Scanner scanner) {
        System.out.print("Enter Account Holder's Address: ");
        String address = scanner.nextLine();

        Node<Account> current = accounts.returnHead();
        while (current != null) {
            if (current.data.getAddress().equalsIgnoreCase(address)) {
                System.out.println("Account found: " + current.data);
                return current.data;
            }
            current = current.next;
        }

        System.out.println("No account found with Address: " + address);
        return null;
    }

    private static void editAccountDetails(Scanner scanner) {
        System.out.println("Edit Account Details");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Address");
        System.out.print("Choose a search option (1-3): ");
        
        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        Account accountToEdit = null;
        
        switch (searchChoice) {
            case 1:
                accountToEdit = searchById(scanner);
                break;
            case 2:
                accountToEdit = searchByName(scanner);
                break;
            case 3:
                accountToEdit = searchByAddress(scanner);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
                return;
        }
        
        if (accountToEdit != null) {
            //System.out.println("Account found: " + accountToEdit);
            System.out.println("Edit Options:");
            System.out.println("1. Edit ID");
            System.out.println("2. Edit Name");
            System.out.println("3. Edit Address");
            System.out.print("Choose an option (1-3): ");

            int editChoice = scanner.nextInt();
            scanner.nextLine();

            switch (editChoice) {
                case 1:
                    System.out.print("Enter new ID: ");
                    int newId = scanner.nextInt();
                    scanner.nextLine();
                    accountToEdit.setId(newId);
                    break;
                case 2:
                    System.out.print("Enter new Name: ");
                    String newName = scanner.nextLine();
                    accountToEdit.setName(newName);
                    break;
                case 3:
                    System.out.print("Enter new Address: ");
                    String newAddress = scanner.nextLine();
                    accountToEdit.setAddress(newAddress);
                    break;
                default:
                    System.out.println("Invalid choice. No changes made.");
            }
            System.out.println("Account details updated successfully.");
        } else {
            System.out.println("No account found. Returning to main menu.");
        }
    }
    
    private static void addBillAmount(Scanner scanner) {
        System.out.println("Add Bill Amount");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Address");
        System.out.print("Choose a search option (1-3): ");

        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        Account account = null;

        switch (searchChoice) {
            case 1:
                account = searchById(scanner);
                break;
            case 2:
                account = searchByName(scanner);
                break;
            case 3:
                account = searchByAddress(scanner);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
                return;
        }

        if (account != null) {
            System.out.print("Enter the bill amount: Rs.");
            double billAmount = scanner.nextDouble();
            scanner.nextLine();

            account.addBill(billAmount);
            System.out.println("Bill amount added successfully.");
        } else {
            System.out.println("No account found. Returning to main menu.");
        }
    }
    
    private static void updatePaidBillAmount(Scanner scanner) {
        System.out.println("Update Paid Bill Amount");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Address");
        System.out.print("Choose a search option (1-3): ");

        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        Account account = null;

        switch (searchChoice) {
            case 1:
                account = searchById(scanner);
                break;
            case 2:
                account = searchByName(scanner);
                break;
            case 3:
                account = searchByAddress(scanner);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
                return;
        }

        if (account != null) {
            System.out.print("Enter the paid amount: ");
            double paidAmount = scanner.nextDouble();
            scanner.nextLine();

            account.addPaidAmount(paidAmount);
            System.out.println("Paid amount recorded successfully.");
        } else {
            System.out.println("No account found. Returning to main menu.");
        }
    }
    
    private static void viewAccountHistory(Scanner scanner) {
        System.out.println("View Account History");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Address");
        System.out.print("Choose a search option (1-3): ");

        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        Account account = null;

        switch (searchChoice) {
            case 1:
                account = searchById(scanner);
                break;
            case 2:
                account = searchByName(scanner);
                break;
            case 3:
                account = searchByAddress(scanner);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
                return;
        }

        if (account != null) {
            //System.out.println("Account found: " + account);
            System.out.println("Bill History");

            SinglyLinkedList<Double> billHistory = account.getBillHistory();
            Node<Double> current = billHistory.returnHead();

            if (current == null) {
                System.out.println("No bill history available.");
            } else {
                while (current != null) {
                    if (current.data > 0) {
                        System.out.println("Should Pay: Rs." + current.data);
                    } else {
                        System.out.println("Paid Amount: Rs." + (-current.data));
                    }
                    current = current.next;
                }
            }
        } else {
            System.out.println("No account found. Returning to main menu.");
        }
    }
    
    private static void removeAccount(Scanner scanner) {
        System.out.println("Remove Account");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.println("3. Search by Address");
        System.out.print("Choose a search option (1-3): ");

        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        Account accountToRemove = null;

        switch (searchChoice) {
            case 1:
                accountToRemove = searchById(scanner);
                break;
            case 2:
                accountToRemove = searchByName(scanner);
                break;
            case 3:
                accountToRemove = searchByAddress(scanner);
                break;
            default:
                System.out.println("Invalid choice. Returning to main menu.");
                return;
        }

        if (accountToRemove != null) {
            //System.out.println("Account found: " + accountToRemove);
            System.out.print("Are you sure you want to remove this account? (yes/no): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                boolean removed = accounts.remove(accountToRemove);
                if (removed) {
                    System.out.println("Account removed successfully.");
                } else {
                    System.out.println("Failed to remove the account.");
                }
            } else {
                System.out.println("Account removal canceled.");
            }
        } else {
            System.out.println("No account found. Returning to main menu.");
        }
    }
}

