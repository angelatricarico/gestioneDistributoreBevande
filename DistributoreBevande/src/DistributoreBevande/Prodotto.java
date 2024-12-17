package DistributoreBevande;



public class Prodotto {
String nome; 
String cat;
double prezzo;
int quantita;

 Prodotto(String nome, String cat, double prezzo, int quantita) {
	this.nome = nome;
	this.cat = cat;
	this.prezzo = prezzo;
	this.quantita = quantita;
}
	public  String getnome() {
		return nome;}
	public  String getcat() {
		return cat;}
	public  double getprezzo() {
		return prezzo;}
	public  int quantita() {
		return quantita;}
	
public void setprezzo(int prezzo) {this.prezzo = prezzo;}
public void setquantita(int quantita) {this.quantita = quantita;}
public void riduciquantita() {if (quantita > 0) {quantita--;}
}



public String toString() 
{
	return "nome: " + nome + " - " + "categoria:" + cat + " - prezzo €" + prezzo + " - " + " quantità " + quantita ; 
}

}

