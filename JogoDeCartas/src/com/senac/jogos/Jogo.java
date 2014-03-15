package com.senac.jogos;

import java.util.Scanner;

import com.senac.jogos.cartas.Baralho;
import com.senac.jogos.cartas.Cartas;

public class Jogo {

	private static Jogador[] jogador = new Jogador[4];
	static Baralho baralho = new Baralho();
	static Cartas cartas = new Cartas((char) 0, 0);
	private static char oldNaipe;
	private static int oldValor;
	private static int[] contador = new int[4];

	public Jogo() {
		for (int i = 0; i < jogador.length; i++) {
			jogador[i] = new Jogador();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		virarCarta();

		for (int i = 0; i < baralho.getNumCartas(); i++) {

			for (int j = 0; j < jogador.length; j++) {
				System.out
						.println("O que deseja fazer? \n 1 Virar uma carta; \n 2 Passar a vez;");
				int opcao = sc.nextInt();

				if(opcao == 2){
					contador[j] = 1;					
				}
				
				if (opcao == 1) {
					virarCarta();
					if (compararCartas(cartas.getNaipe(), cartas.getValor()) > 0) {
						jogador[j].addPontos(compararCartas(cartas.getNaipe(),
								cartas.getValor()));
					} else {
						jogador[j].subtractPontos(2);
					}

				}
				if (opcao == 2) {
					if(contador[j] >= 1){
						System.out.println("Você já passou na rodada anterior\n");
						virarCarta();
						if (compararCartas(cartas.getNaipe(), cartas.getValor()) > 0) {
							jogador[j].addPontos(compararCartas(cartas.getNaipe(),
									cartas.getValor()));
						} else {
							jogador[j].subtractPontos(2);
						}
					}else{
						jogador[j].subtractPontos(1);
					}

				}

			}
		}

	}

	private static void virarCarta() {
		oldNaipe = cartas.getNaipe();
		oldValor = cartas.getValor();
		baralho.drawCarta();
		System.out.println(cartas.getNaipe() + "" + cartas.getValor());
	}
	
	public void jogar(){
		
	}

	public static int compararCartas(char naipe, int valor) {
		int retorno = 0;
		if (oldNaipe == naipe) {
			retorno = 1;
		} else if (oldValor == valor) {
			retorno = 4;
		} else {
			retorno = -2;
		}

		return retorno;

	}

}
