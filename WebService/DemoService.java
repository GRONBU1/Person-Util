package com.webservice.WebService;

import javax.jws.WebService;

@WebService(name = "DemoService", // 暴露服务名称
    targetNamespace = "http://WebService.webservice.com"// 命名空间,一般是接口的包名倒序
)
public interface DemoService {

    public String ap_queryPeopleHousehold(String test);
 
}
