package livraria;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author gidfo
 */
import java.util.List;
import java.util.Scanner; // leitura do usuario


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // objeto do tipo scanner pra chamar sempre que precisar
        LivroDao dao = new LivroDao();
              
        // loop do menu
        while(true) {
            // exibindo o menu
            System.out.println("\n=== Menu da Lirvaria ===");
            System.out.println("[1] - Adicionar livro");
            System.out.println("[2] - Listar livros");
            System.out.println("[3] - Buscar por ID");
            System.out.println("[4] - Remover livro");
            System.out.println("[5] - Atualizar livro");
            System.out.println("[0] - Sair");
            System.out.println("Escolha uma opção: ");
            
            // pedindo pro usuario digitar um numero
            int opcao = sc.nextInt();
            sc.nextLine();
            
            switch (opcao) {
                case 1:
                   adicionar(sc, dao);
                    break; // sai do switch
                case 2:
                    listar(dao);
                    break;
                case 3:
                    buscarPorId(sc, dao);
                    break;
                case 4:
                    remover(sc, dao);
                    break;
                case 5:
                    atualizar(sc, dao);
                    break;                    
                case 0:
                    System.out.println("Saindo do sistema...");
                    return; // encerra
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }
        }
    }

    //CREATE
    private static void adicionar(Scanner sc, LivroDao dao){
        System.out.println("ID: ");
        int id = lerInt(sc);
        
        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("Autor: ");
        String autor = sc.nextLine();

        System.out.print("Preço: ");
        double preco = lerDouble(sc);

        System.out.print("Estoque: ");
        int estoque = lerInt(sc);
        
        dao.adicionar(new Livro(id, titulo, autor, preco, estoque));
        System.out.println("Livro adicionado!");
    }
    
    //READ listar todos
    private static void listar(LivroDao dao){
        List<Livro> livros = dao.listar();
        if (livros.isEmpty()){
            System.out.println("Sem livros cadastrados");
        } else {
            livros.forEach(System.out::println); //toString() de livro
        }
    }
    
    //READ buscar por id
    private static void buscarPorId(Scanner sc, LivroDao dao){
        System.out.print("ID: ");
        int id = lerInt(sc);
        Livro l = dao.buscarPorId(id);
        System.out.println(l != null ? l : "Não encontrado.");        
    }
    
    //DELETE
    private static void remover(Scanner sc, LivroDao dao) {
        System.out.print("ID: ");
        int id = lerInt(sc);
        boolean ok = dao.remover(id);
        System.out.println(ok ? "Removido!" : "Não encontrado.");
    }

    //UPDATE
    private static void atualizar(Scanner sc, LivroDao dao) {
        System.out.print("ID do livro a atualizar: ");
        int id = lerInt(sc);

        System.out.print("Novo título (Enter para manter): ");
        String novoTitulo = sc.nextLine();
        if (novoTitulo.trim().isEmpty()) novoTitulo = null;

        System.out.print("Novo autor (Enter para manter): ");
        String novoAutor = sc.nextLine();
        if (novoAutor.trim().isEmpty()) novoAutor = null;

        System.out.print("Novo preço: ");
        double preco = lerDouble(sc);
        Double novoPreco = (preco < 0) ? null : preco;

        System.out.print("Novo estoque: ");
        int est = lerInt(sc);
        Integer novoEstoque = (est < 0) ? null : est;

        boolean ok = dao.atualizar(id, novoTitulo, novoAutor, novoPreco, novoEstoque);
        System.out.println(ok ? "Atualizado!" : "Livro não encontrado.");
    }

    //Helpers de leitura
    private static int lerInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Digite um número inteiro: ");
            sc.next();
        }
        int v = sc.nextInt();
        sc.nextLine();
        return v;
    }

    private static double lerDouble(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Digite um número válido: ");
            sc.next();
        }
        double v = sc.nextDouble();
        sc.nextLine();
        return v;
    }
}