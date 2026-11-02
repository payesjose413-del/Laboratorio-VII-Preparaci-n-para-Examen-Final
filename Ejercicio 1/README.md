# API de profesores

API REST con Spring Boot. Los datos se mantienen en memoria y se reinician al detener la aplicación.

## Ejecutar y probar

```powershell
mvn spring-boot:run
```

En Postman, incluye `X-API-KEY: mi-clave-123` en cada solicitud:

- `POST /api/profesores` — crea un profesor.
- `GET /api/profesores` — lista profesores.
- `GET /api/profesores?especialidad=Matemáticas` — filtra por especialidad.
- `GET /api/profesores/{id}` — consulta por id; devuelve 404 si no existe.

El cuerpo de creación requiere `nombre`, `apellido`, `correo`, `especialidad` y `estado`:

```json
{
  "nombre": "Ana",
  "apellido": "López",
  "correo": "ana@example.com",
  "especialidad": "Matemáticas",
  "estado": true
}
```

Ejecuta `mvn test` para las pruebas unitarias y de seguridad.
