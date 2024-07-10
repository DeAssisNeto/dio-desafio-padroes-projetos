package one.digitalinnovation.padroes.projeto.controllers;

import jakarta.validation.Valid;
import one.digitalinnovation.padroes.projeto.dtos.ProductOrderRecordDto;
import one.digitalinnovation.padroes.projeto.models.ProductOrderModel;
import one.digitalinnovation.padroes.projeto.services.ProductOrderService;
import one.digitalinnovation.padroes.projeto.utils.ApiGlobalResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/product-order")
public class ProductOrderController {
    @Autowired
    private ProductOrderService productOrderService;

    @PostMapping
    public ResponseEntity<ApiGlobalResponseDto> create(@RequestBody @Valid ProductOrderRecordDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiGlobalResponseDto(productOrderService.save(dto)));
    }

    @GetMapping
    public ResponseEntity<Page<ProductOrderModel>> findAll(@PageableDefault(
            page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC
    ) Pageable pageable) {
        return ResponseEntity.ok(productOrderService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiGlobalResponseDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(new ApiGlobalResponseDto(productOrderService.findOne(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiGlobalResponseDto> update(@PathVariable UUID id, @RequestBody @Valid ProductOrderRecordDto dto) {
        return ResponseEntity.ok(new ApiGlobalResponseDto(productOrderService.update(id, dto)));
    }
}
