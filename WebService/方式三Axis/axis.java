public String cl4(String tid) throws IOException {
       SiteServiceLocator locator = new SiteServiceLocator();
       SiteServiceSoapStub stub = new SiteServiceSoapStub(new URL(locator.getSiteServiceSoapAddress()), new org.apache.axis.client.Service());
       String ret =  stub.getDataBySysID("", "");
       return ret;
    }