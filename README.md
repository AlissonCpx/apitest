# API TEST SD CONECTA

## Requisitos
Para construir e executar o projeto, você precisa:
- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven](https://maven.apache.org)

Para rodar o projeto é necessario clonar este repositorio e configurar o arquivo "reg.properties"
preencher os dados conforme recebido pela SD Conecta.

- prop.client_id = ??????
- prop.client_secret = ??????
- prop.grant_type = ??????


**ENDPOITS**

Foi utilizado o programa *[Insominia](https://insomnia.rest/download)* para testar as requisições, caso use o mesmo programa, pode importar as requisições com este [arquivo](https://github.com/AlissonCpx/apitest/blob/master/Request%20Insominia).

A aplicação ja é inicializada com o Usuário:
- {
    "createdAt": "2022-07-04T18:20:20.467",
    "updatedAt": "2022-07-04T18:20:20.467",
    "id": 1,
    "email": "Admin@email.com",
    "name": "Admin",
    "surname": null,
    "lastAuthorizationStatus": null,
    "crms": [],
    "mobile_phones": []
  }
-------------------------------------------------------
  
***Cadastrar***
<ul>
<li>Methot = POST</li>
<li>URL = "localhost:8080/User"</li>
<li> body = {
  "email": "usuario.teste-1@email.com",
	"password" : "123",
  "name": "João",
  "surname": "Da Silva",
  "crms": [
		    {
      "crm": "1234",
      "uf": "SP",
      "specialty": "Cardiologia"
    }
  ],
	"mobile_phones": [
   {
		 "ddd" : "53",
		 "number" : "981079970",
		 "type" : "celphone"
	 }
  ]
}</li>
</ul>

-------------------------------------------------------

***Atualizar***

  - Methot = PUT
  - URL = "localhost:8080/User"
  - body = {
  "id": 2,
  "email": "usuario.teste-1@email.com",
	"password" : "123",
  "name": "João",
  "surname": "Da Silva",
  "crms": [
		    {
      "crm": "1234",
      "uf": "SP",
      "specialty": "Cardiologia"
    }
  ],
	"mobile_phones": [
   {
		 "ddd" : "53",
		 "number" : "981079970",
		 "type" : "celphone"
	 }
  ]
}
-------------------------------------------------------

***Delete***
  - Methot = Delete
  - URL = "localhost:8080/User?id={ID}"
  - body = {}
  
***Lista Usuarios***
  - Methot = Get
  - URL = "localhost:8080/User"
  - body = {}
  
  - ***Lista um usuario***
  - Methot = Get
  - URL = "localhost:8080/User/getUser?id={ID}"
  - body = {}
-------------------------------------------------------
  
***Filtra um usuario por nome***
  - Methot = Get
  - URL = "localhost:8080/User/name={nome}"
  - body = {}
-------------------------------------------------------
  
***Filtra um usuario por especialidade***
  - Methot = Get
  - URL = "localhost:8080/User/specialty={ESPECIALIDADE}"
  - body = {}
-------------------------------------------------------
***Login***
<ul>
<li>Methot = POST</li>
<li>URL = "localhost:8080/Login"</li>
<li> body = {
	"email": "usuario.teste-1@email.com",
	"password" : "123"
}
</li>
</ul>

-------------------------------------------------------

