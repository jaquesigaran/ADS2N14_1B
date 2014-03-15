package com.senac.jogos.cartas;

public class Baralho {
	private Cartas[] cartas = new Cartas[52];
	private int numCartas;

	public Cartas[] getCartas() {
		return cartas;
	}

	public void setCartas(Cartas[] cartas) {
		this.cartas = cartas;
	}

	public int getNumCartas() {
		return numCartas;
	}

	public void setNumCartas(int numCartas) {
		this.numCartas = numCartas;
	}

	public Baralho()
	{
		numCartas = 0;

		char[] naipes = {'C','O','P','E'};

		for (char naipe: naipes)
		{
			for (int valor = 1; valor <= 13; valor++)
			{
				cartas[numCartas] = new Cartas(naipe,valor);
				numCartas++;
			}
		}
	}

	public Cartas drawCarta()
	{
		int carta = (int)(Math.random() * numCartas);
		Cartas sorteada = cartas[carta];

		numCartas--;

		cartas[carta] = cartas[numCartas]; 

		return sorteada;
	}

}
