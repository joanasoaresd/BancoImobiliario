package ufpb.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ufpb.cartas.HabeasCorpus;
import ufpb.cartas.Pague;
import ufpb.cartas.Presente;
import ufpb.cartas.Receba;
import ufpb.cartas.SorteOuReves;
import ufpb.cartas.VaPrisao;
import ufpb.jogo.Jogador;
import ufpb.jogo.JogoFacade;

public class CartasTest {
	/**
	 * 
	 * attributes to use in card tests
	 * @author joana
	 */
	private SorteOuReves carta;
	private Jogador jogador;
	private JogoFacade jogo;


	/**
	 * 
	 *method that initializes the attributes to be tested on cards
	 * @author joana
	 */
	@Before
	public void setUp() {
		this.jogo = JogoFacade.getInstance();
		this.jogador = new Jogador("Joana", "azul");
		this.jogo.addJogador(new Jogador("Clebson","rosa"));
	}
	
	/**
	 * 
	 *method that resets the game to be tested due to the pattern singleton
	 * @author joana
	 */
	@After
	public void setDown() {
		this.jogo.reset();
	}
	
	/**
	 * 
	 *method testing action of habeas corpus card
	 * @author joana
	 */
	@Test
	public void testHabeasCorpus() {
		this.carta = new HabeasCorpus("Descrição", "2");
		carta.acao(jogador);
		assertTrue("Testando", jogador.temCarta());
	}
	

	/**
	 * 
	 *method testing action of Pague card
	 * @author joana
	 */
	@Test
	public void testPague() {
		this.carta = new Pague("Descrição", "100");
		carta.acao(jogador);
		assertEquals("Testando Pague", 1400, jogador.getSaldo());
	}

	/**
	 * 
	 *method testing action of Presente card
	 * @author joana
	 */
	@Test
	public void testPresente() {
		this.carta = new Presente("Descrição", "50");
		carta.acao(jogador);
		assertEquals("Testando Presente com 2 jogadores na partida",1550,jogador.getSaldo());
	}
	
	/**
	 * 
	 *method testing action of Receba card
	 * @author joana
	 */
	@Test
	public void testReceba() {
		this.carta = new Receba("Descrição","50");
		carta.acao(jogador);
		assertEquals("Testando Recebendo de 1 jogador",1550,jogador.getSaldo());
	}
	
	/**
	 * 
	 *method testing action of VáPrisão card
	 * @author joana
	 */
	@Test
	public void testVaPrisao() {
		this.carta = new VaPrisao("Descrição","0");
		carta.acao(jogador);
		assertTrue(jogo.verificarSeTaNaPrisao(jogador));

	}
	
	

}
