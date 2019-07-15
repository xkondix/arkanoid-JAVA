package arkanoid;

import java.awt.geom.Ellipse2D;


public class Ball extends Ellipse2D.Float
{
	
	private int dx,dy;
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
		  
		   if(b.getMinX()<getMaxX() && b.getMinX()>getMinX()){
			   if(b.getMinY()<getCenterY() && b.getMaxY()>getCenterY()){
				   dx=-Math.abs(dx);
				   return true;
			   }
			}
		   		
		   
		    if(b.getMaxX()>getMinX() && b.getMaxX()<getMaxX()){
			   if(b.getMinY()<getCenterY() && b.getMaxY()>getCenterY()){
				   dx=Math.abs(dx);
				   return true;
			   }
		   }
		   
		    if(b.getMinY()<getMaxY() && b.getMinY()>getMinY()){
			   if(b.getMinX()<getCenterX() && b.getMaxX()>getCenterX()){
				   dy=-Math.abs(dx);
				   return true;
			   }
		   }
		   
		    if(b.getMaxY()>getMinY() && b.getMaxY()<getMaxY()){
			   if(b.getMinX()<getCenterX() && b.getMaxX()>getCenterX()){
				   dy=Math.abs(dx);
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
			 
			   if (b.getHp()<1)
			   {
				   board.livesBeam();
				   b.delete();
				   
			   }
		   }
		   
		   
	
		   
		  // if (b.getHp() == 0)
		  // {
			//   int index = board.brickList.indexOf(b);
			//   board.delete(index);
		  // }
	   }
	   

}
