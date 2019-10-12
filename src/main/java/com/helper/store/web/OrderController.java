package com.helper.store.web;

import com.helper.store.domain.JsonMessage;
import com.helper.store.service.OrderService;
import com.helper.store.util.Constants;
import com.helper.store.util.ParamsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yanghao
 * @create 2019-08-08 16:22
 * @Description:
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    /**
     * 生成订单
     * @param request
     * @return
     */
    @PostMapping("/saveOrder")
    public JsonMessage saveOrder(HttpServletRequest request){
        Map<String,Object> param = ParamsUtils.getParmas(request);
        return orderService.saveOrder(param);
    }



    /**
     * 取消订单
     * @param request
     * @return
     */
    @PostMapping("/cancelOrder")
    public JsonMessage cancelOrder(HttpServletRequest request){
        Map<String,Object> param = ParamsUtils.getParmas(request);
        return orderService.cancelOrder(param);
    }


    /**
     * 取消订单还原鞋子订单
     * @param request
     * @return
     */
    @PostMapping("/restoreSell2")
    public JsonMessage restoreSellBulk(HttpServletRequest request){
        Map<String,Object> param = ParamsUtils.getParmas(request);
        return orderService.restoreSell2(param);
    }

    @PostMapping("/shoeSell")
    public JsonMessage shoeSell(HttpServletRequest request){
        Map<String,Object> param = ParamsUtils.getParmas(request);
        return orderService.shoeSell(param);
    }

    @PostMapping("/shoeSell2")
    public JsonMessage shoeSell2(HttpServletRequest request){
        Map<String,Object> param = ParamsUtils.getParmas(request);
        return orderService.shoeSell2(param);
    }


    /**
     * 立即付款
     * @param request
     * @return
     */
    @PostMapping("/payOrder")
    public JsonMessage payOrder(HttpServletRequest request){
        Map<String,Object> param = ParamsUtils.getParmas(request);
        return orderService.payOrder(param);
    }
    /**
     * 填写快递订单号
     * @param request
     * @return
     */
    @GetMapping(value = "/inputTrackingNumber")
    public JsonMessage updateStoreName(HttpServletRequest request){
        JsonMessage result = new JsonMessage();
        Map<String, Object> data = new HashMap<String, Object>(16);
        Map<String, Object> param = ParamsUtils.getParmas(request);
        try {
            orderService.inputTrackingNumber(param);
            result.setResponseCode(Constants.RES_CODE_0);
            result.setErrorMessage(Constants.RES_MESSAGE_0);
        }catch (Exception e){
            result.setResponseCode(Constants.RES_CODE_101);
            result.setErrorMessage(Constants.RES_MESSAGE_101);
        }
        return result;
    }
    /**
     * 获取快递单号
     * @param request
     * @return
     */
    @GetMapping("/getTrackingNumber")
    public JsonMessage getTrackingNumber(HttpServletRequest request){
        JsonMessage result = new JsonMessage();
        Map<String, Object> data = new HashMap<String, Object>(16);
        Map<String, Object> param = ParamsUtils.getParmas(request);
        try {
            Map<String,Object> trackingNumber = orderService.getTrackingNumber(param);
            data.put("trackingNumber", trackingNumber);
            result.setResponseCode(Constants.RES_CODE_0);
            result.setErrorMessage(Constants.RES_MESSAGE_0);
            result.setData(data);
        }catch (Exception e){
            result.setResponseCode(Constants.RES_CODE_101);
            result.setErrorMessage(Constants.RES_MESSAGE_101);
        }
        return result;
    }
    /**
     * 根据buysellID获取订单信息
     * @param request
     * @return
     */
    @GetMapping("/getOrderByBuyorsellId")
    public JsonMessage getOrderByBuyorsellId(HttpServletRequest request){
        JsonMessage result = new JsonMessage();
        Map<String, Object> data=new HashMap<String, Object>(16);
        Map<String, Object> param = ParamsUtils.getParmas(request);
        try {
            List<Map<String, Object>> list = orderService.getOrderByBuyorsellId(param);
            data.put("orderList",list);
            result.setResponseCode(Constants.RES_CODE_0);
            result.setErrorMessage(Constants.RES_MESSAGE_0);
            result.setData(data);
        }catch (Exception e){

            result.setResponseCode(Constants.RES_CODE_101);
            result.setErrorMessage(Constants.RES_MESSAGE_101);
        }
        return result;
    }


    /**
     * 删除订单
     * @param request
     * @return
     */
    @PostMapping("/deleteOrder")
    public JsonMessage deleteOrder(HttpServletRequest request){
        Map<String,Object> param = ParamsUtils.getParmas(request);
        return orderService.deleteOrder(param);
    }

    /**
     * 确认收货
     *
     */
    @PostMapping("/orderFinish")
    public JsonMessage orderFinish(HttpServletRequest request){
        JsonMessage result = new JsonMessage();
        Map<String, Object> data = new HashMap<String, Object>(16);
        Map<String, Object> param = ParamsUtils.getParmas(request);
        try {
            orderService.orderFinish(param);
            result.setResponseCode(Constants.RES_CODE_0);
            result.setErrorMessage(Constants.RES_MESSAGE_0);
        }catch (Exception e){
            result.setResponseCode(Constants.RES_CODE_101);
            result.setErrorMessage(Constants.RES_MESSAGE_101);
        }
        return result;
    }

    @PostMapping("/sellUserBalance")
    public void sellUserBalance(HttpServletRequest request){
        Map<String,Object> param = ParamsUtils.getParmas(request);
         orderService.sellUserBalance(param);
    }

    @PostMapping("/buyUserBalance")
    public void buyUserBalance(HttpServletRequest request){
        Map<String,Object> param = ParamsUtils.getParmas(request);
        orderService.buyUserBalance(param);
    }

    /**
     * 通知消息
     * @param request
     * @return
     */
    @PostMapping("selectNotice")
    public JsonMessage selectNotice(HttpServletRequest request){
        JsonMessage result = new JsonMessage();
        Map<String, Object> data = new HashMap<String, Object>(16);
        Map<String, Object> param = ParamsUtils.getParmas(request);
        try {
            orderService.selectNoticeBuy(param);
            orderService.selectNoticeSell(param);
            result.setResponseCode(Constants.RES_CODE_0);
            result.setErrorMessage(Constants.RES_MESSAGE_0);
        }catch (Exception e){
            result.setResponseCode(Constants.RES_CODE_101);
            result.setErrorMessage(Constants.RES_MESSAGE_101);
        }
        return result;
    }

    @PostMapping("updateRead")
    public JsonMessage updateRead(HttpServletRequest request){
        JsonMessage result = new JsonMessage();
        Map<String, Object> data = new HashMap<String, Object>(16);
        Map<String, Object> param = ParamsUtils.getParmas(request);
        try {
            orderService.updateNotice(param);
            result.setResponseCode(Constants.RES_CODE_0);
            result.setErrorMessage(Constants.RES_MESSAGE_0);
        }catch (Exception e){
            result.setResponseCode(Constants.RES_CODE_101);
            result.setErrorMessage(Constants.RES_MESSAGE_101);
        }
        return result;

    }
}
