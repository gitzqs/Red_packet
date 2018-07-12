package com.zqs.web.rec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zqs.request.rec.RecRequest;
import com.zqs.service.rec.HongbaoService;

@Controller
@RequestMapping(value="rec")
public class RecController {

	@Autowired
	private HongbaoService hongbaoService;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("record", hongbaoService.record());
		model.addAttribute("link", hongbaoService.loadLink());
		return "rec/rec";
	}
	
	/**
	 * 领取红包
	 * @param rr
	 * @return
	 */
	@RequestMapping(value="/get",method=RequestMethod.POST)
	@ResponseBody
	public String getRec(@RequestBody RecRequest rr) {
		
		try {
			return hongbaoService.getHongbao(rr.getMobile(), rr.getUrl());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
