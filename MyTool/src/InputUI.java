import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
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

public class InputUI extends Frame implements ActionListener{

	JFrame frame;
	JPanel panel;
	JLabel head,arrow,equal,lfrom,lto,linput;
	JTextField from[],to[],value[];
	JButton generateoutput;
	public int height=90;
	
	public InputUI(int nodescount)
	{
		
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
		
		head=new JLabel("ENTER INFORMATION OF NODES ");
		head.setFont(new Font("Comic Sans MS",3,20));
		head.setBounds(30,20,400,20);
		
		
		lfrom=new JLabel("FROM");
		lfrom.setFont(new Font("Comic Sans MS",3,12));
		lfrom.setBounds(100,65,40,25);
		
		lto=new JLabel("TO");
		lto.setFont(new Font("Comic Sans MS",3,12));
		lto.setBounds(195,65,40,25);
		
		linput=new JLabel("INPUT");
		linput.setFont(new Font("Comic Sans MS",3,12));
		linput.setBounds(260,65,60,25);
		

		from=new JTextField[nodescount];
		to=new JTextField[nodescount];
		value=new JTextField[nodescount];
		
		for(int i=0;i<nodescount;i++)
			{
			
			
			from[i]=new JTextField();
			from[i].setBounds(100,height,40,25);
			from[i].setFont(new Font("Comic Sans MS",2,16));
			frame.add(from[i]);
			
			arrow=new JLabel(" -- > ");
			arrow.setFont(new Font("Bauhaus 93",1,20));
			arrow.setBounds(143,height,60,30);
			frame.add(arrow);
			
			to[i]=new JTextField();
			to[i].setBounds(185,height,40,25);
			to[i].setFont(new Font("Comic Sans MS",2,16));
			frame.add(to[i]);
			
			equal=new JLabel(" = ");
			equal.setFont(new Font("Bauhaus 93",1,20));
			equal.setBounds(225,height,60,30);
			frame.add(equal);
			
			value[i]=new JTextField();
			value[i].setBounds(260,height,40,25);
			value[i].setFont(new Font("Comic Sans MS",2,16));
			frame.add(value[i]);
			
			height=height+25;
			}
		
		height=height+10;
		generateoutput=new JButton("GENERATE OUTPUT");
		generateoutput.setBounds(110, height, 170, 30);
		generateoutput.addActionListener(this);
		
		frame.add(head);
		frame.add(lto);
		frame.add(lfrom);
		frame.add(linput);
		frame.add(generateoutput);
		frame.add(panel);
		frame.setForeground(Color.BLACK);
		frame.setSize(420, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int row=0,col=0;
		String val;
		Helper.initialise_matrix();
		if(e.getSource()==generateoutput)
		{
			try
			{
				for(int k=0;k<Helper.total_nodes;k++)
				{
					row=Integer.parseInt(from[k].getText());
					col=Integer.parseInt(to[k].getText());
					val=value[k].getText();
					Helper.matrix[row][col]=val.charAt(0);
				
				}

			Dfa dfa=new Dfa();
			dfa.convert_to_dfa();
			JOptionPane.showMessageDialog(null,"SUCCESSFUL! \n CHECK "+Helper.fname+".txt file");
			frame.setVisible(false);
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			}
			catch(Exception ee)
			{
				JOptionPane.showMessageDialog(null,"Please Enter Correct Input");
			}
		}
	}
	
}
