public class Data_tool_Adapter implements Data_Tool{
    public void getData(String data){
        Xml xmldata=new Xml(data);
    }
    public void data_analyze(Xml xml) {
        System.out.println(xml.xml_data+""+"data processing");
    }
}
