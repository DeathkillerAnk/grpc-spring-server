package com.demo.grpcdemo.primaryService.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrdersRequestPojo {
    List<Integer> companyIds;

    private Date expiryDate;

    private Date orderDate;

    private List<Integer> javisDbIds; // Ship_From

    private List<Integer> javisCartNumbers;
}
