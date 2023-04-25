package com.demo.grpcdemo.primaryService.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrdersItemResponse {
    private Integer orderId;
    private Integer companyId;
    private Integer javisCartNumber;
    private String poNumber;
    private Integer javisDepotId;
    private String orderType;
    private Integer shipToParty;
    private Date orderDate;
    private Date deliveryDate;
    private Date expiryDate;
    private Integer shipFrom;
    private String dbCode;
    private String depotCode;
    private String salesmanCode;
    private String salesArea;
    private Integer salesAreaId;
    private String region;
    private String dbName;
    private String outletCode;
    private String channel;
    private String currency;
    private Integer skuCount;
    private Integer userId;
    private Integer soldToParty;
    private Double grossValue;
    private Double netValue;
    private Double tax1;
    private Double tax2;
    private Double tax3;
    private Double discount;
    private Integer status;
    private Integer state;
    private String beatName;
    private String beatDays;
    private String beatCode;
    private String outletName;
    private Timestamp rowcd;
    private Timestamp rowud;
    List<OrdersItemData> ordersItemDataList;
}
