package arkanoid;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Board extends JPanel implements KeyListener,MouseMotionListener
{
	
	private  int lvl;
	public static int countBeam;
	public static final int heightBeam=10;
	public int leaveBeam;
	private boolean play=true;
	private JFrame jf;
	
	ArrayList <Beam> brickList;
	Beam beam;
	Heart heart; 
	Ball ball;

	public Board(int lvl,JFrame jf)
	{
		super();
	    addKeyListener(this);
	    setFocusable(true);
	    setFocusTraversalKeysEnabled(false);
	    addMouseMotionListener(this);
	    
        this.jf=jf;
		play=true;
		this.lvl = lvl;
		countBeam = lvl*24;
		leaveBeam = countBeam;
		
		beam = new Beam();
		brickList = new ArrayList<Beam>();
		for (int i = 0; i < countBeam; i++){
			  Beam brick=new Beam();
	    	  brickList.add(brick);
		}
		
		this.setObject();
		
		switch(lvl)
		{
		case 1:
		{
			ball = new Ball(this,180,130,1,1);
			 break;
		}
		case 2:
		{
			ball = new Ball(this,180,130,2,2);
			 break;
		}
			
		case 3:
		{
			ball = new Ball(this,180,130,3,3);
			 break;
		}
		
		case 4:
		{
			ball = new Ball(this,180,130,4,4);
			 break;
		}
			
		default: {
			ball = new Ball(this,180,130,1,1);
	    }	
		}
		
		
		
		heart = new Heart(brickList,beam,this,ball) ;
		
		
		
		
		
	}
	
	
	public void paintComponent(Graphics g) 
	   {                                      
	      super.paintComponent(g);            
	      Graphics2D g2d=(Graphics2D)g;       
	 
	      setBackground(Color.LIGHT_GRAY);  
	      
	      g2d.fill(beam);
	      
	      for(int i=0; i<countBeam;i++)
	      {
	    	  if(brickList.get(i).getHp()==3)
	    	  {
	    		  g2d.setColor(Color.BLACK);
	    		  g2d.fill(brickList.get(i));
	    	  }
	    	  else if(brickList.get(i).getHp()==2)
	    	  {
	    		  g2d.setColor(Color.DARK_GRAY);
	    		  g2d.fill(brickList.get(i));
	    	  }
	    	  
	    	  else if(brickList.get(i).getHp()==1)
	    	  {
	    		  g2d.setColor(Color.GRAY);
	    		  g2d.fill(brickList.get(i));
	    	  }
	      }
	      
		  g2d.setColor(Color.BLUE);
	      g2d.fill(ball);
	      
	      if(!game())
	      {
	    	  g2d.setColor(Color.LIGHT_GRAY);
	    	  for(int i=0; i<countBeam;i++)
	    	  {
	    		  g2d.fill(brickList.get(i));
	    	  }
	    	  g2d.fill(beam);
		      g2d.fill(ball);

	    	  
	    	  
	    	  g.setColor(Color.RED);
	    	  g.setFont(new Font("Courier New", Font.BOLD, 33));
	    	  
	    	  if(getLivesBeam()==0)
		      {
		    	  
		    	  g.drawString("WIN", getWidth()/2, getHeight()/2);
		      }
	    	  else
	    		  {
	    		  g.drawString("LOSE", getWidth()/2, getHeight()/2);
	    		  }
	    	  
	    	  g.setFont(new Font("Courier New", Font.BOLD, 15));
	    	  g.drawString("TO EXIT PRESS -> E", getWidth()-370, getHeight()-200);
	    	  g.drawString("TO RESTART PRESS -> R", getWidth()-370, getHeight()-220);
	    	  g.drawString("TO GO TO MENU PRESS -> M", getWidth()-370, getHeight()-240);


	      }
	      
	     
	      
	      
	      g.setColor(Color.RED);
    	  g.setFont(new Font("Courier New", Font.BOLD, 15));
    	  g.drawString("TIME", getWidth()-45, getHeight()-46);
    	  g.drawString(heart.timing(), getWidth()-30, getHeight()-30);
    	  
    	  g.setColor(Color.BLUE);
    	  g.setFont(new Font("Courier New", Font.BOLD, 15));
    	  g.drawString("PKT", getWidth()-380, getHeight()-46);
    	  g.drawString(pkt(), getWidth()-370, getHeight()-30);
	      
	      
	                            
	   }     
	
	
	void game(boolean playOff)
	{
		this.play=playOff;
	}
	
	boolean game()
	{
		return play;
	}
	
	void livesBeam()
	{
		this.leaveBeam=leaveBeam-1;
	}
	
	public String pkt()
	{
		return Integer.toString(countBeam-leaveBeam);
	}
	
	public int getLivesBeam(){
		   return leaveBeam;
	   }
	
	//void delete(int i)
	//{
	//	brickList.remove(i);
	//}
	
	void riseExit()
	{
		double check = beam.getY();

		for(int i = 0;i<countBeam;i++)
		{
			if(brickList.get(i).getY()>=check)
			{
				game(false);
			}
		}
	}
	
	void setNew()
	{
		for(int i=0; i<countBeam;i++)
	      {
			brickList.get(i).changeY();
	      }
	
	}
	
	void setObject()
	{

		int count = 0;
		
		beam = new Beam(100,220,60,heightBeam);
		
		for(int i=0; i>-countBeam/6;i--)
		{
			
			for(int j=0; j<6;j++)
			{
				brickList.get(count).set(j * 60 + 20, i * 20 + 70,45,heightBeam);
				count++;
			}			
			
		}
		
		
	}
	
	public void restart()
	{
	
		int count = 0;
		
		brickList = new ArrayList<Beam>();
		for (int i = 0; i < countBeam; i++){
			  Beam brick=new Beam();
	    	  brickList.add(brick);
		}
		
		
		for(int i=0; i>-countBeam/6;i--)
		{
			
			for(int j=0; j<6;j++)
			{
				brickList.get(count).set(j * 60 + 20, i * 20 + 70,45,heightBeam);
				count++;
			}	
		}
		leaveBeam=countBeam;
		heart.startTime();
		game(true);
		heart = new Heart(this.brickList,this.beam,this,this.ball) ;
		

		repaint();
		
		
		
	}
	
	public int getLvl()
	{
		switch(lvl)
		{
		case 1:
		{
			return 20;
			 
		}
		case 2:
		{
			return 16;
		}
			
		case 3:
		{
			return 10;
		}
		
		case 4:
		{
			return 8;
		}
			
		default: {
			return 25;
	    }	
		}
	}
	
	
	
	
	
	@Override
	public void keyPressed(KeyEvent k) {
	
			
		if(!game())
			{
				//int key = m.getKeyCode();
				
				if( k.getKeyCode()  == KeyEvent.VK_R)
					{
					restart();
					}
				else if ( k.getKeyCode()  == KeyEvent.VK_M)
				{ 
					Frame app = new Frame();
					app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					app.setLocationRelativeTo(null);
					app.setVisible(true);   
					jf.dispose();
				}
				
				else if ( k.getKeyCode()  == KeyEvent.VK_E)
				{
					System.exit(0);
				}
			}

		}
	
	

	@Override
	public void mouseMoved(MouseEvent e) {
		beam.setX(e.getX()-30, this);
		repaint();
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
	

