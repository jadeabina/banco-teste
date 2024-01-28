Visão Geral


O Sistema Bancário é uma aplicação que permite a interação entre empresas e clientes, possibilitando depósitos e saques. O sistema incorpora lógica de taxa de transação.

O projeto consiste na criação de um sistema financeiro com Java, banco de dados H2 e Spring Boot. Haverá dois tipos de usuários: Empresa (identificada por CNPJ) e Cliente (identificado por CPF). A validação de documentos será implementada para garantir integridade.

O sistema seguirá a arquitetura MVC do Spring Boot, com APIs RESTful para comunicação. Empresas terão taxas de sistema em transações. 
A persistência será gerenciada pelo H2 com Spring Data JPA.

O saldo das Empresas será calculado com depósitos e saques, descontando taxas automaticamente. Clientes poderão realizar transações através das Empresas, sujeitas a saldos. 
A escolha dessas tecnologias visa uma implementação eficiente, segura e de fácil manutenção para atender às necessidades financeiras de Empresas e Clientes.


