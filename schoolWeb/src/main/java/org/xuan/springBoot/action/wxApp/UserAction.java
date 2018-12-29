package org.xuan.springBoot.action.wxApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserAction
 * @Description: TODO功能描述:(这里用一句话描述这个类的作用)
 * @author 朱修轩
 * @date 2018年12月29日 下午4:46:00
 * @remark 备注:(用户界面层)
 */
@RestController("WxUserAction")
@RequestMapping("/users")
public class UserAction {
	@Value("${wx.appid}")
	private String appId;
	@Value("${wx.appSecret}")
	private String appSecret;
	/**
	 * @Title: isWxUserLogin
	 * @Description: TODO方法描述:(判断微信用户是否登录)
	 * @param @return
	 * @param @throws Exception    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping("/d2VpeGlueW9uZ2h1ZGVuZ2x1")
	public String isWxUserLogin(String code) throws Exception{
		System.out.println(code+"__"+appId+"——————"+appSecret);
		
		return "222";
	}

}
