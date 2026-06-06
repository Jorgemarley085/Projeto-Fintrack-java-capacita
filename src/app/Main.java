//Classe principal com o menu e execução
package app;
import exception.EntradaInvalidaException;
import java.util.Scanner;
import controller.FinTracker;
public class Main {
    public static void main(String[] args){
        FinTracker controller = new FinTracker();
        int opcao = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("ola");
        while (opcao != 5) {
            try {
            System.out.println("""
                    ===== FINTRACK - SEU CONTROLE FINANCEIRO =====
                    1. Adicionar nova transação
                    2. Listar transações
                    3. Mostrar saldo atual
                    4. Remover transação
                    5. Sair
                    """);
            System.out.println("escolha uma opção ");
            opcao = input.nextInt();
            if(opcao<0){
                throw new EntradaInvalidaException("OPÇÂO NAO PODE NEGATIVA");
            }
            switch (opcao) {
                case 1:
                    controller.adicionarTransacao();
                    break;
                case 2:
                    controller.mostrarTransacoes();
                    break;
                case 3:
                    controller.saldoAtual();
                    break;
                case 4:
                    controller.removerTransacao();
                    break;
            }

            }catch(EntradaInvalidaException e){
                System.out.println(e.getMessage());


            }catch (Exception e) {
                System.out.println("insira 1 ou 2  ou 3 ou 4 ou 5!!");
                input.nextLine();
            }
    }
    }
}
