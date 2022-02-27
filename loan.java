import java.util.*;
class loan
{
    long account, cred_no;
    String cred_name;
    int cvv;
    double loan;
}
class account extends loan
{
    Scanner sc = new Scanner(System.in);
    long acc_no;
    String name;
    double balance;
    public boolean conditions(String name, long acc_no,double balance,double money)
    {
        this.name = name;
        this.acc_no = acc_no;
        this.balance = balance;
        System.out.println("PRESS '1': for WITHDROW \nPRESS '2': for DEPOSIT \nPRESS '3': for PRINT STATEMENT ");
        int a = sc.nextInt();
        if (a==1 && balance<money || money<500)//minimum withdrawal balance = 500
        
        {
           return false;
        }
        
        else
        {
             switch(a)
            {
                case 1:
                    this.balance = balance-money;
                    break;
                case 2:
                    this.balance = balance+money;
                    break;
                case 3:
                    {
                        System.out.println();
                        System.out.println("***PRINT STATEMENT****");
                        System.out.println("Account Holder Name :"+name);
                        System.out.println("Account Number :"+acc_no);
                        System.out.println("Current Balance :"+balance);
                        break;
                    }
            }
            return true;
        }
    }
    public void details(boolean cond)
    {
        if (cond == true)
        {
            System.out.println();
            System.out.println("***Account Details****");
            System.out.println("Account Holder Name :"+name);
            System.out.println("Account Number :"+acc_no);
            System.out.println("Current Balance :"+balance); 
        }
        else{
            throw new java.lang.Error("INSUFFICIENT FUND");
        }
        
    }
    public void apply_loan(long account,long cred_no,String cred_name,int cvv,double loan)
    {
        this.cred_no = cred_no;
        this.account = account;
        this.cvv = cvv;
        this.cred_name = cred_name;
        this.loan = loan;
    }
    public void apply_loan_details()
    {
        System.out.println();
        System.out.println("***APPLIED LOAN DETAILS****");
        System.out.println("Credit Card Number :"+cred_no);
        System.out.println("Account Number"+account);
        System.out.println("Account Holder Name :"+cred_name);
        System.out.println("Loan applied :"+loan);
    }
}
class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        account obj = new account();
        System.out.println("___Enter Account Details for Withdrawal___");
        System.out.println();
        System.out.println("Enter Account No");
        long acc_no = sc.nextLong();
        System.out.println("Enter Account Holder Name :");
        String name = sc.next();
        System.out.println("Enter Balance :");
        double balance = sc.nextFloat();
        System.out.println("Enter ammount :");
        double amount = sc.nextFloat();
        boolean cond = obj.conditions(name,acc_no,balance,amount);
        obj.details(cond);
        System.out.println();
        System.out.println("___Apply for Loan___");
        System.out.println("Enter Credit Card No :");
        long cred_no = sc.nextLong();
        System.out.println("Enter CVV :");
        int cvv = sc.nextInt();
        System.out.println("Enter Amount required for Loan :");
        double loan = sc.nextFloat();
        obj.apply_loan(acc_no,cred_no,name,cvv,loan);
        obj.apply_loan_details();
    }
}