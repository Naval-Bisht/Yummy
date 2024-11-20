package org.naval.assignment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record Productrequest (

        @JsonProperty("product_name")
        String productName,
        @JsonProperty("price")
        int price,
        int min,int max


    ){}
