import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Gerenciador {
    // Lista interna de tarefas
    private List<Tarefa> tarefas = new ArrayList<>();

    // Adiciona uma nova tarefa à lista
    public void adicionar(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    // Marca uma tarefa como concluída pelo ID
    public void concluirTarefa(int id){
        for (Tarefa t : tarefas) {
            if (t.getId() == id) {
                t.concluir(); // altera o estado da tarefa
                System.out.println("Tarefa concluída: " + t.getDescricao());
                return; // encerra o método após encontrar a tarefa
            }
        }
        System.out.println("Tarefa com ID " + id + " não encontrada.");
    }

    // Remove uma tarefa pelo ID
    public void removerTarefa(int id) {
        Iterator<Tarefa> iterator = tarefas.iterator();
        while (iterator.hasNext()) {
            Tarefa t = iterator.next();
            if (t.getId() == id) {
                iterator.remove(); // remove da lista com segurança
                System.out.println("Tarefa removida: " + t.getDescricao());
                return; // encerra o método após remover
            }
        }
        System.out.println("Tarefa com ID " + id + " não encontrada.");
    }

    // Exibe todas as tarefas no console
    public void listarTarefas() {
        System.out.println("\n=== LISTA DE TAREFAS ===");
        for (Tarefa t : tarefas) {
            System.out.println(t); // usa o método toString() da classe Tarefa
        }
    }
}
