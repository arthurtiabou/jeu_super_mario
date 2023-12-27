package jeu_score;

public class Compte_rebout implements Runnable
{
	private final int pause=1000;
	private int compteur_temps;
	private String str;
	
	public Compte_rebout()
	{
		this.compteur_temps=100;
		this.str="Temps restant:100";
		Thread compteur_rebout=new Thread(this);
		compteur_rebout.start();
	}
	
	
	public int getCompteur_temps() {return compteur_temps;}


	public void setCompteur_temps(int compteur_temps) {this.compteur_temps = compteur_temps;}


	public String getStr() {	return str;}


	public void setStr(String str) {this.str = str;}


	public int getPause() {return pause;}


	@Override
	public void run() 
	{
		while(true)
		{
			try
			{Thread.sleep(pause);}
			catch(InterruptedException e){}
			
			this.compteur_temps--;
			this.str="Temps restant : "+ this.compteur_temps;
		}
		
	}

}
