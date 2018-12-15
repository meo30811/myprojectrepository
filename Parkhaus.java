import java.util.Deque;
import java.util.LinkedList;

public class Parkhaus {

	private int maxStellplatz;
	private Object monitor  = new Object();
	
	private Deque<Auto> autos = new LinkedList<Auto>();
	
	public Parkhaus(int maxStellplatz)
	{
		this.maxStellplatz = maxStellplatz;
	}
	
	public void autoHerstellen(Auto auto)
	{
		synchronized(monitor)
		{
			while(autos.size()== maxStellplatz)
			{
				try
				{
					System.out.println("Stellplatz voll warte:"+auto.getName());
					monitor.wait();
				}catch(InterruptedException e)
				{}
			}
			
			System.out.println("Auto herstellen: "+auto.getName());
			autos.addLast(auto);
			monitor.notifyAll();
		}
	}
	public void autoKaufen()
	{
		synchronized(monitor)
		{
			while(autos.size()== 0)
			{
				try
				{
					System.out.println(" kein Auto verfügbar!");
					monitor.wait();
				}catch(InterruptedException e)
				{}
			}
			
			System.out.println("Auto kaufen: "+autos.getFirst().getName());
			autos.pollFirst();
			monitor.notifyAll();
		}
	}
}
