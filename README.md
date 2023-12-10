# CRUDRestful
.
Arquitectura Hexagonal o de puertos y adaptadores

Estructura de paquetes: 
     
     aplicacion 
     servicios 
       puertos 
         entrada 
         salida 
      adaptadores 
          entrada 
          salida 
      dominio 
      comunes

Datos de entrada del servicio

Metodo Get: ninguno

Metodo post: http://localhost:8080/api/user

  "name": "Nombre del Usuario",
  "email": "usuario@email.com",
  "password": "contraseña",
  "phones":[
           { "number": "mobile",
             "citycode":"mobile",
             "contrycode":"mobile"
           }
           ]
}


Metodo put: http://localhost:8080/api/user/1
{
  "name": "Nombre del Usuario",
  "email": "usuario@email.com",
  "password": "contraseña",
  "phones": [
    {
      "number": "mobile",
      "citycode":"mobile",
      "contrycode":"mobile"
    }
  ]
}

Metodo delete: http://localhost:8080/api/user/1
