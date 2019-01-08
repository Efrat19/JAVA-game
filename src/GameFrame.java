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
	JLabel question=new JLabel("?"+"האם את רוצה להתחיל לשחק");
	JTextField answer=new JTextField(30);
	JButton next=new JButton("ok");
	JPanel p=new JPanel(new GridLayout(2,2));
	int count=0;
	String[] questions=new String[10];
	EndFrame ef;
	public GameFrame()
	{
		questions[0]="?"+"איזה צבעים יש לזברה";
		questions[1]="?"+"האם כבר מלאו לך 100 שנים";
		questions[2]="?"+"איזה צבע החצאית שלך";
		questions[3]="?"+"האם את נהנית מהמשחק";
		questions[4]="?JAVA "+"האם את אוהבת שיעור";
		questions[5]="?"+"האם את בטוחה שאת נהנית מהמשחק";
		questions[6]="?"+"אם היו מציעים לך לשחק במשחק אחר, האם היית מסכימה להצעה";
		questions[7]="?"+"אם היו משחררים אותך הביתה האם היית נשארת לשחק במשחק";
		questions[8]="?"+"האם את מרגישה שהמשחק מתחיל להמאס עלייך";
		questions[9]="?"+"האם את מרגישה שהשאלות לא מספיק מגוונות";
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
		if(lastword.equals("כן")||lastword.equals("לא")||lastword.equals("שחור")||lastword.equals("לבן"))
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
