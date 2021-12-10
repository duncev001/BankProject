import java.util.Scanner;
public class BankAccount {
    private static String accountName;
    private static String password;
    private static double money;

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        BankAccount[] accounts = new BankAccount[100];
        accounts[0] = new BankAccount("nameOfAccount", "password", 100);
        
        System.out.println("enter \\help for all commands and \\exit to end the program");
        while(true){
            int numOfAccounts = 0;
            String response = input.nextLine();

            int dummy = 0;
            int words = 0;
            String firstString = "";
            String secondString = "";
            String thirdString = "";
            String fourthString = "";

            for(int i = 0; i<response.length(); i++){
                if(response.substring(i, i+1).equals(" ") || i==response.length()-1){
                    if(i==response.length()-1){
                        i++;
                    }
                    if(dummy==0){
                        firstString = response.substring(0, i);
                        dummy = i+1;
                        words++;
                    }
                    else if(words==1){
                        secondString = response.substring(dummy, i);
                        dummy = i+1;
                        words++;
                    }
                    else if(words==2){
                        thirdString = response.substring(dummy, i);
                        dummy = i+1;
                        words++;
                    }
                    else if(words==3){
                        fourthString = response.substring(dummy, i);
                        dummy = i+1;
                        words++;
                    }
                }
            }

            if(response.equals("\\help")){
                System.out.println("\\exit");
                System.out.println("\\makeAccount nameOfAccount password amount");
                System.out.println("\\deposit nameOfAccount password amount");
                System.out.println("\\withdrawal nameOfAccount password amount");
                System.out.println("\\changePassword nameOfAccount oldPassword newPassword");
                System.out.println("\\accrueInterest nameOfAccount password rate");
                System.out.println("\\returnAccountAmount nameOfAccount password");
            }
            else if(response.equals("\\exit")){
                break;
            }
            else if(words>4){
                System.out.println("invalid command");
            }
            else if(firstString.equals("\\makeAccount")){
                accounts[numOfAccounts] = new BankAccount(secondString, thirdString, Double.valueOf(fourthString));
                System.out.println("account creation successfull");
                numOfAccounts++;
            }
            else if(firstString.equals("\\deposit")){
                boolean success = false;
                for(int i = 0; i<accounts.length; i++){
                    if(accounts[i].printName().equals(secondString)){
                        if(accounts[i].printPassword().equals(thirdString)){
                            accounts[i].deposit(Double.valueOf(fourthString));
                            System.out.println("deposit successfull");
                            success = true;
                            break;
                        }
                    }
                }
                if(!success){
                    System.out.println("deposit unsuccessfull");
                }
            }
            else if(firstString.equals("\\withdrawal")){
                boolean success = false;
                for(int i = 0; i<accounts.length; i++){
                    if(accounts[i].printName().equals(secondString)){
                        if(accounts[i].printPassword().equals(thirdString)){
                            accounts[i].withdrawal(Double.valueOf(fourthString));
                            System.out.println("withdrawal successfull");
                            success = true;
                            break;
                        }
                    }
                }
                if(!success){
                    System.out.println("withdrawal unsuccessfull");
                }
            }
            else if(firstString.equals("\\changePassword")){
                boolean success = false;
                for(int i = 0; i<accounts.length; i++){
                    if(accounts[i].printName().equals(secondString)){
                        if(accounts[i].printPassword().equals(thirdString)){
                            accounts[i].changePassword(fourthString);
                            System.out.println("Password change successfull");
                            success = true;
                            break;
                        }
                    }
                }
                if(!success){
                    System.out.println("Password change unsuccessfull");
                }
            }
            else if(firstString.equals("\\accrueInterest")){
                boolean success = false;
                for(int i = 0; i<accounts.length; i++){
                    if(accounts[i].printName().equals(secondString)){
                        if(accounts[i].printPassword().equals(thirdString)){
                            accounts[i].accrueInterest(Double.valueOf(fourthString));
                            System.out.println("Interest successfull");
                            success = true;
                            break;
                        }
                    }
                }
                if(!success){
                    System.out.println("Interest unsuccessfull");
                }
            }
            else if(firstString.equals("\\returnAccountAmount")){
                boolean success = false;
                for(int i = 0; i<accounts.length; i++){
                    if(accounts[i].printName().equals(secondString)){
                        if(accounts[i].printPassword().equals(thirdString)){
                            System.out.println("$" + accounts[i].printTotal());
                            success = true;
                            break;
                        }
                    }
                }
                if(!success){
                    System.out.println("Unsuccessfull in finding account");
                }
            }
            else{
                System.out.println("invalid response");
            }
        }
    }

    public BankAccount(String x, String y, double z){
        accountName = x;
        password = y;
        money = z;
    }

    public static void deposit(double amount){
        money += amount;
    }

    public static void withdrawal(double amount){
        money -= amount;
    }

    public static double printTotal(){
        return money;
    }

    public static String printName(){
        return accountName;
    }

    public static String printPassword(){
        return password;
    }

    public static void changePassword(String newPassword){
        password = newPassword;
    }

    public static void accrueInterest(double rate){
        money = (1+rate) * money;
    }
}
