package com.ouyang.model.pay;

import java.io.Serializable;

//@Description("支付请求返回结构体")
public class PaymentEntity implements Serializable {

//    @Description("跳转URL")
    public String url;

//    @Description("提交内容,post body")
    public String pb;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPb() {
        return pb;
    }

    public void setPb(String pb) {
        this.pb = pb;
    }

  
}

