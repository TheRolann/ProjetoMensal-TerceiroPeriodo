
---

# 🏢 Sistema de Gestão de Serviços – Detetizadora

Este projeto tem como objetivo desenvolver um sistema de gestão de chamados e serviços para uma empresa de detetização.

O sistema permitirá:

* Cadastro de clientes (empresas)
* Cadastro de funcionários
* Cadastro de serviços
* Agendamento de atendimentos
* Controle de status dos serviços
* Geração de relatórios

O projeto está sendo desenvolvido em Java, utilizando princípios de Programação Orientada a Objetos e organização em camadas.

---

# 📂 Estrutura do Projeto

O sistema está organizado seguindo uma separação de responsabilidades:

### 📁 model

Contém as classes que representam as entidades do sistema.
Exemplo:

* Cliente
* Funcionario
* Servico
* Enums (Cargo, Status, etc.)

Essas classes representam os dados da aplicação.

---

### 📁 repository

Responsável pelo armazenamento dos dados em memória.
Simula o comportamento de um banco de dados.

Exemplo:

* ClienteRepository
* FuncionarioRepository
* ServicoRepository

Essa camada apenas salva, busca, lista e remove dados.

---

### 📁 service

Contém as regras de negócio do sistema.

É responsável por:

* Validar dados
* Aplicar regras
* Gerenciar IDs
* Controlar operações antes de acessar o repository

Exemplo:

* ClienteService
* FuncionarioService
* ServicoService

---

### 📁 menu (ou view)

Responsável pela interação com o usuário.

Aqui ficam:

* Scanner
* Menus
* Entrada e saída de dados pelo terminal

Exemplo:

* ServicoMenu
* ClienteMenu

---

### 📁 interfaces

Contém interfaces utilizadas no projeto, como o contrato genérico de operações CRUD.

Exemplo:

* Crud<T>

---

# 🧠 Conceitos Aplicados

* Programação Orientada a Objetos
* Encapsulamento
* Enum
* Interface
* Generics
* Separação em camadas
* Organização arquitetural

---
