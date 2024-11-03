package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    JButton login,clear,Signup;
    JTextField cardTextField;
    JPasswordField PINTextField;
    Login()
    {
        setTitle("Rawat Banking");
        setLayout(null);
        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image I2=I1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(I2);
        JLabel lable = new JLabel(I3);
        lable.setBounds(70,10,100,100);
        add(lable);
        
        JLabel text =new JLabel("Welcome to the Bank");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,500,40);
        add(text);
        
        JLabel CardNo =new JLabel("Card No:");
        CardNo.setBounds(120,150,150,30);
        CardNo.setFont(new Font("Raleway",Font.BOLD,28));
        add(CardNo);
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        JLabel PIN =new JLabel("PIN:");
        PIN.setFont(new Font("Raleway",Font.BOLD,28));
        PIN.setBounds(120,220,250,30);
        add(PIN);
        PINTextField=new JPasswordField();
        PINTextField.setBounds(300,220,230,30);
        PINTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(PINTextField);
        
        login=new JButton("Sign In");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.white);
        login.setForeground(Color.black);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("Clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.white);
        clear.setForeground(Color.black);
        clear.addActionListener(this);
        add(clear);
        
        Signup=new JButton("Sign Up");
        Signup.setBounds(300,350,230,30);
        Signup.setBackground(Color.white);
        Signup.setForeground(Color.black);
        Signup.addActionListener(this);
        add(Signup);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true); 
        setLocation(350,200);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
           cardTextField.setText("");
           PINTextField.setText("");
            
        }
        else if(ae.getSource()==login){
            Conn conn=new Conn();
            String cardno=cardTextField.getText();
            String pinno=PINTextField.getText();
            String query="select * from login where cardnumber='"+cardno+"'and pin='"+pinno+"'";
            try{
              ResultSet rs  =conn.s.executeQuery(query);
              if(rs.next()){
                  setVisible(false);
                  new Transactions(pinno).setVisible(true);
              }
              else
                  JOptionPane.showMessageDialog(null,"Incorrect Card number or PIN");
            }catch(Exception e){
             System.out.println(e);
            }
        }
        else if(ae.getSource()==Signup){
            setVisible(false);
            new SignUp1().setVisible(true);
        }
    }
   public static void main(String args[])
   {
    new Login();   
   }
}

