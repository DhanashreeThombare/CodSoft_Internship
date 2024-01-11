import java.awt.Color;	
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;
import java.sql.*;

import javax.swing.*;

public class DepositAmt implements ActionListener {
	
	JLabel l1,l2,l3;
	JTextField amt;
	JButton b1,b2;
	Font f1=new Font("Cambria",Font.BOLD,16);

	double bal,newBal;
	public String unm,pwd;
	
	DepositAmt(String unm,String pwd) {
		JFrame f=new JFrame("Deposit");
		
		l1=new JLabel("Enter amount : ");
		amt=new JTextField(10);
		b1=new JButton("Deposit");
		l2=new JLabel();
		l3=new JLabel();
		b2=new JButton("Exit");
		
		l1.setFont(f1);
		l1.setForeground(Color.black);
		l2.setFont(f1);
		l2.setForeground(Color.black);
		l3.setFont(f1);
		l3.setForeground(Color.black);
		b1.setFont(f1);
		b1.setForeground(Color.black);
		b1.setBackground(Color.green);
		b2.setFont(f1);
		b2.setForeground(Color.white);
		b2.setBackground(Color.red);
		
		l1.setBounds(20,50,150,40);
		amt.setBounds(150,55,200,30);
		b1.setBounds(75,100,150,30);
		l2.setBounds(75,150,250,40);
		l3.setBounds(75,200,250,40);
		b2.setBounds(75,250,150,30);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		f.add(new JLabel());
		f.add(l1);
		f.add(amt);
		f.add(b1);
		f.add(l2);
		f.add(l3);
		f.add(b2);
		
		f.getContentPane().setBackground(Color.orange);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
		
		this.unm=unm;
		this.pwd=pwd;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			try
			{
				boolean b=false;
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM_Interface","root","23102003");
				String sql="select * from customerData where unm=? and pass=?;";
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setString(1, unm);
				stmt.setString(2, pwd);
				ResultSet resultSet=stmt.executeQuery();
				while(resultSet.next()) {
					b=true;
					bal=Double.parseDouble(resultSet.getString(5));
					newBal=bal+(Double.parseDouble(amt.getText()));
					sql="update customerData set bal=? where unm=? and pass=?;";
					stmt=con.prepareStatement(sql);
					stmt.setString(1, Double.toString(newBal));
					System.out.println("New Balance : "+newBal);
					stmt.setString(2, unm);
					stmt.setString(3, pwd);
					stmt.executeUpdate();
					JOptionPane.showMessageDialog(b1,"Successful..");
					l2.setText("Old balance : "+bal);
					l3.setText("Updated balance : "+newBal);
					break;
				}
			}catch(Exception exp) {}
		}
		if(e.getSource()==b2)
		{
			try {
				new ATM_Machine(unm, pwd);
			} catch (IOException e1) {}
		}
	}
}
