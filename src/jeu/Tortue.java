package jeu;

import java.awt.Image;

import javax.swing.ImageIcon;

import jeu_objet.objet;

public class Tortue extends personnage implements Runnable
{
	private Image imgtortue;
	private ImageIcon icotortue;
	
	private final int pause=15;//temps d'attente de 02 tours de boucle
	private int dxtortue;//pas de deplacement de la tortue
	
	public Tortue(int x, int y)
	{
		super(x,y,35,50);
		super.setVersdroite(true);
		super.setMarche(true);
		this.dxtortue=1;
		
		this.icotortue=new ImageIcon(getClass().getResource("/image_mario/tortue_arret_droite.png"));
		this.imgtortue=this.icotortue.getImage();
		
		Thread chronotortue=new Thread(this);
		chronotortue.start();
	}
	//****GETTERS AND SETTERS
	
	public Image getImgtortue() {return imgtortue;}

	public void setImgtortue(Image imgtortue) {this.imgtortue = imgtortue;}

	public ImageIcon getIcotortue() {return icotortue;}

	public void setIcotortue(ImageIcon icotortue) {this.icotortue = icotortue;}

	public int getDxtortue() {return dxtortue;}
	
	public void setDxtortue(int dxtortue) {this.dxtortue = dxtortue;}
	
	//****METHODES DE LA Tortue
	public void bouge()//deplacement de la tortue
	{
		if(super.isVersdroite()==true)
		{this.dxtortue=1;}
		else
		{this.dxtortue=-1;}
		super.setX(super.getX() +this.dxtortue);
	}
	
	public void contact(objet obj)
	{
		if((super.contact_avant(obj)==true && this.isVersdroite()==true))
		{
			super.setVersdroite(false);
			this.dxtortue=-1;
		}
		else if(super.contact_arriere(obj)==true && this.isVersdroite()==false)
		{
			super.setVersdroite(true);
			this.dxtortue=1;
		}
	}
	
	@Override
	public void run() 
	{
		try{Thread.sleep(20);}
		catch (InterruptedException e){}
		
		while(true)
		{
			if(this.vivant==true)
			{
				this.bouge();
				try
				{Thread.sleep(pause);}
				catch (InterruptedException e){}
			}
			
		}
		
	}
	public void contact(personnage personnage)
	{
		if(super.contact_avant(personnage)==true && this.isVersdroite()==true)
		{
			super.setVersdroite(false);
			this.dxtortue=-1;
		}
		else if(super.contact_arriere(personnage)==true && this.isVersdroite()==false) 
		{
			super.setVersdroite(true);
			this.dxtortue=1;
		}
	}
	
	public Image meurt()
	{
		String str;
		ImageIcon ico;
		Image img;
		
		
		
		if(this.isVersdroite()==true)
		{str="/image_mario/tortue_ecrase_droite.png";}
		else
		{str="/image_mario/tortue_ecrase_gauche.png";}
		
		ico=new ImageIcon(getClass().getResource(str));
		img=ico.getImage();
		return img;
	}

}
