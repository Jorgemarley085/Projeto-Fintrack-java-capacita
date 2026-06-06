package controller;
import model.Transacao;
import app.Main;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import exception.EntradaInvalidaException;
import model.TransacaoMensal;
//Logica principal para gerenciar as transações
public class FinTracker {

    Main menu = new Main();
    Transacao transacao = new Transacao();
    public double adicionarTransacao;
    private String tipoDaTransacao;

    public ArrayList<Transacao> transacoes = new ArrayList<>();
    public double calcularSaldoTotal;
    public int removerTransacao;
    Scanner input2 = new Scanner(System.in);

    public double total = 0;

    public void adicionarTransacao() {
        this.adicionarTransacao = adicionarTransacao;
        Transacao transacao = new Transacao();
        System.out.println("""
                1 - adicionar transação comum 
                2 - adicionar transação mensal
                """);

        try {
            int opcao = input2.nextInt();
            input2.nextLine();
            if(opcao!=1 && opcao!=2){
                throw new EntradaInvalidaException("INSIRA 1 OU 2");

            }

            if (opcao == 1) {
                System.out.println("insira o tipo (receita/despesa): ");
                transacao.tipo = input2.nextLine();
                transacao.tipo=transacao.tipo.toLowerCase();
                if(!transacao.tipo.equals("receita") && !transacao.tipo.equals("despesa")){
                    throw new EntradaInvalidaException("insira somente Receita ou Despesa");
                }

                System.out.println("insira o valor: ");
                transacao.valor = input2.nextDouble();
                if (transacao.valor < 0) {
                    throw new EntradaInvalidaException("valor nao pode ser negativo");
                }
                input2.nextLine();
                System.out.println("insira a descrição");
                transacao.descricao = input2.nextLine();
                System.out.println("insira a data no formato dd/MM/yyyy");
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                transacao.data = input2.nextLine();
                transacao.date = LocalDate.parse(transacao.data, formato);

                transacoes.add(transacao);
                System.out.println("Transação adicionada com sucesso!!");


            } else if (opcao == 2) {

                TransacaoMensal transacaoMensal = new TransacaoMensal();
                System.out.println("insira o tipo (receita/despesa): ");
                transacaoMensal.tipo = input2.nextLine();
                transacaoMensal.tipo=transacaoMensal.tipo.toLowerCase();
                if(!transacaoMensal.tipo.equals("receita") && !transacaoMensal.tipo.equals("despesa")){
                    throw new EntradaInvalidaException("insira somente Receita ou Despesa");
                }
                System.out.println("insira o valor: ");
                transacaoMensal.valor = input2.nextDouble();
                if (transacaoMensal.valor < 0) {
                    throw new EntradaInvalidaException("valor nao pode ser negativo");
                }
                input2.nextLine();
                System.out.println("insira a descrição");
                transacaoMensal.descricao = input2.nextLine();
                System.out.println("insira a data no formato dd/MM/yyyy");
                DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                transacaoMensal.diaFixo = input2.nextLine();
                transacaoMensal.date = LocalDate.parse(transacaoMensal.diaFixo, formato);


                transacoes.add(transacaoMensal);
                System.out.println("Transação adicionada com sucesso!!");
            }
        } catch(EntradaInvalidaException e){
            System.out.println(e.getMessage());

        }catch (Exception e){
            System.out.println("DATA OU ENTRADA INVALIDA");
        }

    }
    public double somenteReceita() {
         double saldo = 0;

        for (int i = 0; i < transacoes.size(); i++) {
            model.Transacao t = transacoes.get(i);
            if (t.tipo.equals("receita")) {
                saldo += t.valor;

            }
        }
        return saldo;
    }
    public double somenteDespesas(){
        double despesas = 0;
        for (int i = 0 ;i<transacoes.size();i++){
            Transacao t = transacoes.get(i);
            if (t.tipo.equals("despesa")) {
                despesas += t.valor;
            }
        }
        return despesas;
    }



    public void saldoAtual(){
        try {
            System.out.println("voce quer saldo da receita(1) ou saldo das despesas(2) ou ambos(3)");
            int opcao = input2.nextInt();
            if (opcao >3 || opcao<1){
                throw new EntradaInvalidaException("nao pode ser valor negativo ou maior 3");
            }
            if (opcao==1){
                System.out.println(somenteReceita());
            }else if(opcao==2){
                System.out.println(somenteDespesas());
            }else{
                total = somenteReceita()-somenteDespesas();
                System.out.println(total);

            }

        }catch (EntradaInvalidaException e){
            System.out.println("Entrada invalida insira 1(receita) ou 2(despesas) ou 3(ambos)");

        }
    }
    public void mostrarTransacoes(){
        for(int i=0;i<transacoes.size();i++){
            System.out.println(transacoes.get(i));

        }
    }
    public void removerTransacao(){
        try {
            System.out.println("insira o ID para remover a transação");
            boolean encontrou = false;
            int entrada = input2.nextInt();
            if (entrada<0){
                throw new EntradaInvalidaException("ID NAO PODE SER NEGATIVO");
            }
            for(int i=0;i<transacoes.size();i++) {
                Transacao t = transacoes.get(i);
                if (entrada == t.id) {
                    transacoes.remove(i);
                    encontrou = true;
                    System.out.println("removido com sucesso");
                    break;
                }
            System.out.println("ID NAO ENCONTRADO");


            }
        }catch (EntradaInvalidaException e) {

            System.out.println("insira um numero inteiro do ID nao STRING");


        }

    }
}
