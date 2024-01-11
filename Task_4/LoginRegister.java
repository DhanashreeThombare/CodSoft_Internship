import javax.swing.*;	
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class LoginRegister implements ActionListener{
	
	JLabel l,unm,pass,accNo,custNm;
	JTextField tunm,tpass,taccNo,tcustNm;
	JButton b,login,createAcc;
	JFrame f;
	
	Font f1=new Font("Cambria", Font.BOLD, 22);
	Font f2=new Font("Cambria", Font.BOLD, 18);
	
	LoginRegister() {
		f=new JFrame();
		l=new JLabel("WELCOME TO STATE BANK OF INDIA...!!!");
		l.setFont(f1);
		
		JLabel l1=new JLabel();
		ImageIcon img=new ImageIcon(this.getClass().getResource("/sbi1.png"));
		l1.setIcon(img);
		l1.setBounds(130,10,1500,150);
		
		b=new JButton();
		login=new JButton("Login");
		createAcc=new JButton("Create Account");
		
		login.setBounds(170,350,150,40);
		createAcc.setBounds(400,350,200,40);
		
		login.setFont(f2);
		createAcc.setFont(f2);
		
		login.setBackground(Color.blue);
		login.setForeground(Color.white);
		createAcc.setBackground(Color.blue);
		createAcc.setForeground(Color.white);
		
		login.addActionListener(this);
		createAcc.addActionListener(this);
		
		l.setBounds(170,230,470,30);
		l.setForeground(Color.black);
		
		f.add(b);
		f.getContentPane().add(l1);
		f.add(l);
		f.add(login);
		f.add(createAcc);
		
		f.getContentPane().setBackground(Color.cyan);
		f.getContentPane().setLayout(null);
		f.setSize(800,500);
		f.setLayout(null);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==login)
		{
			new LoginATM();
		}
		if(e.getSource()==createAcc) {
			new CreateAccount();
		}
	}
	public static void main(String[] args)
	{
		new LoginRegister();
	}
}
