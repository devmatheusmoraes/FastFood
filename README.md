# FastFood - Controle de Pedidos

O projeto FastFood é um sistema de controle de pedidos desenvolvido com Spring Boot. Ele gerencia solicitações de alimentos, bebidas e sobremesas.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas antes de executar o projeto:

- Java JDK 17
- Maven
- Git

## Configuração do Ambiente

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/fastfood.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd fastfood
   ```
   
## Executando o Projeto

Execute o seguinte comando para compilar e iniciar o aplicativo:

```bash
mvn spring-boot:run
```

O aplicativo estará acessível em http://localhost:8080.

## Endpoints

O projeto oferece os seguintes endpoints:

- `GET /pedidos`: Retorna todos os pedidos.
- `GET /pedidos/{id}`: Retorna um pedido específico pelo ID.
- `POST /pedidos`: Cria um novo pedido.
- `PUT /pedidos/{id}`: Atualiza um pedido existente.
- `DELETE /pedidos/{id}`: Exclui um pedido pelo ID.

Certifique-se de consultar a documentação completa da API para obter detalhes sobre a utilização de cada endpoint.

## Contribuindo

Sinta-se à vontade para contribuir com melhorias no projeto. Para contribuir, siga estas etapas:

1. Faça um fork do repositório.
2. Crie uma branch para suas alterações: `git checkout -b feature/nova-feature`.
3. Faça as alterações desejadas.
4. Commit suas mudanças: `git commit -m 'Adiciona nova feature'`.
5. Faça push para a branch: `git push origin feature/nova-feature`.
6. Abra um pull request.

## Licença

Este projeto é licenciado sob a MIT License.
