package sword.wechat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sword.wechat.service.CoreService;
import sword.wechat.utils.SignUtil;





/**
 * @author Binary Wang(https://github.com/binarywang)
 */
@RestController
@RequestMapping("/wechat/portal")
public class WechatController {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private CoreService a;
  
  @GetMapping(produces = "text/plain;charset=utf-8")
  public String authGet(
      @RequestParam(name = "signature",
          required = false) String signature,
      @RequestParam(name = "timestamp",
          required = false) String timestamp,
      @RequestParam(name = "nonce", required = false) String nonce,
      @RequestParam(name = "echostr", required = false) String echostr) {

    this.logger.info("\n接收到来自微信服务器的认证消息：[{}, {}, {}, {}]", signature,
        timestamp, nonce, echostr);

    if (StringUtils.isAnyBlank(signature, timestamp, nonce)) {
      throw new IllegalArgumentException("请求参数非法，请核实!");
    }

	if (SignUtil.checkSignature(signature, timestamp, nonce)) {
		return echostr;
	}

    return "非法请求";
  }

	/**
	 * 处理微信服务器发来的消息
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 调用核心业务类接收消息、处理消息
		String respMessage = a.processRequest(request);

		// 响应消息
		PrintWriter out = response.getWriter();
		out.print(respMessage);
		out.close();
	}



}
