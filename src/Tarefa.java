public class Tarefa {
    // Identificador único da tarefa
    private int Id;
    // Descrição da tarefa
    private String descricao;
    // Estado da tarefa: false = pendente, true = concluída
    private boolean estado;

    // Construtor: inicializa o ID e a descrição da tarefa
    public Tarefa(int Id, String descricao){
        this.Id = Id;
        this.descricao = descricao;
        this.estado = false; // toda tarefa nova inicia como pendente
    }

    // Getters e setters
    public int getId() {
        return Id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Marca a tarefa como concluída
    public void concluir() {
        this.estado = true;
    }

    // Retorna true se a tarefa estiver concluída
    public boolean isConcluir() {
        return estado;
    }

    // Representação da tarefa em String, mostrando status e descrição
    @Override
    public String toString() {
        return "[" + (estado ? "✔" : "✖") + "] " + descricao;
    }
}
