# API de empleados

API REST con Spring Boot. Los datos se mantienen en memoria y se reinician al detener la aplicación.

## Ejecutar y probar

```powershell
mvn spring-boot:run
```

En Postman, incluye `X-API-KEY: 080270` en cada solicitud:

- `POST /api/empleados` — crea un empleado.
- `GET /api/empleados` — lista empleados.
- `GET /api/empleados?especialidad=Contabilidad` — filtra por especialidad.
- `GET /api/empleados/{id}` — consulta por id; devuelve 404 si no existe.

El cuerpo de creación requiere `nombre`, `apellido`, `correo`, `especialidad` y `estado`:

```json
{
  "nombre": "Ana",
  "apellido": "López",
  "correo": "ana@example.com",
  "especialidad": "Contabilidad",
  "estado": true
}
```

Ejecuta `mvn test` para las pruebas unitarias y de seguridad.
