package day01.B_joinAwt;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JoinView extends Frame implements WindowListener, ActionListener{
	JButton joinBtn;
	
	public JoinView() {
	
		super("Join");
		setLayout(new GridLayout(6,0));
		
		JPanel p[] = new JPanel[6];
		for (int i = 0; i < p.length; i++) {
			p[i] = new JPanel();
			p[i].setSize(450, 90);
			p[i].setLayout(null);
			p[i].setBackground(new Color(204,153, 255));
			add(p[i]);
			//if(i%2 ==0) p[i].setBackground(Color.yellow);
		}
		
		// p[1] 아이디
		JLabel title = new JLabel("J O I N");
		title.setSize(450, 100);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("Ink Free", Font.BOLD, 30));
		title.setForeground(Color.white);
		p[0].add(title);
		
		
	
		
		String labels[] = {" I D ", " P W ", "NAME ","EMAIL"};
		JLabel l[] = new JLabel[4];
		for (int i = 0; i < 4; i++) {
			l[i] = new JLabel(labels[i]);
			l[i].setBounds(0, 30, 110, 30);
			l[i].setHorizontalAlignment(JLabel.RIGHT);
			l[i].setFont(new Font("Ink Free", Font.BOLD, 15));
			p[i+1].add(l[i]);
			l[i].setForeground(Color.white);
		}
		
		TextField txt[] = new TextField[4];
		for (int i = 0; i < 4; i++) {
			txt[i] = new TextField();
			txt[i].setBounds(150, 30, 200, 30);
			p[i+1].add(txt[i]);
		}
		
		
		 joinBtn = new JButton("회 원 가 입 ");
		joinBtn.setBounds(150, 10, 180, 50);
		p[5].add(joinBtn);
	
		
		
		setBounds(100, 100, 450, 540);
		setVisible(true);
		addWindowListener(this);
		
	
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
		if(nowBtn ==  joinBtn) {
			
		}
		
		
		
	}
	

}
