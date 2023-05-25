
package caixaeletronico;


class Dinheiro {
    int valor;
    int quantidade;
    int retirado;
    
    Dinheiro(int valor_dinheiro, int quantidade_dinheiro, int quantidade_retirada){
        valor = valor_dinheiro;
        quantidade = quantidade_dinheiro;
        retirado = quantidade_retirada;
    }

    @Override
    public String toString() {
        return "Dinheiro{" + "valor=" + valor + ", quantidade=" + quantidade + '}';
    }
    
}
