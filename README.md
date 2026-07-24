# PetCare-API
Sistema de Gerenciamento de PetShop e Clinicas Veterinarias: O PetCare API é uma solução RESTful desenvolvida em Java com Spring Boot, projetada para otimizar a gestão operacional e clínica de pet shops e clínicas veterinárias. O sistema permite o gerenciamento completo de tutores, pets, agendamentos de serviços e históricos médicos (prontuários).


## Visão Geral da Arquitetura
O projeto adota a Arquitetura em 3 Camadas (3-Tier), promovendo baixo acoplamento, alta coesão e facilidade de manutenção e testabilidade:


### [ Cliente / Frontend ]
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



## Estruturas de Pacotes
com.petcare.api
- controller/            `Endpoints REST e anotações @RestController`
- service/               `Classes @Service com regras de negócio`
- repository/            `Interfaces Spring Data JPA`
- model/                 `Entidades JPA do domínio (@Entity)`
- model/enums/           `Enums (Especie, TipoServico, StatusAgendamento)`
- dto/                   `Request e Response DTOs`
- exception/             `Manipulador global (@RestControllerAdvice) e exceções customizadas`
