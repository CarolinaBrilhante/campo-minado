package br.com.arjos.cm;

import br.com.arjos.cm.modelo.Tabuleiro;
import br.com.arjos.cm.visao.TabuleiroConsole;

public class Aplicacao {

	public static void main(String[] args) {
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6);
		new TabuleiroConsole(tabuleiro);
		
	}
		
}
