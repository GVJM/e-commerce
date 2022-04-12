package br.com.letscode.shop.product;

import br.com.letscode.shop.product.requests.ProductRequest;
import br.com.letscode.shop.product.requests.StatusRequest;
import br.com.letscode.shop.product.requests.ValueRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@AllArgsConstructor
@RequestMapping("produtos")
@RestController
public class ProductController {

    private ProductService productService;

    @GetMapping()
    public ResponseEntity<Page<ProductEntity>> get(
            @RequestParam(name = "offset") Integer offset,
            @RequestParam(name = "limit") Integer limit,
            @RequestParam(name = "name", required = false) String name,
//            @RequestParam(name = "dataCriacao") String dataCriacao,
//            @RequestParam(name = "manufacturer") String manufacturer,
            @RequestParam(name = "max_value", required = false) BigDecimal maxValue
    ){
        Page<ProductEntity> products = productService.searchAll(offset, limit, name, maxValue);
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<ProductEntity> create(
            @RequestBody ProductRequest request
    ){
        ProductEntity product = productService.create(request);
        return ResponseEntity.created(null).body(product);
    }

    @GetMapping("/bar_code/{barCode}")
    public ResponseEntity<ProductEntity> getByBarCode(
            @PathVariable(name = "barCode") String barCode){

        ProductEntity product = productService.searchByBarCode(barCode);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/id/{id}/value")
    public ResponseEntity<ProductEntity> updateValue(
            @PathVariable(name = "id") Long id,
            @RequestBody ValueRequest valueRequest
    ){
        ProductEntity product = productService.updateValue(id,valueRequest);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/id/{id}/status")
    public ResponseEntity<ProductEntity> updateStatus(
            @PathVariable(name = "id") Long id,
            @RequestBody StatusRequest statusRequest
    ){
        ProductEntity product = productService.updateStatus(id,statusRequest);
        return ResponseEntity.ok(product);
    }
}
