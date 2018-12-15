import java.util.Random;

public class Hersteller extends Thread {

	private Parkhaus parkhaus;
	private static int kennzeichen = 1;
	
	public Hersteller(Parkhaus parkhaus)
	{
		this.parkhaus = parkhaus;
		
	}	
	public void run()
	{
		Random prodzeit = new Random();
		
		while(true)
		{
			Auto auto = new Auto("R-FH "+kennzeichen++);
			parkhaus.autoHerstellen(auto);
			try
			{
				Thread.sleep(prodzeit.nextInt(1000));
			}catch(InterruptedException e){}
		}
	}
}
