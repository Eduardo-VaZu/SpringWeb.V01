package pe.example.springWeb.v01.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import pe.example.springWeb.v01.controller.dto.ProductItem;
import pe.example.springWeb.v01.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductItem>> list() {
        List<ProductItem> items = productService.list();
        return ResponseEntity.ok(items);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid ProductItem productItem) {
        productService.create(productItem);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") @Min(1) Integer id,
            @RequestBody @Valid ProductItem productItem) {
        productService.update(id, productItem);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") @Min(1) Integer id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
