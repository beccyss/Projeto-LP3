import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservas {
    private Hospedes hospede;
    private Quartos quarto;
    private String dataCheck_in;
    private String dataCheck_out;
    private double valorTotal;
    private String formaPagamento;

    public Hospedes getHospede() {
        return hospede;
    }
    public void setHospede(Hospedes hospede) {
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

    public Reservas(Hospedes hospede, Quartos quarto, String dataCheck_in, String dataCheck_out, String formaPagamento) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataCheck_in = dataCheck_in;
        this.dataCheck_out = dataCheck_out;
        this.valorTotal = quarto.getPreco() * calcularDias();
        this.formaPagamento = formaPagamento;
    }

    private long calcularDias(){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate checkIn = LocalDate.parse(this.dataCheck_in, formatter);
            LocalDate checkOut = LocalDate.parse(this.dataCheck_out, formatter);
            return ChronoUnit.DAYS.between(checkIn, checkOut) + 1;
        } catch (Exception e) {
            System.err.println("Erro ao calcular dias da reserva: " + e.getMessage());
            return 1;
        }
    }

    public String toFileString() {
        return hospede.getCpf() + ";" +
               hospede.getNome() + ";" +
               quarto.getTipoQuarto() + ";" +
               quarto.getNumPessoas() + ";" +
               dataCheck_in + ";" +
               dataCheck_out + ";" +
               String.format("%.2f", valorTotal).replace(",", ".") + ";" +
               formaPagamento + ";";
    }
}