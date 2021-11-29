# Interface Design -  First
## Mario Castro Vélez

Este proyecto es el primer tutorial que hemos seguido para aprender diseño de interfaces en
Android Studio. Considero que la mejor forma de explicar su proceso de creación consiste en
seguir la división interna del proyecto, que ha sido también el flujo de aprendizaje. 
Aquí podemos ver la **estructura del proyecto**.

![issue tab](img/estructura.png)

## *Introducción*
*Grasshopper* simula una aplicación de rutas y senderismo, similar a algunos ejemplos reales como Wikiloc.
Sin romper con la temática agreste pero huyendo del cliché del color verde para temas naturales, me ha parecido interesante escoger una gama de colores azulados, con destacados de un amarillo vivo que se pueden asociar rápidamente con la alta montaña gracias a la imagen de fondo de la aplicación y al splash screen.

En este caso, los colores fríos resultan menos agresivos y resultan ideales para ocupar los espacios principales de la aplicación.

El logo y el nombre de la aplicación afirman y apuntalan esta idea: una bota en svg como logo
y de nombre "Grasshopper", o saltamontes en español.

## 1. *Android Manifest*
El documento xml *AndroidManifest*, uno de los ejes fundamentales de cualquier aplicación *android*, es en el lugar en el que declaramos la existencia de *Activities* y decidimos por cuál de ellas va a comenzar la aplicación al abrirse. Desde ahí
dirigimos el flujo de la aplicación.

## 2. *Java* y *Res*: *Layout*
En la carpeta Java podemos encontrar las clases en las que programamos las tareas de las ventanas.

Lo primero que nos encontramos es la *Splash Screen*, que es la ventana de recibimiento con el logo y una imagen de montañas, que va a marcar  las directrices cromáticas    del resto de la aplicación.

![issue tab](img/splash.png)

Desde la Splash Screen se accede automáticamente al **Login**, organizado de forma clásica con 
un espacio para el nombre de usuario y uno para la contraseña.

![issue tab](img/login.png)

Desde el Login podemos acceder al **Signup** mediante el botón de Registrarse. La pantalla de 
registro es similar a la del login pero con los espacios necesarios (EditText) para introducir
datos de registro. 

![issue tab](img/signup.png)

Una vez realizado el log in, accedemos al Main, donde estaría desarrollada la aplicación, en 
este caso una app hipotética.


3. [Resources]
    3.1. [Layout]
        En el Layout encontramos lo que probablemente sea la parte más importante del desarrollo
        de interfaces: los xml donde decidimos qué objetos vemos, su jerarquía, cómo se llaman
        para su desarrollo en el código, su aspecto y apariencia, etc. Aquí, cada xml es un
        activity.
    3.2. [Drawable y mipmap]
        En estas carpetas encontramos las imágenes y los diseños vectoriales que se utilizan en
        nuestra aplicación, tanto en el logo como en las activities.
    3.3. [Añadidos]
        Podemos crear carpetas de recursos nuevas para añadir algunos detalles personalizados, 
        como es el caso de las fuentes nuevas (font de tipo font) o el caso de las animaciones
        (anim/anim).        
