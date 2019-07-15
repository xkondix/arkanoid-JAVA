package arkanoid;

import java.util.ArrayList;







public class Heart extends Thread {
	
	Beam beam;
	ArrayList<Beam> brickList = new ArrayList();
	Board board;
	Ball ball;
	Time time;
	
	
	
	
	
	public Heart(ArrayList<Beam> brickList, Beam beam, Board board, Ball ball)
	{
		super();
		this.board=board;
		this.beam=beam;
		this.brickList=brickList;
		this.ball=ball;
		startTime();
		start();
		
		
       
		
	}
	
	public void startTime()
	{
		time = new Time(board);
		time.start();
	}
	
	
	
	
	public String timing()
	{	
		return Integer.toString(time.secound);
	}
	
	
	 public void run()                   
	   {                                  
	      try                             
	      {                               
	         while(board.game() )                  
	         {   
		        sleep(8);

		        ball.motion();
 
	            sleep(5);
	            ball.contact(beam);
	            sleep(5);
	            for (int i = 0; i < Board.countBeam; i++){
	            	ball.delete(brickList.get(i));
	            }
	            
	            

	            
	         }                            
	      }                               
	      catch(InterruptedException e){} 
	   }      

}
