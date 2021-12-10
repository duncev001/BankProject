public class BankAccount{
    String name;
    double balance;
    static double fee = 0.0;

    public BankAccount(){
        name="";
        balance=0;
    }

    public BankAccount(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void withdraw(double amount){
        if(balance - fee - amount < 0){
        }else{
            balance = balance - fee - amount;
        }
    }

    public String accountToString(){
        return name + ", $" + balance;
    }
}

