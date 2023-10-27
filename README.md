# Mergulho Spring Boot

Projeto realizado durante a semana mergulho spring rest feito pela algaworks.

---

## Tecnologias Usadas

- Java 17
- Spring Framework
- Spring Validation
- Hibernate
- MySQL
- Model Mapper
- Flyway
- Swagger

---

## O que aprendi

- Como organizar o projeto de maneira mais eficiente.
- Como implementar o Exception Handler.
- Como utilizar o Model Mapper.
- Diferença entre o model e o dto(representation model).
- Annotation @Embeddable, @Embedded, @Valid, @JsonProperty(access = Access.READ_ONLY), @JsonInclude(Include.NON_NULL), @Transient
- O que é uma classe anemica: classe que só serve para criar o banco de dados.
- Maneira diferente de usar o @ManyToOne e @OneToMany.
- Como criar uma interface, onde implementamos as anotações do swagger e o controller implementa esta interface, deixando o controller mais limpo.
- Como utilizar o flyway para as migrations
- ISO-8601 é um padrao internacional para representar data e hora, por isso utilizamos a Classe OffsetDateTime.
- Quando não sabemos qual método http utilizar, PUT pode ser a solução, ela é idempotente, ou seja, após ser executado uma vez pode ser executada várias vezes que não será alterado mais nada.
