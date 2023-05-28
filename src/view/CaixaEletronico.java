package view;

import javax.swing.JOptionPane;

import controller.Dinheiro;

public class CaixaEletronico {

	public static void main(String[] args) {

		Dinheiro dinheiro = new Dinheiro();
		dinheiro.getNotas();

		int escolha = 0;
		double saldoCaixa = 0;

		int[] valores = dinheiro.getNotas();
		int[] quantidadeNotas = new int[valores.length];

		for (int i = 0; i < valores.length; i++) {
			quantidadeNotas[i] = Integer
					.parseInt(JOptionPane.showInputDialog("Quantidade de notas de R$ " + valores[i]));
		}

		while (escolha != 9) {
			//@formatter:off
			String menu = "Menu Principal\n" 
					+ "1 – Carregar Notas\n"
					+ "2 – Retirar Notas\n" 
					+ "3 – Estatística\n" 
					+ "9 – Fim";
			//@formatter:on
			escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));

			if (escolha < 1 || (escolha > 3 && escolha != 9)) {
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				continue;
			}

			switch (escolha) {
			case 1:
				saldoCaixa = carregar_notas(dinheiro, quantidadeNotas);
				JOptionPane.showMessageDialog(null, "Notas carregadas, valor total no caixa: R$ " + saldoCaixa);
				break;

			case 2:
				saldoCaixa = retirar_notas(dinheiro, quantidadeNotas, saldoCaixa);
				break;

			case 3:
				//
				break;

			case 9:
				break;
			}
		}
	}

	public static double carregar_notas(Dinheiro dinheiro, int[] quantidadeNotas) {
		int saldo = 0;
		int[] valores = dinheiro.getNotas();

		for (int i = 0; i < valores.length; i++) {
			dinheiro.setQtdNotas(quantidadeNotas[i]);
			saldo += valores[i] * quantidadeNotas[i];
		}

		return saldo;
	}

	public static double retirar_notas(Dinheiro dinheiro, int[] quantidadeNotas, double saldo) {
		int valor = -1;
		int[] valores = dinheiro.getNotas();
		int cont = 0;
		while (valor != 0) {
			valor = Integer.parseInt(JOptionPane.showInputDialog(
					"Quantidade a ser retirada em reais, valores entre R$2,00 e R$3000,00 (exceto o valor R$3,00)"));

			if (valor == 3 || valor < 2 || valor > 3000) {
				JOptionPane.showMessageDialog(null, "Valor solicitado inválido.");
				continue;
			}

			if (valor > saldo) {
				JOptionPane.showMessageDialog(null, "Valor não disponível no caixa.");
				continue;
			}
			saldo -= valor;

			while (valor % 5 != 0) {
				valor -= 2;
				cont++;
			}

			for (int i = 0; i < valores.length; i++) {
				if (valor >= valores[i] && quantidadeNotas[i] > 0) {
					int notasRetiradas = Math.min(quantidadeNotas[i], valor / valores[i]);
					quantidadeNotas[i] -= notasRetiradas;
					valor -= notasRetiradas * valores[i];
					JOptionPane.showMessageDialog(null, "Notas de R$ " + valores[i] + ": " + notasRetiradas);
				}
			}
			JOptionPane.showMessageDialog(null, "Notas de R$ " + valores[6] + ": " + cont);
		}

		return saldo;
	}
}
