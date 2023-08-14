import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Agenda {
    public static void main(String[] args) throws Exception {
        int escolha;
        List<String> tarefas = new ArrayList<>();
        Map<Integer, String> agenda = new HashMap<Integer, String>();
        do {
            Scanner Entrada = new Scanner(System.in);
            System.out.println("\nBem vindo(a) a sua agenda");
            System.out.println("\nDigite o número da sua escolha:");
            System.out.println("1 - Visualzar suas tarefas");
            System.out.println("2 - Adicionar tarefa");
            System.out.println("3 - Remover Tarefa");
            System.out.println("0 - SAIR");

            escolha = Entrada.nextInt();

            if (escolha == 0) {
                break;
            }
            else if (escolha < 1 || escolha > 3) {
                System.out.println("\nOpção inválida. Tente novamente.");
                continue;
            }
            
            switch (escolha) {
                case 1:
                    visualizar(tarefas, agenda);
                    break;
                case 2:
                    adicionar(tarefas, agenda);
                    break;
                case 3:
                    
                    break;

                case 4:
                    
                    break;
                }
                Entrada.close();
        } while (true);

        System.out.println("\nAté logo! :)");


    }
    
    public static void visualizar(List<String> tarefas, Map<Integer, String> agenda) {
        if (tarefas.isEmpty()) {
            System.out.println("\nParece que não há nenhuma tarefa pendente. Muito bem!");
        }
        else{
            for (String tarefa : tarefas) {
                agenda.put(tarefas.indexOf(tarefa)+1, tarefa);
            }
            for (Map.Entry<Integer, String> entry : agenda.entrySet()) {
                Integer chave = entry.getKey();
                String valor = entry.getValue();
                System.out.println(chave + " - " + valor);
            }
        }
    }

    public static void adicionar(List<String> tarefas, Map<Integer, String> agenda) {
        Scanner Entrada = new Scanner(System.in);
        System.out.println("\nDigite a descrição da sua tarefa:");
        String descricao = Entrada.nextLine();
        tarefas.add(descricao);
        System.out.println("\nTarefa adicionada com sucesso!");
        Entrada.close();
    }
}
