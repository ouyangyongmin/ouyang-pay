package com.ouyang.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ouyang.AppConfig;
import com.ouyang.adapter.PayAdapterFactory;
import com.ouyang.constants.PayTypeConstants;
import com.ouyang.model.pay.PayReqData;
import com.ouyang.model.pay.PaymentEntity;
import com.ouyang.pay.service.PayService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class BaseTest  {
	 
	
	@Autowired
	private PayAdapterFactory payAdapterFactory;
 
	
	private PayService payService = null;
	private PayReqData payData  =null;
	 
	
	@Before
	public void initPayData() {
		payData = new PayReqData();
		payData.setPayType(PayTypeConstants.PAY_TYPE_WX);
		payData.setOrderNo("S010001");
	} 
	
	
	@Test
	public void doPay () {
	    payService = payAdapterFactory.payServiceAdapter(payData);
		PaymentEntity doPayment = payService.doPayment(payData);
		System.out.println(doPayment);
	}
	
	@After
	public void payNotify() {
		String notifyBody ="<xml><trade_no>S010001</trade_no><attach>1</attach></xml>";
		String notify = payService.notify(notifyBody);
		log.info("回调返回结果为：{}",notify);
//		System.out.println("notify:"+notify);
	}
	
	
	
}
