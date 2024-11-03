
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton deposit,back;
    String pinno;
    
    Deposit(String pinno){
        this.pinno=pinno;
        
        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image I2=I1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(I2);
        JLabel image=new JLabel(I3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter the Amount You want to Deposit:");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,16));
        amount.setBounds(170,350,320,25);
        image.add(amount);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(355,480,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back=new JButton("Back");
        back.setBounds(355,510,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }  
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
          String amtdeposit=amount.getText();
          Date date=new Date();
          if(amtdeposit.equals(""))
              JOptionPane.showMessageDialog(null, "Please Enter the Amount you want to Deposit");
          else{
              try{
              Conn conn=new Conn();
              String query="insert into bank values('"+pinno+"','"+date+"','Deposit','"+amtdeposit+"')";
              conn.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Rs"+amtdeposit+" Deposited Successfully");
              setVisible(false);
              new Transactions(pinno).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }  
          }   
        }
        else if(ae.getSource()==back){
           setVisible(false);
           new Transactions(pinno).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Deposit("");
    }
}
