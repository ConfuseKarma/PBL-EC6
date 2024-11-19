# PBL-EC6
Project Based Learning do 6º Semestre de Engenharia da Computação na Faculdade Engenheiro Salvador Arena

## Descrição do Projeto
<h1 style="font-size: 14px; font-weight: bold; text-align: justify;">Sistema de avaliação de filmes e séries</h1>

<p style="text-align: justify;">
O sistema é um software baseado em website de avaliação de filmes, séries e animações, direcionado a críticos profissionais e usuários comuns. Ele deve ser capaz de registrar e exibir avaliações, bem como fornecer informações detalhadas sobre as obras e seus respectivos elencos. Este projeto é parte das atividades acadêmicas da disciplina de Modelagem de Software, 6° Semestre do curso de Engenharia da Computação.
</p>

<p style="text-align: justify;">
Apesar desse sistema ser uma aplicação relativamente simples e inicialmente local, sendo utilizada principalmente como uma ferramenta de aprendizado acadêmico, ele segue um planejamento de arquitetura de software que poderia ser utilizado em um sistema real, escalável e robusto.
</p>

<p style="text-align: justify;">
Embora sua aplicação seja para fins acadêmicos, as tecnologias empregadas, como Java Spring para o back-end e HTML/CSS para o front-end, bem como a organização em camadas lógicas e físicas, refletem práticas profissionais que poderiam ser facilmente adaptadas para ambientes maiores e distribuídos. Como já citado anteriormente, esta aplicação será utilizada localmente, sem grandes integrações com sistemas externos ou exigências de alta performance, mas foi projetada com uma arquitetura sólida que garante sua funcionalidade, apresentando facilidade de manutenção e expansão futura, caso seja necessário.
</p>

<p style="text-align: justify;">
A seguir, detalhamos as principais decisões de arquitetura tomadas para esse projeto.
</p>


# Funcionalidades

## 1. Página Inicial (Home)
- Apresenta visão geral das funcionalidades do website.
- Acesso à pesquisa (básica e avançada) para informações de filmes, séries e animações.
- Acesso à página de cadastro de usuário ou login.

## 2. Cadastro de Usuários
### 2.1. Usuários Padrão
- Permite registro e gerenciamento de usuários.
- Possui campos como Nome, E-mail, Senha.
- Suporta cadastro e autenticação para garantir a segurança do login.

### 2.2. Críticos Profissionais
- Inclusão de nome, profissão, credenciais verificáveis, e uma breve biografia.
- Critérios de verificação de credenciais, com implementação de um sistema automatizado ou manual para validação das credenciais dos críticos.
- Suporta cadastro e autenticação para garantir a segurança do login.

## 3. Área do Usuário
- A área do usuário proporciona uma experiência personalizada, permitindo o acesso e gerenciamento de informações pessoais.

### 3.1. Detalhamento
- Acesso a dados pessoais e configurações de perfil.
- Resumo das críticas publicadas, destacando as que geram maior engajamento (visualizações, curtidas, comentários).
- Utilização de algoritmos para sugerir conteúdo relevante com base no comportamento do usuário.
- Segurança: Medidas de proteção de dados pessoais.

## 4. Cadastro de Filmes/Séries/Animações
- Exibição de informações como título, resenha, elenco, diretor, trailer, avaliação geral do público, e críticas com maior engajamento.
- Interface acessível para usuários com deficiência (ex.: compatibilidade com leitores de tela).
- Cada item terá um resumo com título e imagem em miniatura, e link para informações detalhadas.
- Exibição de uma lista dos filmes, curtas e séries mais novos, do mais recente ao mais antigo.
- Exibição de uma lista de filmes com filtros personalizáveis (ex.: tempo de lançamento, popularidade).

### 4.1. Detalhamento
- A lista de filmes será atualizada em intervalos regulares para garantir que os usuários sempre vejam os conteúdos mais recentes.

### 4.2. Ficha Técnica do Ator
- Apresentação de informações detalhadas sobre atores e equipe cinematográfica.
- Acesso a outras obras nas quais os atores e membros da equipe participaram.

### 4.3. Rankeamento de Filme
- Seção do site apresentando o Top 10 Filmes em Alta, exibindo os filmes mais populares.
- Presença de filtros acessíveis e intuitivos, permitindo aos usuários personalizar a visualização do ranking.


## Modelagem de Classes

O projeto é estruturado com base nas seguintes classes principais:

![PBL-EC6 drawio](https://github.com/user-attachments/assets/ced8d2fc-10de-4385-9da6-e5f12ba50caf)


## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Security**
- **Hibernate/JPA**
- **Thymeleaf**: Para renderização de templates no front-end.
- **Maven**: Para gerenciamento de dependências.
- **H2 Database: é um banco de dados em memória.

## Diagrama  de Implementação 

![Imagem2Corrigida](https://github.com/user-attachments/assets/72c2cf30-0094-41da-810c-d70efb79b589)

## Estrutura do Projeto

## Modelos (Models)
Os modelos representam as entidades do banco de dados e são utilizados na camada de negócio para manipular os dados.

   --Falta
## Data Access Objects (DAOs)
Os DAOs encapsulam o acesso aos dados e executam operações no banco de dados utilizando Stored Procedures.
    --Falta

