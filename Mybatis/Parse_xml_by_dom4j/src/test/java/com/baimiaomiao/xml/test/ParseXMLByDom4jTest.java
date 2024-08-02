package com.baimiaomiao.xml.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


public class ParseXMLByDom4jTest {
    @Test
    public void testParseSqlMapperXML() throws DocumentException {
        SAXReader reader = new SAXReader();
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("CarMapper.xml");
        Document document = reader.read(is);

        //获取namespace
        String xpath = "/mapper";
        Element mapper = (Element) document.selectSingleNode(xpath);
        String namespace = mapper.attributeValue("namespace");

        //获取mapper节点下所有的子节点
        List<Element> elements = mapper.elements();
        elements.forEach(element -> {
            //获取sqlId
            String id = element.attributeValue("id");
            System.out.println("id：" + id);
            //获取resultType
            String resultType = element.attributeValue("resultType"); //没有这个属性值的话会自动返回"null"
            System.out.println("resultType：" + resultType);
            //获取标签中的sql语句（表示获取标签中的文本内容，而且去除前后空白）
            String sql = element.getTextTrim();
            System.out.println("sql语句：" + sql);
            //insert into t_car values(null,#{carNum},#{brand},#{guidePrice},#{produceTime},#{catType})
            //insert into t_car values(null,?,?,?,?,?)
            //mybatis封装了jdbc，早晚要执行带有?的sql语句
            //转换
            String newSql = sql.replaceAll("#\\{[0-9A-Za-z_$]*}","?");
            System.out.println(newSql);
        });



    }
    @Test
    public void testParseMyBatisConfigXML() throws DocumentException {
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        //获取输入流
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
        //读XML文件，返回document对象，document对象是文档对象
        Document document = reader.read(is);
        //获取文档当中的根标签
        //Element rootElt = document.getRootElement();
        //String rootEltName = rootElt.getName();
        //System.out.println(rootEltName);

        //获取default默认的环境id
        String xpath = "/configuration/environments"; //xpath是做标签路径匹配的，能让我们快速定位XML文件中的元素
        Element environments = (Element) document.selectSingleNode(xpath); //Element是Node的子类，方法更对，使用更便捷
        //获取属性的值
        String defaultEnvironmentId = environments.attributeValue("default");
        //System.out.println("默认环境的id：" + defaultEnvironmentId);

        //获取具体的环境environment
        xpath = "/configuration/environments/environment[@id='" + defaultEnvironmentId +"']";
        Element environment = (Element) document.selectSingleNode(xpath);
        //获取environment节点下的transactionManager节点(Element.element方法用来获取子节点)
        Element transactionManager = environment.element("transactionManager");
        String transactionType = transactionManager.attributeValue("type");
        //获取dataSource节点
        Element dataSource = environment.element("dataSource");
        String dataSourcetype = dataSource.attributeValue("type");

        //获取dataSource节点下的所有子节点
        List<Element> properties = dataSource.elements();
        properties.forEach(propertyElt -> {
            String name = propertyElt.attributeValue("name");
            String value = propertyElt.attributeValue("value");
            System.out.println(name + "=" + value);
        });

        //解析mappers表现
        xpath = "//mapper"; //不想从根下开始获取，想从任意位置开始，获取所有的某个标签，xpath该这样写
        List<Node> mappers = document.selectNodes(xpath);
        mappers.forEach(mapper -> {
            Element mapperElt = (Element) mapper;
            String resource = mapperElt.attributeValue("resource");
            System.out.println(resource);
        });
    }
}
