package com.ouyang.model.pay;

import java.io.Serializable;

 
public class PayReqData implements Serializable {

    
    public String serviceType = "APP";

//    @Description("支付类型,可选默认wxpay,alipay(支付宝) wxpay(微信支付),applepay(苹果支付)")
    public String payType;

//    @Description("订单ID,必选")
    public String orderNo;

//    @Description("订单名称(可选)")
    public String orderName;
    
//    @Description("备注信息(可选)")
    public String remarks;
    
//    @Description("微信OpenId(可选)")
    public String openId;

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
