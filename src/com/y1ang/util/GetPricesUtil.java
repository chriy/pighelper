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

import com.y1ang.entity.PriceJson;
import com.y1ang.entity.Prices;

/**
 * 
 * @author y1ang
 * @Data 2018年9月26日-下午4:30:59
 * @Description 获取猪价工具类
 */
public class GetPricesUtil {
    /**
     * 正则匹配规则，匹配换行空格
     */
    private static Pattern pattern = Pattern.compile("\t|\r|\n");

    /**
     * 获取猪价类
     * 
     * @param u 获取猪价的网址
     * @return
     */
    public static PriceJson getPrices(String u) {
        InputStream in = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        PriceJson res = new PriceJson();
        try {
            URL url = new URL(u);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.140 Safari/537.36");
            in = connection.getInputStream();
            isr = new InputStreamReader(in, "UTF8");
            br = new BufferedReader(isr);
            String line = "";
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                Matcher m = pattern.matcher(line);
                String dest = "";
                dest = m.replaceAll("");
                sb.append(dest);
            }
            String reg = "<td>.*?</td>";
            Matcher matcher = Pattern.compile(reg).matcher(sb.toString());
            List<String> list = new ArrayList<>();
            while (matcher.find()) {
                list.add(matcher.group());
            }

            List<String> city = new ArrayList<>();
            List<String> price = new ArrayList<>();
            List<String> range = new ArrayList<>();

            /**
             * 0 上涨 1 下降 -1 不变
             */
            for (int i = 0, len = list.size(); i < len; i++) {
                if (i % 6 == 0) {
                    city.add(list.get(i).replace("<td>", "").replace("</td>", ""));
                }
                if (i % 6 == 1) {
                    if (list.get(i).lastIndexOf("fb red") > 0) {
                        price.add(list.get(i).replace("<td><span class=\"fb red\">", "").replace("</span></td>", ""));
                        range.add("0");
                    } else if (list.get(i).lastIndexOf("fb green") > 0) {
                        price.add(list.get(i).replace("<td><span class=\"fb green\">", "").replace("</span></td>", ""));
                        range.add("1");
                    } else {
                        price.add(list.get(i).replace("<td><span class=\"fb\">", "").replace("</span></td>", "")
                                .replace("<td><spanclass=\"fb\">", ""));
                        range.add("-1");
                    }
                }
            }
            // 最终数据
            List<Prices> priceList = new ArrayList<>();

            for (int i = 0, len = city.size(); i < len; i++) {
                if ("".equals(city.get(i)) || "".equals(price.get(i))) {
                    continue;
                }
                Prices p = new Prices(city.get(i), price.get(i), range.get(i));
                priceList.add(p);
            }
            // 赋值到json中
            res.setData(priceList);
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
        return res;
    }
}
