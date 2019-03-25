package com.thd.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.thd.security.ImageCode;
@Controller
public class HelloController {
	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		System.out.println("welcome()");
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		System.out.println("admin()");
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page - Admin Page!");
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/dba**", method = RequestMethod.GET)
	public ModelAndView dbaPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page - Database Page!");
		model.setViewName("admin");

		return model;

	}
	
	//Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {
		System.out.println("login()");
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error",error);
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.addObject("title","Login Info");
		model.setViewName("login");

		return model;

	}
	
	
	
	//Spring Security see this :
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout() {
		System.out.println("logout()");
		ModelAndView model = new ModelAndView();
		model.setViewName("logout");
		return model;
	}
		
		
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess() {
		System.out.println("loginProcess()");
		ModelAndView model = new ModelAndView();
		System.out.println(111);
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin"); 

		return model;

	}	
		
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView test() {
		System.out.println("test()");
		ModelAndView model = new ModelAndView();
		System.out.println(111);
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page!");
		model.setViewName("admin");

		return model;

	}
	
	//验证码图片
	@RequestMapping(value = "/code/image", method = RequestMethod.GET)
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
 
        ImageCode imageCode = createImageCode(request);
        HttpSession session = request.getSession();
        session.setAttribute("VALIDATE_CODE", imageCode);//将验证码存入session，留验证之用
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());//将验证码图片以jpeg格式写入输出流，以在页面显示
    }
	
	
	
	
	//短信验证码
	@RequestMapping(value = "/code/sms", method = RequestMethod.GET)
    public ModelAndView createSmsCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//模拟生成验证码并发送验证码 
		ImageCode imageCode = createImageCode(request);
		HttpSession session = request.getSession();
		session.setAttribute("VALIDATE_CODE", imageCode);//将验证码存入session，留验证之用
		ModelAndView model = new ModelAndView();
		model.addObject("validateCode", imageCode.getCode());
		model.setViewName("smsCode");
		return model;
    }
	 
    private ImageCode createImageCode(HttpServletRequest request) {
        int width = 65; //验证码图片长度
        int height = 25;//宽
 
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
 
        Graphics g = image.getGraphics();
 
        Random random = new Random();
 
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 20));
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
 
        String sRand = "";
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 13 * i + 6, 16);
        }
 
        g.dispose();
 
        return new ImageCode(image, sRand, 600);
    }
 
    /**
     * 生成随机背景条纹
     *
     */
    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
	
}
