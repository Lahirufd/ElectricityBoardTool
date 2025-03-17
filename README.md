# ⚡ Electricity Board Management Tool

A comprehensive Java application for managing electricity board customer accounts, bills, and payments using a custom singly linked list data structure.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Data Structures](https://img.shields.io/badge/Data_Structures-4EAA25?style=for-the-badge&logo=java&logoColor=white)
![OOP](https://img.shields.io/badge/OOP-007396?style=for-the-badge&logo=java&logoColor=white)

## 🎓 Project Overview

This is a small project developed as part of a Programming Data Structures and Algorithms module to gain practical knowledge about data structures and algorithms. The application demonstrates the implementation and usage of a singly linked list data structure in a real-world scenario, providing hands-on experience with fundamental programming concepts.

## ✨ Features

The Electricity Board Management Tool provides the following functionality:

- **Account Management**
  - ✅ Create new customer accounts with unique IDs
  - ✅ Display all existing accounts
  - ✅ Search for accounts by ID, name, or address
  - ✅ Edit account details
  - ✅ Delete accounts

- **Billing System**
  - 💰 Add bill amounts to customer accounts
  - 💸 Update paid bill amounts
  - 📊 View complete account history with billing and payment records

## 🛠️ Technologies Used

- **Java**: Core programming language
- **Data Structures**: Custom implementation of singly linked list
- **Object-Oriented Programming**: Follows OOP principles with proper encapsulation and abstraction
- **Command-Line Interface**: User-friendly menu-driven interface

## 🚀 Setup and Installation

Follow these steps to run the project locally:

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/electricity-board-tool.git
   cd electricity-board-tool
   ```

2. **Compile the Java Files**
   ```bash
   javac electricityboardtool2/*.java
   ```

3. **Run the Application**
   ```bash
   java electricityboardtool2.ElectricityBoardTool2
   ```

## 📖 Usage

### Main Menu

When you run the application, you'll see the following menu:

```
🔌 Electricity Board Management Tool 🔌
─────────────────────────────────────────
1. Add an account
2. Display all accounts
3. Search account details
4. Edit account details
5. Add bill amount
6. Update paid bill amounts
7. View account history
8. Delete an account
9. Exit
─────────────────────────────────────────
Enter your choice:
```

### Key Operations

#### Adding an Account
Select option 1 and follow the prompts to enter account ID, name, and address.

#### Searching for an Account
Select option 3 to search by ID, name, or address.

#### Managing Bills
- Option 5: Add a new bill amount
- Option 6: Record a payment
- Option 7: View complete billing history

#### Deleting an Account
Select option 8 and confirm deletion after searching for the account.

## 📁 Project Structure

The project consists of the following Java files:

- **Account.java**: Represents a customer account with ID, name, address, and bill history
- **Node.java**: Defines nodes for the singly linked list
- **SinglyLinkedList.java**: Implements the custom singly linked list data structure
- **ElectricityBoardTool2.java**: Main application class with user interface and operations

## 👥 Contributing

Contributions are welcome! To contribute:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is part of my **PDSA Module coursework** and is open for learning purposes. 

---

<p align="center">
  Developed with ❤️ as part of a Programming Data Structures and Algorithms module
</p>
