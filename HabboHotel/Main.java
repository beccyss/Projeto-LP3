import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    // Constante para o nome do arquivo de histórico de reservas
    private static final String NOME_ARQUIVO_RESERVAS = "reservas_historico.txt";

    public static void main(String[] args) {
        System.out.println("--- Sistema de Reservas de Hotel ---");

        // 1. Criar um funcionário
        Funcionarios func1 = new Funcionarios("Ana Silva", "123.456.789-00", "98765-4321", "ana.silva@hotel.com",
                                             "Gerente de Recepcao", 3500.00);
        func1.setDataNasc("15/03/1990");
        System.out.println("\nFuncionario Criado:");
        System.out.println(func1);

        // 2. Criar um hóspede
        Hospedes hosp1 = new Hospedes("Joao Pereira", "987.654.321-00", "11223-3445", "joao.p@email.com");
        hosp1.setDataNasc("20/07/1985");
        System.out.println("\nHospede Criado:");
        System.out.println(hosp1);

        // Criando outro hóspede para testar mais reservas
        Hospedes hosp2 = new Hospedes("Maria Souza", "111.222.333-44", "99887-7665", "maria.s@email.com");
        hosp2.setDataNasc("05/11/1992");
        System.out.println("\nOutro Hospede Criado:");
        System.out.println(hosp2);

        // 3. Criar alguns quartos
        Quartos quarto101 = new Quartos(2, "Standard", 150.00, false); // Começa desocupado
        quarto101.liberar(); // Garante que o status seja "Desocupado"
        Quartos quarto205 = new Quartos(3, "Luxo", 300.00, false);
        quarto205.liberar();
        Quartos quarto301 = new Quartos(4, "Suite Presidencial", 1200.00, true); // Começa ocupado
        quarto301.ocupar(); // Garante que o status seja "Ocupado"

        System.out.println("\nQuartos no Sistema:");
        System.out.println(quarto101);
        System.out.println(quarto205);
        System.out.println(quarto301);

        // 4. Realizar algumas reservas
        System.out.println("\n--- Realizando Reservas ---");

        // Reserva 1: Quarto 101 para João Pereira
        String checkIn1 = "10/07/2025";
        String checkOut1 = "15/07/2025"; // 6 dias

        if (quarto101.estaDisponível()) {
            Reservas reserva1 = new Reservas(hosp1, quarto101, checkIn1, checkOut1, "Cartao de Credito");
            quarto101.ocupar();
            System.out.println("\nReserva - SUCESSO:");
            System.out.println("Reserva de " + reserva1.getHospede().getNome() +
                               " no Quarto " + reserva1.getQuarto().getTipoQuarto() + // Usando getTipoQuarto() para uma saída mais limpa
                               " de " + reserva1.getDataCheck_in() + " a " + reserva1.getDataCheck_out() +
                               " | Valor Total: R$" + String.format("%.2f", reserva1.getValorTotal()) +
                               " | Forma de Pagamento: " + reserva1.getFormaPagamento());

            // --- NOVO: Registrar a reserva no arquivo ---
            registrarReserva(reserva1);
        } else {
            System.out.println("\nReserva - FALHA: Quarto " + quarto101.getTipoQuarto() + " (" + quarto101.getNumPessoas() + " pessoas) nao esta disponivel.");
        }

        // Reserva 2: Quarto 205 para Maria Souza
        String checkIn2 = "20/07/2025";
        String checkOut2 = "22/07/2025"; // 3 dias

        if (quarto205.estaDisponível()) {
            Reservas reserva2 = new Reservas(hosp2, quarto205, checkIn2, checkOut2, "Boleto Bancario");
            quarto205.ocupar();
            System.out.println("\nReserva - SUCESSO:");
            System.out.println("Reserva de " + reserva2.getHospede().getNome() +
                               " no Quarto " + reserva2.getQuarto().getTipoQuarto() +
                               " de " + reserva2.getDataCheck_in() + " a " + reserva2.getDataCheck_out() +
                               " | Valor Total: R$" + String.format("%.2f", reserva2.getValorTotal()) +
                               " | Forma de Pagamento: " + reserva2.getFormaPagamento());

            // --- NOVO: Registrar a reserva no arquivo ---
            registrarReserva(reserva2);
        } else {
            System.out.println("\nReserva - FALHA: Quarto " + quarto205.getTipoQuarto() + " (" + quarto205.getNumPessoas() + " pessoas) nao esta disponivel.");
        }

        // Tentativa de reserva em quarto ocupado (Quarto 301)
        System.out.println("\n--- Tentando reservar Quarto 301 (Ocupado) ---");
        String checkIn3 = "01/08/2025";
        String checkOut3 = "05/08/2025";
        if (quarto301.estaDisponível()) {
            // Este bloco não será executado
            Reservas reserva3 = new Reservas(hosp1, quarto301, checkIn3, checkOut3, "Pix");
            quarto301.ocupar();
            System.out.println("Reserva - SUCESSO (nao deveria acontecer aqui): " + reserva3.getHospede().getNome());
            registrarReserva(reserva3);
        } else {
            System.out.println("Reserva - FALHA: Quarto " + quarto301.getTipoQuarto() + " (" + quarto301.getNumPessoas() + " pessoas) nao esta disponivel. Status: " + quarto301.status);
        }


        System.out.println("\n--- Simulando Liberacao de Quarto ---");
        // Simular a liberação do quarto 101 (reservado anteriormente)
        if (!quarto101.estaDisponível()) { // Se o quarto estiver ocupado
            quarto101.liberar(); // Libera o quarto
            System.out.println("Quarto " + quarto101.getTipoQuarto() + " (101) liberado.");
            System.out.println("Status do Quarto 101: " + quarto101.status);
        }

        System.out.println("\n--- Fim da Simulacao ---");

        // --- NOVO: Exemplo de como ler e exibir o histórico de reservas ---
        System.out.println("\n--- Historico Completo de Reservas ---");
        List<String> historico = lerHistoricoReservas();
        if (historico.isEmpty()) {
            System.out.println("Nenhuma reserva registrada ainda.");
        } else {
            System.out.println("CPF_Hospede; Nome_Hospede; Tipo_Quarto; Num_Pessoas_Quarto; CheckIn; CheckOut; ValorTotal; FormaPagamento;");
            for (String linhaReserva : historico) {
                System.out.println(linhaReserva);
            }
        }

        // --- NOVO: Contar reservas por cliente (exemplo) ---
        System.out.println("\n--- Contando Reservas por Cliente ---");
        contarReservasPorCliente("987.654.321-00"); // CPF do João Pereira
        contarReservasPorCliente("111.222.333-44"); // CPF da Maria Souza
        contarReservasPorCliente("999.888.777-66"); // Um CPF que talvez não tenha reservas
    }

    /**
     * Registra uma reserva no arquivo de histórico.
     * Cada reserva é adicionada como uma nova linha.
     * @param reserva A reserva a ser registrada.
     */
    public static void registrarReserva(Reservas reserva) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO_RESERVAS, true))) {
            writer.write(reserva.toFileString());
            writer.newLine();
            System.out.println("Reserva registrada no historico.");
        } catch (IOException e) {
            System.err.println("Erro ao registrar reserva no arquivo: " + e.getMessage());
        }
    }

    /**
     * Lê todas as linhas do arquivo de histórico de reservas.
     * @return Uma lista de strings, onde cada string é uma reserva formatada.
     */
    public static List<String> lerHistoricoReservas() {
        List<String> reservas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO_RESERVAS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                reservas.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler historico de reservas: " + e.getMessage());
            // Se o arquivo não existir, esta exceção será lançada. Isso é normal na primeira execução.
        }
        return reservas;
    }

    
    public static void contarReservasPorCliente(String cpf) {
        int count = 0;
        List<String> historico = lerHistoricoReservas();
        System.out.println("\nBuscando reservas para o CPF: " + cpf);
        if (historico.isEmpty()) {
            System.out.println("Nenhuma reserva registrada no historico.");
            return;
        }

        for (String linhaReserva : historico) {
            String[] dados = linhaReserva.split(";"); // Divide a linha pelo delimitador ";"
            if (dados.length > 0 && dados[0].equals(cpf)) { // O CPF é o primeiro campo (índice 0)
                count++;
                System.out.println(" - Encontrado: " + linhaReserva);
            }
        }
        System.out.println("Total de reservas para o CPF " + cpf + ": " + count);
    }
}