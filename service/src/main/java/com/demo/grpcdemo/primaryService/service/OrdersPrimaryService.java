package com.demo.grpcdemo.primaryService.service;

import com.demo.grpc.OrdersItemResponseList;
import com.demo.grpcdemo.iris.model.OrderItem;
import com.demo.grpcdemo.iris.model.OrderSummary;
import com.demo.grpcdemo.iris.repository.OrderItemRepository;
import com.demo.grpcdemo.primaryService.pojo.OrdersItemData;
import com.demo.grpcdemo.primaryService.pojo.OrdersItemResponse;
import com.demo.grpcdemo.primaryService.pojo.OrdersRequestPojo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Component
public class OrdersPrimaryService {

    @Autowired
    OrderItemRepository orderItemRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersPrimaryService.class);

    public List<OrdersItemResponse> getOrdersData(OrdersRequestPojo ordersRequestPojo) {
        log.info("inside getOrdersData");
        List<Integer> companyIds = ordersRequestPojo.getCompanyIds();
        Date expiryDate = ordersRequestPojo.getExpiryDate();
        Date orderDate = ordersRequestPojo.getOrderDate();
        List<Integer> javisDbIds = ordersRequestPojo.getJavisDbIds();
        List<Integer> javisCartNumbers = ordersRequestPojo.getJavisCartNumbers();

//        List<OrderItem> orderItems = orderItemRepository.findAll();
        List<Integer> cIDs = new ArrayList<>();
//        cIDs.add(1054);
        cIDs.add(1208);
        cIDs.add(1213);
//        cIDs.add(1207);
//        cIDs.add(1222);
//        cIDs.add(1242);
//        cIDs.add(1227);
//        cIDs.add(1221);

        Instant start = Instant.now();


        List<OrderItem> orderItems = orderItemRepository.findByOrderSummaryCompanyIdIn(cIDs);

        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("sql records: " + orderItems.size() + " query time: " + timeElapsed.toString());


        for (int i = 0; i < 3; i++)
//            for (int j = 0; j < orderItems.size(); j++)
                orderItems.addAll(orderItems);
//        LOGGER.info("total PoItems - "+ orderItems.size());

        orderItems =
                orderItems.stream().filter(of-> of.getOrderSummary() != null && of.getOrderSummary().getStatus().equals(1)).collect(
                        Collectors.toList());

        if(javisDbIds != null && !javisDbIds.isEmpty()){
            orderItems =
                    orderItems.stream().filter(of-> of.getOrderSummary() != null && javisDbIds.contains(of.getOrderSummary().getShipFrom())).collect(
                            Collectors.toList());
        }

//        else if (javisDbIds == null || javisDbIds.isEmpty()) {
//            orderItems =
//                    orderItemRepository.findByOrderSummaryCompanyIdInAndOrderSummaryExpiryDateGreaterThanEqualAndOrderSummaryOrderDateGreaterThanEqual(
//                            companyIds,
//                            expiryDate,
//                            orderDate);
//        }

        Map<Integer, List<OrderItem>> orderItemMap =
                orderItems.stream().collect(Collectors.groupingBy(OrderItem::getOrderId));

        List<OrdersItemResponse> ordersItemResponseList = new ArrayList<>();
        for (Map.Entry<Integer, List<OrderItem>> entry : orderItemMap.entrySet()){
            OrdersItemResponse ordersItemResponse = new OrdersItemResponse();

            OrderSummary orderSummary = entry.getValue().get(0).getOrderSummary();
            BeanUtils.copyProperties(orderSummary, ordersItemResponse);

            List<OrderItem> orderItemList = entry.getValue();
            List<OrdersItemData> ordersItemDataList = new ArrayList<>();
            for (OrderItem orderItem : orderItemList){
                OrdersItemData ordersItemData = new OrdersItemData();
                BeanUtils.copyProperties(orderItem, ordersItemData);
                ordersItemDataList.add(ordersItemData);
            }
            ordersItemResponse.setOrdersItemDataList(ordersItemDataList);

            ordersItemResponseList.add(ordersItemResponse);
        }
        LOGGER.info("final response size- "+ ordersItemResponseList.size());

        return ordersItemResponseList;
    }
    //grpc
//    public List<com.demo.grpc.OrdersItemResponseList> getOrdersDataGrpc(com.demo.grpc.OrdersRequestPojo ordersRequestPojo) {
//        log.info("inside getOrdersData");
//        List<Integer> companyIds = ordersRequestPojo.getCompanyIdsList();
//        Date expiryDate = new Date(ordersRequestPojo.getExpiryDate());
//        Date orderDate = new Date(ordersRequestPojo.getOrderDate());
//        List<Integer> javisDbIds = ordersRequestPojo.getJavisDbIdsList();
//        List<Integer> javisCartNumbers = ordersRequestPojo.getJavisCartNumbersList();
//
//        List<OrderItem> orderItems = new ArrayList<>();
//
//        if(javisCartNumbers == null || javisCartNumbers.isEmpty()) {
//            if (companyIds == null || companyIds.isEmpty()) {
//                return new ArrayList<>();
//            }
//            else if(expiryDate != null){
//                orderItems =
//                        orderItemRepository.findByOrderSummaryCompanyIdInAndOrderSummaryExpiryDateGreaterThanEqual(companyIds, expiryDate);
//            } else if(orderDate != null){
//                orderItems =
//                        orderItemRepository.findByOrderSummaryCompanyIdInAndOrderSummaryOrderDateGreaterThanEqual(companyIds, orderDate);
//
//            } else {
//                orderItems =
//                        orderItemRepository.findByOrderSummaryCompanyIdIn(companyIds);
//            }
//        }else{
//            orderItems = orderItemRepository.findAllByOrderSummaryJavisCartNumberIn(javisCartNumbers);
//        }
//
//        LOGGER.info("total PoItems - "+ orderItems.size());
//
//        orderItems =
//                orderItems.stream().filter(of-> of.getOrderSummary().getStatus().equals(1)).collect(
//                        Collectors.toList());
//
//        if(javisDbIds != null && !javisDbIds.isEmpty()){
//            orderItems =
//                    orderItems.stream().filter(of-> javisDbIds.contains(of.getOrderSummary().getShipFrom())).collect(
//                            Collectors.toList());
//        }
//
////        else if (javisDbIds == null || javisDbIds.isEmpty()) {
////            orderItems =
////                    orderItemRepository.findByOrderSummaryCompanyIdInAndOrderSummaryExpiryDateGreaterThanEqualAndOrderSummaryOrderDateGreaterThanEqual(
////                            companyIds,
////                            expiryDate,
////                            orderDate);
////        }
//
//        Map<Integer, List<OrderItem>> orderItemMap =
//                orderItems.stream().collect(Collectors.groupingBy(OrderItem::getOrderId));
//
//        List<OrdersItemResponse> ordersItemResponseList = new ArrayList<>();
//        for (Map.Entry<Integer, List<OrderItem>> entry : orderItemMap.entrySet()){
//            OrdersItemResponse ordersItemResponse = new OrdersItemResponse();
//
//            OrderSummary orderSummary = entry.getValue().get(0).getOrderSummary();
//            BeanUtils.copyProperties(orderSummary, ordersItemResponse);
//
//            List<OrderItem> orderItemList = entry.getValue();
//            List<OrdersItemData> ordersItemDataList = new ArrayList<>();
//            for (OrderItem orderItem : orderItemList){
//                OrdersItemData ordersItemData = new OrdersItemData();
//                BeanUtils.copyProperties(orderItem, ordersItemData);
//                ordersItemDataList.add(ordersItemData);
//            }
//            ordersItemResponse.setOrdersItemDataList(ordersItemDataList);
//
//            ordersItemResponseList.add(ordersItemResponse);
//        }
//        LOGGER.info("final response size- "+ ordersItemResponseList.size());
//
//        return ordersItemResponseList;
//    }
}
