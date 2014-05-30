package com.senac;

import com.senac.commands.Commands;

public class TravessiaDeserto {

	public static final int MAP_SIZE = 10;
	public static final int MAX_FUEL = 6;

	public static final java.util.Scanner sc = new java.util.Scanner(System.in);

	private int[] map;
	private int fuel;
	private int pos;

	public static void main(String[] args) {
		(new TravessiaDeserto()).run();
	}

	/**
	 * inicializa o jogo
	 */
	public void run() {
		initGame();
		do {
			printStatus();
			int cmd = translateCommand(sc.next());
			processCommand(cmd);
		} while (!isGameOver());

		System.out.println(getEndMessage());
	}

	/**
	 * retorna a mensagem caso o usuário tenha vencido ou perdido o jogo
	 * 
	 * @return
	 */
	public String getEndMessage() {
		if (isWinner())
			return "Voce GANHOU!";
		else
			return "Voce PERDEU.";
	}

	/**
	 * verifica se o usuário venceu ou perdeu o jogo
	 * 
	 * @return
	 */
	public boolean isGameOver() {
		if (isWinner())
			return true;
		if (fuel == 0 && map[pos] == 0)
			return true;
		return false;
	}

	/**
	 * verifica a condição para ganhar o jogo
	 * 
	 * @return
	 */
	public boolean isWinner() {
		return pos == MAP_SIZE;
	}

	/**
	 * inicialização dos atributos do jogo
	 */
	public void initGame() {
		pos = 0;
		fuel = MAX_FUEL;
		map = new int[MAP_SIZE];
	}

	/**
	 * imprime o status atual do jogo
	 */
	public void printStatus() {
		System.out.println(String.format("Voce esta na posicao %d.", pos));
		System.out.println(String.format(
				"Voce possui %d unidades de combustivel.", fuel));
		if (pos > 0)
			System.out.println(String.format(
					"Existem %d unidades de combustivel nessa posicao.",
					map[pos]));
	}

	/**
	 * retorna o codigo do comando selecionado
	 * 
	 * @param command
	 * @return
	 */
	public int translateCommand(String command) {
		String cmd = command.toLowerCase();
		if (cmd.equals("avancar"))
			return Commands.AVANCAR;
		if (cmd.equals("voltar"))
			return Commands.VOLTAR;
		if (cmd.equals("carregar"))
			return Commands.CARREGAR;
		if (cmd.equals("descarregar"))
			return Commands.DESCARREGAR;
		if (cmd.equals("ajuda"))
			return Commands.AJUDA;
		return Commands.ERROR;
	}

	/**
	 * responsável pela chamada do método a ser executado
	 * 
	 * @param command
	 */
	public void processCommand(int command) {
		switch (command) {
		case Commands.AVANCAR:
			avancar();
			break;
		case Commands.VOLTAR:
			voltar();
			break;
		case Commands.CARREGAR:
			carregar();
			break;
		case Commands.DESCARREGAR:
			descarregar();
			break;
		case Commands.AJUDA:
			ajuda();
			break;
		default:
			System.err.println(Commands.INVALID_COMMAND);
		}
	}

	/**
	 * responsável por auxiliar o usuário na escolha dos comandos a serem
	 * executados
	 */
	public void ajuda() {
		System.out.println("Comandos: avancar voltar carregar descarregar ajuda");
	}

	/**
	 * descarregar combustivel no local atual do mapa
	 */
	public void descarregar() {
		if (fuel > 0) {
			fuel--;
			map[pos]++;
		}
	}

	/**
	 * carregar o combustível para o caminhão
	 */
	public void carregar() {
		if (map[pos] > 0) {
			map[pos]--;
			fuel++;
		} else if (map[pos] == 0 && fuel <= 6) {
			fuel++;
		}
	}

	/**
	 * valida se não está na posição inicial e se há combustível para retornar
	 */
	public void voltar() {
		if (fuel > 0 && pos > 0) {
			fuel--;
			pos--;
		}
		if (pos == 0)
			fuel = MAX_FUEL;
	}

	/**
	 * valida se possui combustivel e avança
	 * 
	 * @return
	 */
	public void avancar() {
		if (fuel > 0) {
			fuel--;
			pos++;
		}
	}

	/**
	 * retornar o valor do combustível
	 * 
	 * @return
	 */
	public int getFuel() {
		return this.fuel;
	}

	/**
	 * retorna a posicao
	 * 
	 * @return
	 */
	public int getPos() {
		return this.pos;
	}

	/**
	 * retorna o mapa
	 * 
	 * @return
	 */
	public int[] getMap() {
		return this.map;
	}

}
