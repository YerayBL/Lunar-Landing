# Lunar-Landing
# Aplicación Web JPA

Práctica que consiste en crear una web dinámica, que resuelva peticiones a través de servlets para un juego en JavaScript.

###  Clases y documentos del proyecto

* index.jsp: Página de registro y login que realizan cada uno una petición a un servlet diferente.
* game.jsp: Página principal del proyecyo con el juego.
* lunar.js: Scripts del juego y peticiones de información para enviar como peticiones en el momento que haga falta.
* YblUsers.java: Entidad persistente de la tabla con el mismo nombre.
* YblScores.java: Entidad persistente de la tabla con el mismo nombre.
* ProyectListener.java: Listener del proyecto.
* ScoresService.java: Clase que se encarga de tratar las peticiones que serán necesarias en la tabla YblScores del persistance a 
través de el servlet que lo necesite.
* UsersService.java: Clase que tiene los métodos para pedir información a la tabla YblUsers para los servlets.
*ServletGame.java: En este servlet se tratan datos durante, antes y justo al terminar una partida. Para mantener datos actualizados 
en pantalla se fuerza una recarga de la página al reiniciar partida.
*ServletLogFilter.java: Filtro que permite a game.jsp ser la página principal pero no poder ser vista sin login, ya que redirige
a index.jsp.
*ServletLogin.java: Servlet que trata el login de index.jsp.
*ServletRegister.java: Servlet que trata el login de index.jsp.

###  Resumen del funcionamiento

Nada más arrancar se redirige a la página del juego. Si no existe una cookie de un login prévio, se redirige a la página index.jsp 
donde se ve un login y registro en la web. Todo esto lo trata el arranque y el filtro ServletLogFilter.java.
Una vez registrado se puede acceder al game.jsp.
Esto lo tratan los servlets Login y Registro uno actualiza en la base de datos, viendo que no exista el usuario a crear y 
actuliza la base de datos y el otro compara la información de login para ver si es correcta la información ,existe y así validar
el login.
Durante una partida se registran fechas de incio al empezar y puntuación y fecha de finalización. Con una petición ajax se actualiza
la información a través del servletGame pero no se vería en pantalla, así que se fuerza una recarga de la web que te dejará en el mismo punto.


