package one.digitalinnovation.padroes.projeto.controllers;

import one.digitalinnovation.padroes.projeto.dtos.AddressRecordDto;
import one.digitalinnovation.padroes.projeto.models.AddressModel;
import one.digitalinnovation.padroes.projeto.services.AddresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    private AddresService addresService;

    @PostMapping
    public ResponseEntity<AddressModel> addAddress(@RequestBody AddressRecordDto address) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addresService.save(address));
    }

    @GetMapping
    public ResponseEntity<Page<AddressModel>> getAll(@PageableDefault(
                    page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC
            ) Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(addresService.findAll(pageable));
    }
}
