public class soap{
    String operationName = methodName;// 调用方法名
            String operationName = "login";// 调用方法名
            // String namespaceUrl = nameUrl;
            // targetNamespace 就是 namespaceUrl
            String namespaceUrl = "http://e3.org/eecmisws/soapws";
            Service service = new Service();
            String ret = "";
            try {
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(webserviceURL);
            //call.setTargetEndpointAddress("http://10.200.30.116:8999/services/eecmisws.asmx");
            call.setOperationName(new QName(namespaceUrl, operationName)); // 设置要调用哪个方法
            call.addParameter(new QName(namespaceUrl, "Code"), // 设置要传递的参数
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
            call.addParameter(new QName(namespaceUrl, "OtherSysID"), // 设置要传递的参数
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
            call.addParameter(new QName(namespaceUrl, "Year"), // 设置要传递的参数
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// （标准的类型）
            call.setUseSOAPAction(true);
            call.setSOAPActionURI(namespaceUrl + operationName);
            ret = (String) call.invoke(new Object[]{"NNGACRJ",tid,"2019"});// 调用方法并传递参
            //ret = (String) call.invoke(new Object[]{"",""});// 调用方法并传递参数
            } catch (Exception ex) {
            logger.error(ex.getMessage());
            ex.printStackTrace();
            }
            return ret;
}