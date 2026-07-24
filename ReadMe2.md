# Visão Geral da Arquitetura
O projeto adota a Arquitetura em 3 Camadas (3-Tier), promovendo baixo acoplamento, alta coesão e facilidade de manutenção e testabilidade:

[ Cliente / Frontend ]
          │ (HTTP REST / JSON)
          ▼

1. Presentation Layer (Controller)      ➔ Expõe Endpoints e valida entradas (@Valid)

                    │
                    ▼

2. Business Layer (Service)             ➔ Executa Regras de Negócio e DTO Mappings

                    │
                    ▼

3. Data Access Layer (Repository)       ➔ Persistência de Dados via Spring Data JPA

                    │
                    ▼
         [ Banco de Dados SQL ]
