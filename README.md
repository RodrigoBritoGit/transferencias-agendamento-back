---

### **README - Backend (Spring Boot)**

# Sistema de Agendamento de Transferências Financeiras - Backend

Este repositório contém a implementação do **backend** para o sistema de agendamento de transferências financeiras, utilizando **Spring Boot**. O sistema permite que o usuário agende transferências e visualize o extrato das transferências realizadas.

## Funcionalidades

- **Listagem de Transferências**: Exibe todos os agendamentos de transferências realizadas.
- **Novo Agendamento**: Permite ao usuário agendar uma nova transferência financeira.

### Requisitos Funcionais

1. **Agendamento de Transferências**:
   - Conta de origem (padrão XXXXXXXXXX)
   - Conta de destino (padrão XXXXXXXXXX)
   - Valor da transferência
   - Taxa (calculada conforme a tabela abaixo)
   - Data da transferência (data em que será realizada a transferência)
   - Data do agendamento (hoje)

2. **Cálculo de Taxa**:
   O valor da taxa é calculado com base na data de transferência conforme a tabela:

   | Dias De | Até | Taxa (%) |
   |---------|-----|----------|
   | 0       | 0   | 2,5      |
   | 1       | 10  | 0,0      |
   | 11      | 20  | 8,2      |
   | 21      | 30  | 6,9      |
   | 31      | 40  | 4,7      |
   | 41      | 50  | 1,7      |

   **Nota**: Caso não haja taxa aplicável, um alerta será gerado e a transferência não será permitida.

3. **Exibição de Extrato**:
   O sistema permite ao usuário visualizar todos os agendamentos de transferências realizadas.

4. **Persistência em Banco de Dados em Memória (H2)**:
   O sistema utiliza um banco de dados H2 para armazenar os agendamentos de transferências.

---

## Arquitetura e Ferramentas Utilizadas

- **Spring Boot**: Framework utilizado para o desenvolvimento da API RESTful.
- **Java 11**: Versão da linguagem Java utilizada no projeto.
- **H2 Database**: Banco de dados em memória utilizado para persistência de dados.
- **Swagger**: Interface de documentação interativa para explorar a API.

## Como Executar o Backend

### Pré-requisitos

- **Java 11** ou superior
- **Maven** para gerenciamento de dependências e construção do projeto

### Passos para Executar o Backend

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/RodrigoBritoGit/transferencias-agendamento-back.git
   cd transferencias-agendamento-back
   ```

2. **Compile e execute o backend**:
   Execute o comando abaixo para rodar a aplicação Spring Boot:
   ```bash
   ./mvnw spring-boot:run
   ```
   O servidor será iniciado na porta **8080** por padrão. O backend estará acessível em `http://localhost:8080`.

3. **Acesse a documentação Swagger**:
   Para explorar os endpoints da API, você pode acessar:
   ```url
   http://localhost:8080/swagger-ui/index.html#/
   ```

---

## Testes Unitários

Os testes unitários foram implementados utilizando o **JUnit** para garantir o bom funcionamento da aplicação. Abaixo estão as instruções para executar os testes.

### Executar Testes Unitários com Maven

Para executar os testes unitários, basta rodar o comando Maven abaixo no diretório do projeto:

```bash
./mvnw test
```

Este comando irá compilar o projeto e executar todos os testes unitários presentes na pasta `src/test/java`.

### Resultados dos Testes

Os resultados dos testes serão exibidos no terminal após a execução. Caso algum teste falhe, as informações detalhadas sobre o erro serão apresentadas para facilitar o diagnóstico e a correção.

Além disso, os resultados também podem ser visualizados nos relatórios gerados pela execução dos testes, na pasta `target/surefire-reports`.

### Testes na IDE

Se você estiver utilizando uma IDE como IntelliJ IDEA, Eclipse ou Visual Studio Code, também é possível executar os testes diretamente pela interface da IDE. O JUnit 5 será detectado automaticamente como framework de testes e você poderá executar os testes diretamente do painel de testes.

Claro! Aqui está a seção ajustada com os detalhes dos **endpoints** e um exemplo de `responseBody`:

---

## Endpoints

- **GET** `http://localhost:8080/api/transferencias`  
  Retorna a listagem de todas as transferências agendadas.

- **POST** `http://localhost:8080/api/transferencias`  
  Utilizado para agendar uma nova transferência. O corpo da requisição deve ser enviado no formato JSON com as informações da transferência.

### Exemplos de Request Body (para POST)

```json
{
  "contaOrigem": "123",
  "contaDestino": "456",
  "valorBruto": 100.00,
  "dataTransferencia": "2025-02-11",
  "dataAgendamento": "2025-02-10"
}
```
---

## Considerações Finais

Este sistema oferece uma solução simples para agendamento de transferências financeiras e visualização de extratos. As funcionalidades foram implementadas com foco em simplicidade e eficiência, e a escolha das ferramentas visa garantir um bom equilíbrio entre produtividade e qualidade de código.

---
