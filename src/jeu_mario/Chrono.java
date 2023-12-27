package jeu_mario;

public class Chrono implements Runnable
{
	private final int pause=3;//temps d'attente entre deux tours de boucle
	@Override
	public void run() 
	{
		while(true)
		{
			//System.out.println("ok");
			Main.scene.repaint();
			try {Thread.sleep(pause);} 
			
			catch (InterruptedException e) {}
		}
		
	}
	
}
