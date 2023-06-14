package atmMachine;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
        OperationInterface op=new OperationImpl();
        
        System.out.println("*******************************************");
        System.out.println("                 DBS BANK                  ");
        System.out.println("*******************************************");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
      
        Map<String, String> users = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("user.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String storedUsername = parts[0];
                    String storedPassword = parts[1];
                    users.put(storedUsername, storedPassword);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading login file: " + e.getMessage());
            return;
        }
        System.out.println("	");
        System.out.println("*******************************************");
        System.out.println("            Welcome to the ATM");
        System.out.println("*******************************************");
        if (users.containsKey(username) && users.get(username).equals(password)){
            while(true){
            	System.out.println("+------------------------------------------+");
                System.out.println("|(1) View Available Balance                |\n|(2) Withdraw Amount                       |\n|(3) Deposit Amount                        |");
                System.out.println("|(4) View Ministatement                    |\n|(5) Exit                                  |");
				System.out.println("+------------------------------------------+");
                System.out.println("Enter Choice : ");
                Scanner in = new Scanner(System.in);
				int ch=in.nextInt();
                if(ch==1){
                    op.viewBalance();

                }
                else if(ch==2){
                    System.out.println("Enter amount to withdraw ");
                    double withdrawAmount=in.nextDouble();
                    op.withdrawAmount(withdrawAmount);

                }
                else if(ch==3){
                    System.out.println("Enter Amount to Deposit :");
                    double depositAmount=in.nextDouble();
                    if(depositAmount>0) {
                    op.depositAmount(depositAmount);}
                    else {
                    	System.out.println("Enter Amount greater than zero");
                    }


                }
                else if(ch==4){
                    op.viewMiniStatement();

                }
                else if(ch==5){
                    System.out.println("Collect cash \nThank you for using ATM Machine!!");
                    System.exit(0);
                }
                else
                {
                    System.out.println("Please enter correct choice");
                }
            }
        }
        else{
            System.out.println("Incorrect Atm Number or pin");
            System.exit(0);
        }


    }

}
