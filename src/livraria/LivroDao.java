package livraria;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gidfo
 */
import java.util.ArrayList;
import java.util.List;

//LivroDao "Data Access Object": classe que cuida de armazenar os dados.
//Usando uma lista em memória (sem banco) para estudo
public class LivroDao {
    
    private final List<Livro> livros = new ArrayList<>();
    
    //CREATE (regra id ser unico)
    public void adicionar (Livro livro){
        if (buscarPorId(livro.getId()) != null){ //Não permitir dois livros com o mesmo id
            throw new IllegalArgumentException("Já existe livro com id " + livro.getId());
        }
        livros.add(livro);
    }
    
    //READ 1
    public List<Livro> listar(){ //lista inteira, só leitura
        return livros;
    }
    
    //READ 2
    public Livro buscarPorId(int id){
        for (Livro l : livros){
            if (l.getId() == id){ //se o id bater, achou
                return l;
            }
        }
        return null; //nao achou
    }
    
    //UPDATE
    public boolean atualizar(int id, String novoTitulo, String novoAutor,
            Double novoPreco, Integer novoEstoque){ //Doubçe e Integer quando precisar da opcao null
        Livro l = buscarPorId(id);
        if (l == null) return false;
        
        if (novoTitulo != null && !novoTitulo.trim().isEmpty()){
            l.setTitulo(novoTitulo);
        }
        
        if (novoAutor != null && !novoAutor.trim().isEmpty()){
            l.setAutor(novoAutor);
        }
        
        if (novoPreco != null && novoPreco >= 0){
            l.setPreco(novoPreco);
        }
        
        if (novoEstoque != null && novoEstoque >= 0){
            l.setEstoque(novoEstoque);
        }
        
        return true;     
    }

    //DELETE remove um livre pelo id, retorna true se removeu e false se não existia
    public boolean remover(int id){
        return livros.removeIf(l -> l.getId() == id); //removeIf percorre a lista e remove se a condição for verdadeira
    }
    
}