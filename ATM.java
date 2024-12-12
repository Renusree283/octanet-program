import java.util.Scanner;
class Atm{
    Scanner bb=new Scanner(System.in);
    float balance;
    int pin;
     void atms(float balance,int pin){
        this.balance=balance;
        this.pin=pin;
        }
        void withdraw(float amt){
        if(balance < amt){
            System.out.println("\tinsufficient amount");
        }
        else{
            balance-=amt;
        }
       }
       void deposite(float amount){
        balance+=amount;
        System.out.println("\tbalance amt:"+balance);
       }
        void validatepin(int newpin){
        if(pin==newpin){
            System.out.println("\tcorrect pin");
        }
        else{
            System.out.println("\twrong pin");
            System.out.println("\tif you want to change pin say yes or no");
            String ss=bb.nextLine();
            if(ss.equals("yes")){
                changepin();
            }
        }
        }
        float getbalance(){
            return balance;
        }
        int changepin(){
            System.out.print("\tenter pin no:");
            int newpin=bb.nextInt();
            this.pin=newpin;
            System.out.println("\tnew pin no is :"+ pin);
            return pin;
        } 
        public static void main(String args[]){
        Scanner aa=new Scanner(System.in);
        Atm obj=new Atm();
        obj.atms(1000,1234);
        int opt;
        System.out.println("\tATM Machine System");
        do{
        System.out.println("1.check balance");
        System.out.println("2.deposite amount");
        System.out.println("3.withdraw amount");
        System.out.println("4.validate pin");
        System.out.println("5.exit");
        System.out.print("enter the option:");
        opt=aa.nextInt();
        switch(opt){
            case 1:
                System.out.println("\ttotal balance:"+obj.getbalance());
            break;
            case 2:
                System.out.print("\tenter amount :");
                float amount=Float.parseFloat(System.console().readLine());
                obj.deposite(amount);
            break;
            case 3:
                System.out.print("\tenter amount :");
                float amt=Float.parseFloat(System.console().readLine());
                obj.withdraw(amt);
            break;
            case 4:
                System.out.print("\tenter pin:");
                int newpin=aa.nextInt();
                obj.validatepin(newpin);
            break;
            case 5:
                System.out.println("\texit");
            default :
            break;
        }
        } while(opt !=5);
    }
}