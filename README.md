# Ejercicio Grupal: Mini Agenda Compartida

## Contexto
Una empresa pequeña desea organizar sus eventos internos (cumpleaños, juntas, convivencias, fechas clave) mediante una aplicación web donde cada empleado pueda consultar y registrar eventos.

El objetivo del cliente es contar con una herramienta sencilla, con una interfaz básica, funcional desde el navegador, que permita:
- Registrar eventos mediante un formulario.
- Visualizarlos organizados por fecha.

---

## Instrucciones

### 1. Creación del proyecto en equipo
- Utilizar **Spring Tool Suite (STS)** para crear un proyecto con `spring-boot-starter-web`.
- Dividir las responsabilidades entre los integrantes del equipo:
  - Configuración inicial
  - Capa de servicios
  - Controladores
  - Vistas
  - Pruebas unitarias
- Agregar al `pom.xml` las dependencias necesarias para:
  - JSP o Thymeleaf
  - Logging
  - Pruebas
  - Empaquetado en WAR

---

### 2. Configuración base del proyecto
Configurar en `application.properties`:
- Ruta de vistas
- Puerto personalizado
- Configuración del log

Documentar las propiedades agregadas y explicar su propósito.

---

### 3. Definición de modelo y beans
- Crear una clase `Evento` con los campos:
  - `titulo`
  - `fecha`
  - `descripcion`
  - `responsable`
- Declarar la clase como un Bean de Spring.
- Identificar las anotaciones utilizadas (`@Component`, `@Bean`, etc.) y documentar su propósito.

---

### 4. Capa de servicio e inyección
- Implementar una clase `AgendaServiceImpl` que gestione la lógica del sistema.
- Marcar la clase con `@Service`.
- Usar `@Autowired` para inyectar el servicio en el controlador.
- El servicio debe manejar una lista interna simulando una base de datos.
- Funcionalidades mínimas:
  - Agregar evento
  - Listar eventos
  - Buscar eventos por fecha

---

### 5. Controladores y peticiones
Crear un controlador con al menos tres rutas:
1. **GET** – Mostrar formulario
2. **POST** – Recibir y validar formulario
3. **GET** – Mostrar eventos agrupados por día

Manejar correctamente los parámetros recibidos y enviar los datos a las vistas según el modelo MVC.

---

### 6. Diseño de vistas y lógica en JSP/Thymeleaf
Desarrollar:
- Un formulario para registrar eventos
- Una vista para mostrar los eventos agrupados

Usar JSTL o Thymeleaf con:
- `c:out` o `${}` para mostrar información
- `c:if` y `c:choose` para validaciones
- `c:forEach` para iterar eventos

Aplicar funciones útiles como formateo de fechas o manejo de cadenas si es necesario.

---

### 7. Pruebas unitarias
Crear una clase de prueba usando `@SpringBootTest` para validar:
- Que los eventos se agregan correctamente
- Que pueden recuperarse por fecha adecuadamente

---

### 8. Empaquetado del proyecto
- Ejecutar:
```
mvn package
```
- Generar un archivo `.war`.
- Verificar que todas las configuraciones necesarias estén incluidas para su despliegue.

---

## Resultado esperado
Un proyecto colaborativo en Spring Boot, funcional, ordenado por capas, con vistas dinámicas, pruebas unitarias y empaquetado correcto para despliegue.

