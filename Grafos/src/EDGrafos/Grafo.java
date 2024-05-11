package EDGrafos;

import java.util.ArrayList;

//Grafo do tipo genérico para poder adaptar com diversos tipos de dados

public class Grafo<TIPO> {
    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;
    
    public Grafo(){
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Aresta<TIPO>>();
    }
    
    public void adicionarVertice(TIPO dado){
        Vertice<TIPO> novoVertice = new Vertice<TIPO>(dado);
        this.vertices.add(novoVertice);
    }
    
    //Método adicionar aresta serve para adicionar um amigo e definir o peso dessa amizade.
    
    public void adicionarAresta(Double peso, TIPO dadoInicio, TIPO dadoFim){
        Vertice<TIPO> inicio = this.getVertice(dadoInicio);
        Vertice<TIPO> fim = this.getVertice(dadoFim);
        Aresta<TIPO> aresta = new Aresta<TIPO>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }
    
    public Vertice<TIPO> getVertice(TIPO dado){
        Vertice<TIPO> vertice = null;
        for(int i=0; i < this.vertices.size(); i++){
            if (this.vertices.get(i).getDado().equals(dado)){
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }
    
    //Faz a busca em largura em determinado usuário, podendo então visualizar as conexõeS
    
 // Adicionando um parâmetro ao método buscaEmLargura para iniciar a busca a partir de um vértice específico
    public void buscaEmLargura(TIPO dadoInicio) {
        ArrayList<Vertice<TIPO>> marcados = new ArrayList<Vertice<TIPO>>();
        ArrayList<Vertice<TIPO>> fila = new ArrayList<Vertice<TIPO>>();
        Vertice<TIPO> atual = this.getVertice(dadoInicio);
        
        if (atual == null) {
            System.out.println("Erro: Vértice inicial não encontrado.");
            return;
        }
        
        marcados.add(atual);
        System.out.println(atual.getDado());
        fila.add(atual);
        
        while (!fila.isEmpty()) {
            Vertice<TIPO> visitado = fila.get(0);
            for (Aresta<TIPO> aresta : visitado.getArestasSaida()) {
                Vertice<TIPO> proximo = aresta.getFim();
                if (!marcados.contains(proximo)) { 
                    marcados.add(proximo);
                    System.out.println(proximo.getDado());
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
        System.out.println();
    }
    
    
    // Busca amigos de um determinado usuário
    
    public void buscarAmigo(TIPO dadoVertice) {
        Vertice<TIPO> vertice = getVertice(dadoVertice);
        
        if (vertice != null) {
            System.out.println("Amigos de " + dadoVertice + ":");
            for (Aresta<TIPO> aresta : vertice.getArestasSaida()) {
                System.out.println(aresta.getFim().getDado());
            }
            System.out.println();
        } else {
            System.out.println("Erro: Vertice não encontrado.");
        }
    }
    
    // Remove amigos de um determinado usuário
    
    public void removerAmigo(TIPO dadoVertice, TIPO dadoAmigo) {
        Vertice<TIPO> vertice = getVertice(dadoVertice);
        Vertice<TIPO> amigo = getVertice(dadoAmigo);
        
        if (vertice != null && amigo != null) {
            for (Aresta<TIPO> aresta : vertice.getArestasSaida()) {
                if (aresta.getFim().getDado().equals(dadoAmigo)) {
                    vertice.getArestasSaida().remove(aresta);
                    break;
                }
            }
        } else {
            System.out.println("Erro: Vertice ou amigo não encontrado.");
        }
    }
}