Readme:
# Análisis y corrección SOLID — Ejercicio 4

## 1) Principio SOLID vulnerado principalmente
**Principio:** DIP (Dependency Inversion Principle / Principio de Inversión de Dependencias).

## 2) Justificación con evidencias
**Clase(s) y/o método(s) donde se concentra el problema:**
- En la declaración de atributos de la clase `AltaEmpleadoService`.

**Síntomas que lo delatan (marca y explica brevemente):**
- **Acoplamiento fuerte por uso de `new`:** El servicio instancia directamente a `RepositorioEmpleadosEnMemoria` y a `GeneradorPasswordSimple`. Esto significa que el módulo de alto nivel (la lógica de negocio del alta) depende directamente de módulos de bajo nivel (los detalles de cómo se guarda en memoria y cómo se genera el string del password). El código está rígidamente soldado a esas dos clases concretas.

## 3) Inconvenientes del diseño actual
**Indica cambios futuros caros o arriesgados, partes difíciles de probar o mantener, errores fáciles de introducir si el proyecto crece...:**
- **Testing unitario imposible:** Al tener los `new` dentro del servicio, no podemos hacer un test aislado de `AltaEmpleadoService` sin que se ejecute obligatoriamente el código de guardado en el mapa real. No podemos usar *mocks* (simulacros).
- **Falta de flexibilidad frente a cambios:** Si el día de mañana la empresa decide guardar los empleados en una base de datos MySQL en lugar de en memoria, tendríamos que entrar a modificar el código fuente de `AltaEmpleadoService` (rompiendo OCP de paso).

## 4) Propuesta y aplicación de la corrección
**Describe la refactorización (qué extraes, qué conviertes en interfaz, qué separas, etc.):**
- **Creación de interfaces:** Hemos extraído los métodos públicos de las herramientas a dos interfaces: `RepositorioEmpleados` y `GeneradorPassword`.
- **Inyección de Dependencias:** Modificamos `AltaEmpleadoService` para que sus atributos sean de tipo Interfaz, y se los pasamos a través del constructor. De este modo, la clase no sabe *cómo* se guarda ni *cómo* se genera el password, solo sabe *que* puede hacerlo.
- **Delegación a la raíz (App):** Es la clase `App` (el punto de entrada del programa) la encargada de instanciar las clases concretas y "enchufarlas" al servicio. Si en el futuro cambiamos a base de datos, solo tocaremos la clase `App` para inyectar una implementación distinta.