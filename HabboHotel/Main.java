public class Main {
    public static void main(String[] args) {

        System.out.println("--- Sistema de Reservas de Hotel ---");

        Funcionarios func1 = new Funcionarios("Ana Silva", "123.456.789-00", "98765-4321", "ana.silva@hotel.com",
                                                "Gerente de Recepcao", 3500.00);
        System.out.println("\nFuncionario Criado:");
        System.out.println(func1);
        // Exemplo: Setando a dataNasc do funcionário (se você adicionar a essa versão de Pessoa e Funcionario)
        func1.setDataNasc("15/03/1990"); // Chamando o setter da classe Pessoa
        System.out.println("Funcionario com data de nascimento setada: " + func1);


        // 2. Criar um hóspede
        // O construtor de Hospedes não aceita dataNasc como parâmetro.
        Hospedes hosp1 = new Hospedes("Joao Pereira", "987.654.321-00", "11223-3445", "joao.p@email.com");
        System.out.println("\nHospede Criado:");
        System.out.println(hosp1);
        // Exemplo: Setando a dataNasc do hóspede
        hosp1.setDataNasc("20/07/1985"); // Chamando o setter da classe Pessoa
        System.out.println("Hospede com data de nascimento setada: " + hosp1);


        // 3. Criar alguns quartos
        // Observe que o construtor Quartos agora exige 'ocupado' no final
        Quartos quarto101 = new Quartos(2, "Standard", 150.00, false); // Começa desocupado
        quarto101.liberar(); // Setar o status para "Desocupado"
        Quartos quarto205 = new Quartos(3, "Luxo", 300.00, false);
        quarto205.liberar();
        Quartos quarto301 = new Quartos(4, "Suite Presidencial", 1200.00, true); // Começa ocupado
        quarto301.ocupar(); // Setar o status para "Ocupado"

        System.out.println("\nQuartos no Sistema:");
        System.out.println(quarto101);
        System.out.println(quarto205);
        System.out.println(quarto301);

        // 4. Realizar algumas reservas

        System.out.println("\n--- Realizando Reservas ---");

        // Reserva 1: Quarto 101 para João Pereira
        String checkIn1 = "10/07/2025";
        String checkOut1 = "15/07/2025";

        if (quarto101.estaDisponível()) { // Usando o método atual estaDisponível()
            // Hospede é um tipo Pessoa, então pode ser passado diretamente
            Reservas reserva1 = new Reservas(hosp1, quarto101, checkIn1, checkOut1, "Cartao de Credito");
            quarto101.ocupar(); // Usando o método ocupar()
            System.out.println("\nReserva - SUCESSO:");
            System.out.println("Reserva de " + reserva1.getHospede().getNome() +
                               " no Quarto " + reserva1.getQuarto().toString() + // Usando toString do Quarto
                               " de " + reserva1.getDataCheck_in() + " a " + reserva1.getDataCheck_out() +
                               " | Valor Total: R$" + String.format("%.2f", reserva1.getValorTotal()) +
                               " | Forma de Pagamento: " + reserva1.getFormaPagamento());
            System.out.println("Status do Quarto 101 apos reserva: " + quarto101.estaDisponível());
        } else {
            System.out.println("\nReserva - FALHA: Quarto " + quarto101.getTipoQuarto() + " (" + quarto101.getNumPessoas() + " pessoas) nao esta disponivel.");
        }

        System.out.println("\n--- Simulando Liberacao de Quarto ---");
        // Simular a liberação do quarto 101
        if (!quarto101.estaDisponível()) { // Se o quarto estiver ocupado
            quarto101.liberar(); // Libera o quarto
            System.out.println("Quarto " + quarto101.getTipoQuarto() + " (101) liberado.");
            System.out.println("Status do Quarto 101: " + quarto101.estaDisponível());
        }

        System.out.println("\n--- Fim da Simulacao ---");
    }
}