package com.demo.grpcdemo.primaryService.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdersItemData {

    private Integer orderItemId;
    private Integer javisSkuId;
    private String skuCode;
    private String skuDesc;
    private Double skuQty;
    private String variant;
    private String packSize;
    private String brand;
    private Integer runId;
    private Date cancelDate;
    private Integer cancelUserId;
    private Integer userId;
    private Double skuTaxRate1;
    private Double skuTaxValue1;
    private Double skuTaxRate2;
    private Double skuTaxValue2;
    private Double skuTaxRate3;
    private Double skuTaxValue3;
    private Double sellerBasePrice;
    private Double sellerMrp;
    private String skuUom;
    private Double grossValue;
    private Double netValue;
    private Double discount;
    private String schemeCode;
    private Integer status = 1;
    private Integer state;
    private String currency;
    private String batch;
    private Integer errorCode = 0;
    private Integer amendmentState = 0;
    private String amendmentType;
    private String subOrderNumber;
    private Timestamp rowcd;
    private Timestamp rowud;

}
