package com.ouyang.adapter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ouyang.model.pay.PayReqData;
import com.ouyang.pay.service.PayService;

/**
 * 支付类型适配工厂,根据支付方式找到对应的处理支付处理器组件
 * @author Administrator
 *
 */
@Component
public class PayAdapterFactory {
	
	@Autowired
	private  List<PayService> payServices;
	
	public PayService payServiceAdapter(PayReqData payData) {
		for(PayService pay:payServices) {
			if(pay.supports(payData)) {
				return pay;
			}
		}
		throw new RuntimeException("找不到支付类型");
	}

}
