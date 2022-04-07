package br.com.letscode.ecommerce.controller;

import br.com.letscode.ecommerce.model.entity.FabricanteEntity;
import br.com.letscode.ecommerce.model.exchange.FabricanteRequest;
import br.com.letscode.ecommerce.service.FabricanteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("fabricantes")
@RestController
public class FabricanteController {

    private FabricanteService fabricanteService;

    @PostMapping
    public ResponseEntity<FabricanteEntity> create(
            @RequestBody FabricanteRequest request
    ){
        return ResponseEntity.created(null).body(fabricanteService.criar(request));
    }

}
