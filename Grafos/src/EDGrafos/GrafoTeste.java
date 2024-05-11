package EDGrafos;

import javax.swing.JOptionPane;

public class GrafoTeste {
	
	public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<String>();
        
        grafo.adicionarVertice("João");
        grafo.adicionarVertice("Lorenzo");
        grafo.adicionarVertice("Cleuza");
        grafo.adicionarVertice("Cleber");
        grafo.adicionarVertice("Cláudio");
        grafo.adicionarVertice("Luna");
        grafo.adicionarVertice("Marcos");
        grafo.adicionarVertice("Agatha");
        grafo.adicionarVertice("Luiz");
        
        
        grafo.adicionarAresta(3.0, "João", "Lorenzo");
        grafo.adicionarAresta(2.0, "Lorenzo", "Cleber");
        grafo.adicionarAresta(1.0, "Cleber", "Cleuza");
        grafo.adicionarAresta(4.0, "João", "Cleuza");
        grafo.adicionarAresta(2.0, "Cláudio", "João");
        grafo.adicionarAresta(5.0, "Cláudio", "Lorenzo");
        grafo.adicionarAresta(2.0, "Luna", "Marcos");
        grafo.adicionarAresta(3.0, "Marcos", "Agatha");
        grafo.adicionarAresta(1.0, "João", "Marcos");
        grafo.adicionarAresta(3.0, "Luiz", "Marcos");
        
        
        while (true) {
            String nomeUsuario = JOptionPane.showInputDialog("Digite o nome do usuário ou deixe em branco para sair:");
            
            // Se o usuário deixar em branco, sair do programa
            if (nomeUsuario == null || nomeUsuario.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Saindo do programa.");
                System.exit(0);
            }
            
            // Adicionar o usuário ao grafo
            grafo.adicionarVertice(nomeUsuario);
            
            // Loop para interagir com o usuário
            while (true) {
                // Opções do menu
                String[] opcoes = {"Adicionar amigo", "Buscar amigos", "Remover amigo", "Buscar em largura", "Voltar e inserir novo usuário", "Sair"};
                int escolha = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
                
                switch (escolha) {
                    case 0: // Adicionar amigo
                        String novoAmigo = JOptionPane.showInputDialog("Digite o nome do amigo:");
                        grafo.adicionarAresta(1.0, nomeUsuario, novoAmigo);
                        JOptionPane.showMessageDialog(null, "Amigo adicionado com sucesso!");
                        break;
                    case 1: // Buscar amigos
                        grafo.buscarAmigo(nomeUsuario);
                        break;
                    case 2: // Remover amigo
                        String amigoRemover = JOptionPane.showInputDialog("Digite o nome do amigo a ser removido:");
                        grafo.removerAmigo(nomeUsuario, amigoRemover);
                        JOptionPane.showMessageDialog(null, "Amigo removido com sucesso!");
                        break;
                    case 3: // Busca em largura
                        JOptionPane.showMessageDialog(null, "Busca em largura:");
                        grafo.buscaEmLargura(nomeUsuario);
                        break;
                    case 4: // Voltar e inserir novo usuário
                        break;
                    case 5: // Sair
                        JOptionPane.showMessageDialog(null, "Saindo do programa.");
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida!");
                }
                
                // Se escolher voltar e inserir novo usuário, limpar os dados e permitir inserir um novo usuário
                if (escolha == 4) {
                    new Grafo<String>();
                    break;
                }
            }
        }
	}
    
}
