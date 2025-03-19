#  📚 Java Back-End - Sistema de Compras
Este projeto é uma aplicação back-end baseada em microsserviços para um sistema de compras, desenvolvida com Spring Boot, Hibernate e PostgreSQL. O objetivo é fornecer um ambiente modular e escalável para gerenciar usuários, produtos e compras. Foi feito em cima do livro Back-end Java: Microsserviços, Spring Boot e Kubernetes de Eduardo Felipe Zambom Santana. Grande homem!

🏗️ Arquitetura
A aplicação é dividida em três microserviços:

🧑‍💻 User API – Gerencia os usuários do sistema.
📦 Product API – Controla o cadastro e a listagem de produtos.
🛒 Shopping API – Processa as compras feitas pelos usuários.
Cada serviço utiliza um schema separado no banco de dados, garantindo melhor organização e independência.

💾 Banco de Dados
Os microserviços utilizam um banco de dados PostgreSQL. No primeiro uso, as tabelas são criadas automaticamente, mas é necessário que o banco dev já exista. Caso utilize Docker Compose, o banco será provisionado automaticamente.

🔧 Tecnologias Utilizadas
-  Spring Boot (Web, Data JPA)
-  PostgreSQL
-  Hibernate
-  Docker & Docker Compose
-  Kubernetes (para deploy)

Ainda está sendo finalizado!
