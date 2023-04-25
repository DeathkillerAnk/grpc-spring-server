package com.demo.grpcdemo.primaryService.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductGroupRequest {
    private List<Integer> companyIds;
    private List<String> itemCodes;
    private List<String> productGroups;
    private Boolean active;
}
