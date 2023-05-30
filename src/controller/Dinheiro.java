
package controller;

public class Dinheiro {

	private int[] notas = { 200, 100, 50, 20, 10, 5, 2 };
	private int qtdNotas;
	private double deposito;
	private double saque;
	private double saldo;

	public Dinheiro() {
		saldo = 0;
	}

	Dinheiro(double deposito) {
		this.deposito += deposito;
	}

	public int[] getNotas() {
		return notas;
	}

	public double getSaldo() {
		saldo -= saque;
		saldo += deposito;
		return saldo;
	}

	public void setSaque(int valor) {
		saque -= valor;
	}

	public double getSaque(double valor) {
		return saque;
	}

	public void setQtdNotas(int qtdNotas) {
		this.qtdNotas = qtdNotas;
	}

	public int getQtdNotas() {
		return qtdNotas;
	}
}
