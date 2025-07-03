public abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected String dataNasc;
    protected String telefone;
    protected String e_mail;

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getE_mail() {
        return e_mail;
    }
    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    // Construtor
    public Pessoa(String nome, String cpf, String telefone, String e_mail){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.e_mail = e_mail;
    }

    // Métodos
    public String getIdentificacao(){
        return cpf;
    }

    public String Contato(){
        return telefone + " / " + e_mail;
    }
}