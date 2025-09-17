// Create a Java program to simulate a banking system that demonstrates exception handling by 
// implementing a custom exception and handling a predefined exception. The program should 
// meet the following requirements: 
// 1. Define a custom exception class named InsufficientBalanceException to handle cases 
// where a withdrawal amount exceeds the available account balance. 
// 2. Implement a method to perform a withdrawal operation, which throws 
// InsufficientBalanceException if the withdrawal amount is greater than the balance. 
// 3. Implement a method to calculate interest, which may throw an ArithmeticException (e.g., 
// due to division by zero in an invalid interest rate scenario). 
// 4. Prompt the user to input the account balance, withdrawal amount, and an interest rate 
// for the calculation. 
// 5. Use try-catch blocks to handle both the custom InsufficientBalanceException and the 
// predefined ArithmeticException, displaying appropriate error messages for each. 
// 6. Ensure the program continues to execute smoothly after handling exceptions, providing 
// clear feedback to the user. 
// The program should handle invalid inputs gracefully and demonstrate robust exception handling 
// for both custom and predefined exceptions. 

import java.util.Scanner;
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Withdrawal failed! Insufficient balance.");
        }
        balance -= amount;
        System.out.println("Withdrawal successful! Remaining Balance: " + balance);
    }

    public double calculateInterest(double rate) {
        return balance * (rate / 100);
    }

    public double getBalance() {
        return balance;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter initial account balance: ");
            double balance = sc.nextDouble();

            BankAccount account = new BankAccount(balance);

            System.out.print("Enter withdrawal amount: ");
            double withdrawAmount = sc.nextDouble();

            try {
                account.withdraw(withdrawAmount);
            } catch (InsufficientBalanceException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("Enter interest rate: ");
            double rate = sc.nextDouble();

            try {

                double interest = account.calculateInterest(rate);
                System.out.println("Calculated Interest: " + interest);
            } catch (ArithmeticException e) {
                System.out.println("Error: Invalid interest rate (Division by zero).");
            }

            System.out.println("Final Account Balance: " + account.getBalance());
            System.out.println("Program executed successfully without crashing!");

        } catch (Exception e) {
            System.out.println("Invalid input! Please enter numeric values only.");
        } finally {
            sc.close();
        }
    }
}
