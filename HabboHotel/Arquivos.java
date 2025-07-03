import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

    private static final String NOME_ARQUIVO_RESERVAS = "reservas_historico.txt";

    public static void registrarReserva(Reservas reserva) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO_RESERVAS, true))) {
            writer.write(reserva.toFileString());
            writer.newLine();
            System.out.println("Reserva registrada no historico.");
        } catch (IOException e) {
            System.err.println("Erro ao registrar reserva no arquivo: " + e.getMessage());
        }
    }

    public static List<String> lerHistoricoReservas() {
        List<String> reservas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(NOME_ARQUIVO_RESERVAS))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                reservas.add(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler historico de reservas: " + e.getMessage());
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
            String[] dados = linhaReserva.split(";");
            if (dados.length > 0 && dados[0].equals(cpf)) {
                count++;
                System.out.println(" - Encontrado: " + linhaReserva);
            }
        }
        System.out.println("Total de reservas para o CPF " + cpf + ": " + count);
    }
}