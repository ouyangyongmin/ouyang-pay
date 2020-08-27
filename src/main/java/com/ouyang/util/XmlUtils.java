package com.ouyang.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

/**
 *  <p> Description:XML转换工具类 </p>
 *
 * @author hz
 */
public class XmlUtils {
	
	/**
	 * 转换成Xml格式
	 * @param map
	 * @return
	 */
	public static String parseXML(Map<String,Object> map) {
	   StringBuffer sb = new StringBuffer();
       sb.append("<xml>");
       for(String k:map.keySet()){
    	   Object v = map.get(k);
    	   if(v != null && !"".equals(v)){
    		   sb.append("<" + k +"><![CDATA[" + v + "]]></" + k + ">\n");
    	   }
		}
       sb.append("</xml>");
	   return sb.toString();
	}
	
	/**
	 * @param xmlString
	 * @return
	 * @throws DocumentException
	 */
	@SuppressWarnings("rawtypes")
	public static Map parseMap(String xml) throws DocumentException {
		Document doc = DocumentHelper.parseText(xml);
		Element rootElement = doc.getRootElement();
		return (Map<String, Object>)parseMap(rootElement);
	}

	public static Object parseMap(Element element) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Element> elements = element.elements();
		
		if (elements.size() == 0) {
			map.put(element.getName(), element.getText());
			if (!element.isRootElement()) {
		        return element.getText();
		    }
		} else if (elements.size() == 1) {
			map.put(element.getName(), parseMap(elements.get(0)));
			
		} else if (elements.size() > 1) {
			Map<String, Element> tempMap = new HashMap<String, Element>();
			for (Element ele : elements) {
				tempMap.put(ele.getName(), ele);
			}
			Set<String> keySet = tempMap.keySet();
			for (String string : keySet) {
				Namespace namespace = tempMap.get(string).getNamespace();
				List<Element> elements2 = element.elements(new QName(string, namespace));
				if (elements2.size() > 1) {
					List<Object> list = new ArrayList<Object>();
					for (Element ele : elements2) {
						list.add(parseMap(ele));
					}
					map.put(string, list);
				} else {
					map.put(string, parseMap(elements2.get(0)));
				}
			}
		}

		return map;
	}
	public static byte[] readInput(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int len = 0;
        byte[] buffer = new byte[1024];
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        out.close();
        in.close();
        return out.toByteArray();
    }

    public static String inputStreamToString(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i;
        while ((i = is.read()) != -1) {
            baos.write(i);
        }
        return baos.toString();
    }


    public static InputStream getStringStream(String sInputString) {
        ByteArrayInputStream tInputStringStream = null;
        if (sInputString != null && !sInputString.trim().equals("")) {
            tInputStringStream = new ByteArrayInputStream(sInputString.getBytes());
        }
        return tInputStringStream;
    }

    public static Object getObjectFromXML(String xml, Class tClass) {
        //将从API返回的XML数据映射到Java对象
        XStream xStreamForResponseData = new XStream();
        xStreamForResponseData.alias("xml", tClass);
        xStreamForResponseData.ignoreUnknownElements();//暂时忽略掉一些新增的字段
        return xStreamForResponseData.fromXML(xml);
    }

    public static String getXMLStringFromObject(Object xmlObj) {
        //解决XStream对出现双下划线的bug
        XStream xStreamForRequestPostData = new XStream(new DomDriver("UTF-8", new XmlFriendlyNameCoder("-_", "_")));
        xStreamForRequestPostData.alias("xml",xmlObj.getClass());
        //将要提交给API的数据对象转换成XML格式数据Post给API
        return xStreamForRequestPostData.toXML(xmlObj);
    }

    public static String getStringFromMap(Map<String, Object> map, String key, String defaultValue) {
        if (key == "" || key == null) {
            return defaultValue;
        }
        String result = (String) map.get(key);
        if (result == null) {
            return defaultValue;
        } else {
            return result;
        }
    }

    public static int getIntFromMap(Map<String, Object> map, String key) {
        if (key == "" || key == null) {
            return 0;
        }
        if (map.get(key) == null) {
            return 0;
        }
        return Integer.parseInt((String) map.get(key));
    }
}
