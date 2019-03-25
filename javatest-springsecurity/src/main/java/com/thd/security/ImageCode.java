package com.thd.security;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

public class ImageCode {
	//验证码图片
    private BufferedImage image;
	//验证码随机数字
    private String code;
	//验证码失效时间
    private LocalDateTime expireTime;
	//验证码过期与否
    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expireTime);
    }
 
    public ImageCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }
 
    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDateTime getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(LocalDateTime expireTime) {
		this.expireTime = expireTime;
	}

}
