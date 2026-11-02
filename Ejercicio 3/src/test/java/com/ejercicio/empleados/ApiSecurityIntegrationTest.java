package com.ejercicio.empleados;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(properties = "api.key=test-api-key")
class ApiSecurityIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void rechazaSolicitudSinApiKey() throws Exception {
        mockMvc.perform(get("/api/empleados"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void respondeNoEncontradoParaEmpleadoInexistente() throws Exception {
        mockMvc.perform(get("/api/empleados/999")
                        .header("X-API-KEY", "test-api-key"))
                .andExpect(status().isNotFound());
    }
}
