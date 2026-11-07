package io.entloom.server.api;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class OpenApiController {

    @GetMapping(value = "/openapi.yaml", produces = "text/yaml")
    public Resource openapi() {
        return new ClassPathResource("openapi/entloom.yaml");
    }
}
