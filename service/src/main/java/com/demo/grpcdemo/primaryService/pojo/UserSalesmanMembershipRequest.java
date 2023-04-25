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
public class UserSalesmanMembershipRequest {
    private Integer id;
    private List<Integer> userIds;
    private List<Integer> javisSalesmanIds;
    private Boolean active;
}
