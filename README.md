# 📚 Livraria Console (Java 8)

CRUD simples de Livros em **Java (console)**, feito para estudo e prática de programação orientada a objetos.

## ✨ Funcionalidades
- **Create**: adicionar livro (id, título, autor, preço, estoque)
- **Read**: listar todos os livros ou buscar por ID
- **Update**: atualização parcial (só altera o que for informado)
- **Delete**: remover livro por ID

## 📌 Próximos passos
Pretendo continuar estudando e evoluir a aplicação, adicionando:

- Persistência em arquivo (CSV) para simular banco de dados
- Integração com um **banco de dados real** (MySQL ou PostgreSQL)
- Criação de um **Web Service REST** para expor o CRUD
- Deploy em servidor de aplicação como **GlassFish** ou **Payara**


## ⚙️ Requisitos
- Java 8 ou superior

## 🚀 Como executar

1. Compile os arquivos Java:

   ```powershell
   javac -d build/classes src/*.java
   ```

2. Execute o programa principal:

   ```powershell
   java -cp build/classes Main
   ```