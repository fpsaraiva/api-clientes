# api-clientes

Backend de um sistema de gerenciamento de clientes.

## Tecnologias utilizadas

* Java
* Springboot
* Spring Security
* JPA/Hibernate
* JWT
* OAuth
* Maven
* Swagger
* PostgreSQL
* Docker

## Rodando o projeto

1. Baixar o repositório na máquina local através do comando:
```
git clone https://github.com/fpsaraiva/api-clientes.git
```
2. Abrir o projeto na IDE.
3. Antes de subir a aplicação, no terminal (dentro da pasta raiz do projeto), subir o docker compose:
```
docker-compose up -d
```
4. Com o docker rodando, dar o start na aplicação.

## Endpoints

A documentação da API está disponível em http://localhost:8080/swagger-ui.html

*cliente-controller*
```
GET /api/clientes
POST /api/clientes
GET /api/cllientes/{id}
DELETE /api/clientes/{id}
PATCH /api/clientes/{id}
```

*usuario-controller*
```
/api/usuarios
```

## Bugs encontrados

* Tratar a exceção lançada quando usuário tenta logar com nome de usuário/senha senha errada (InvalidGrantException).

## Melhorias futuras

* Implementar testes automatizados.
* Permitir que apenas 1 endereço seja definido como principal.
* Deploy da aplicação.
