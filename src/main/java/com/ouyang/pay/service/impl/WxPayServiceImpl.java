package com.ouyang.pay.service.impl;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ouyang.adapter.PayNofityAdapterFactory;
import com.ouyang.constants.PayTypeConstants;
import com.ouyang.model.pay.PayNotifyVo;
import com.ouyang.model.pay.PayReqData;
import com.ouyang.model.pay.PaymentEntity;
import com.ouyang.order.service.OrderNotifyService;
import com.ouyang.pay.service.PayService;
import com.ouyang.util.XmlUtils;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class WxPayServiceImpl implements PayService {
	
	
	@Autowired
	private PayNofityAdapterFactory payNofityAdapterFactory;
	
	
	@Override
	public boolean supports(PayReqData payType) {
		return PayTypeConstants.PAY_TYPE_WX.equals(payType.getPayType());
	}
	

	@Override
	public PaymentEntity doPayment(PayReqData payReqData) {
		String orderNo = payReqData.getOrderNo();
		PaymentEntity payEntity = new PaymentEntity();
		payEntity.setPb("微信支付成功，订单号:["+orderNo+"]");
		System.out.println(payEntity.getPb());
		log.info("微信支付成功，订单号:{}",orderNo);
		return payEntity;
	}
	
	/**
	 * notifyBody微信返回的回调参数,根据不同的支付类型返回不同的格式进行解析
	 * 比如微信返回xml格式，阿里支付宝返回json
	 * <xml><trade_no>S010001</trade_no><attach>1</attach></xml>
	 */
	@Override
	public String notify(String notifyBody) {
		try {
			Map parseMap = XmlUtils.parseMap(notifyBody);
			PayNotifyVo vo = new PayNotifyVo();
			vo.setOrderNo(MapUtils.getString(parseMap, "trade_no"));
			vo.setType(MapUtils.getInteger(parseMap, "attach"));
			OrderNotifyService orderNotifyService = payNofityAdapterFactory.payNotifyServiceAdapter(vo);
			boolean processNotify = orderNotifyService.processNotify(vo);
			if(processNotify) {
				return "success";
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return "fail";
	}
	
}
