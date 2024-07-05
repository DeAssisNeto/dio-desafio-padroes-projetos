package one.digitalinnovation.padroes.projeto.services.impl;

import one.digitalinnovation.padroes.projeto.dtos.ProductRecordDto;
import one.digitalinnovation.padroes.projeto.exceptions.ResourceNotFoundException;
import one.digitalinnovation.padroes.projeto.models.ProductModel;
import one.digitalinnovation.padroes.projeto.repositories.ProductRepository;
import one.digitalinnovation.padroes.projeto.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<ProductModel> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public ProductModel findById(UUID id) {
        Optional<ProductModel> productModel = productRepository.findById(id);
        if (productModel.isPresent()) return productModel.get();

        throw new ResourceNotFoundException("Product", "id", id.toString());
    }

    @Override
    public ProductModel save(ProductRecordDto dto) {
        return productRepository.save(new ProductModel(dto));
    }

    @Override
    public ProductModel update(UUID id, ProductRecordDto dto) {
        Optional<ProductModel> productModel = productRepository.findById(id);
        if (productModel.isEmpty()) throw new ResourceNotFoundException("Product", "id", id.toString());
        ProductModel product = productModel.get();

        if (dto.name() != null) product.setName(dto.name());
        if (dto.price() != null) product.setPrice(dto.price());
        if (dto.expirationDate() != null) product.setExpirationDate(dto.expirationDate());
        if (dto.barCode() != null) product.setBarCode(dto.barCode());
        if (dto.stock() != null) product.setStock(dto.stock());

        return productRepository.save(product);

    }

    @Override
    public void delete(UUID id) {

    }
}
