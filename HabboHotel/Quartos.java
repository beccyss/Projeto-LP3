public class Quartos {
    private int numPessoas;
    private String tipoQuarto;
    private double preco;
    private boolean ocupado;
    public String status; // Considere tornar 'status' privado e gerenciar via getters/setters ou ocupar/liberar

    // Getters e Setters
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

    // Construtor
    public Quartos(int numPessoas, String tipoQuarto, double preco, boolean ocupado) {
        this.numPessoas = numPessoas;
        this.tipoQuarto = tipoQuarto;
        this.preco = preco;
        this.ocupado = ocupado;
        this.status = ocupado ? "Ocupado" : "Desocupado"; // Define o status inicial
    }

    // Métodos
    public boolean estaDisponível() {
        return !ocupado;
    }

    public void ocupar() {
        ocupado = true;
        status = "Ocupado";
    }

    public void liberar() {
        ocupado = false;
        status = "Desocupado";
    }

    // toString
    @Override
    public String toString() {
        return "Quarto " + tipoQuarto + ", Número de Pessoas: " + numPessoas + ", R$" + String.format("%.2f", preco) + ", " + status + ";";
    }
}