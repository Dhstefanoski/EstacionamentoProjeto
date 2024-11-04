package gerenciamente;
public class Vaga {
int numero;
String tamanho;
boolean disponivel = true;
Veiculo veiculo;
public int getNumero() {
	return numero;
}
public void setNumero(int numero) {
	this.numero = numero;
}
public String getTamanho() {
	return tamanho;
}
public void setTamanho(String tamanho) {
	this.tamanho = tamanho;
}
public boolean isDisponivel() {
	return disponivel;
}
public void setDisponivel(boolean disponivel) {
	this.disponivel = disponivel;
}
public Vaga(int numero, String tamanho) {
	this.numero = numero;
	this.tamanho = tamanho;
}
public Veiculo getVeiculo() {
	return veiculo;
}
public void setVeiculo(Veiculo veiculo) {
	this.veiculo = veiculo;
}
public Vaga() {
	
}
@Override
public String toString() {
	if (disponivel) {
		return "Vaga " + numero + "| Tamanho: " + tamanho + "| A vaga esta disponivel" + disponivel;
	}
	else {
		return "Vaga " + numero + "| Tamanho: " + tamanho + "| A vaga esta ocupada pelo veículo da placa:" + veiculo.getPlaca();
	}
	
}
public void ocupar(Vaga vaga, Veiculo veiculo) {
	this.veiculo = veiculo;
	vaga.setDisponivel(true);
}
public void liberar(Vaga vaga) {
	 this.veiculo = null;
	vaga.setDisponivel(false);
}
}
