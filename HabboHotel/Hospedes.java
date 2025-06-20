public class Hospedes extends Pessoa{

    // Construtor
    public Hospedes(String nome, String cpf, String telefone, String e_mail) {
        super(nome, cpf, telefone, e_mail);
    }

    // toString
	@Override
	public String toString() {
		return  nome + ", " + cpf + ", " + dataNasc + ", " + telefone + ", " + e_mail + ";";
	}
}