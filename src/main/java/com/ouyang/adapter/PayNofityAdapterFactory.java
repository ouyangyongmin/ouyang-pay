package com.ouyang.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ouyang.model.pay.PayNotifyVo;
import com.ouyang.order.service.OrderNotifyService;

/**
 * 支付业务类型处理器
 * @author Administrator
 *
 */
@Component
public class PayNofityAdapterFactory {
	
	@Autowired
	private List<OrderNotifyService> orderNotifyServices; 
	
	
	public OrderNotifyService payNotifyServiceAdapter(PayNotifyVo payNotifyVo) {
		for(OrderNotifyService payNotify:orderNotifyServices) {
			if(payNotify.supports(payNotifyVo)) {
				return payNotify;
			}
		}
		throw new RuntimeException("找不到支付回调组件");
	}
	 
}
