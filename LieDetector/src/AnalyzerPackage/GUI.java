package AnalyzerPackage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class GUI extends JPanel implements ActionListener {

	ArrayList<String> condorFiles = new ArrayList<String>();
	String dagFile = null;
	
	static private final String newline = "\n";
	JButton folderButton, anaButton;
	JTextField jtf;
	
		public GUI(){
			super(new BorderLayout());

			jtf = new JTextField(20);
			//jtf.addActionListener(this);
			
			//Create the test button.
			folderButton = new JButton("Open Question File");
			folderButton.addActionListener(this);

			//For layout purposes, put the buttons in a separate panel
			JPanel buttonPanel = new JPanel(); //use FlowLayout
			buttonPanel.add(jtf);
			buttonPanel.add(folderButton);
			
			//Create the test button.
			anaButton = new JButton("Analyze Question");
			anaButton.addActionListener(this);
			
			//For layout purposes, put the buttons in a separate panel
			JPanel centerPanel = new JPanel(); //use FlowLayout
			centerPanel.add(anaButton);
			
			//Add the buttons and the log to this panel.
			add(buttonPanel, BorderLayout.PAGE_START);
			add(centerPanel, BorderLayout.CENTER);
		}
	
		public static void createAndShowGUI() {
			//Create and set up the window.
			JFrame frame = new JFrame("Lie Detector v2.0");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			//Add content to the window.
			frame.add(new GUI());

			//Display the window.
			frame.pack();
			frame.setVisible(true);
		}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == folderButton){
			System.out.println("SOMEONE HIT THE BUTTON");
			Driver.readFile(jtf.getText());
		}
		if(e.getSource() == anaButton){
			System.out.println("SOMEONE HIT THE OTHER BUTTON");
			Driver.runAnalysis();
		}
	}

}
