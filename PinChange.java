package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pin,repin;
    JButton change,back;
    String pinno;
    PinChange(String pinno){
        this.pinno=pinno;
        setLayout(null);
        ImageIcon I1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image I2=I1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon I3=new ImageIcon(I2);
        JLabel image=new JLabel(I3);
        image.setBounds(0,0,900,900);
        add(image); 
        
        JLabel text=new JLabel("Change Your Pin");
        text.setBounds(250,280,500,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
           
        JLabel pintext=new JLabel("New Pin:");
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(165,320,180,25);
        image.add(pintext);
        
        pin=new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,16));
        pin.setBounds(330,320,180,25);
        image.add(pin);
              
        JLabel repintext=new JLabel("Confirm Pin:");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,360,180,25);
        image.add(repintext);
        
        repin=new JPasswordField();
        repin.setFont(new Font("Raleway",Font.BOLD,16));
        repin.setBounds(330,360,180,25);
        image.add(repin);
                        
        change=new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);  
        
        
        setUndecorated(true);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==change){
        try{
           String npin=pin.getText();
           String rpin=repin.getText();
           
           if(!npin.equals(rpin))
            JOptionPane.showMessageDialog(null,"Entered Pin does not match"); 
           if(rpin.equals(""))
            JOptionPane.showMessageDialog(null," Please Re-enter the new Pin");   
           if(npin.equals(""))
            JOptionPane.showMessageDialog(null,"Please Enter new Pin");    
           Conn conn=new Conn();
           String query1="update bank set pin='"+rpin+"'where pin='"+pinno+"'";
           String query2="update login set pin='"+rpin+"'where pin='"+pinno+"'";
           String query3="update signup3 set pin='"+rpin+"'where pin='"+pinno+"'";
           
           conn.s.executeUpdate(query1);
           conn.s.executeUpdate(query2);
           conn.s.executeUpdate(query3);
           JOptionPane.showMessageDialog(null,"Pin changed successfully"); 
           new Transactions(rpin).setVisible(true);
           
       } catch(Exception e){
           System.out.println(e);
       }
       }
       else{
           setVisible(false);
            new Transactions(pinno).setVisible(true);
       }
       
    }
   public static void main(String args[]){
       new PinChange("").setVisible(true);
   } 
}
