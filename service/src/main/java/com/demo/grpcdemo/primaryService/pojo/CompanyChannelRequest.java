package com.demo.grpcdemo.primaryService.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompanyChannelRequest {
    List<String> appIDs;
    List<Integer> companyIDs;
    List<Integer> parentCompanyIDs;
    Boolean active;
}
