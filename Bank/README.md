# Recomendações para auxiliar a execução do programa

### Banco postgres
       <property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/bank"/>
    
### Criando banco e tabela
    CREATE DATABASE bank;
    CREATE TABLE acount(
        id bigserial primary key,
        accnumber int not null,
        usercpf varchar(14) not null,
        username varchar(255) not null,
        accbalance double precision not null,
        acclimit double precision not null,
        maxlimit double precision not null
    );
