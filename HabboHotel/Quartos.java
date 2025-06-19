public class Quartos {
    private int numPessoas;
    private String tipoQuarto;
    private double preco;
    private boolean ocupado;

    public int getNumPessoas() {
		return numPessoas;
	}
	public void setNumPessoas(int numPessoas) {
		this.numPessoas = numPessoas;
	}
    public String getTipoQuarto() {
		return tipoQuarto;
	}
	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public boolean isOcupado() {
        return ocupado;
    }
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
}
