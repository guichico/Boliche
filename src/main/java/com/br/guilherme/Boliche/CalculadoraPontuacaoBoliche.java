package com.br.guilherme.Boliche;

public class CalculadoraPontuacaoBoliche {

	public static int pontuacaoDoJogo(int[] pontuacao) {
		int resultado = 0;
		boolean ehMesmaRodada = false;

		for (int i = 0; i < pontuacao.length; i++) {
			int p = pontuacao[i];

			if(deveSomarPontuacao(i, pontuacao))
				resultado += p;

			// Se essa ou jogada passafa foram strike, não é a mesma rodada
			ehMesmaRodada = p == 10 || i > 0 && pontuacao[i - 1] == 10 ? false : ehMesmaRodada;

			// se foi spare soma bônus da pontuação da próxima rodada 
			if(ehMesmaRodada && p + pontuacao[i - 1] == 10)
				resultado += pontuacao[i + 1];

			// Se foi strike soma bônus da pontuação das duas próximas rodadas 
			if(p == 10 && i < pontuacao.length - 2)
				resultado += pontuacao[i + 1] + pontuacao[i + 2];

			ehMesmaRodada = !ehMesmaRodada;
		}

		return resultado;
	}

	private static boolean deveSomarPontuacao(int i, int[] pontuacao) {
		// Se foi strike na última rodada
		if(pontuacao[pontuacao.length - 3] == 10)
			// Não soma pontuação das últimas duas rodadas, apenas bônus
			if(i == pontuacao.length - 1 || i == pontuacao.length - 2)
				return false;
		// Se é a última jogada
		if(i == pontuacao.length - 1)
			// E a rodada teve um spare, não soma a última pontuação, apenas bônus
			if(pontuacao[i - 1] + pontuacao[i - 2] == 10)			
				return false;

		return true;
	}
}