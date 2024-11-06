# PBL-EC6
Project Based Learning do 6º Semestre de Engenharia da Computação na Faculdade Engenheiro Salvador Arena

## Descrição do Projeto
# **Sistema de avaliação de filmes e séries - Total Mídia**

<h1 style="font-size: 14px; font-weight: bold;">Sistema de avaliação de filmes e séries</h1>

<p style="text-align: justify;">
O sistema é um software baseado em website de avaliação de filmes, séries e animações, direcionado a críticos profissionais e usuários comuns. Ele deve ser capaz de registrar e exibir avaliações, bem como fornecer informações detalhadas sobre as obras e seus respectivos elencos. Este projeto é parte das atividades acadêmicas da disciplina de Modelagem de Software, 6° Semestre do curso de Engenharia da Computação.
</p>

<p style="text-align: justify;">
Apesar desse sistema ser uma aplicação relativamente simples e inicialmente local, sendo utilizada principalmente como uma ferramenta de aprendizado acadêmico, ele segue um planejamento de arquitetura de software que poderia ser utilizado em um sistema real, escalável e robusto. Embora sua aplicação seja para fins acadêmicos, as tecnologias empregadas, como Java Spring para o back-end e HTML/CSS para o front-end, bem como a organização em camadas lógicas e físicas, refletem práticas profissionais que poderiam ser facilmente adaptadas para ambientes maiores e distribuídos. Como já citado anteriormente, esta aplicação será utilizada localmente, sem grandes integrações com sistemas externos ou exigências de alta performance, mas foi projetada com uma arquitetura sólida que garante sua funcionalidade, apresentando facilidade de manutenção e expansão futura, caso seja necessário.
</p>

<p style="text-align: justify;">
A seguir, detalhamos as principais decisões de arquitetura tomadas para esse projeto.
</p>

## Funcionalidades

- **Sistema de Usuários**: Os usuários podem se registrar, fazer login e acessar suas contas. Existem dois tipos de usuários:
  - **Usuário Comum**: Pode fazer reviews, comentar e dar notas.
  - **Crítico Profissional**: Tem mais destaque no site e suas avaliações possuem peso maior nas classificações.
  
- **Autenticação e Autorização**:
  - Implementada com **Spring Security**, com suporte a login e controle de permissões baseado em roles (`ROLE_USER`, `ROLE_CRITIC`, `ROLE_ADMIN`).
  
- **Gerenciamento de Reviews**:
  - Usuários podem postar reviews de filmes e séries, comentar e classificar os conteúdos.
  
- **Personalização de Perfis**:
  - Cada usuário pode personalizar seu perfil com informações, foto, etc.

- **Gêneros e Profissionais**:
  - Sistema de cadastro de gêneros e profissionais (atores e diretores), com integração aos filmes e séries.

## Modelagem de Classes

O projeto é estruturado com base nas seguintes classes principais:

![PBL-EC6 drawio](https://github.com/user-attachments/assets/ced8d2fc-10de-4385-9da6-e5f12ba50caf)


## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Security**
- **Hibernate/JPA**
- **MySQL**: Para o banco de dados.
- **Thymeleaf**: Para renderização de templates no front-end.
- **Maven**: Para gerenciamento de dependências.
