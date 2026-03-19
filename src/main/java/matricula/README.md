# Análisis y corrección SOLID — Paquete: matricula

## 1) Principio SOLID vulnerado principalmente
**Principalmente SRP (Principio de Responsabilidad Única)**

Dependency Inversion Principle (DIP)
## 2) Justificación con evidencias
**Clase(s) y/o método(s) donde se concentra el problema:**

    - Clase MatriculaService al completo

**Síntomas que lo delatan (marca y explica brevemente):**

    -Es responsable de demasiadas cosas, notifica, valida, calcula precio, etc.

## 3) Inconvenientes del diseño actual
**Indica cambios futuros caros o arriesgados, partes difíciles de probar o mantener, errores fáciles de introducir si el proyecto crece...:**
    
    -Si se produce algun despiste y se introduce algo mal, produciria la caida de todo el programa.
    -No permite reutilizar nada.

## 4) Propuesta y aplicación de la corrección
**Describe la refactorización (qué extraes, qué conviertes en interfaz, qué separas, etc.):**
    
    - Se ha extraído la lógica de validación a una clase ValidadorDni.
    - Se ha extraído la creación de la cadena de texto a GeneradorInformes.
    - Se ha extraído el cálculo matemático de las tarifas a una clase CalculadoraPrecio.
    - Se ha extraído el envío de avisos a una clase Notificador.