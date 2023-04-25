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
public class InvSummaryReqPojo {
    private List<Integer> companyIds ;
    private List<Integer> javisDbIds ;
    private String itemCode ;
    private Boolean active ;
    private Integer mrp;
}