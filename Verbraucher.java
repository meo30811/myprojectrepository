import java.util.Random;

public class Verbraucher extends Thread {

	private Parkhaus parkhaus;
	
	public Verbraucher(Parkhaus parkhaus)
	{
		this.parkhaus = parkhaus;
		
	}
	
	public void run()
	{
		Random kaufzeit = new Random();
		while(true)
		{
			parkhaus.autoKaufen();
			try
			{
				Thread.sleep(kaufzeit.nextInt(1000));
			}catch(InterruptedException e){}
		}
	}
}
