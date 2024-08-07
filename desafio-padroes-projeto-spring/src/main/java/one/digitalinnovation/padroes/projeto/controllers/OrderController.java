package one.digitalinnovation.padroes.projeto.controllers;

import one.digitalinnovation.padroes.projeto.dtos.OrderRecordDto;
import one.digitalinnovation.padroes.projeto.models.OrderModel;
import one.digitalinnovation.padroes.projeto.services.OrderService;
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
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<ApiGlobalResponseDto> save(@RequestBody OrderRecordDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiGlobalResponseDto(orderService.save(dto)));
    }

    @GetMapping
    public ResponseEntity<Page<OrderModel>> findAll(@PageableDefault(
            page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC
    )Pageable pageable) {
        return ResponseEntity.ok(orderService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiGlobalResponseDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(new ApiGlobalResponseDto(orderService.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiGlobalResponseDto> update(@PathVariable UUID id, @RequestBody OrderRecordDto dto) {
        return ResponseEntity.ok(new ApiGlobalResponseDto(orderService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiGlobalResponseDto> delete(@PathVariable UUID id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
