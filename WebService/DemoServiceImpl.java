package com.webservice.WebService;


import com.webservice.Util.TxtConverString;

import javax.jws.WebService;
import java.io.File;
import java.util.Date;
 
@WebService(serviceName = "DemoService", // 与接口中指定的name一致
        targetNamespace = "http://WebService.webservice.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.webservice.WebService.DemoService"// 接口地址
)
public class DemoServiceImpl implements DemoService {

    @Override
    public String ap_queryPeopleHousehold(String test) {
        File file = new File("C:\\Users\\CCC\\Desktop\\ap_queryPeopleHousehold.txt");
        return TxtConverString.file2String(file,null);
    }

}