package com.demo.grpcdemo.primaryService.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecondaryProductRequest {

    private List<Integer> companyIds;
    private List<String> productGroups;
    private List<Integer> javisDbIds;
    private String userLanguage;
    private Integer javisOutletId;
    private String brand;
    private String variant;
    private String group;
    private String packSize;
    private String materialForm;
    private String measurementUnit;
    private Integer mrp;
}
