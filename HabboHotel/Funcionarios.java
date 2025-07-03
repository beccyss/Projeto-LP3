public class Funcionarios extends Pessoa {
    private String cargo;
    private double salario;

    // Getters e Setters
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Construtor
    public Funcionarios(String nome, String cpf, String telefone, String e_mail, String cargo, double salario) {
        super(nome, cpf, telefone, e_mail);
        this.cargo = cargo;
        this.salario = salario;
    }

    // toString
    @Override
    public String toString() {
        return  nome + ", " + cpf + ", " + dataNasc + ", " + telefone + ", " + e_mail + ", " + cargo + ", R$" + String.format("%.2f", salario) + ";";
    }
}