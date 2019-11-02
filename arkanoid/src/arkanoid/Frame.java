package arkanoid;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

public class Frame extends JFrame implements ActionListener {
	
	   private JButton bPlay, bExit,bLvl;
	   private JComboBox colorBox;
	   private int lvl;
	   
	   
	
	   public Frame()
	   {
	   
		   setSize(400, 300);
		   setTitle("Menu");
		   setLayout(null);
		   this.lvl=1;
		   
		   try {
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			SwingUtilities.updateComponentTreeUI(this);
			
			
			
			bPlay = new JButton("PLAY");
			bPlay.setBounds(130, 50, 120, 20);
			add(bPlay);
			bPlay.addActionListener(this);
			
			bExit = new JButton("EXIT");
			bExit.setBounds(130, 125, 120, 20);
			add(bExit);
			bExit.addActionListener(this);
			
			
			colorBox = new JComboBox();
			colorBox.setBounds(130, 100, 120, 20);
			add(colorBox);
			colorBox.addItem("Easy");
			colorBox.addItem("Medium");
			colorBox.addItem("Hard");
			colorBox.addItem("Imposible");
			colorBox.addActionListener(this);
			
			bLvl = new JButton("LVL");
			bLvl.setBounds(130, 75, 120, 20);
			add(bLvl);
			bLvl.setEnabled(false);

		   
		   
		   
	   }
	

	   public static void main(String[] args)                       
	   {                                                           
		   Frame app = new Frame();
		   app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   app.setLocationRelativeTo(null);
		   app.setVisible(true);    

	   }


	@Override
	public void actionPerformed(ActionEvent e) {
		Object k = e.getSource();
		
		if (k == bExit)
		{
			dispose();
		}
		
		else if (k==bPlay)
		{
			javax.swing.SwingUtilities.invokeLater(new Runnable()  
				      //http://pojava.fizyka.pw.edu.pl/images/wyklady/wyklad6.pdf 21str
				      {                                                        
				         public void run()                                     
				         {                                                     
				            Board board;  
				            JFrame jf=new JFrame(); 
				            board=new Board(lvl,jf);                                   
				                                                               
				                                     
				            jf.add(board);                                         
				                                                               
				            jf.setTitle("Arkanoid");                       
				            jf.setSize(400,300);
				            jf.setResizable(false);
				            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				            jf.setLocationRelativeTo(null);
				            jf.setVisible(true);
				            
				          

				         }                                                     
				      });  
			
			//this.setVisible(false);
			this.dispose();
		}
		
		else if(k == colorBox)
		{
			String choice = colorBox.getSelectedItem().toString();
			
			if (choice == "Easy")
			{
				this.lvl=1;
			}
			
			else if (choice == "Medium")
			{
				this.lvl=2;
			}
			
			else if (choice == "Hard")
			{
				this.lvl=3;
			}
			
			else if (choice == "Imposible")
			{
				this.lvl=4;
			}
			
			
		}
		
	}                                                           
	}
