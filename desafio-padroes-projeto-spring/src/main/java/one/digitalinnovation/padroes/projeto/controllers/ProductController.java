package one.digitalinnovation.padroes.projeto.controllers;

import jakarta.validation.Valid;
import one.digitalinnovation.padroes.projeto.dtos.ProductRecordDto;
import one.digitalinnovation.padroes.projeto.models.ProductModel;
import one.digitalinnovation.padroes.projeto.services.ProductService;
import one.digitalinnovation.padroes.projeto.utils.ApiGlobalResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ApiGlobalResponseDto> addProduct(@RequestBody @Valid ProductRecordDto product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiGlobalResponseDto(productService.save(product)));
    }

    @GetMapping
    public ResponseEntity<Page<ProductModel>> findAll(Pageable pageable) {
        return ResponseEntity.ok(productService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiGlobalResponseDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(new ApiGlobalResponseDto(productService.findById(id)));
    }


}
