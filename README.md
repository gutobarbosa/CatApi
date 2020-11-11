### Olá, Eu sou o Augusto e seja muito bem vinda(o) ao projeto que realizei :smiley:



###### Para facilitar o entendimento do que foi feito, vou sinalizar alguns pontos para que você entenda tudo, tudo mesmo :slightly_smiling_face:

###### vamos lá ?

**A Arquitetura utilizada foi a Restful Api**
![ArquiteturaCatApi](https://user-images.githubusercontent.com/46411054/98756906-383f0a00-23aa-11eb-9c06-6935ab030411.PNG)

### Documentação do projeto

- **Linguagem utilizada no projeto foi a Java.**
- **Framework utilizado:** Springboot.
- **Bibliotecas utilizadas:** Spring Data JPA, Spring Web, Lombok, modelmapper, logback, Slf4j, Optional, Mockito, Hamcrest.
- **IDE:** Intellij, Dbeaver.
- **Banco de dados:** PostgreSQL.
- **Ferramentas:** Docker, Postman.



### API'S

**Endpoints utilizados neste aplicação**

- **POST = localhost:8080/breeds/save**
  - *Aciona a rota externa para que os dados sejam salvos no banco de dados criado*
- **GET = localhost:8080/breeds/Nomedaraça**
  - *Ao ser acionada retorna todas as raças do banco de dados que contenham o nome adicionado ao final da rota*
- **GET = localhost:8080/breeds/origin/nomedaorigem**
  - *Ao ser acionada retorna todas as raças do banco de dados que contenham a origem passada no final da rota (paramento origin)*

- **GET = localhost:8080/breeds/origin/nomedotemperamento**
  - *Ao ser acionada retorna todas as raças que contenham o temperamento passado no final da rota (paramentro temperament)*

- **GET = localhost:8080/breeds**
  - *Retorna todas as raças cadastradas no banco de dados*



#### Documentação da arquitetura

- **Controller:** Package que contém a classe de conexão com as rotas internas.
  - **BreedController:**  Classe que possui todas as conexões de rotas configuradas.

- **Service:** Package que possui classes de interface de serviço e arquivos de implementação do serviço.
  - **BreedService:** Classe de Interface para a aplicação do BreedServiceImpl.
  - **BreedServiceImpl:** Classe de implementação das funções/logica/regra de negócio.
  - **ImageInfoService:** Classe de Interface para a aplicação do ImageInfoServiceImpl.
  - **ImageInfoServiceImpl:** Classe de implementação das funções/logica/regra de negócio.

- **Repository:** Package que contem os arquivos de interação com o banco de dados.
  - **BreedRepository:** Interface de conexão/interação com o banco de dados.
  - **ImageInfoRepository:** Interface de conexão/interação com o banco de dados.

- **Entity:** Package no qual contém classes que serviram para criar tabelas no banco de dados.
  - **BreedEntity:** Classe que contém todas colunas/tipos/relacionamentos da tabela que será criada.
  - **BreedImageInfoEntity:** Classe que contém todas colunas/tipos/relacionamentos da tabela que será criada.

* **HTTP:** Package que contém conexão externa.

  * **dto:** Package que contém a classe que informa tipos de retorno.
    * **Breeds:** Classe que nos diz quais são os dados que deverá ser retornado quando chamada.

  - **Component:**  Package que contem classes de conexão externa.
    - **BreedRoutes:** classe que interage com a API Externa, trata o dado para que seja realizado uma ação após isso.

- **Config:** Package que armenaza classes de configuração.
  - **AsyncConfiguration:** Classe contendo configurações de Thread.

- **Exception:** Package com classes utilizadas para tratativas da aplicação.
  - **ExceptionNotFound:** Classe usada para tratativa de erro do tipo "Não Encontrado".



###### Testes

- **Controller:** Package que contém a classe de conexão com as rotas internas.
  - **BreedControllerTeste:**  Classe que possui todas as conexões de rotas configuradas com a finalidade de testa-las ( teste unitário ).
  - Para não criar mais uma classe repository e service, apenas apliquei as já criadas no projeto através de injeção de dependência.



#### Documentação de como reproduzir a aplicação em localhost

###### Itens necessários

* JDK11
* Docker ou PostgreSQL (na maquina local)
* IntelliJ, Eclipse ou uma outra IDE de sua preferencia
* Postman, Insomnia ou outra ferramenta de requisição de API de sua preferencia.
* Dbeaver ou a propria ferramenta do PostgreSQL para consultar os dados do banco.
* Lembrando que no arquivo application.properties deve conter as informações, tais como usuario, senha e etc de acordo com as da sua maquina.



###### Para executar a aplicação

Basta executar a classe CatApiApplication e enquanto ela estiver rodando as requisições no postman darão retorno.



###### Para executar os testes

Basta executar o arquivo CatApiApplicationTests que os mesmos irão retornar os resultados



###### Abaixo alguns logs em execução

![Telasdelogs](https://user-images.githubusercontent.com/46411054/98757131-98ce4700-23aa-11eb-95b4-ed6fb5e8f0fb.png)


#### E é isso, qualquer duvida estou à disposição. :smiley:


