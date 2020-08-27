package com.ouyang.pay.service.impl;

import org.springframework.stereotype.Service;

import com.ouyang.constants.PayTypeConstants;
import com.ouyang.model.pay.PayReqData;
import com.ouyang.model.pay.PaymentEntity;
import com.ouyang.pay.service.PayService;

@Service
public class AliPayServiceImpl implements PayService {
	
	@Override
	public boolean supports(PayReqData payType) {
		return PayTypeConstants.PAY_TYPE_ALI.equals(payType.getPayType());
	}

	@Override
	public PaymentEntity doPayment(PayReqData payReqData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String notify(String notifyBody) {
		// TODO Auto-generated method stub
		return null;
	}
}
