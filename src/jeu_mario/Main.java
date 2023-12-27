package jeu_mario;

import javax.swing.JFrame;

public class Main 
{
	public static Scene scene;
	
	public static void main(String[] args)
	{
		//conteneur de l'application
		JFrame fen=new JFrame("jeu style mario");
		fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fen.setSize(700, 390);
		fen.setLocationRelativeTo(null);
		fen.setResizable(false);
		fen.setAlwaysOnTop(true);
		
		scene=new Scene();
		fen.setContentPane(scene);
		fen.setVisible(true);
	}
}
