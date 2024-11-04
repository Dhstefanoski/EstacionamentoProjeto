package gerenciamente;
import java.time.Duration;
import java.time.LocalDateTime;
public class Veiculo {
String placa;
String modelo;
String tamanho;
LocalDateTime horarioEntrada;
LocalDateTime horarioSaida;
public String getPlaca() {
	return placa;
}
public void setPlaca(String placa) {
	this.placa = placa;
}
public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public String getTamanho() {
	return tamanho;
}
public void setTamanho(String tamanho) {
	this.tamanho = tamanho;
}
public LocalDateTime getHorarioEntrada() {
	return horarioEntrada;
}
public void setHorarioEntrada(LocalDateTime horarioEntrada) {
	this.horarioEntrada = horarioEntrada;
}
public LocalDateTime getHorarioSaida() {
	return horarioSaida;
}
public void setHorarioSaida(LocalDateTime horarioSaida) {
	this.horarioSaida = horarioSaida;
}
public Veiculo(String placa, String modelo, String tamanho) {
	this.placa = placa;
	this.modelo = modelo;
	this.tamanho = tamanho;
}
public Veiculo() {
        
}
public double calcularValor() {
   if (horarioEntrada == null || horarioSaida == null) {
       System.out.println("Entrada ou saída não registrada.");
   }
   long horas = Duration.between(horarioEntrada, horarioSaida).toHours();
  
    if (horas <= 1) {
       return 5.0;
   } else if (horas <= 3) {
       return 10.0;
   } else {
       return 15.0;
   }
}

@Override
public String toString() {
	return "Veiculo " + placa + " | Modelo: " + modelo + " | Tamanho: " + tamanho + " | Horário de Entrada: "
			+ horarioEntrada + " | Horário de Saida: " + horarioSaida;
}
}
