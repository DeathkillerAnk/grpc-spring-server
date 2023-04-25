package com.demo.grpcdemo.primaryService.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DbMasterPojo {

    private Integer javisDbId;

    private Integer javisSiteId;

    private String dbName;

    private String phoneNum;

    private String email;

    private String dbUrl;

    private String gstin;

    private String address;

    private Integer javisCityId;

    private String city;

    private String pinCode;

    private Date rowcd;

    private Date rowud;

    private Integer userId;

    private Boolean active;

    @Override
    public String toString() {
        return "DbMaster{" +
                "javisDbId=" + javisDbId +
                ", javisSiteId=" + javisSiteId +
                ", dbName='" + dbName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", email='" + email + '\'' +
                ", dbUrl='" + dbUrl + '\'' +
                ", gstin='" + gstin + '\'' +
                ", address='" + address + '\'' +
                ", javisCityId=" + javisCityId +
                ", city='" + city + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", rowcd=" + rowcd +
                ", rowud=" + rowud +
                ", userId=" + userId +
                ", active=" + active +
                '}';
    }
}
