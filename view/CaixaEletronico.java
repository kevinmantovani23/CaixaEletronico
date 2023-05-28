package caixaeletronico;

import javax.swing.JOptionPane;
import java.io.*;

public class CaixaEletronico {

    public static void main(String[] args) {
        int escolha = 0, i, SaldoCaixa = 0;
        Dinheiro[] notas = new Dinheiro[7];
        int valores[] = {200, 100, 50, 20, 10, 5, 2};
        for (i = 0; i < valores.length; i++) {
            notas[i] = new Dinheiro(valores[i], 0, 0);
        }

        while (escolha != 9) {
            escolha = Integer.parseInt(JOptionPane.showInputDialog("Menu Principal\n"
                    + "1 – Carregar Notas\n"
                    + "2 – Retirar Notas\n"
                    + "3 – Estatística\n"
                    + "9 – Fim "));
            if (escolha != 1 && escolha != 2 && escolha != 3 && escolha != 9) {
                System.out.print("\nOpção inválida!");
                continue;
            }
            switch (escolha) {
                case 1:
                    SaldoCaixa = SaldoCaixa + carregar_notas(notas);
                    System.out.print("\nNotas carregadas, valor total no caixa: R$ " + SaldoCaixa);
                    break;

                case 2:
                    SaldoCaixa = retirar_notas(notas, SaldoCaixa);
                    break;

                case 3:
                    //
                    break;

                case 9:
                    break;
            }
        }
    }

    public static int carregar_notas(Dinheiro[] notas) {
        // 2, 5, 10, 20, 50, 100, 200 << valor das notas <<
        int i;
        int saldo = 0;
        for (i = 0; i < notas.length; i++) {
            notas[i].quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de notas de " + notas[i].valor + ":"));
            saldo = saldo + (notas[i].quantidade * notas[i].valor);
        }
        return saldo;
    }

    public static int retirar_notas(Dinheiro[] notas, int saldo) {
        int valor=1, i;
        while (valor != 0) {
            valor = Integer.parseInt(JOptionPane.showInputDialog("Quantidade a ser retirada em reais, valores entre R$2,00 e R$3000,00 (exceto o valor R$3,00)"));
            if (valor == 3 || valor < 2 || valor > 3000) {
                System.out.print("\nValor solicitado inválido.");
                continue;
            }
            if (valor > saldo) {
                System.out.print("\nValor não disponível no caixa.");
                continue;
            }saldo = saldo - valor;
            for (i = 0; valor >0; i++) {
                while (valor % 5 != 0){
                    notas[6].retirado++;
                    notas[6].quantidade = notas[6].quantidade - notas[6].retirado;
                    valor = valor - (notas[i].retirado * notas[i].valor);
                }
                notas[i].retirado = valor / notas[i].valor;
                notas[i].quantidade = notas[i].quantidade - notas[i].retirado;
                valor = valor - (notas[i].retirado * notas[i].valor);
                System.out.print("\nNotas de R$ "+ notas[i].valor+": "+ notas[i].retirado);
            }
        }
        return(saldo);
    }
}
