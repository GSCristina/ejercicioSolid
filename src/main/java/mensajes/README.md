# Análisis y corrección SOLID — Paquete: mensajes

## 1) Principio SOLID vulnerado principalmente
**Principio (SRP / OCP / LSP / DIP):**
**Principalmente OCP (Principio de Abierto/Cerrado)**
## 2) Justificación con evidencias
**Clase(s) y/o método(s) donde se concentra el problema:**
-
    - El método generar() en la clase GeneradorTextoMensajes.
    - La clase modelo Mensaje.

**Síntomas que lo delatan (marca y explica brevemente):**
-
    - El método generar() revisa el tipo de mensaje, esto viola directamente el OCP, ya que la clase no está cerrada a la modificación.
    - La clase Mensaje tiene atributos que no corresponden a todos los mensajes, esto obliga a rellenar de (null) las instancias en la clase App.

## 3) Inconvenientes del diseño actual
**Indica cambios futuros caros o arriesgados, partes difíciles de probar o mantener, errores fáciles de introducir si el proyecto crece...:**
-
    - Si se decide en un futuro crear un nuevo tipo de mensaje, habrá que tocar múltiples ficheros (añadir al enum, modificar el constructor gigante, añadir otro if en el generador).
    - Riesgo de NullPointerException: Al instanciar objetos con atributos a null por obligación del constructor, es muy fácil que otra parte del código intente acceder a ellos y la aplicación se rompa.

## 4) Propuesta y aplicación de la corrección
**Describe la refactorización (qué extraes, qué conviertes en interfaz, qué separas, etc.):**
-
    - Sustitución de condicionales por polimorfismo: Hemos eliminado el enum TipoMensaje y transformado Mensaje en una clase abstracta que contiene solo los atributos comunes.
    - Hemos creado subclases específicas (MensajeAviso, MensajeIncidencia, etc.) que extienden de Mensaje. Cada subclase tiene sus atributos específicos (sin necesidad de null`) y sabe cómo construirse a sí misma mediante el método sobreescrito generarContenido().
    - Ahora GeneradorTextoMensajes está cerrado a modificaciones. Simplemente hace msg.generarContenido(). Si mañana hay que añadir un nuevo tipo de mensaje, solo hay que crear una nueva clase, sin tocar el código existente.