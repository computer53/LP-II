import java.util.Scanner;

public class ChatBot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ChatBot: Hello! Welcome to our Customer Support. How can I assist you today?");
        System.out.println("Type 'help' to see available options or 'exit' to end the chat.");
        
        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine().toLowerCase();
            
            // Exit condition with confirmation
            if (userInput.equals("exit")) {
                System.out.print("ChatBot: Are you sure you want to exit? (yes/no): ");
                String confirmation = scanner.nextLine().toLowerCase();
                if (confirmation.equals("yes")) {
                    System.out.println("ChatBot: Thank you for chatting with us! Have a great day!");
                    break;
                } else {
                    System.out.println("ChatBot: Let's continue. How can I assist you further?");
                }
            }
            // Help menu
            else if (userInput.equals("help")) {
                System.out.println("ChatBot: Here are the things I can assist you with:");
                System.out.println("1. Hours - Get store hours");
                System.out.println("2. Location - Find our store location");
                System.out.println("3. Services - Learn about our services");
                System.out.println("4. Support - Get technical support");
                System.out.println("Type any of the above keywords to get more information.");
            }
            // Responses to user queries
            else if (userInput.equals("hours")) {
                System.out.println("ChatBot: Our store is open from 9 AM to 9 PM, Monday to Saturday, and 10 AM to 6 PM on Sundays.");
            }
            else if (userInput.equals("location")) {
                System.out.println("ChatBot: We are located at 123 Main Street, Downtown City.");
            }
            else if (userInput.equals("services")) {
                System.out.println("ChatBot: We offer the following services: product consultation, repairs, and home delivery.");
            }
            else if (userInput.equals("support")) {
                System.out.println("ChatBot: For technical support, please email us at support@example.com or call us at +123-456-7890.");
            }
            else {
                System.out.println("ChatBot: I'm sorry, I didn't understand that. Type 'help' for assistance.");
            }
        }
        
        scanner.close();
    }
}
