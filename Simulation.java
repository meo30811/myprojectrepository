
public class Simulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		Parkhaus parkhaus = new Parkhaus(10);
		
		Hersteller hersteller = new Hersteller(parkhaus);// Firma BMW
		hersteller.start();
	
		for(int i=1;i<=5; i++)
		{
			Verbraucher verb= new Verbraucher(parkhaus);
			verb.start();
		}
		
		try
		{			
			Thread.sleep(3000);
		}catch(InterruptedException e)
		{}
				
		System.out.println("Ende der Simulation");
	}

}
