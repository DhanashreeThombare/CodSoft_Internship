import java.awt.*;	
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ATM_Machine implements ActionListener{
	
	JButton b1,withdraw,deposit,checkBal,quit;
	JLabel l;
	JFrame f;
	
	public double balance;
	public String unm,pwd;
	
	Font f1=new Font("Cambria", Font.BOLD, 22);
	Font f2=new Font("Comic Sans MS",Font.BOLD,14);
	
	ATM_Machine(String unm,String pwd) throws IOException{
		
		f=new JFrame("ATM_INTERFACE");
		l=new JLabel("WELCOME TO SBI ATM...!!!");
		l.setFont(f1);

		withdraw=new JButton("WITHDRAW MONEY");
		deposit=new JButton("DEPOSIT MONEY");
		checkBal=new JButton("CHECK BALANCE");
		quit=new JButton("EXIT");
		
		JLabel l1=new JLabel();
		ImageIcon img=new ImageIcon(this.getClass().getResource("/logo.png"));
		l1.setIcon(img);
		l1.setBounds(10,30,300,300);
		
		withdraw.setFont(f2);
		deposit.setFont(f2);
		checkBal.setFont(f2);
		quit.setFont(f2);
		
		l.setBounds(190,80,280,40);
		withdraw.setBounds(200,150,220,45);
		deposit.setBounds(450,150,220,45);
		checkBal.setBounds(200,220,220,45);
		quit.setBounds(450,220,220,45);
		
		withdraw.addActionListener(this);
		deposit.addActionListener(this);
		checkBal.addActionListener(this);
		quit.addActionListener(this);
		
		l.setForeground(Color.white);
		withdraw.setBackground(Color.cyan);
		deposit.setBackground(Color.cyan);
		checkBal.setBackground(Color.cyan);
		quit.setBackground(Color.cyan);
		
		withdraw.setForeground(Color.black);
		deposit.setForeground(Color.black);
		checkBal.setForeground(Color.black);
		quit.setForeground(Color.black);
		
		withdraw.addActionListener(this);
		deposit.addActionListener(this);
		checkBal.addActionListener(this);
		quit.addActionListener(this);
		
		b1=new JButton();
		
		f.add(l);
		f.getContentPane().add(l1);
		f.add(b1);
		f.add(withdraw);
		f.add(deposit);
		f.add(checkBal);
		f.add(quit);
		
		f.getContentPane().setBackground(Color.blue);
		f.getContentPane().setLayout(null);
		f.setSize(800,500);
		f.setLayout(null);
		f.setVisible(true);
		
		this.unm=unm;
		this.pwd=pwd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==withdraw) {
			new WithdrawAmt(unm,pwd);
		}
		if(e.getSource()==deposit) {
			new DepositAmt(unm, pwd);
		}
		if(e.getSource()==checkBal) {
			new checkBalance(unm,pwd);
		}
		if(e.getSource()==quit) {
			System.exit(0);
		}
	}
}
