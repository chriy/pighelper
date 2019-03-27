package com.y1ang.controller;

import com.y1ang.util.GetNewsUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * 
 * @author y1ang
 * @Data 2018年10月13日-上午10:23:55
 * @Description 首页获取新闻控制类
 */
@Controller
public class NewsController {
	/**
	 * 首页展示新闻
	 * @return
	 */
	
	@RequestMapping("/index.html")
	public String getNews(HttpServletRequest request) {
	    Object title = request.getSession().getAttribute("title");
	    Object url = request.getSession().getAttribute("url");
	    if(title==null&&url==null) {
	        List<List<String>> item = GetNewsUtil.getItem();
	        request.getSession().setAttribute("title", item.get(0));
	        request.getSession().setAttribute("url", item.get(1));
	    }
		return "index.jsp";
	}
	
	/**
	 * 每条新闻点进去的详情
	 * @param url
	 * @param title
	 * @param model
	 * @return
	 */
	@RequestMapping("/getMoreNews")
	public String getMoreNews(String url,String title,Model model) {
		String newsDetails = GetNewsUtil.getItemContent(url);
		model.addAttribute("title", title);
		model.addAttribute("newsDetails", newsDetails);
		return "newsContent.jsp";
	}
}
