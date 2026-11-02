# API de proveedores

API REST con Spring Boot. Los datos se mantienen en memoria y se reinician al detener la aplicación.

## Ejecutar y probar

```powershell
mvn spring-boot:run
```

En Postman, incluye `X-API-KEY: 888` en cada solicitud:

- `POST /api/proveedores` — crea un proveedor.
- `GET /api/proveedores` — lista proveedores.
- `GET /api/proveedores?categoria=Tecnología` — filtra por categoría.
- `GET /api/proveedores/{id}` — consulta por id; devuelve 404 si no existe.

El cuerpo de creación requiere `nombre`, `apellido`, `correo`, `categoria` y `estado`:

```json
{
  "nombre": "Ana",
  "apellido": "López",
  "correo": "ana@example.com",
  "categoria": "Tecnología",
  "estado": true
}
```

Ejecuta `mvn test` para las pruebas unitarias y de seguridad.
