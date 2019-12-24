package day01.B_loginAwt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import day01.B_joinAwt.JoinView;

public class LoginView extends Frame implements WindowListener, ActionListener {
	JButton login;
	JButton join;
	
	public LoginView() {
		
		super("Login");
		setLayout(null);
		
		JLabel id = new JLabel("ID");
		id.setBounds(100, 80, 50, 30);
		id.setFont(new Font("Ink Free", Font.PLAIN, 15));
		add(id);
		
		TextField idTxt = new TextField();
		idTxt.setBounds(150, 80, 150, 30);
		add(idTxt);
		
		
		JLabel pw = new JLabel("PW");
		pw.setBounds(100, 120, 50, 30);
		pw.setFont(new Font("Ink Free", Font.PLAIN, 15));
		add(pw);
		
		TextField pwTxt = new TextField();
		pwTxt.setBounds(150, 120, 150, 30);
		add(pwTxt);
		
		
		 login = new JButton("Login");
		login.setBounds(100, 180, 90, 50);
		login.addActionListener(this);
		add(login);
		
		
		join = new JButton("Join");
		join.setBounds(230, 180, 90, 50);
		join.addActionListener(this);
		add(join);
		
		
		
		setBounds(200, 100, 400, 300);
		setVisible(true);
		addWindowListener(this);
		setBackground(Color.WHITE);
		
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton nowBtn = (JButton)e.getSource();
		if(nowBtn == login) {
			// 로그인 버튼 누르기
			
			
		}
		else if( nowBtn == join) {
			
			dispose();
			new JoinView();
			
			
		}
		
		
		
		
	}

}
