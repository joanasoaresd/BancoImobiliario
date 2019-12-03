package ufpb.cartas;

import ufpb.jogo.Jogador;
import ufpb.jogo.JogoFacade;


/**
 * <p>
 * This class is a subclass of LuckyOrReves and therefore inherits its
 * attributes from the card's description and position in the Lucky or Setback
 * queue.
 * </p>
 * <p>
 * In addition, its behavior is also inherited, therefore is required to
 * implement the acao method.
 * </p>
 */
public class CartaLancarDados extends SorteOuReves {

	/**
	 * <p>
	 * Constructor method of class CaetaLancarDados.
	 * </p>
	 * 
	 * @param description - A String with representing the description of the action
	 *                    taken by the lucky card or setback - type String
	 * @param posision    - A String with representing the position in the luck or
	 *                    setback queue.
	 */
	public CartaLancarDados(String descricao, String valor) {
		super(descricao, valor);
	}

	/**
	 * <p>
	 * This method implement the method acao, therefore it must realize a action
	 * with base in your type and description.
	 * </p>
	 * <p>
	 * It is possible for the current player to roll the dice again.
	 * </p>
	 * 
	 * @param jogo - JogoFacade
	 */
	@Override
	public void acao(Jogador j) {
		j.jogada(j.lancaDado(), j.lancaDado(),JogoFacade.getInstance());
	}

}
