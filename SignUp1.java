
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignUp1 extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,FnameTextField,emailTextField,addTextField,cityTextField,stateTextField,PcTextField;
    JButton next;
    JRadioButton male,female,o,y,n;
    JDateChooser dateChooser;
    SignUp1(){
       
        setLayout(null);
        
        Random r=new Random();
        random=Math.abs((r.nextLong()%9000L)+1000L);
        
        JLabel formno=new JLabel("APPICATION FORM NO:"+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        getContentPane().setBackground(Color.white);
        add(formno);
        
        JLabel PersonalDetails=new JLabel("Page 1:Personal Details");
        PersonalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        PersonalDetails.setBounds(290,80,400,30);
        getContentPane().setBackground(Color.white);
        add(PersonalDetails);
        
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        getContentPane().setBackground(Color.white);
        add(name);
        
         nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel Fname=new JLabel("Fathers Name:");
        Fname.setFont(new Font("Raleway",Font.BOLD,20));
        Fname.setBounds(100,190,200,30);
        getContentPane().setBackground(Color.white);
        add(Fname);
        
        FnameTextField=new JTextField();
        FnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        FnameTextField.setBounds(300,190,400,30);
        add(FnameTextField);
        
        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        getContentPane().setBackground(Color.white);
        add(dob);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        JLabel g=new JLabel("Gender:");
        g.setFont(new Font("Raleway",Font.BOLD,20));
        g.setBounds(100,290,200,30);
        getContentPane().setBackground(Color.white);
        add(g);
        
        male=new JRadioButton("Male");
        male.setBounds(300,290,120,30);
        male.setBackground(Color.white);
        add(male);
        female=new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
       
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        getContentPane().setBackground(Color.white);
        add(email);
        
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
        JLabel mstatus=new JLabel("Marital Status:");
        mstatus.setFont(new Font("Raleway",Font.BOLD,20));
        mstatus.setBounds(100,390,200,30);
        getContentPane().setBackground(Color.white);
        add(mstatus);
        
        y=new JRadioButton("Married");
        y.setBounds(300,390,100,30);
        y.setBackground(Color.white);
        add(y);
        n=new JRadioButton("Unmarried");
        n.setBounds(450,390,100,30);
        n.setBackground(Color.white);
        add(n);
        o=new JRadioButton("Others");
        o.setBounds(630,390,100,30);
        o.setBackground(Color.white);
        add(o);

        ButtonGroup mastatus=new ButtonGroup();
        mastatus.add(y);
        mastatus.add(n);
        mastatus.add(o);
        
        JLabel add=new JLabel("Address:");
        add.setFont(new Font("Raleway",Font.BOLD,20));
        add.setBounds(100,440,200,30);
        getContentPane().setBackground(Color.white);
        add(add);
        addTextField=new JTextField();
        addTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addTextField.setBounds(300,440,400,30);
        add(addTextField);
        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        getContentPane().setBackground(Color.white);
        add(city);
        
        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        getContentPane().setBackground(Color.white);
        add(state);
        
        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);
        
        JLabel Pc=new JLabel("PIN code:");
        Pc.setFont(new Font("Raleway",Font.BOLD,20));
        Pc.setBounds(100,590,200,30);
        getContentPane().setBackground(Color.white);
        add(Pc);
        
        PcTextField=new JTextField();
        PcTextField.setFont(new Font("Raleway",Font.BOLD,14));
        PcTextField.setBounds(300,590,400,30);
        add(PcTextField);
        
        next=new JButton("Next");
        next.setBackground(Color.white);
        next.setForeground(Color.black);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;
        String name=nameTextField.getText();
        String fname=FnameTextField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String email=emailTextField.getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender="Female";
        }
        String marital=null;
        if(y.isSelected())
            marital="Married";
        else if(n.isSelected())
            marital="Unmarried";
        else if(o.isSelected())
            marital="Other";
        String address=addTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=PcTextField.getText();
        
        try{
            if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Name is Required");    
            }
            else{
                Conn c=new Conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignUp2(formno).setVisible(true);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    public static void main(String args[]){
        new SignUp1();
    }
}
