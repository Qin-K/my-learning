import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Qin Kai
 * @date 2019-09-02
 */
public class JsoupDemo {

    public void helloJsoup() {

        try {
            Document document =  Jsoup.connect("http://www.w3school.com.cn/b.asp").get();
            System.out.println(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void headerDemo() {
        //获取请求连接
        Connection connect = Jsoup.connect("http://www.w3school.com.cn/b.asp");
        //使用Map集合存储头信息
        Map<String, String> header = new HashMap<String, String>();
        header.put("Host", "www.w3school.com.cn");
        header.put("User-Agent", " Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.108 Safari/537.36");
        header.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
        header.put("Accept-Language", "zh-cn,zh;q=0.5");
        header.put("Accept-Encoding", "gzip, deflate");
        header.put("Cache-Control", "max-age=0");
        header.put("Connection", "keep-alive");
        //添加头信息
        Connection conheader = connect.headers(header);
        //使用get()请求页面内容

//        //设置延迟时间，5000指5秒
//        Document doc = Jsoup.connect("http://www.w3school.com.cn/b.asp").timeout(5000).get();
//        System.out.println(doc);
        try {
            Document document = conheader.get();
            //输出页面内容
            System.out.println(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void parseHtmlDemo() {
        //需要解析的HTML文本
        String html = "<html><body><div id=\"w3school\"> <h1>浏览器脚本教程</h1> <p><strong>从左侧的菜单选择你需要的教程！</strong></p> </div>"
                + "<div>  <div id=\"course\"> <ul> <li><a href=\"/js/index.asp\" title=\"JavaScript 教程\">JavaScript</a></li> </ul> </div> </body></html>";

        Document document = Jsoup.parse(html);
        Element element = document.select("div[id=w3school]").get(0);

        //从Element提取内容(抽取一个Node对应的信息)
        String text1 = element.select("h1").text();
        //从Element提取内容(抽取一个Node对应的信息)
        String text2 = element.select("p").text();
        System.out.println("输出解析的元素内容为:");
        System.out.println(element);
        System.out.println("抽取的文本信息为:");
        System.out.println(text1 + "\t" + text2);

    }


    public void selectorDemo() throws IOException {
        //获取URL对应的HTML内容
        Document doc = Jsoup.connect("http://www.w3school.com.cn/b.asp").timeout(5000).get();

//        System.out.println(doc);
        Elements elements = doc.select("div[id=\"course\"]")
                .select("ul")
                .select("li")
                .select("a");
        for (Element element : elements) {
            System.out.println(element);
            System.out.println(element.attr("href"));
            System.out.println(element.text());
        }
    }


    public static void main(String[] args) throws IOException {
        JsoupDemo jsoupDemo = new JsoupDemo();
        jsoupDemo.selectorDemo();
    }

}
