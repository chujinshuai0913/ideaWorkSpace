/**
 * Copyright (C), 2018-2018
 * FileName: GetBookDetailByIsbn
 * Author:   jinshuai
 * Date:     2018/5/27 0:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import common.model.Book;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author jinshuai
 * @create 2018/5/27
 * @since 1.0.0
 */
public class GetBookDetailByIsbn {
    @Autowired
    HttpServletRequest request;

    private static  final Logger log = Logger.getLogger(common.test.GetBookDetailByIsbn.class);
    public static   String doGet(String url, String queryString, String charset, boolean pretty) {
        StringBuffer response = new StringBuffer();
        HttpClient client = new HttpClient();
        HttpMethod method = new GetMethod(url);
        try {
            method.setRequestHeader(
                    "User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36");
            if (queryString!=null)

                method.setQueryString(URIUtil.encodeQuery(queryString));
            client.executeMethod(method);
            if (method.getStatusCode() == HttpStatus.SC_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), charset));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (pretty)
                        response.append(line).append(System.getProperty("line.separator"));
                    else
                        response.append(line);
                }
                reader.close();
            }
        } catch (URIException e) {
            log.error("HTTP Get " + queryString , e);
        } catch (IOException e) {
            log.error("HTTP Get " + queryString , e);
        } finally {
            method.releaseConnection();
        }
        return response.toString();
    }

    public static Map<String, String> toMap(String jsonString) throws JSONException {
        Map<String, String> result = new HashMap<String, String>();
        Map mapTypes = JSON.parseObject(jsonString);
        for (Object obj : mapTypes.keySet()){
            result.put(obj+"",mapTypes.get(obj)+"");
        }
        return result;
    }
    public static Book getBook(String isbn)  {
        Book book=new Book();
        String uri="https://api.douban.com/v2/book/isbn/"+isbn;
        String y = doGet(uri, null, "UTF-8", true);
        if (y!=null&&!y.equals("")){
            y=y.replace("\"", "'");
            y=y.replaceAll("\\\\","/");
            y=y.replaceAll("//","/");
            Map<String, String> map=null;
            try {
                book=getBookByMap(toMap(y));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return  book;
    }

    public static Book getBookByMap(Map<String, String> map) {

        Book book=new Book();
        String author = map.get("author").toString();
        author = author.replace("[", "");
        author = author.replace("]", "");
        author = author.replace("\"", "");
        book.setBookName(map.get("title"));
        String translator=map.get("translator").toString();
        translator = translator.replace("[", "");
        translator = translator.replace("]", "");
        translator = translator.replace("\"", "");
        book.setTranslator(translator);
        book.setAuthor(author);
        book.setSubtitle( map.get("subtitle"));
        String author_intro=map.get("author_intro").toString();
        author_intro=author_intro.replace("/n", "<br>");
        book.setAuthorIntro(author_intro);
        book.setPricing(new BigDecimal(map.get("price").replace("元","")));
        book.setPricingunit("元");
        book.setPress(map.get("publisher"));
        book.setPressTime(DateUtils.getDayUnixTimeStamp(map.get("pubdate")));
        book.setPageNumber(Integer.parseInt(map.get("pages")));
        book.setIsbn(Long.parseLong(map.get("isbn13")));
        book.setIsbn10(Long.parseLong(map.get("isbn10")));
        book.setBinding(map.get("binding"));
        book.setIntroduce(map.get("summary"));
        String catalog=map.get("catalog").toString();
        catalog=catalog.replace("/n", "<br>");
        book.setCatalog(catalog);

        Map<String, String> map2 = null;
        try {
            map2 = toMap(map.get("images").toString().replace("\"", "'"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
       /* String url1= (map2.get("small")).substring(0, (map2.get("small")).indexOf("/")+1).trim();
        String url2= (map2.get("small")).substring((map2.get("small")).indexOf("/")+1).trim();
        if(!url2.substring(0, (map2.get("small")).indexOf("/")).trim().equals("/")){
            book.setSrc(url1+"/"+url2);
        }*/
        book.setSrc(ImgDown.getImgDwon(map2.get("small")).trim());
        book.setSrc2(ImgDown.getImgDwon(map2.get("medium")).trim());
        book.setSrc3(ImgDown.getImgDwon(map2.get("large")).trim());
        JSONArray json = JSONArray.parseArray(map.get("tags")); // 首先把字符串转成 JSONArray  对象
        String tag=null;
        if (json.size() > 0) {
            for (int i = 0; i < json.size(); i++) {
                JSONObject job = json.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
                if(i==0){
                    tag=job.get("title")+"";
                }else {
                    tag = tag +','+ job.get("title");
                }
            }
        }
        book.setTag(tag);
        return  book;
    }
}
