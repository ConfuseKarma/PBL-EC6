# PBL-EC6
Project Based Learning do 6º Semestre de Engenharia da Computação na Faculdade Engenheiro Salvador Arena

## Descrição do Projeto

Este projeto faz parte do PBL (Project Based Learning) da Faculdade Engenheiro Salvador Arena. O objetivo é desenvolver um site de reviews de filmes e séries, com funcionalidades como:
- Registro e login de usuários
- Dois tipos de usuários: Usuários comuns e Críticos profissionais
- Sistema de reviews com notas e comentários
- Personalização de perfis de usuários
- Integração com filmes, séries, gêneros e profissionais (atores e diretores)

O projeto utiliza Java Spring Boot e segue uma arquitetura MVC, além de implementar autenticação e autorização via Spring Security.

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

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Security**
- **Hibernate/JPA**
- **MySQL**: Para o banco de dados.
- **Thymeleaf**: Para renderização de templates no front-end.
- **Maven**: Para gerenciamento de dependências.
