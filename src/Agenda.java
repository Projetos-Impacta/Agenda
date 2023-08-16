import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Agenda {
    static Scanner Entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int escolha;
        Map<Integer, String> agenda = new HashMap<Integer, String>();

        do {
            System.out.println("\nBem vindo(a) a sua agenda");
            System.out.println("\nDigite o número da sua escolha:");
            System.out.println("1 - Visualzar suas tarefas");
            System.out.println("2 - Adicionar tarefa");
            System.out.println("3 - Remover Tarefa");
            System.out.println("0 - SAIR");

            escolha = Entrada.nextInt();

            if (escolha == 0) {
                break;
            } else if (escolha < 1 || escolha > 3) {
                System.out.println("\nOpção inválida. Tente novamente.");
                continue;
            }

            switch (escolha) {
                case 1:
                    visualizar(agenda);
                    break;
                case 2:
                    adicionar(agenda);
                    break;
                case 3:
                    excluir(agenda);
                    break;
            }
        } while (true);

        Entrada.close();
        System.out.println("\nAté logo! :)");

    }

    public static void visualizar(Map<Integer, String> agenda) {
        if (agenda.isEmpty()) {
            System.out.println("\nParece que não há nenhuma tarefa pendente. Muito bem!");
            return;
        }

        for (Map.Entry<Integer, String> entry : agenda.entrySet()) {
            Integer chave = entry.getKey();
            String valor = entry.getValue();
            System.out.println(chave + " - " + valor);
        }
    }

    public static void adicionar(Map<Integer, String> agenda) {
        Entrada = new Scanner(System.in);

        System.out.println("\nDigite a descrição da sua tarefa:");
        String descricao = Entrada.nextLine();
        agenda.put(RecebeIdDisponivel(agenda), descricao);
        System.out.println("\nTarefa adicionada com sucesso!");
    }

    public static void excluir(Map<Integer, String> agenda) {
        Entrada = new Scanner(System.in);
        System.out.println("\nDigite o número tarefa que deseja excluir:");
        int item = Entrada.nextInt();

        if (!agenda.containsKey(item)) {
            System.out.println("Tarefa inválida. Nenhum elemento foi removido.");
            return;
        }
        
        agenda.remove(item);
        System.out.println("\nTarefa removida com sucesso!");
    }

    private static Integer RecebeIdDisponivel(Map<Integer, String> agenda) {
        int id = 1;

        while (agenda.containsKey(id)) {
            id++;
        }
        
        return id;
    }
}
