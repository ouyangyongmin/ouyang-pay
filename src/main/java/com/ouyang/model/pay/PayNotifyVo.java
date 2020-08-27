package com.ouyang.model.pay;

import java.util.Date;

import io.swagger.annotations.ApiModelProperty;


public class PayNotifyVo {

	@ApiModelProperty(value="系统订单编号",example="")
	private String orderNo;
	
	@ApiModelProperty(value="支付时间",example="")
	private Date payTime;
	
	@ApiModelProperty(value="支付通道流水号",example="1217752501201407033233368018")
	private String payNo;

	//新增appId和openId
	//如果是小程序，需要获取union_id
	@ApiModelProperty(value="小程序ID",example="")
	private String appid;

	@ApiModelProperty(value="用户标识",example="")
	private String openId;

	@ApiModelProperty(value="订单类型,3表示认证课订单")
	private Integer type;

	@ApiModelProperty(value="支付客户端",example="1、支付宝2、微信3、苹果")
	private Integer payClient;
	

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getPayNo() {
		return payNo;
	}

	public void setPayNo(String payNo) {
		this.payNo = payNo;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPayClient() {
		return payClient;
	}

	public void setPayClient(Integer payClient) {
		this.payClient = payClient;
	}

	@Override
	public String toString() {
		return "PayNotifyVo [orderNo=" + orderNo + ", payTime=" + payTime + ", payNo=" + payNo + ", appid=" + appid
				+ ", openId=" + openId + ", type=" + type + ", payClient=" + payClient + "]";
	}
	
	
	 
}
