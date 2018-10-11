package com.zztlj.xjpj.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.configuration.Configuration;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.common.utils.R;
import com.bootdo.system.domain.UserDO;
import com.zztlj.xjpj.domain.PingdingxinxiDO;
import com.zztlj.xjpj.domain.WhitelistDO;
import com.zztlj.xjpj.service.ApiKeyService;
import com.zztlj.xjpj.service.PingdingxinxiService;
import com.zztlj.xjpj.service.WhitelistService;
import com.zztlj.xjpj.utils.ConfigUtil;
import com.zztlj.xjpj.utils.DateUtils;
import com.zztlj.xjpj.utils.MD5Tool;;

@Controller
@RequestMapping("/api/xjpj/import")
public class ImportApiController {
	@Autowired
	private PingdingxinxiService pingdingxinxiService;
	
	@Autowired
	private ApiKeyService apikeyService;
	@Autowired
	private WhitelistService whitelistService;
	@PostMapping()
	@ResponseBody
	public R ImportPingdingxinxi(@RequestBody PingdingxinxiDO pdxx,@RequestParam("_timestamp") String _timestamp,@RequestParam("_appid") String _appid,@RequestParam("_sign") String _sign) {
		System.out.println(pdxx.getSfzh()+" "+pdxx.getZgxm()+" "+pdxx.getNl()+" "+_timestamp+" "+_appid+" "+_sign);
		if (pdxx.getSfzh()==null||pdxx.getSfzh().isEmpty()) {
			return R.error(1003, "身份证号不能为空！");
		}
		Map<String, String> sortedParams = new TreeMap<String, String>();
		sortedParams.put("sfzh", pdxx.getSfzh());
		sortedParams.put("_timestamp", _timestamp);
		sortedParams.put("_appid", _appid);
		
		
		long timestamp = Long.parseLong(_timestamp);
		long now = new Date().getTime();
		long minute = Math.abs(now-timestamp)/(1000*60);
		if(minute > 5){//请求时间戳超时
			System.out.println("请求时间戳超时----now:"+now);
			return R.error();
		}
		
		String secret = apikeyService.get(_appid).getAppkey();
		Long deptId = apikeyService.get(_appid).getDeptId();
		pdxx.setDeptId(deptId);
		String sign = "";
		try {
			sign = getSignature(sortedParams,secret);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (!_sign.isEmpty() && sign.equals(_sign)) {
			String khzq = pdxx.getKhzq();
			if (khzq==null||khzq.isEmpty()) {
				return R.error(1003, "考核周期不能为空！");
			}
			// 检查所选考核周期是否在可修改期限内
			Configuration config = ConfigUtil.getConfig();

			String archiveDayStr = config.getString("archiveDay");
			String archiveDateStr = khzq + archiveDayStr + "235959";
			Date archiveDate = DateUtils.parse(archiveDateStr, DateUtils.YMDHMS);
			// 所选考核周期增加一个月为截止时间
			Calendar cal = Calendar.getInstance();
			cal.setTime(archiveDate);
			cal.add(Calendar.MONTH, 1);
			archiveDate = cal.getTime();


			WhitelistDO whitelistDO = whitelistService.getByDeptId(deptId);

			if (whitelistDO != null && whitelistDO.getExpiryDate().compareTo(archiveDate) > 0) {
				archiveDate = whitelistDO.getExpiryDate();
			}

			Date nowDate = new Date();
			// 当前时间超出归档时间
			if (nowDate.compareTo(archiveDate) > 0) {
				return R.error(1002,"已过录入截止时间，不允许新增！如有疑问请联系管理员！");
			}
			if (pingdingxinxiService.save(pdxx)==1) {
				return R.ok();
			}
			else {
				return R.error("数据库保存错误！");
			}
			
		}
		else {
			return R.error(1001,"签名错误，不允许访问接口！");
		}
		
	}
	
	/**
	 * 签名生成算法
	 * @param Map<String,String> params 请求参数集，所有参数必须已转换为字符串类型
	 * @param String secret 签名密钥
	 * @return 签名
	 * @throws IOException
	 */
	public static String getSignature(Map<String,String> params, String secret) throws IOException
	{
	    // 先将参数以其参数名的字典序升序进行排序
	    Map<String, String> sortedParams = new TreeMap<String, String>(params);
	    Set<Entry<String, String>> entrys = sortedParams.entrySet();
	 
	    // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
	    StringBuilder basestring = new StringBuilder();
	    for (Entry<String, String> param : entrys) {
	    	if(param.getKey().equals("_sign")) continue;
	        basestring.append(param.getKey()).append("=").append(param.getValue());
	    }
	    basestring.append(secret);
	 
	    System.out.println(basestring);
	    // 使用MD5对待签名串求签
	    String sign = MD5Tool.MD5(basestring.toString());
	    return sign.toString();
	}
	
	public static void main(String[] args) {
		Map<String, String> sortedParams = new TreeMap<String, String>();
		sortedParams.put("sfzh", "411102198903050023");
		sortedParams.put("_timestamp", new Date().getTime()+"");
		sortedParams.put("_appid", "xjpjtest");
		
		try {
			System.out.println(getSignature(sortedParams, "HSDFKLJWIOEUNASKD123789HDWQH1"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
