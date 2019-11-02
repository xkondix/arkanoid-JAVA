package arkanoid;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Beam extends Rectangle2D.Float {
	
	private int hp;
	private boolean flaga = true;
	Random generator = new Random();
	


	public Beam()
	{
		this.x=0;       
	    this.y=0;     
	    this.width=0;  
	    this.height=0; 
	    this.hp=generator.nextInt(3)+1;
	}
	
	public Beam(int x, int y, int width, int height)       
	   {                  
	      this.x=x;       
	      this.y=y;     
	      this.width=width;  
	      this.height=height;
	   } 
	
	
	void set(int x, int y, int width, int height)
	{
		this.x=x;       
	    this.y=y;     
	    this.width=width;  
	    this.height=height; 
	    
	}
	
	void delete()
	{
		this.x=0;       
	    this.y=0;     
	    this.width=0;  
	    this.height=0;
	}
	
	void setHp()
	{
		this.hp=hp-1;
		
	}
	
	int getHp()
	{
		return hp;
	}

	
	void setX(int x, Board p) 
	{  
		  int X = x;
		  if (X < 0)
			  {
			  X = 0;
			  }
		  else if (X+width > p.getWidth())
		  	  {
			  X = (int) (p.getWidth()-width);
		  	  }
	   this.x=X;     
	}  
	
	void changeY()
	{
		this.y+=30;
	}
	
	public double getY()
	{
		return y;
	}
	
	public void stop()
	{
		flaga = false;
		new Thread()
		{
			public void run()
			{
				try {
					Thread.sleep(300);
					flaga = true;	

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
		
	}
	
	public boolean getFlaga()
	{
		return flaga;
	}
	
	
	
	
	
	

}
