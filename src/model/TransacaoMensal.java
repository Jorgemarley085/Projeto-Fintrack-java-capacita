package model;

import java.util.ArrayList;
import utils.Formatador;

//Subclasse que representa umaa transação recorrente(ex: salario fixo)
public class TransacaoMensal extends Transacao {
    public String diaFixo;
    public int quantidadedeMeses;
    boolean ativa = false;
    ArrayList <Transacao> transacaos;

    @Override
    public String toString() {
        return " |id|: "+id+
                " |tipo|: "+tipo+
                " |valor|: " +Formatador.formatarMoeda(valor)+
                " |Descriçao|: "+descricao+
                " |Dia Fixo|: "+date;
    }
}
