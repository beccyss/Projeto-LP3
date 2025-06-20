public class Reservas {
	private Pessoa hospede;
	private Quartos quarto;
	private String dataCheck_in;
	private String dataCheck_out;
	private double valorTotal;
	private String formaPagamento;
	
	// Getters e Setters
	public Pessoa getHospede() {
		return hospede;
	}
	public void setHospede(Pessoa hospede) {
		this.hospede = hospede;
	}
	public Quartos getQuarto() {
		return quarto;
	}
	public void setQuarto(Quartos quarto) {
		this.quarto = quarto;
	}
	public String getDataCheck_in() {
		return dataCheck_in;
	}
	public void setDataCheck_in(String dataCheck_in) {
		this.dataCheck_in = dataCheck_in;
	}
	public String getDataCheck_out() {
		return dataCheck_out;
	}
	public void setDataCheck_out(String dataCheck_out) {
		this.dataCheck_out = dataCheck_out;
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	// Construtor
	public Reservas(Pessoa hospede, Quartos quarto, String dataCheck_in, String dataCheck_out, String formaPagamento) {
		this.hospede = hospede;
		this.quarto = quarto;
		this.dataCheck_in = dataCheck_in;
		this.dataCheck_out = dataCheck_out;
		this.valorTotal = quarto.getPreco() * calcularDias();
		this.formaPagamento = formaPagamento;
	}

	// Métodos
	private int calcularDias(){
		return 1;  // Ainda preciso fazer uma forma de calcular (uma putaria pra fazer isso)
	}

	public class criarReserva {
		//System.out.println("Reserva criada com sucesso!");
	}
	public class modificarReserva {
		//System.out.println("Reserva modificada com sucesso!");
	}
	public class cancelarReserva {
		//System.out.println("Reserva cancelada com sucesso!");
	}
	public class quartosDisponiveis {
		//System.out.println("Tem x quartos disponíveis.");
	}
	public class calcularValorReserva {
		
	}
	public class statusReserva {
		// Confirmada, pendente, cancelada;
	}
}