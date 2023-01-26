package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.dto.ProductSaveDto;
import com.kodilla.ecommercee.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductMapper {

    private final GroupRepository groupRepository;

    public Product mapToProduct(final ProductSaveDto productSaveDto){
        Product product = new Product();
        product.setName(productSaveDto.getName());
        product.setDescription(productSaveDto.getDescription());
        product.setPrice(productSaveDto.getPrice());
        product.setQty((productSaveDto.getQty()));
        return product;
    }
    public ProductDto mapToProductDto(final Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getGroup() != null ? String.valueOf(product.getGroup().getId()) : null
        );
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList) {
        return productList.stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }


    public Product mapToProduct(final ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        Group g = groupRepository.findById(Long.parseLong(productDto.getGroupId())).get();
        product.setGroup(g);

        return product;
    }

    public List<Product> mapToProductList(final List<ProductDto> productDtoList) {
        return productDtoList.stream()
                .map(this::mapToProduct)
                .collect(Collectors.toList());
    }

}

