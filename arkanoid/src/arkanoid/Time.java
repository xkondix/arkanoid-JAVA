package arkanoid;

import java.util.Timer;
import java.util.TimerTask;


public class Time {
	
	Board board;
	public Boolean t = true;


	int secound=0;

	Timer timer = new Timer();
	TimerTask task = new TimerTask()
		{
		public void run()
		   {
			secound++;
			
			if(secound%board.getLvl()==0 && t)
			{
				System.out.println(secound);
				System.out.println(t);
				board.setNew();
			    board.riseExit();
			}
			
			if(!board.game())
			{
				cancel();
				
			}
			
		   }
		};


	
		
		public Time(Board board)
		{
			this.board=board;
		}
		
		
		
		
		public void start() {
			timer.scheduleAtFixedRate(task, 1000, 1000);
		}

		
		public static void main(String[] args)
		{
			
		}
		
}

