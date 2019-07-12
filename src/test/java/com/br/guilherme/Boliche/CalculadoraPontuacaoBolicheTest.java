package com.br.guilherme.Boliche;

import static com.br.guilherme.Boliche.CalculadoraPontuacaoBoliche.pontuacaoDoJogo;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculadoraPontuacaoBolicheTest {

	@Parameter(value = 0)
	public int[] jogadas;	
	@Parameter(value = 1)
	public int total;	
	@Parameter(value = 2)
	public String nome;

	@Parameters(name="{2}")
	public static Collection<Object[]> getParameters() {
		return Arrays.asList(new Object[][] {
			{new int[]{1, 4, 4, 5, 5, 4, 5, 3, 9, 0, 1, 7, 3, 6, 4, 4, 2, 7, 6, 3}, 83, "Exemplo Jogo Sem Bônus"},
			{new int[]{1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6}, 133, "Exemplo Jogo Completo"},
			{new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 2, 3, 0, 0}, 20, "Exemplo Strike"},
			{new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 8, 2, 3, 0, 0}, 17, "Exemplo Spare"},
			{new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, 300, "Exemplo Jogo Perfeito"}
		});
	}

	@Test
	public void testaPontuacaoDoJogo() {
		int totalJogo = pontuacaoDoJogo(jogadas);
		
		assertEquals(total, totalJogo);
	}
}
