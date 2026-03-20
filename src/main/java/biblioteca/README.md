# Análisis y corrección SOLID — Ejercicio 3

## 1) Principio SOLID vulnerado principalmente
**Principio:** LSP (Liskov Substitution Principle / Principio de Sustitución de Liskov).

## 2) Justificación con evidencias
**Clase(s) y/o método(s) donde se concentra el problema:**
- La clase `LibroReferencia`, concretamente en su método sobrescrito `@Override public void prestarA(...)`.

**Síntomas que lo delatan (marca y explica brevemente):**
- **Violación del contrato esperado:** La superclase `Libro` define un método `prestarA(dni, fecha)` con la promesa de guardar ese DNI y esa fecha. Sin embargo, `LibroReferencia` hereda este método pero **ignora los parámetros del cliente**, asignando valores fijos ("SALA" y la fecha de hoy).
- Esto es un "falso polimorfismo". Si sustituimos un `Libro` por un `LibroReferencia`, el programa se comporta de forma incorrecta e inesperada para quien llama al método (el servicio cree que prestó el libro a un DNI, pero el objeto hizo otra cosa en secreto).

## 3) Inconvenientes del diseño actual
**Indica cambios futuros caros o arriesgados, partes difíciles de probar o mantener, errores fáciles de introducir si el proyecto crece...:**
- **Inconsistencia de datos:** El sistema (`PrestamoService`) imprimirá un ticket o guardará un registro diciendo "Diccionario prestado a 12345678A", pero el estado interno del objeto dirá que está prestado a "SALA". Esto corrompe la lógica de negocio.
- **Herencia forzada:** Obligar a una clase a heredar métodos que no puede usar lógicamente (como obligar a un pingüino a heredar el método `volar()`) provoca código lleno de parches, excepciones `UnsupportedOperationException` o, como en este caso, comportamientos falsos.

## 4) Propuesta y aplicación de la corrección
**Describe la refactorización (qué extraes, qué conviertes en interfaz, qué separas, etc.):**
- **Corrección de la jerarquía de herencia:** Hemos roto la herencia directa entre `Libro` y `LibroReferencia`.
- Se ha creado una clase base abstracta `ItemBiblioteca` que contiene únicamente lo que ambos comparten: el `titulo`.
- `Libro` hereda de `ItemBiblioteca` y **sí** define la lógica, los atributos y los métodos para ser prestado.
- `LibroReferencia` hereda de `ItemBiblioteca`, pero no implementa lógica de préstamo, sino su propio comportamiento (`consultarEnSala()`).
- Al hacer esto, el compilador protege al `PrestamoService`, impidiendo por tipado estricto que nadie intente pasarle un `LibroReferencia` a su método `prestar()`.