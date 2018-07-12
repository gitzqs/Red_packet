package com.zqs.web.order;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zqs.request.rec.Link;
import com.zqs.request.rec.Recharge;
import com.zqs.service.cms.IUserService;
import com.zqs.service.order.IOrderService;
import com.zqs.service.rec.AltService;
import com.zqs.service.rec.HongbaoService;

@Controller
public class OrderController {

	@Autowired
	private IOrderService orderService;
	@Autowired
	private IUserService userService;
	@Autowired
	private AltService altService;
	@Autowired
	private HongbaoService hongbaoService;
	
	@RequestMapping(value="help/",method=RequestMethod.GET)
	public String help() {
		return "order/help";
	}
	
	@RequestMapping(value="help/gx",method=RequestMethod.GET)
	public String gx() {
		return "rec/gx";
	}
	
	@RequestMapping(value="help/lj",method=RequestMethod.GET)
	public String lj(Model model) {
		model.addAttribute("link", hongbaoService.loadLink());
		return "rec/lj";
	}
	
	@RequestMapping(value="help/del",method=RequestMethod.POST)
	@ResponseBody
	public String del(@RequestParam("id") int id) {
		
		return hongbaoService.del(id);
	}
	
	@RequestMapping(value="help/addLink",method=RequestMethod.POST)
	@ResponseBody
	public String add(@RequestBody Link link) {
		
		return hongbaoService.add(link);
	}
	
	@RequestMapping(value="help/jc",method=RequestMethod.GET)
	public String jc() {
		return "rec/jc";
	}
	
	
	@RequestMapping(value="recharge/",method=RequestMethod.GET)
	public String recharge(Model model) {
		model.addAttribute("list", orderService.pageLimit10());
		model.addAttribute("score", userService.loadScore());
		return "order/recharge2";
	}
	
	/**
	 * 充值参数获取
	 * @param amount
	 * @return
	 */
	@RequestMapping(value="recharge/pay", method=RequestMethod.POST)
	@ResponseBody
	public String pay(@RequestBody Recharge r) {
		
		return orderService.pay(r.getAmount());
	}
	
	@RequestMapping(value="notify/",method=RequestMethod.GET)
	public String front() {
		return "order/help";
	}
	
	//网页提交Cookie
		@RequestMapping(value = "help/insertCookie", method = RequestMethod.POST)
		@ResponseBody
	    public String inseryCookie(@RequestBody Recharge r) throws IOException {
			List<String> cookie = altService.formatConversion(r.getCookieUrl());
			String message = altService.insertCookie(cookie);
			return message;  
	    }
}
