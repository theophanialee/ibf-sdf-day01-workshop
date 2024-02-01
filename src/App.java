import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//1. compiling
//javac --source-path src -d bin src /*

// 2. running the compiled classes
// java -cp bin App

//3, packing to jar
//jar -c -v -f day01.jar -e App . (Do inside bin folder)

//4. run the jar package

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to your shopping cart");

        List<String> cartItems = new ArrayList<>();
        Console cons = System.console();
        String input = "";
       

        while(!input.equals("quit")) {

            input = cons.readLine(">");
            input = input.toLowerCase();

            if (input.equals("list")) {

                if (cartItems.size() > 0 ) {
                    for (int i=0; i < cartItems.size(); i++) {
                        // System.out.println(i+1 + cartItems.get(i));
                        System.out.printf("%d. %s\n", (i+1), cartItems.get(i));
                    } 
                } else {
                    System.out.println("Your cart is empty");
                }
            }

            if(input.startsWith("add")) {

                input = input.replace(',',' ');
                
                Scanner scan = new Scanner(input.substring(4));
                String stringVal = "";
                while(scan.hasNext()) {
                    stringVal = scan.next();
                    cartItems.add(stringVal);
                }
            }

            if(input.startsWith("delete")) {
                Scanner scan = new Scanner(input.substring(7));
                String stringVal ="";
                
               while (scan.hasNext()) {
                stringVal = scan.next();

                int cartPosition = Integer.parseInt(stringVal);
                cartPosition = cartPosition - 1;

                if (cartPosition < cartItems.size()) {
                    //delete the item from cart
                    cartItems.remove(cartPosition);
                } else {
                    System.out.println("Incorrect item index");
                }
            }
        }

        // System.out.println("Bye! Bye! See you again...");
    }
}}
