import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EndFrame extends JFrame implements ActionListener
{
	JLabel end=new JLabel();
	
	public EndFrame(int count) 
	{
		end.setText("GAME OVER!!!\nYou've answered "+count+" correct answers!");
		this.add(end);
		this.setSize(400,100);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		System.exit(0);
	}
}
