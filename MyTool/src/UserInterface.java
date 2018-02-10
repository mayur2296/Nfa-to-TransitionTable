import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class UserInterface extends Frame implements ActionListener{

	JFrame frame;
	JPanel panel;
	JLabel lable,lable2,filename,states,head;
	JTextField nodescount,charcount,fname,statescount;
	JButton submit;

	
	
	public UserInterface() {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame=new JFrame("MyTooL");
		panel=new JPanel();
		panel.setLayout(new FlowLayout());

		head=new JLabel(" TOOL ");
		head.setFont(new Font("Jokerman",0,35));
		head.setForeground(Color.BLUE);
		head.setBounds(113,20,400,40);
		frame.add(head);
		
		lable=new JLabel("Enter total number of Edges: ");
		lable.setFont(new Font("Comic Sans MS",3,16));
		lable.setBounds(30,80,245,20);
		
		lable2=new JLabel("Enter total number of Char : ");
		lable2.setFont(new Font("Comic Sans MS",3,16));
		lable2.setBounds(30,120,245,20);
		
		filename=new JLabel("Enter file name to save : ");
		filename.setFont(new Font("Comic Sans MS",3,16));
		filename.setBounds(30,200,230,20);
		
		states=new JLabel("Enter total number of states: ");
		states.setFont(new Font("Comic Sans MS",3,16));
		states.setBounds(30,160,245,20);
		
		nodescount=new JTextField();
		nodescount.setBounds(265,80,50,25);
		nodescount.setFont(new Font("Comic Sans MS",2,16));
		
		charcount=new JTextField();
		charcount.setBounds(265,120,50,25);
		charcount.setFont(new Font("Comic Sans MS",2,16));
		
		fname=new JTextField();
		fname.setBounds(240,200,80,25);
		fname.setFont(new Font("Comic Sans MS",2,16));
		
		statescount=new JTextField();
		statescount.setBounds(265,160,50,25);
		statescount.setFont(new Font("Comic Sans MS",2,16));
		
		submit=new JButton("Submit");
		submit.setBounds(130, 237, 80, 30);
		submit.addActionListener(this);
		
		frame.add(panel);
		frame.add(lable);
		frame.add(states);
		frame.add(statescount);
		frame.add(lable2);frame.add(filename);
		frame.add(charcount);
		frame.add(fname);
		frame.add(nodescount);
		frame.add(submit);

		
		frame.add(panel);
		frame.setForeground(Color.BLACK);
		frame.setSize(370, 325);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==submit)
		{
			int totalnode,totalchar,statesnum;
			String fnamestr;
			try
			{
			totalnode=Integer.parseInt(nodescount.getText());
			totalchar=Integer.parseInt(charcount.getText());
			fnamestr=fname.getText();
			statesnum=Integer.parseInt(statescount.getText());
			Helper.fname=fnamestr;
			Helper.total_inpu_char=totalchar;
			Helper.matrixcols=statesnum+1;
			Helper.matrixrows=statesnum+1;
			Helper.total_nodes=totalnode;
			frame.setVisible(false);
			InputUI inputUI=new InputUI(totalnode);
			}
			catch(Exception ee)
			{
				JOptionPane.showMessageDialog(null,"Please Enter Correct Input");
			}
		}
		
	}

}
