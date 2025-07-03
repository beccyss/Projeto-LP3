import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Sistema de Reservas de Hotel ---");

        Funcionarios func1 = new Funcionarios("Ana Silva", "123.456.789-00", "98765-4321", "ana.silva@hotel.com",
                                      "Gerente de Recepcao", 3500.00);
        func1.setDataNasc("15/03/1990");
        System.out.println("\nFuncionario Criado:");
        System.out.println(func1);

        Hospedes hosp1 = new Hospedes("Joao Pereira", "987.654.321-00", "11223-3445", "joao.p@email.com");
        hosp1.setDataNasc("20/07/1985");
        System.out.println("\nHospede Criado:");
        System.out.println(hosp1);

        Hospedes hosp2 = new Hospedes("Maria Souza", "111.222.333-44", "99887-7665", "maria.s@email.com");
        hosp2.setDataNasc("05/11/1992");
        System.out.println("\nOutro Hospede Criado:");
        System.out.println(hosp2);

        Quartos quarto101 = new Quartos(2, "Standard", 150.00, false);
        quarto101.liberar();
        Quartos quarto205 = new Quartos(3, "Luxo", 300.00, false);
        quarto205.liberar();
        Quartos quarto301 = new Quartos(4, "Suite Presidencial", 1200.00, true);
        quarto301.ocupar();

        System.out.println("\nQuartos no Sistema:");
        System.out.println(quarto101);
        System.out.println(quarto205);
        System.out.println(quarto301);

        System.out.println("\n--- Realizando Reservas ---");

        String checkIn1 = "10/07/2025";
        String checkOut1 = "15/07/2025";

        if (quarto101.estaDisponível()) {
            Reservas reserva1 = new Reservas(hosp1, quarto101, checkIn1, checkOut1, "Cartao de Credito");
            quarto101.ocupar();
            System.out.println("\nReserva - SUCESSO:");
            System.out.println("Reserva de " + reserva1.getHospede().getNome() +
                               " no Quarto " + reserva1.getQuarto().getTipoQuarto() +
                               " de " + reserva1.getDataCheck_in() + " a " + reserva1.getDataCheck_out() +
                               " | Valor Total: R$" + String.format("%.2f", reserva1.getValorTotal()) +
                               " | Forma de Pagamento: " + reserva1.getFormaPagamento());

            Arquivos.registrarReserva(reserva1);
        } else {
            System.out.println("\nReserva - FALHA: Quarto " + quarto101.getTipoQuarto() + " (" + quarto101.getNumPessoas() + " pessoas) nao esta disponivel.");
        }

        String checkIn2 = "20/07/2025";
        String checkOut2 = "22/07/2025";

        if (quarto205.estaDisponível()) {
            Reservas reserva2 = new Reservas(hosp2, quarto205, checkIn2, checkOut2, "Boleto Bancario");
            quarto205.ocupar();
            System.out.println("\nReserva - SUCESSO:");
            System.out.println("Reserva de " + reserva2.getHospede().getNome() +
                               " no Quarto " + reserva2.getQuarto().getTipoQuarto() +
                               " de " + reserva2.getDataCheck_in() + " a " + reserva2.getDataCheck_out() +
                               " | Valor Total: R$" + String.format("%.2f", reserva2.getValorTotal()) +
                               " | Forma de Pagamento: " + reserva2.getFormaPagamento());

            Arquivos.registrarReserva(reserva2);
        } else {
            System.out.println("\nReserva - FALHA: Quarto " + quarto205.getTipoQuarto() + " (" + quarto205.getNumPessoas() + " pessoas) nao esta disponivel.");
        }

        System.out.println("\n--- Tentando reservar Quarto 301 (Ocupado) ---");
        String checkIn3 = "01/08/2025";
        String checkOut3 = "05/08/2025";
        if (quarto301.estaDisponível()) {
            Reservas reserva3 = new Reservas(hosp1, quarto301, checkIn3, checkOut3, "Pix");
            quarto301.ocupar();
            System.out.println("Reserva - SUCESSO (nao deveria acontecer aqui): " + reserva3.getHospede().getNome());
            Arquivos.registrarReserva(reserva3);
        } else {
            System.out.println("Reserva - FALHA: Quarto " + quarto301.getTipoQuarto() + " (" + quarto301.getNumPessoas() + " pessoas) nao esta disponivel. Status: " + quarto301.getStatus());
        }

        System.out.println("\n--- Simulando Liberacao de Quarto ---");
        if (!quarto101.estaDisponível()) {
            quarto101.liberar();
            System.out.println("Quarto " + quarto101.getTipoQuarto() + " (101) liberado.");
            System.out.println("Status do Quarto 101: " + quarto101.getStatus());
        }

        System.out.println("\n--- Fim da Simulacao ---");

        System.out.println("\n--- Historico Completo de Reservas ---");
        List<String> historico = Arquivos.lerHistoricoReservas();
        if (historico.isEmpty()) {
            System.out.println("Nenhuma reserva registrada ainda.");
        } else {
            System.out.println("CPF_Hospede; Nome_Hospede; Tipo_Quarto; Num_Pessoas_Quarto; CheckIn; CheckOut; ValorTotal; FormaPagamento;");
            for (String linhaReserva : historico) {
                System.out.println(linhaReserva);
            }
        }

        System.out.println("\n--- Contando Reservas por Cliente ---");
        Arquivos.contarReservasPorCliente("987.654.321-00");
        Arquivos.contarReservasPorCliente("111.222.333-44");
        Arquivos.contarReservasPorCliente("999.888.777-66");
    }
}