package com.ouyang.pay.service;

import com.ouyang.model.pay.PayReqData;
import com.ouyang.model.pay.PaymentEntity;

public interface  PayService {
	
	/**
	 * 判断当前系统是否有匹配的支付类型组件
	 * @param payReqData
	 * @return
	 */
	public boolean supports(PayReqData payReqData);
	
//	public boolean supports(String  payType);
	
	/**
	 * 根据支付请求传递参数，执行支付
	 * @param payReqData
	 * @return
	 */
	public PaymentEntity doPayment(PayReqData payReqData);
	
	/**
	 * 支付回调
	 * @param payType 
	 * @param notifyBody
	 * @return
	 */
	public String  notify(String notifyBody);
}
