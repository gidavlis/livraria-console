package livraria;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gidfo
 */
public class Livro {    
    
    // aributos
    private int id;
    private String titulo;
    private String autor;
    private double preco;
    private int estoque;
    
    // metodo construtor
    public Livro(int id, String titulo, String autor, double preco, int estoque) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
        this.estoque = estoque;
    }
    
    // getters( metodo de leitura)
    public int getId() {return id;}
    public String getTitulo() {return titulo;}
    public String getAutor() {return autor;}
    public double getPreco() {return preco;}
    public int getEstoque() {return estoque;}
    
    // setters (metodo para alterar valores)
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public void setAutor(String autor) {this.autor = autor;}
    public void setPreco(double preco) {this.preco = preco;}
    public void setEstoque(int estoque) {this.estoque = estoque;}
    
    //representação em texto/sobrescrevendo
    @Override
    public String toString() {
        return String.format("%d - \"%s\" (%s) R$%.2f | estoque %d,", //placeholders (%) \" <- para colocar aspas duplas no texto
                id, titulo, autor, preco, estoque);
    }
    
}