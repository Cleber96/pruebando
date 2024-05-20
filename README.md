# ATRIBUTOS DE CALIDAD
 id | categorías
 --|--
 01 | calidad de diseño
 02 | calidad en tiempo de ejecución
 03 | calidad del sistema
 04 | calidad de usuario


## > RENDIMIENTO (tiempo de ejecución)
Capacidad de respuesta de un sistema para ejecitar cualquier acción en un intervalo de tiempo. puede medirse en tiempo de latencia

## descripción de escenario
### caso: REDDIT: red social
- interacción entre usuarios 
- origen: usuario en busca de contenido de un tema de interés
- estímulo: busca tema de interés para la interacción
- entorno: sistema operando de manera continua con gran cantidad de usuario. la latencia es 485ms desde el navegador del clientes hasata el sitio
artefacto: sitio web almacena su infrectructura en AWS
![imagen1](https://github.com/Cleber96/pruebando/blob/main/image1.jpeg)
![imagen2](https://github.com/Cleber96/pruebando/blob/main/image2.jpeg)
![imagen3](https://github.com/Cleber96/pruebando/blob/main/image3.jpeg)
- respuesta: viaje de ida y vuelta hasta que se muestre los resultados relacionados al temas buscado

## > SEGURIDAD: (en tiempo de ejecución)
Capacidad de un sistema para impedir acciones malintencionadas o accidentales ajenas al uso previsto
![imagen1](https://github.com/Cleber96/pruebando/blob/main/image4.jpeg)
![imagen2](https://github.com/Cleber96/pruebando/blob/main/image5.jpeg)

## > USABILIDAD:
Grado en que el app cumple los requisitos  del user siendo intuitíva y ofreciendo una buena experiencia 
## descripción de escenario
### caso: REDDIT: red social
![imagen1](https://github.com/Cleber96/pruebando/blob/main/image6.jpeg)
- busqueda intuitivo de la página sobre temas de interés
- origen: usuario en busca tema de interés de acceso sencillo
- estímulo: encontrar tema de interés accesible (comodidad) para intereacción
- entorno: gran comunidad de usuarios concurrentes. latencia 209 milisegundos desde que el usuario entra a la página y realiza una busqueda
![imagen1](https://github.com/Cleber96/pruebando/blob/main/image7.jpeg)
Artefacto: sitio web AMAZON service
Respuesta: viaje de ida y vuelta desde que el usuario busca entra a la página mediante el navegador y muestra el inicio
