package gerenciamente;
import java.util.Scanner;
public class Principal {

	 public static void main(String[] args) {
		 int opcao;
			Estacionamento estacionamento = new Estacionamento();
		 Scanner scan = new Scanner(System.in);
		 System.out.println("Bem vindo ao Sistema de Gerenciamento de Estacionamento");
	        do {
	        	System.out.println("=================================");
	            System.out.println("1 - Cadastrar Vaga");
	            System.out.println("2 - Cadastrar Veículo");
	            System.out.println("3 - Registrar Entrada");
	            System.out.println("4 - Registrar Saída");
	            System.out.println("5 - Gerar Relatório");
	            System.out.println("6 - Exibir Histórico de Permanência");
	            System.out.println("7 - Sair do Sistema");
	            System.out.println("=================================");
	            System.out.println("Escolha uma opção: ");
	            opcao = scan.nextInt();
	            scan.nextLine(); 

	            if (opcao == 1) {
	                estacionamento.cadastrarVaga();
	            } else if (opcao == 2) {
	                estacionamento.cadastrarVeiculo();
	            } else if (opcao == 3) {
	                System.out.print("Digite a placa do veículo para registrar a entrada: ");
	                String placaEntrada = scan.nextLine();
	                estacionamento.registrarEntrada(placaEntrada);
	            } else if (opcao == 4) {
	                System.out.print("Digite a placa do veículo para registrar a saída: ");
	                String placaSaida = scan.nextLine();
	                estacionamento.registrarSaida(placaSaida);
	            } else if (opcao == 5) {
	                estacionamento.gerarRelatorio();
	            } 
	            else if (opcao == 6) {
	            	estacionamento.exibirHistorico();
	            }
	            else if (opcao == 7) {
	                System.out.println("Saindo do sistema...");
	            } else {
	                System.out.println("Opção inválida! Tente novamente.");
	            }

	        } while (opcao != 7);
	        System.out.println("Sistema fechado, até logo!");
	 }
}
