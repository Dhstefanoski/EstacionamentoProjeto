package gerenciamente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Estacionamento {
	public static Scanner scan = new Scanner(System.in);
List<Vaga> listaVagas = new ArrayList<>();
List<Veiculo> listaVeiculos = new ArrayList<>();
List<Registro> listaRegistros = new ArrayList<>();
public void cadastrarVaga() {
	System.out.println("Digite o número da vaga:");
	int nu = scan.nextInt();
	String tipo = "";
	int n;
	do {
		System.out.println("Digite o número correspondente ao tamanho da vaga:");
		System.out.println("1 - Pequena");
		System.out.println("2 - Média");
		System.out.println("3 - Grande");
		n = scan.nextInt();
		scan.nextLine(); 
		if (n == 1) {
			tipo = "Pequena";
		}
		else if (n == 2) {
			tipo = "Média";
		}
		else if (n == 3) {
			tipo = "Grande";
		}
		else {
			System.out.println("Opção Inválida!");
		}
	} while ((n < 1) && (n > 3));
	Vaga novaVaga = new Vaga(nu, tipo);
	listaVagas.add(novaVaga);
	System.out.println("Vaga cadastrada com sucesso!");
}
public void cadastrarVeiculo() {
	String tipo = "";
	int n;
	System.out.println("Digite a placa do veículo:");
	String placa = scan.nextLine();
	System.out.println("Digite o modelo do veículo:");
	String modelo = scan.nextLine();
	do {
		System.out.println("Digite o número correspondente ao tamanho da veículo:");
		System.out.println("1 - Pequeno");
		System.out.println("2 - Médio");
		System.out.println("3 - Grande");
		n = scan.nextInt();
		scan.nextLine(); 
		if (n == 1) {
			tipo = "Pequena";
		}
		else if (n == 2) {
			tipo = "Média";
		}
		else if (n == 3) {
			tipo = "Grande";
		}
		else {
			System.out.println("Opção Inválida!");
		}
	} while ((n < 1) && (n > 3));
	Veiculo novoVeiculo = new Veiculo(placa, modelo, tipo);
	listaVeiculos.add(novoVeiculo);
	System.out.println("Veiculo cadastrado com sucesso!");
}

public Vaga buscarVaga(int numero) {
	for (Vaga vaga : listaVagas) {
        if (vaga.getNumero() == numero) {
            return vaga;
        }
    }
    return null;
}

public Veiculo buscarVeiculo(String placa) {
	for (Veiculo veiculo : listaVeiculos) {
        if (veiculo.getPlaca() == placa) {
            return veiculo;
        }
    }
    return null;
}

void registrarEntrada(String placa) {
    Veiculo veiculo = listaVeiculos.stream()
            .filter(v -> v.getPlaca().equals(placa))
            .findFirst()
            .orElse(null);

    if (veiculo == null) {
        System.out.println("Veículo não encontrado. Cadastre-o antes de registrar a entrada.");
        return;
    }

    Vaga vagaDisponivel = listaVagas.stream()
            .filter(v -> v.isDisponivel() && v.getTamanho().equalsIgnoreCase(veiculo.getTamanho()))
            .findFirst()
            .orElse(null);

    if (vagaDisponivel == null) {
        System.out.println("Nenhuma vaga disponível para o tamanho do veículo.");
    } else {
        veiculo.setHorarioEntrada(LocalDateTime.now());
        vagaDisponivel.setVeiculo(veiculo);
        vagaDisponivel.setDisponivel(false);
        listaRegistros.add(new Registro(veiculo, vagaDisponivel, LocalDateTime.now(), null));
        System.out.println("Entrada registrada. Vaga " + vagaDisponivel.getNumero() + " ocupada.");
    }
}

void registrarSaida(String placa) {
    Registro registro = listaRegistros.stream()
            .filter(r -> r.getVeiculo().getPlaca().equals(placa) && r.getHoraSaida() == null)
            .findFirst()
            .orElse(null);

    if (registro != null) {
        LocalDateTime horaSaida = LocalDateTime.now();
        registro.setHoraSaida(horaSaida);
        Vaga vaga = registro.getVaga();
        vaga.liberar(vaga);
        double valor = registro.calcularValor();
        System.out.printf("Saída registrada. Tempo: %.2f horas, Valor a pagar: R$ %.2f%n", registro.getHorasEstacionado(), valor);
    } else {
        System.out.println("Registro de entrada não encontrado para esta placa.");
    }
}

void gerarRelatorio() {
    System.out.println("Relatório de Vagas Ocupadas:");
    listaVagas.stream()
            .filter(v -> !v.isDisponivel())
            .forEach(v -> System.out.println(v));
}

public void exibirHistorico() {
    System.out.println("Histórico de Permanência dos Veículos:");

    for (Registro registro : listaRegistros) {
        if (registro.getHoraSaida() != null) { 
            String placa = registro.getVeiculo().getPlaca();
            double tempoPermanencia = registro.calcularTempoPermanencia();
            double valorPago = registro.getValorPago();

            System.out.printf("Veículo Placa: %s | Tempo de Permanência: %.2f horas | Valor Pago: R$ %.2f%n",
                    placa, tempoPermanencia, valorPago);
        } else {
            System.out.printf("Veículo Placa: %s | Aguardando Saída%n", registro.getVeiculo().getPlaca());
        }
    }
}

}

