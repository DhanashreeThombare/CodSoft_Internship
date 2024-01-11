import java.awt.Color;	
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.*;
public class CreateAccount implements ActionListener {

	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField ano,nm,mno,email,unm,bal;
	JPasswordField pass;
	JButton b1,b2;
	
	Font f1=new Font("Cambria",Font.BOLD,16);

	CreateAccount(){
		l1=new JLabel("Enter your Account Number : ");
		ano=new JTextField(10);
		l2=new JLabel("Enter your Name : ");
		nm=new JTextField(20);
		l3=new JLabel("Enter your Mobile No. : ");
		mno=new JTextField(12);
		l4=new JLabel("Enter your Email ID :  ");
		email=new JTextField(20);
		l5=new JLabel("Enter account Balance : ");
		bal=new JTextField(10);
		l6=new JLabel("Enter Username : ");
		unm=new JTextField(20);
		l7=new JLabel("Enter Password : ");
		pass=new JPasswordField(8);
		pass.setEchoChar('*');
		
		l1.setFont(f1);
		l2.setFont(f1);
		l3.setFont(f1);
		l4.setFont(f1);
		l5.setFont(f1);
		l6.setFont(f1);
		l7.setFont(f1);
		
		l1.setForeground(Color.black);
		l2.setForeground(Color.black);
		l3.setForeground(Color.black);
		l4.setForeground(Color.black);
		l5.setForeground(Color.black);
		l6.setForeground(Color.black);
		l7.setForeground(Color.black);
		
		JFrame f=new JFrame("Register");
		
		f.getContentPane().setBackground(Color.pink);
		
		f.setLayout(new GridLayout(9,2,2,5));
		f.setVisible(true);
		f.setSize(600,300);


		b1=new JButton("Register");
		b2=new JButton("Reset");
		b1.setFont(f1);
		b2.setFont(f1);
		b1.setBackground(Color.green);
		b2.setBackground(Color.red);
		b2.setForeground(Color.white);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		f.add(new JLabel());
		f.add(new JLabel());
		
		f.add(l1);
		f.add(ano);
		f.add(l2);
		f.add(nm);
		f.add(l3);
		f.add(mno);
		f.add(l4);
		f.add(email);
		f.add(l5);
		f.add(bal);
		f.add(l6);
		f.add(unm);
		f.add(l7);
		f.add(pass);

		f.add(b1);
		f.add(b2);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource()==b2)
			{
				nm.setText(null);
				ano.setText(null);
				email.setText(null);
				mno.setText(null);
				bal.setText(null);
				unm.setText(null);
				pass.setText(null);
			}
			if(e.getSource()==b1)
			{
				String accNo=ano.getText();
				String name=nm.getText();
				String emailid=email.getText();
				String mob=mno.getText();
				String accBal=bal.getText();
				String usernm=unm.getText();
				String pwd=pass.getText();
				//System.out.println(accNo+" "+name+" "+emailid+" "+mob);
				if(pwd.length()!=8){
					JOptionPane.showMessageDialog(b1, "Enter 8 character password..");
				}
				try
				{
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM_Interface","root","23102003");
					String sql="insert into customerData values(?,?,?,?,?,?,?);";
					PreparedStatement stmt=con.prepareStatement(sql);
					stmt.setString(1, accNo);
					stmt.setString(2, name);
					stmt.setString(3, mob);
					stmt.setString(4, emailid);
					stmt.setString(5, accBal);
					stmt.setString(6, usernm);
					stmt.setString(7, pwd);
					int x=stmt.executeUpdate();
					if(x==0) {
						JOptionPane.showMessageDialog(b1,"Customer already exist..");
					}
					int bal1=Integer.parseInt(accBal);
					
					if(bal1<1000) {
						JOptionPane.showMessageDialog(b1,"Too low balance to create account...");
					}
					else {
						JOptionPane.showMessageDialog(b1,"Your data is registered successfully...");
						new ATM_Machine(usernm,pwd);
					}
					con.close();
				}catch(Exception exp) {}
			}
		}
		catch(Exception ex) {}
	}
}
