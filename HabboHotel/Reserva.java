public class Reserva {
	private int dataCheck_in;
	private int dataCheck_out;
	private int numQuarto;
	private double valorTotal;
	private String formaPagamento;
	
	public int getDataCheck_in() {
		return dataCheck_in;
	}
	public void setDataCheck_in(int dataCheck_in) {
		this.dataCheck_in = dataCheck_in;
	}
	public int getDataCheck_out() {
		return dataCheck_out;
	}
	public void setDataCheck_out(int dataCheck_out) {
		this.dataCheck_out = dataCheck_out;
	}
	public int getNumQuarto() {
		return numQuarto;
	}
	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
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