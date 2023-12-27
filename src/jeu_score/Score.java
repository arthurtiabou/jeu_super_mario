package jeu_score;

public class Score 
{
	private final int nbre_total_pieces=10;
	private int nbre_pieces;
	
	public Score()
	{
		this.nbre_pieces=0;
	}
	//GETTERS AND SETTERS

	public int getNbre_pieces() {return nbre_pieces;}

	public void setNbre_pieces(int nbre_pieces) {this.nbre_pieces = nbre_pieces;}

	public int getNbre_total_pieces() {return nbre_total_pieces;}
	
}
