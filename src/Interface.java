import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Interface extends JFrame {
    // Modelo da lista de tarefas para a JList
    private DefaultListModel<Tarefa> modeloLista = new DefaultListModel<>();
    // Lista gráfica que mostra as tarefas
    private JList<Tarefa> listaTarefas = new JList<>(modeloLista);
    // Campo de texto para digitar a descrição da tarefa
    private JTextField campoDescricao = new JTextField(20);
    // Botões para adicionar, concluir e remover tarefas
    private JButton btnAdicionar = new JButton("Adicionar");
    private JButton btnConcluir = new JButton("Concluir");
    private JButton btnRemover = new JButton("Remover");

    // Lista interna de tarefas (dados do programa)
    private ArrayList<Tarefa> tarefas = new ArrayList<>();
    // Controle do próximo ID para cada tarefa
    private int proximoId = 1;

    public Interface() {
        super("Gerenciador de Tarefas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Painel superior: campo de entrada e botão "Adicionar"
        JPanel painelEntrada = new JPanel();
        painelEntrada.add(campoDescricao);
        painelEntrada.add(btnAdicionar);
        add(painelEntrada, BorderLayout.NORTH);

        // Painel central: lista de tarefas com barra de rolagem
        add(new JScrollPane(listaTarefas), BorderLayout.CENTER);

        // Painel inferior: botões "Concluir" e "Remover"
        JPanel painelBotoes = new JPanel();
        painelBotoes.add(btnConcluir);
        painelBotoes.add(btnRemover);
        add(painelBotoes, BorderLayout.SOUTH);

        // Eventos dos botões
        btnAdicionar.addActionListener(e -> adicionarTarefa());
        btnConcluir.addActionListener(e -> concluirTarefa());
        btnRemover.addActionListener(e -> removerTarefa());

        setVisible(true);
    }

    // Adiciona uma nova tarefa à lista
    private void adicionarTarefa() {
        String descricao = campoDescricao.getText().trim();
        if (!descricao.isEmpty()) {
            Tarefa t = new Tarefa(proximoId++, descricao); // cria a tarefa com ID único
            tarefas.add(t); // adiciona à lista interna
            modeloLista.addElement(t); // adiciona à lista gráfica
            campoDescricao.setText(""); // limpa o campo de entrada
        } else {
            JOptionPane.showMessageDialog(this, "Digite uma descrição!");
        }
    }

    // Marca a tarefa selecionada como concluída
    private void concluirTarefa() {
        int index = listaTarefas.getSelectedIndex();
        if (index != -1) {
            Tarefa t = tarefas.get(index);
            t.concluir(); // altera o estado da tarefa
            listaTarefas.repaint(); // atualiza a exibição da lista
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para concluir!");
        }
    }

    // Remove a tarefa selecionada da lista
    private void removerTarefa() {
        int index = listaTarefas.getSelectedIndex();
        if (index != -1) {
            tarefas.remove(index); // remove da lista interna
            modeloLista.remove(index); // remove da lista gráfica
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para remover!");
        }
    }

    public static void main(String[] args) {
        // Cria a interface na thread do Swing
        SwingUtilities.invokeLater(Interface::new);
    }
}
