package gerenciamente;
import java.time.Duration;
import java.time.LocalDateTime;

public class Registro {
    Veiculo veiculo;
    Vaga vaga;
    LocalDateTime horaEntrada;
    LocalDateTime horaSaida;
    double valorPago;

    public Registro(Veiculo veiculo, Vaga vaga, LocalDateTime horaEntrada, LocalDateTime horaSaida) {
        this.veiculo = veiculo;
        this.vaga = vaga;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
    }
    public Veiculo getVeiculo() {
        return veiculo;
    }
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
    public Vaga getVaga() {
        return vaga;
    }
    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }
    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }
    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }
    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }
    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }
    public double getValorPago() {
        return valorPago;
    }

    public double calcularTempoPermanencia() {
        return Duration.between(horaEntrada, horaSaida).toMinutes() / 60.0;
    }

    public double calcularValor() {
        long horas = Duration.between(horaEntrada, horaSaida).toHours();
        if (horas <= 1) {
            valorPago = 5.0;
        } else if (horas <= 3) {
            valorPago = 10.0;
        } else {
            valorPago = 15.0;
        }
        return valorPago;
    }
    public double getHorasEstacionado() {
        return Duration.between(horaEntrada, horaSaida).toMinutes() / 60.0;
    }
}



