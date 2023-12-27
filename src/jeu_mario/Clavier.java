package jeu_mario;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clavier implements KeyListener
{

	@Override
	public void keyTyped(KeyEvent e) 
	{
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		//annule le decalage de 1 cree par deplacement
		if(Main.scene.mar.isVivant()==true) 
		{
		
			if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			{
				if(Main.scene.getXpos()==-1)
				{
					Main.scene.setXpos(0);
					Main.scene.setXfond1(-50);
					Main.scene.setXfond2(750);
				}
				Main.scene.mar.setMarche(true);
				Main.scene.mar.setVersdroite(true);
				Main.scene.setDx(1);
			
			}
			else if(e.getKeyCode()==KeyEvent.VK_LEFT)
			{
				if(Main.scene.getXpos()==4601)
				{
					Main.scene.setXpos(4600);
					Main.scene.setXfond1(-50);
					Main.scene.setXfond2(750);
					
				}
				Main.scene.mar.setMarche(true);
				Main.scene.mar.setVersdroite(false);
				Main.scene.setDx(-1);
			}
			
		
		   //mario saure
		   if(e.getKeyCode()==KeyEvent.VK_SPACE)
		   {
			   Main.scene.mar.setSaut(true);
		   }
		}
	 }	

	@Override
	public void keyReleased(KeyEvent e) 
	{
		Main.scene.mar.setMarche(false);
		Main.scene.setDx(0);//remise a 0 de la variable dx de la classe objet scene lors du relachement des touches
	}
	
}
