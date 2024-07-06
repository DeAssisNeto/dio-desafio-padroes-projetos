package one.digitalinnovation.padroes.projeto.controllers;

import one.digitalinnovation.padroes.projeto.dtos.OrderRecordDto;
import one.digitalinnovation.padroes.projeto.models.OrderModel;
import one.digitalinnovation.padroes.projeto.services.OrderService;
import one.digitalinnovation.padroes.projeto.utils.ApiGlobalResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<OrderModel>> findAll(Pageable pageable) {
        return ResponseEntity.ok(orderService.findAll(pageable));
    }
}
