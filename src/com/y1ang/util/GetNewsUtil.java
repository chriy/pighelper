package com.y1ang.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author y1ang
 * @Data 2018年9月10日-下午9:05:12
 * @Description 获取网页数据
 */
public class GetNewsUtil {
    /**
     * 获取源代码
     * 
     * @param url
     * @return
     */
    public static String getSources(String url) {
        InputStream in = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            URL u = new URL(url);
            URLConnection connection = u.openConnection();
            connection.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36");
            in = connection.getInputStream();
            isr = new InputStreamReader(in, "UTF8");
            br = new BufferedReader(isr);
            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    /**
     * 获取标题和URL
     * 
     * @return
     */
    public static List<List<String>> getItem() {
        String reqUrl = "https://www.zhuwang.cc/";
        String resource = GetNewsUtil.getSources(reqUrl);
        List<List<String>> result = new ArrayList<>();
        List<String> hrefList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        String reg = "<div class=\"mainC_box main2c-box\">(.*?)</div>";
        Matcher matcher = Pattern.compile(reg).matcher(resource.toString());
        if (matcher.find()) {
            // 获取地址
            String regURL = "href=\".*?\"";
            Matcher matcherURL = Pattern.compile(regURL).matcher(matcher.group());
            while (matcherURL.find()) {
                hrefList.add(matcherURL.group().replace("href=\"//", "").replace("\"", ""));
            }
            // 获取标题
            String regTitle = "title=\".*?\"";
            Matcher matcherTitle = Pattern.compile(regTitle).matcher(matcher.group());
            while (matcherTitle.find()) {
                titleList.add(matcherTitle.group().replace("title=\"", "").replace("\"", ""));
            }
        }
        result.add(titleList);
        result.add(hrefList);
        return result;
    }

    /**
     * 获取各条新闻详情
     * 
     * @param url
     * @return
     */
    public static String getItemContent(String url) {
        String sources = GetNewsUtil.getSources(url);
        String reg = "<div>(.*?)</div>|<div style=\"text-align: justify;\">(.*?)</div>";
        Matcher matcher = Pattern.compile(reg).matcher(sources);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            sb.append(matcher.group());
        }
        return sb.toString();
    }
}
