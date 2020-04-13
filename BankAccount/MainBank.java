package BankAccount;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;
import java.lang.Object;
class MainBank extends JFrame{
    private static final long serialVersionUID = 1L;
    Map<String, Float> a1 = new HashMap<>();
  JFrame f ;
  String accName;
    MainBank() {
         f= new JFrame("Bank Management System");
         JLabel l =new JLabel("WELCOME TO SIS BANK");
        l.setBounds(10,10,500,80);
        l.setFont(new Font("Serif", Font.BOLD, 37));
        JButton b1 = new JButton("Create Account");
        b1.setBounds(30, 170, 130, 50);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Button1(evt);
            }
       });
        JButton b2 = new JButton("Login Account");
        b2.setBounds(180, 170, 130, 50);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Button2(evt);
            }
       });
        JButton b3 =new JButton("Current Balance");
        b3.setBounds(330, 170,130, 50);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Button3(evt);
            }
       });
        JButton b4 =new JButton("Deposit Ammount");
        b4.setBounds(30, 260, 130, 50);
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Button4(evt);
            }
       });
        JButton b5 =new JButton("Withdraw Ammount");
        b5.setBounds(180, 260, 130, 50);
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Button5(evt);
            }
       });
        JButton b6 =new JButton("Exit");
        b6.setBounds(330, 260,130, 50);
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Button6(evt);
            }
       });
       JButton b7=new JButton("About");
       b7.setBounds(355,410, 130,50);
       b7.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            Button7(evt);
        }
   });
        f.add(l);f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(b5);f.add(b6);f.add(b7);
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);
    }
    public static Account a;
    public void Button1(ActionEvent e){
        accName = JOptionPane.showInputDialog(f,"Enter Your Account Name");
        long accNo=10012;
         a=new Account(accName,accNo);
        try{
            if (a1.containsKey(accName)) {
                throw new Exception();
        }
        else {
            float b = a.balance();
            a1.put(accName,b);
            System.out.println(a1);
        }
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(f,"Account Already Exist");
        }
    }
    public void Button2(ActionEvent e){
        String arr = JOptionPane.showInputDialog(f,"Enter Your Account Name for login");
        try{
        if(a1.containsKey(arr)) {
        Object bal = a1.get(arr);
        //System.out.println(bal);
         a.setbalance(bal.toString());
       // float b=(float)bal;
        }
        else
        throw new Exception();}
        catch(Exception e1){
            JOptionPane.showMessageDialog(f,"Do not have any accout of "+arr);
        }
    }
    public void Button3(ActionEvent e){
        try{
        float bal=a.balance();
        JOptionPane.showMessageDialog(f,a.getName()+" your Current Balance is "+bal+"Rs");
        }
        catch(Exception e1){
            JOptionPane.showMessageDialog(f,"Firstly login to thier account");
        }
    }
    public void Button4(ActionEvent e){
        try{
        String deposit=JOptionPane.showInputDialog(f,"Enter amount to be Deposit");
        a.deposit(Float.parseFloat(deposit));
        a1.put(accName,a.balance());
        JOptionPane.showMessageDialog(f,"Successfully Deposit");}
        catch(Exception ex){}
    }
    public void Button5(ActionEvent e1){
        try{
        String w=JOptionPane.showInputDialog(f,"Enter amount to be Withdraw");
        a.withdraw(Float.parseFloat(w));
        a1.put(accName,a.balance());
        JOptionPane.showMessageDialog(f,"Successfully Withdraw");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(f,"Do not have enough Balance","Alert",JOptionPane.WARNING_MESSAGE);
        }
    }
    public void Button6(ActionEvent e) {
        System.exit(0);
    }
    public void Button7(ActionEvent e){
        JOptionPane.showMessageDialog(f,"Designed By:-\nMadhav Kharbanda");
    }
    public static void main(String[] args) {
       new MainBank();
       
    }
}