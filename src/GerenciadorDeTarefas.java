import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorDeTarefas {
    private static ArrayList<String> tarefas = new ArrayList<>();
    private static ArrayList<Boolean> statusTarefas =  new ArrayList<>();

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarTarefa(scanner);
                    break;

                case 2:
                    listarTarefas(scanner);
                    break;

                case 3:
                    marcarComoConcluida(scanner);
                    break;

                case 4:
                    removerTarefa(scanner);
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção invalida! Tente novamente.");
            }
        } while (opcao != 0);
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- GERENCIADOR DE TAREFAS ---");
        System.out.println("1. Adicionar tarefa");
        System.out.println("2. Listar Tarefas");
        System.out.println("3. Marcar tarefa como concluida");
        System.out.println("4. Remover tarefa");
        System.out.println("0. Sair");
    }

    private static void adicionarTarefa(Scanner scanner) {
        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();
        tarefas.add(descricao);
        statusTarefas.add(false);
        System.out.println("Tarefa adicionada com sucesso!");

    }

    private static void listarTarefas(Scanner scanner) {
        if (tarefas.isEmpty()){
            System.out.println("Nenhuma tarefa foi cadastrada.");
            return;
        }
        System.out.println("\n--- Lista de Tarefas ---");
        for (int i = 0; i < tarefas.size(); i++){
            String status = statusTarefas.get(i) ? "[✔]" :"[ ]" ;
            System.out.println((i + 1) + "." + status + " " + tarefas.get(i));
        }

    }

    private static void marcarComoConcluida(Scanner scanner){
        listarTarefas(scanner);
        if (tarefas.isEmpty()) return;

        System.out.println("Digite o número da tarefa para marcar como concluida: ");
        int indice = scanner.nextInt() -1;
        int i = -1;

        if (indice >= 0 && indice < tarefas.size()){
            statusTarefas.set(indice, true);
            System.out.println("Tarefa marcada como concluida!");
        } else {
            System.out.println("Número inválido.");
        }
    }

    private static void removerTarefa(Scanner scanner){
        listarTarefas(scanner);
        if (tarefas.isEmpty()) return;

        System.out.print("Digite o número da tarefa para remover: ");
        int indice = scanner.nextInt() - 1;
        
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice);
            statusTarefas.remove(indice);
            System.out.println("Tarefa removida com sucesso!");
        }
        else {
            System.out.println("Número inválido.");
        }
    }
}