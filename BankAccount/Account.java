package BankAccount;
import java.util.*;

public class Account {
    String accName;
    long accNo;
    float Balance=0.00F;
    ArrayList<String> a1 = new ArrayList<>();
    Account(String a, long b) {
        accName = a;
        accNo = b;
    }
    // public void AccountChecker() throws Exception {

    //         if (a1.contains(accName)) {
    //             throw new Exception();
    //     }
    //     else {
    //         a1.add(accName);
    //         System.out.println(a1);
    //     }
    // }
    public float balance() {
        return Balance;
    }
    public void setbalance(String bal){
        Balance= Float.parseFloat(bal);
    }
    public String getName(){
        return accName;
    }
    public void deposit(float d){
        Balance += d;

    }
    public void withdraw(float w) throws Exception {
        if(Balance>=w){
            Balance -= w;
        }
        else
        {
            throw new Exception();
        }
    }
    }