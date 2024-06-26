package one.digitalinnovation.padroes.projeto.controllers;

import one.digitalinnovation.padroes.projeto.dtos.CustomerRecordDto;
import one.digitalinnovation.padroes.projeto.models.CustomerModel;
import one.digitalinnovation.padroes.projeto.services.CustomerService;
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
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<ApiGlobalResponseDto> save(@RequestBody CustomerRecordDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ApiGlobalResponseDto(customerService.save(dto)));
    }

    @GetMapping
    public ResponseEntity<Page<CustomerModel>> getAllCustomers(@PageableDefault(
            page = 0,size = 10,sort = "id",direction = Sort.Direction.ASC
    ) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiGlobalResponseDto> getById(@PathVariable UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiGlobalResponseDto(customerService.findById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiGlobalResponseDto> update(@PathVariable UUID id, @RequestBody CustomerRecordDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiGlobalResponseDto(customerService.update(id, dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiGlobalResponseDto> delete(@PathVariable UUID id) {
        customerService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
