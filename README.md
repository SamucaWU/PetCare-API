# PetCare-API
Sistema de Gerenciamento de PetShop e Clinicas Veterinarias: O PetCare API é uma solução RESTful desenvolvida em Java com Spring Boot, projetada para otimizar a gestão operacional e clínica de pet shops e clínicas veterinárias. O sistema permite o gerenciamento completo de tutores, pets, agendamentos de serviços e históricos médicos (prontuários).

# Estruturas de Pacotes
com.petcare.api
├── controller/            # Endpoints REST e anotações @RestController
├── service/               # Classes @Service com regras de negócio
├── repository/            # Interfaces Spring Data JPA
├── model/                 # Entidades JPA do domínio (@Entity)
│   └── enums/             # Enums (Especie, TipoServico, StatusAgendamento)
├── dto/                   # Request e Response DTOs
└── exception/             # Manipulador global (@RestControllerAdvice) e exceções customizadas
