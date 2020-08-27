package com.ouyang.order.service;

import com.ouyang.model.pay.PayNotifyVo;

public interface OrderNotifyService {
	
	public boolean supports(PayNotifyVo payNotifyVo);
	
	public boolean   processNotify(PayNotifyVo payNotifyVo);
}
