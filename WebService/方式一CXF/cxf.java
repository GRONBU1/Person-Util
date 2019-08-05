    public class Cxf{

        public String cl3(String tid) throws IOException {
                Object[] objects = new Object[0];
                String namespaceUrl = nameUrl;
                String operationName = methodName;
                try {
                    if (client == null){
                    //创建动态客户端
                    JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
                    client = factory.createClient(webserviceURL);
                    //Client client = factory.createClient("http://10.200.30.116:8999/services/eecmisws.asmx?wsdl");
                    // 需要密码的情况需要加上用户名和密码
                    //client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,PASS_WORD));
                    HTTPConduit conduit = (HTTPConduit) client.getConduit();
                    HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
                    httpClientPolicy.setConnectionTimeout(2000);  //连接超时
                    httpClientPolicy.setAllowChunking(false);    //取消块编码
                    httpClientPolicy.setReceiveTimeout(120000);     //响应超时
                    conduit.setClient(httpClientPolicy);
                    //client.getOutInterceptors().addAll(interceptors);//设置拦截器
                    //Object[] objects = new Object[0];
                    // invoke("方法名",参数1,参数2,参数3....);
                    }
                    objects = client.invoke(operationName, "NNGACRJ", tid, "2019");
                    //objects = client.invoke("login","NNGACRJ","");
                    System.out.println(objects[0]);
                    return objects[0];
                } catch (Exception e) {
                    logger.error(ExceptionUtil.getStackTrace(e));
                    e.printStackTrace();
                }
        }
    }