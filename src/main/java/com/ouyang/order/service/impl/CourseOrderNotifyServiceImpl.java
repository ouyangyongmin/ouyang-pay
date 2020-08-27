package com.ouyang.order.service.impl;

import org.springframework.stereotype.Component;

import com.ouyang.constants.OrderTypeConstants;
import com.ouyang.model.pay.PayNotifyVo;
import com.ouyang.order.service.OrderNotifyService;


/**
 * 课程通知组件
 * @author oy
 *
 */
@Component
public class CourseOrderNotifyServiceImpl implements OrderNotifyService {

	@Override
	public boolean supports(PayNotifyVo payNotifyVo) {
		return OrderTypeConstants.ORDER_TYPE_COURSE.equals(payNotifyVo.getType());
	}

	@Override
	public boolean  processNotify(PayNotifyVo payNotifyVo) {
		
		System.out.println("CourseOrderNotifyServiceImpl.processNotify:课程组件回调处理");
		
		System.out.println("处理参数为："+payNotifyVo);
		 
		return true;
	}
}
