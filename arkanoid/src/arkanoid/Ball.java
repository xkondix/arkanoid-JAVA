package arkanoid;

import java.awt.geom.Ellipse2D;


public class Ball extends Ellipse2D.Float
{
	
	
	private int dy,dx;
	private Board board;

	Ball(Board board,int x,int y,int dx,int dy)
	{
		this.board=board;
		this.dx=dx;
		this.dy=dy;
		this.x=x;
		this.y=y;
		
		this.width=10;                          
	    this.height=10;
			
		
	}
	
	void motion()
	{
		x+=dx;
		y+=dy;
		
		if(getMinX()<0 || getMaxX()>board.getWidth())  dx=-dx; 
	    if(getMinY()<0 ) dy=-dy; 
	    if(getMaxY()>board.getHeight() && board.getHeight() !=0 && getMaxY() !=141 )
	    {
	    	board.game(false);
	    	x=180;
	    	y=130;
	    }
	    
	    if(board.getLivesBeam()==0)
	    {
	    	board.game(false);
	    }
	 
	    board.repaint(); 
	}
	
	 boolean contact(Beam b){
		  
		   
		   //up
		    if(b.getMinY()<getMaxY()+dy && b.getMinY()>getMinY()+dy){
				   if(b.getMinX()+dx<getCenterX() && b.getMaxX()>getCenterX()+dx){
					   dy=-Math.abs(dx);
					   return true;
				   }
			   }
			 
		    //bottom
		    if(b.getMaxY()>getMinY()+dy && b.getMaxY()<getMaxY()+dy){
				   if(b.getMinX()<getCenterX()+dx && b.getMaxX()>getCenterX()+dx){
					   dy=Math.abs(dx);
					   return true;
				   }
			   }
			    
		    //left
		    if(b.getMinX()<getMaxX()+dx && b.getMinX()>getMinX()+dx){
				   if(b.getMinY()<getCenterY()+dy && b.getMaxY()>getCenterY()+dy){
					   dx=-Math.abs(dx);
					   return true;
				   }
				}
			
				   		
		    	//right
				  if(b.getMaxX()>getMinX()+dx && b.getMaxX()<getMaxX()+dx){
					 if(b.getMinY()<getCenterY()+dy && b.getMaxY()>getCenterY()+dy){
						   dx= Math.abs(dx);
						   return true;
					   }
				   }
				 
			  
			    
		   
		   board.repaint();
		   return false;
	   }
	 
	   void delete(Beam b)
	   {
		   if(this.contact(b))
		   {
			   
			   b.setHp();
			   
			   try {
					Thread.sleep(10); //to test collision set 1000
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
			   
			   if (b.getHp()<1)
			   {
				   board.livesBeam();
				   b.delete();
				   
				 	
			   }
		   }
		   
		   
	   }
	   

}
