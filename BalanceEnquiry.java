package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinno;
    BalanceEnquiry(String pinno){
        this.pinno=pinno;
        setLayout(null);
        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image I2=I1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(I2);
        JLabel image=new JLabel(I3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        Conn conn=new Conn();
        int balance=0;
        try{
            ResultSet rs=conn.s.executeQuery("select * from bank where pin='"+pinno+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                 balance+=Integer.parseInt(rs.getString("amount")); 
                }
                else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        JLabel text=new JLabel("Your Current Account Balance is ₹ "+balance);
        text.setForeground(Color.white);
        text.setBounds(170,300,400,30);
        image.add(text);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(pinno).setVisible(true);
    }
public static void main(String args[]){
  new BalanceEnquiry("");   
}    
}
