package ufpb.opcoes;

import ufpb.jogo.JogoFacade;

/**
 * <p>
 * Represents the class of the cards.
 * </p>
 *
 */
public class Carta implements Opcao {

	/**
	 * <p>
	 * Method for the player try to get out of prison with the card Habeas Corpus.
	 * </p>
	 * 
	 * @param jogo JogoFacade
	 * @return boolean
	 */
	@Override
	public boolean fazerOP() {
		JogoFacade jogo = JogoFacade.getInstance();
		if (jogo.JogadorAtual().temCarta()) {
			jogo.JogadorAtual().removeCarta();
			System.out.println(jogo.JogadorAtual() + " usou carta para sair da prisão");
			return true;
		}
		System.out.println("Não tem carta de Habeas corpus");
		return false;
	}

}
