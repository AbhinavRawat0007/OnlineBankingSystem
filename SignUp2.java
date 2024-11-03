package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SignUp2 extends JFrame implements ActionListener{
    JTextField pnoTextField,anoTextField;
    JButton next;
    JRadioButton yes,no;
    JComboBox rel,cate,inc,edq,ocp;
    String formno;
    SignUp2(String formno){
       this.formno=formno;
        setLayout(null);
        
        setTitle("New Account Application Form_Page 2 ");
        
        JLabel AdditionalDetails=new JLabel("Page 2:Additional Details");
        AdditionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        AdditionalDetails.setBounds(290,80,400,30);
        getContentPane().setBackground(Color.white);
        add(AdditionalDetails);
        
        JLabel religon=new JLabel("Religon:");
        religon.setFont(new Font("Raleway",Font.BOLD,20));
        religon.setBounds(100,140,100,30);
        getContentPane().setBackground(Color.white);
        add(religon);
        
        String valRel[]={"Hindu","Muslim","Sikh","Christian","Other"};
        rel=new JComboBox(valRel);
        rel.setBounds(300,140,400,30);
        rel.setBackground(Color.white);
        add(rel);
        
        JLabel cat=new JLabel("Category:");
        cat.setFont(new Font("Raleway",Font.BOLD,20));
        cat.setBounds(100,190,200,30);
        getContentPane().setBackground(Color.white);
        add(cat);
        
        String valcat[]={"General","OBC","SC","ST","Other"};
        cate=new JComboBox(valcat);
        cate.setBounds(300,190,400,30);
        cate.setBackground(Color.white);
        add(cate);
        
        JLabel in=new JLabel("Income:");
        in.setFont(new Font("Raleway",Font.BOLD,20));
        in.setBounds(100,240,200,30);
        getContentPane().setBackground(Color.white);
        add(in);
        
        String valin[]={"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"};
        inc=new JComboBox(valin);
        inc.setBounds(300,240,400,30);
        inc.setBackground(Color.white);
        add(inc);
        
        JLabel ed=new JLabel("Educational");
        ed.setFont(new Font("Raleway",Font.BOLD,20));
        ed.setBounds(100,290,200,30);
        getContentPane().setBackground(Color.white);
        add(ed);
       
        JLabel qua=new JLabel("Qualification:");
        qua.setFont(new Font("Raleway",Font.BOLD,20));
        qua.setBounds(100,315,200,30);
        getContentPane().setBackground(Color.white);
        add(qua);
        
        String valeq[]={"Non Graduate","Graduate","Post Graduation","Doctrate","Others"};
        edq=new JComboBox(valeq);
        edq.setBounds(300,315,400,30);
        edq.setBackground(Color.white);
        add(edq);
        
        JLabel occ=new JLabel("Occupation:");
        occ.setFont(new Font("Raleway",Font.BOLD,20));
        occ.setBounds(100,390,200,30);
        getContentPane().setBackground(Color.white);
        add(occ);
        
        String valocc[]={"Salaried","Self Employed","Bussiness","Student","Retired","Others"};
        ocp=new JComboBox(valocc);
        ocp.setBounds(300,390,400,30);
        ocp.setBackground(Color.white);
        add(ocp);
      
        JLabel pno=new JLabel("PAN Number:");
        pno.setFont(new Font("Raleway",Font.BOLD,20));
        pno.setBounds(100,440,200,30);
        getContentPane().setBackground(Color.white);
        add(pno);
        pnoTextField=new JTextField();
        pnoTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pnoTextField.setBounds(300,440,400,30);
        add(pnoTextField);
        
        JLabel ano=new JLabel("Aadhar Number:");
        ano.setFont(new Font("Raleway",Font.BOLD,20));
        ano.setBounds(100,490,200,30);
        getContentPane().setBackground(Color.white);
        add(ano);
        
        anoTextField=new JTextField();
        anoTextField.setFont(new Font("Raleway",Font.BOLD,14));
        anoTextField.setBounds(300,490,400,30);
        add(anoTextField);
        
        JLabel scz=new JLabel("Senior Citizen:");
        scz.setFont(new Font("Raleway",Font.BOLD,20));
        scz.setBounds(100,540,200,30);
        getContentPane().setBackground(Color.white);
        add(scz);
        
        yes=new JRadioButton("Yes");
        yes.setBounds(300,540,120,30);
        yes.setBackground(Color.white);
        add(yes);
        no=new JRadioButton("No");
        no.setBounds(450,540,120,30);
        no.setBackground(Color.white);
        add(no);
        ButtonGroup yorn=new ButtonGroup();
        yorn.add(yes);
        yorn.add(no);
        
        JLabel Pc=new JLabel("Existing Account:");
        Pc.setFont(new Font("Raleway",Font.BOLD,20));
        Pc.setBounds(100,590,200,30);
        getContentPane().setBackground(Color.white);
        add(Pc);
        yes=new JRadioButton("Yes");
        yes.setBounds(300,590,120,30);
        yes.setBackground(Color.white);
        add(yes);
        no=new JRadioButton("No");
        no.setBounds(450,590,120,30);
        no.setBackground(Color.white);
        add(no);
        ButtonGroup yorne=new ButtonGroup();
        yorne.add(yes);
        yorne.add(no);
       
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
        String sreligon=(String)rel.getSelectedItem();
        String scategory=(String)cate.getSelectedItem();
        String sincome=(String)inc.getSelectedItem();
        String sequalification=(String)edq.getSelectedItem();
        String soccupation=(String)ocp.getSelectedItem();
        String span=pnoTextField.getText();
        String saadhar=anoTextField.getText();
        String senior=null;
        if(yes.isSelected())
            senior="Yes";
        else if(no.isSelected())
            senior="No";
        String existing=null;
        if(yes.isSelected())
            existing="Yes";
         else if(no.isSelected())
            existing="No";
        
        try{
                Conn c=new Conn();
                String query="insert into signup2 values('"+formno+"','"+sreligon+"','"+scategory+"','"+sincome+"','"+sequalification+"','"+soccupation+"','"+span+"','"+saadhar+"','"+senior+"','"+existing+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUp3(formno).setVisible(true);
                
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    public static void main(String args[]){
        new SignUp2("");
    }
}

