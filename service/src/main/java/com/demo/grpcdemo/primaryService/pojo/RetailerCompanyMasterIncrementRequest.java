package com.demo.grpcdemo.primaryService.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RetailerCompanyMasterIncrementRequest {
    Set<Integer> javisOutletIds;
    @Builder.Default
    Integer smsCountIncrement = 0;
    @Builder.Default
    Integer whatsappCountIncrement = 0;
    @Builder.Default
    Integer noSmsFailureCountIncrement = 0;
    @Builder.Default
    Integer smsFailureCountIncrement = 0;
    Integer companyId;
}
