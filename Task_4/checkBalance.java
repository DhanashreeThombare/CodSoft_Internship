import java.awt.Color;	
import java.awt.Font;
import java.awt.event.*;
import java.io.IOException;
import java.sql.*;

import javax.swing.*;

public class checkBalance implements ActionListener {
	
	JLabel l1,l2,l3,l4,l5;
	JTextField amt;
	JButton b1,b2;
	Font f1=new Font("Cambria",Font.BOLD,18);

	String bal,custNm,accNo;
	public String unm,pwd;
	
	checkBalance(String unm,String pwd) {
		JFrame f=new JFrame("Check Balance");
		
		l1=new JLabel();
		l2=new JLabel();
		l3=new JLabel();
		l4=new JLabel();
		l5=new JLabel();
		
		b2=new JButton("Exit");
		
		l1.setFont(f1);
		l1.setForeground(Color.black);
		l2.setFont(f1);
		l2.setForeground(Color.black);
		l3.setFont(f1);
		l3.setForeground(Color.black);
		l4.setFont(f1);
		l4.setForeground(Color.black);
		l5.setFont(f1);
		l5.setForeground(Color.black);
		
		b2.setFont(f1);
		b2.setForeground(Color.white);
		b2.setBackground(Color.red);
		
		l1.setBounds(75,50,250,30);
		l2.setBounds(75,100,250,30);
		l3.setBounds(75,150,250,30);
		//l4.setBounds(75,200,250,30);
		//l5.setBounds(75,250,250,30);
		b2.setBounds(75,220,150,30);
		
		b2.addActionListener(this);
		
		f.add(new JLabel());
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(new JButton());
		f.add(b2);
		
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
				accNo=resultSet.getString(1);
				custNm=resultSet.getString(2);
				bal=resultSet.getString(5);
				l1.setText("Account No. : "+accNo);
				l2.setText("Customer Name : "+custNm);
				l3.setText("Account Balance : "+bal);
				break;
			}
		}catch(Exception exp) {}
		
		f.getContentPane().setBackground(Color.orange);
		f.setSize(400,400);
		f.setLayout(null);
		f.setVisible(true);
		
		this.unm=unm;
		this.pwd=pwd;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b2)
		{
			try {
				new ATM_Machine(unm, pwd);
			} catch (IOException e1) {}
		}
	}
}
