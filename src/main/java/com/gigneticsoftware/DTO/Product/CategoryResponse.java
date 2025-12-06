package com.gigneticsoftware.DTO.Product;

import lombok.Data;

import java.util.List;

@Data
public class CategoryResponse {
    private String id;
    private String name;
    private String iconUrl;
    private List<ProductResponse> products;
}
