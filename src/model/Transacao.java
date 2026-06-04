package model;

import java.time.LocalDate;

//Classe base para qualquer tipo de transção
public class Transacao {
    public String descricao;
    public double valor;
    public boolean ehReceita;
    public LocalDate date; //O formato padrão de exibição do LocalDate é o ISO-8601 (AAAA-MM-DD). Para converter uma data em texto ou ler uma data a partir de texto (String), usa-se o DateTimeFormatter:De String para LocalDate:LocalDate data = LocalDate.parse("2026-05-23");
     public String tipo;
     public static int contadorId=0;
     public int id =0;
     public Transacao(){
         contadorId++;
         this.id=contadorId;
     }
    public String data;
    @Override
    public String toString() {
        return "id: "+id+
                "Tipo: " + tipo +
                " Valor: " + valor +
                " Descrição: " + descricao;
    }



}
