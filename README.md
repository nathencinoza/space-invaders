## SPACE INVADERS 

Se implementó un videojuego, aplicado los conceptos de:
* Programación orientada a objetos
* Principios de diseño
* Patrones de diseño 
* Testing

El juego es Space Invaders :). El patrón de diseño utilizado es Command, para configurar los controles del juego.

Descripción: En el juego Space Invaders, el jugador controla un cañón. Está a punto de salvar la Tierra de la invasión de los malvados invasores del espacio.

Modo de juego básico: el jugador controla el cañón en la parte inferior de la pantalla, que solo puede moverse horizontalmente. Los alienígenas se mueven tanto horizontal como verticalmente (acercándose al cañón). El cañón se puede controlar para disparar láser para destruir a los alienígenas, mientras que los alienígenas dispararán aleatoriamente hacia el cañón. Si un alienígena es disparado por el cañón, es destruido; si se dispara el cañón, se pierde una vida. Sin embargo, la posición de los alienígenas no se restablecerá si se pierde el cañón. El número inicial de vidas es tres.

Comportamiento alienígena: Los alienígenas están alineados en una formación rectangular, flotando lentamente en dirección horizontal. A medida que la formación llega a un lado, los alienígenas se acercan al fondo en cierta medida y comienzan a flotar en la dirección horizontal opuesta. Cualquier columna del alienígena puede disparar un láser hacia el cañón en un momento aleatorio.

Puntuaciones: Cada alienígena eliminado vale 10 pts.

Completar un nivel: cuando se eliminan todos los alienígenas, se completa el nivel.

Juego terminado: cuando se han perdido todas las vidas, o los alienígenas han alcanzado una cierta posición vertical (invadieron con éxito el planeta).
