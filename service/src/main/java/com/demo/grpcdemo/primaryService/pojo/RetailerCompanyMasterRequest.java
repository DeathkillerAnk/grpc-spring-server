package com.demo.grpcdemo.primaryService.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RetailerCompanyMasterRequest {
    private Set<Integer> companyIds;
    private Set<Integer> javisOutletIds;
    private Set<Integer> salesAreaIds;
    private Set<Integer> javisSiteIds;
    private Boolean active;
    private Set<Integer> states;
    private Set<Integer> javisDbIds;
    private Set<String> beatCodes;
    private Set<Integer> javisSalesmanIds;
    private Set<String> beatDays;
    private Integer id;
    private Set<String> outletCodes;
}
