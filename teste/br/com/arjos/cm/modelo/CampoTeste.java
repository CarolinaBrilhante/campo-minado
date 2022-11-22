package br.com.arjos.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.arjos.cm.excecao.ExplosaoException;
public class CampoTeste {

	private Campo campo;
	
	@BeforeEach
	void iniciarCampo() {
		campo = new Campo (3, 3);
	}
	
	@Test
	void testeVizinhoDistancia1Esquerda () {
		Campo vizinho = new Campo(3, 2);	
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoDistancia1Direita () {
		Campo vizinho = new Campo(3, 4);	
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoDistancia1Emcima () {
		Campo vizinho = new Campo(2, 3);	
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoDistancia1Embaixo () {
		Campo vizinho = new Campo(4, 3);	
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeVizinhoDistancia2 () {
		Campo vizinho = new Campo(2, 2);	
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertTrue(resultado);
	}
	
	@Test
	void testeNaoVizinho () {
		Campo vizinho = new Campo(1, 1);	
		boolean resultado = campo.adicionarVizinho(vizinho);
		
		assertFalse(resultado);
	}
	
	@Test
	void testeValorPadraoAtributoMarcado() {
		assertFalse(campo.isMarcado());
	}

	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		
		assertTrue(campo.isMarcado());
	}
	
	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		
		assertFalse(campo.isMarcado());
	}
	
	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		
		assertTrue(campo.abrir());
	}

	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		
		assertFalse(campo.abrir());
	}
		
	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		
		assertFalse(campo.abrir());
	}
	
	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	
	}

	@Test 
	void testeAbrirComVizinhos() {
		
		Campo campo11 = new Campo(1,1);
		
		Campo campo22 = new Campo(2,2);
		campo22.adicionarVizinho(campo11);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isAberto());
		
	}
	
	@Test 
	void testeAbrirComVizinhos2() {
		
		Campo campo11 = new Campo(1,1);
		Campo campo12 = new Campo(1,1);
		campo12.minar();
		
		Campo campo22 = new Campo(2,2);
		campo22.adicionarVizinho(campo11);
		campo22.adicionarVizinho(campo12);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.isAberto() && campo11.isFechado());
		
	}
	
	@Test
	void testeGetLinha() {
		campo.getLinha();
	}
	
	@Test
	void testeGetColuna() {
		campo.getColuna();
	}
	
	@Test
	void testeObjetivoAlcancado() {
		Campo campo3 = new Campo(3,4);
		campo3.isAberto();
		campo3.naoMinado();
		Campo campo4 = new Campo(3,2);
		campo4.minar();
		campo4.alternarMarcacao();
							
		campo.adicionarVizinho(campo4);
		campo.adicionarVizinho(campo3);
		
		campo.abrir();
		
		assertTrue(campo.objetivoAlcancado());
	}
	
	@Test
	void testeTemMinasNaVizinhanca() {
		Campo campo5 = new Campo(3,4);
		campo5.minar();
		Campo campo6 = new Campo(4,4);
		Campo campo7 = new Campo(3,2);
		Campo campo8 = new Campo(2,3);
		Campo campo9 = new Campo(2,2);
		campo9.minar();
		
		campo.adicionarVizinho(campo9);
		campo.adicionarVizinho(campo8);
		campo.adicionarVizinho(campo7);
		campo.adicionarVizinho(campo6);
		campo.adicionarVizinho(campo5);
		
		campo.abrir();
	    campo.minasNaVizinhaca();
	   
	    assertTrue(campo.minasNaVizinhaca()>0);
	 } 	
	
	@Test
	void testeReiniciar() {
		campo.minar();
				
		campo.reiniciar();
		
		assertFalse(campo.isAberto());
	}
}
