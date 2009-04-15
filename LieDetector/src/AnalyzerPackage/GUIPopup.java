
package AnalyzerPackage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class GUIPopup extends JPanel implements ActionListener {

	ArrayList<String> condorFiles = new ArrayList<String>();
	String dagFile = null;
	
	static private final String newline = "\n";
	JButton folderButton, anaButton;
	JTextField jtf;
	static JLabel stress, unstress;
	JPanel centerPanel;
	
		public GUIPopup(){
			super(new BorderLayout());

			
		

			
			
			//Create the test button.
			
			stress = new JLabel("Stressed Response");
			unstress = new JLabel("Unstressed Response");
			
			//For layout purposes, put the buttons in a separate panel
			centerPanel = new JPanel(); //use FlowLayout
			centerPanel.add(stress);
			centerPanel.add(unstress);
			
			stress.setVisible(false);
			unstress.setVisible(false);
			
			add(centerPanel, BorderLayout.CENTER);
		}
	
		public static void createAndShowGUI() {
			//Create and set up the window.
			JFrame frame = new JFrame("Lie Detector v2.0");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			//Add content to the window.
			frame.add(new GUIPopup());

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
			if(Driver.runAnalysis() == 0){
				System.out.println("Stressed Response");
				centerPanel.add(stress);
			} else if(Driver.runAnalysis() == 1){
				System.out.println("Unstressed Response");
				centerPanel.add(unstress);
			}
		}
	}

}



/*package AnalyzerPackage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class GUIPopup extends JPanel implements ActionListener {


	static private final String newline = "\n";
	JButton folderButton, anaButton;
	
	public static JLabel stress, unstress;
	public static JPanel centerPanel;
	
		public GUIPopup(){
			super(new BorderLayout());

		

			stress = new JLabel("Stressed Response");
			unstress = new JLabel("Unstressed Response");
								
			add(centerPanel, BorderLayout.CENTER);
			
			centerPanel.add(stress);
			centerPanel.add(unstress);
			
			stress.setVisible(false);
			unstress.setVisible(false);
		}
	
		public static void createAndShowGUI() {
			//Create and set up the window.
			JFrame frame = new JFrame("Lie Detector v2.0");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			//Add content to the window.
			frame.add(new GUIPopup());

			//Display the window.
			frame.pack();
			frame.setVisible(true);
		}
		public void actionPerformed(ActionEvent e) {
			
			
		}
		
	
	

}
*/