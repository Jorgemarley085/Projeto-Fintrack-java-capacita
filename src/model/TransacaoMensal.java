package model;

import java.util.ArrayList;

//Subclasse que representa umaa transação recorrente(ex: salario fixo)
public class TransacaoMensal extends Transacao {
    public String diaDopagamento;
    public int quantidadedeMeses;
    boolean ativa = false;
    ArrayList <Transacao> transacaos;

    @Override
    public String toString() {
        return "id: "+id+
                "tipo: "+tipo+
                "valor: " +valor+
                "Descriçao: "+descricao+
                "Dia Fixo: "+diaDopagamento;
    }
}
