import java.awt.Color;	
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

public class LoginATM implements ActionListener{
	JLabel l,l1,l2;
	JTextField unm;
	JPasswordField pass;
	JButton b1,b2;
	
	Font f1=new Font("Cambria",Font.BOLD,18);
	
	LoginATM() {
		
		l1=new JLabel("Enter Username : ");
		unm=new JTextField(30);
		l2=new JLabel("Enter Password : ");
		pass=new JPasswordField(10);
		pass.setEchoChar('*');
		
		l1.setFont(f1);
		l2.setFont(f1);
		
		l1.setForeground(Color.black);
		l2.setForeground(Color.black);
		
		b1=new JButton("Login");
		b2=new JButton("Reset");
		b1.setFont(f1);
		b2.setFont(f1);
		
		b1.setBackground(Color.green);
		b2.setBackground(Color.red);
		b2.setForeground(Color.white);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		JFrame f=new JFrame("Login");
		f.getContentPane().setBackground(Color.pink);
		f.setLayout(new GridLayout(5,2,2,5));
		f.setVisible(true);
		f.setSize(600,250);
		
		f.add(new JLabel());
		f.add(new JLabel());
		f.add(l1);
		f.add(unm);
		f.add(l2);
		f.add(pass);
		f.add(b1);
		f.add(b2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b2)
		{
			unm.setText(null);
			pass.setText(null);
		}
		if(e.getSource()==b1)
		{
			String usernm=unm.getText();
			String pwd=pass.getText();
			if(pwd.length()!=8){
				JOptionPane.showMessageDialog(b1, "Enter 8 character password..");
			}
			try
			{
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM_Interface","root","23102003");
				String sql="select * from customerData where unm=? and pass=?;";
				boolean b=false;
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setString(1, usernm);
				stmt.setString(2, pwd);
				ResultSet resultSet=stmt.executeQuery();
				while(resultSet.next()) {
					b=true;
					break;
				}
				if(b==false) {
					JOptionPane.showMessageDialog(b1,"Incorrect credentials..");
				}
				else {
					JOptionPane.showMessageDialog(b1,"Successful..");
					new ATM_Machine(usernm,pwd);
				}
			}catch(Exception exp) {}
		}
	}	
}
