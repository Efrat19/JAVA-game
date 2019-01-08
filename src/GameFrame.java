import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.peer.KeyboardFocusManagerPeer;
import java.util.Random;

import javax.management.remote.JMXAddressable;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class GameFrame extends JFrame implements ActionListener,KeyListener
{
	JLabel question=new JLabel("?"+"��� �� ���� ������ ����");
	JTextField answer=new JTextField(30);
	JButton next=new JButton("ok");
	JPanel p=new JPanel(new GridLayout(2,2));
	int count=0;
	String[] questions=new String[10];
	EndFrame ef;
	public GameFrame()
	{
		questions[0]="?"+"���� ����� �� �����";
		questions[1]="?"+"��� ��� ���� �� 100 ����";
		questions[2]="?"+"���� ��� ������ ���";
		questions[3]="?"+"��� �� ����� ������";
		questions[4]="?JAVA "+"��� �� ����� �����";
		questions[5]="?"+"��� �� ����� ��� ����� ������";
		questions[6]="?"+"�� ��� ������ �� ���� ����� ���, ��� ���� ������ �����";
		questions[7]="?"+"�� ��� ������� ���� ����� ��� ���� ����� ���� �����";
		questions[8]="?"+"��� �� ������ ������ ����� ����� �����";
		questions[9]="?"+"��� �� ������ ������� �� ����� �������";
		p.add(question);
		p.add(answer);
		p.add(next);
		this.setSize(700,100);
		this.add(p,BorderLayout.CENTER);
		this.setVisible(true);
		next.addActionListener(this);
		answer.addKeyListener(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void checkAns(String ans)
	{
		String lastword=ans.substring(ans.lastIndexOf(' ')+1);
		if(lastword.equals("��")||lastword.equals("��")||lastword.equals("����")||lastword.equals("���"))
		{
			ef=new EndFrame(this.count);
			this.dispose();
			
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		checkAns(this.answer.getText());
		Random rnd=new Random();
		this.question.setText(questions[rnd.nextInt(10)]);
		this.answer.setText("");
		count++;
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		//if(e.getKeyChar()==' ')
		//	checkAns((answer.getText()).substring(0,(answer.getText()).length()-1));
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyChar()==' ')
			checkAns((answer.getText()).substring(0,(answer.getText()).length()-1));
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		
	}
	
	
}
