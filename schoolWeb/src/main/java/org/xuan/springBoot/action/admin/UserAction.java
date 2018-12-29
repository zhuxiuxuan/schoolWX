package org.xuan.springBoot.action.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xuan.springBoot.util.RedisUtil;
@Controller
public class UserAction {
	@Resource
	private RedisUtil redisUtil;
	@RequestMapping("/text")
	public String text(){
		redisUtil.set("name", "zhuxiuxuan");
		System.out.println(redisUtil.get("name"));
		return "";
	}

}
