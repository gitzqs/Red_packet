package com.zqs.utils.alipay;


/**
 * alipay基础配置类
 * 
 * @author qiushi.zhou  
 * @date 2017年7月14日 下午8:59:46
 */
public class AlipayConfig {
	
	/** 支付宝网关（固定） */
	public static final String GATEWAY_URL = "https://openapi.alipay.com/gateway.do";
	
	/** APPID 即创建应用后生成 */
	public static final String APPID = "2018040702516351";
//	public static final String APPID = "2017071307738514";
	
	/** 开发者私钥，由开发者自己生成 */
	public static final String APP_PRIVATE_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCwzO+pgdSs2ljLnKv0sZrr5EiIwiWztHx1z+pEhnPmha/iF3fUi7xIakOLdW/FA7/SeNGhf65y+Hf5/DkMJ1ccMSecN+EStOAU/YwBrSiYfn7du7LOcZ3Z9tZBlv16ERjgR+viwIn29fNQ5JqSaKcEsMS9MMol735njSJW+EW9ysEYWpyUp/w7cQljhVNfSQoNqeptNc1TUjY9KQVdBri1xIuwlJfcwslxfKJ0euDn1Wp2rDDk9DA1EyjroFx8OnX8R8V8l0E5hm7DtSUzjQI3EJZUSeZ44ERaXPvtQQy/7VJopDmja7IiIxhl+J761a5PL4VNlIyNq5CMezfjUQcnAgMBAAECggEAHslQ4l9tPTw4QhxiBRX4OCNkTgwgrI49LfaqgIw5GmclHWWgxC4g9ysp39rvP4tLl8baGhk1s2d43NsCxA8FqC8XCqjgVHWSn5UXECOq8gL07H+Gv1QhfJby8DDuqpbXkhZ0COQmIg7p86gbEmuOyc5OM/OO/9QYWsfEtwg8fLPLilxbkdrNPjDnzeil9xYebYaBhphKZjfsxA+z1KZ/3UyijYy3ZohIm2N2s/44YduzcYww31H0n2yhUimPsrGpyhWtviBPdjnu//RY5jdY17Fgir1/ryQoF92X4/hyl2qNi6la84CcNKSAjzU1N7PCo1kE9imhXG4LF2vfrV9FYQKBgQDeOMqy/25e5fGp4M+YI9ktrQTaUq9Xf+1fsSnaPjzm1IAb+vq+3+V+rKGtujxU5kWbXEk7PghFmswm6cS1rMEoOkvDySxfLR8TBetCtKehhKlgmTccC0Az++4X63xnyfWzXq0WJI+/gyj+EffJb/MXxdFR/2h13Td3Qg4LAOKp0wKBgQDLrK/+FNuZATFaVTThu3rdGnRzUgcFbWiKL9VbTCO3xeNxAZ5nDCApCa08hhcln04v5NNtRfMYmm3BKNNxxjN7nZDfbaayhjnWcyXWxfTsEbyJtytSiNEp2gsdwg1bp4R510rjUbwZoCCo6nDlw2Sk6dXkuFrCS/gaPrHtxrpk3QKBgCFn8DDQbUseziF3hj2cxf0z0VLwsyM4O/ryqxP/3y/kKg4KwL8I8XsFgJiZMpCgvT4JtYiOXrf3+VCwO74D5lWhzdn02BLGubEmZqN0fO6u/rdi0QIKPvCRos09vUns9l6skOCPRnzHvtXS5akGh0i/mCP3fUCarMfkyi+lRm25AoGAN1GH23K+0ifIx8gsvMK29CajSk8VKRw2MJIdWNatPNS6mY7e/w4EDiFas/2Xe9hw3AFCi4NcK2qGNNhp1ZUHlqONHaIijIp4Ww6bUGIjy5plouHlGl2escdPDZ4PEr3E9XLMHEGu3Sbot/g1AbK4OzJnrd+EhxErKbWtje9T4OECgYAXIM3guCFLEop3997iQOIYUQgTST1lpr6fY1Lvt7UECLfNq+HvrsMVgNNXS3ZvdA6U4ieXjQhDLgE06Jt5hpzL1877EO2mDNeMaJ3Jq6R4ANN/DjRlAaquOJ9f62+paQl2/eBjlXdDLLrnP2W2fTU4MsVfHH+c61fxeshOZNwbfw==";
//	public static final String APP_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCjOMeHVk4u152aVxnvhAgiKNTvez4UgNJAIWFfWPEBAe+5XqP62khE31rvWJD8n0vDJ/v4uy3DCX8ZTfgB3X7ZIRsH0zFh0riCDWarlSkfqSdtY/JHtp7jFI4UZpSmA5E8UrF/EvoXVyuy3YolAZ336xxbbGLV8nxKwiRTj2T2LjDyFE460LsJQQvwo5UMLIynpHJfybL8HqZPCR701SDmRUa/8Ex/+0NsSMZAZibdHpN+r1Ra7j9bShJCRBL0EkM3ms+SHs3jtq54oH+oPyG0S38kx1B1qI9e2RvohkU4KnNtxpDvZtIpxvGyFdSTHMu5B/46cpcXYqnEZSSUxzwLAgMBAAECggEAa35kYawkN1NG9zNv4D7rAFw1yDY5L1WboiKZtyqjJg+5ajJ6+iUxvTH/+GsyqTzbr34wwqG7RJyHeQnRUKEn/iWAYMnk1tDpNLVQraXBfJlxXuiY0kPiJhkObT8VnLPyvXCUduTvkdmV7OlcJn0HJRRRC6C5Ar/8vVtYgzOHwVyiY2xTdGD3m3BYheXgya6mwwCkzq8gTfa1XwvzKT5ALYodJ0wwKne4BFsjmRp0g+kvXeesRNlyHOGfHxOEWZpOWlfFFjJZOGY/M7sMYqtIND0+QHo7BxjpeHjifHmjE3QMOnGZi6ORKo8WeuSUOAvHUYu8/lGBLDgxXpfFwi55aQKBgQDcB5qFpb5nLhRk0YnF8svcPChEUFOthXkGL1jP3kU1rTjstowNmm51iTWvcx68qeYIQeLASs7gjCBLld80d/4K6OCtore86PY6qSLdGazo6B2Wh8QABpNweNcvm0tjnv92P444zlly6IAGDGXgBtD4isWUAYdy1Hg/T5DkEpDTRwKBgQC957mtDpbTlv0bn0wRC7QXmLbxNyLAjaX9waV3H4WblzkwJcVO79jvbxNZrno+BAuVSNhngQzFI8G2NDv+fTnLfQgn8BUFurcDHEIB06qo1JfZqwynKL5p81tRzrcOJcq7bGeXyD4Ut0EvSaOx1EvH/5FsHTRiVXj1dQqy9XrLHQKBgDTDjgamrHZJ0pIqvYM+qixyMKXRLX/bFh6pk/6lKquokpIRZJyOgBanhLxCOwi7JXKtehbq2Zl3gPcfRZtrevxaxCZfcvhWVVXT4Yxr788aep3yiMoIyaqbD99Wukl1g4Vz0ENHGKQ5pRnON0/10n8HqEHJ7BVZZkyoY/KNkTVZAoGBAIT4ubFscr3LjoUF4Jxa5opTO13hbmsHhAAP1M15e/M7Sybke6jPFsZor1Lvcdb0vCuWqzimSwvLAruTDaMfihVrAgf8+qtdVwJNigZ/cJLw8TbPp3dwdwv3A61fohu86JydxleoNZgJzRHQbVd6QGnVEL10IZbtJFoyzwAKFSYdAoGBAJQmBl7CEkcy/p9sV0BXkTnRSz4KbLqsh9+hKxS2ZNGHML2ssVnCC9/q2xcq0MZ/rLi4pOZpIujNBkG4+yvNKK3HhFb7tyL6XA/WENcBsW7zsykVj133syVwiD6h4RLmg5pC+8Lu2+LonvJH+C4XTu6KZhznGR/omWlG6ibybVEh";
	/** 参数返回格式，只支持json */
	public static final String FORMAT = "json";
	
	/** 编码集，支持GBK/UTF-8 */
	public static final String CHARSET = "UTF-8";
	
	/** 支付宝公钥，由支付宝生成 */
	public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtIenCLyKAwTs8xQNycoenEEqa7vcjC1PGrZO6ldJa3cXDKOptQL4BxFroPnY4Gx9t7QAVnrES3v9Y/JoPy3Rorz8NaNnFZxEp1G3/KgFJxhOB4j32DG/w4NdVq9W0GToB5EG249TeC6ZQjou36gY9g4LYVXtG3rYdGbCpPwas49ByHDQVD3eA7wtZ0eN0D+LGgYv+uZYIBUqBZZGkAeUYdlDkaSTztfF4OdPSTgJ2DEiyG38KcoqKYhHMPWnYb6Cj8WGCD8znTVnb6YJBX8ECp6H2rsgp4zqG8MfUUD88inbVojecnYCl3HJa/F1vhNUb4sOBLxwx1pkTYgna9DeEQIDAQAB";
//	public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAm+mQdTwyxlN3T9wm8PIm8mua79YEMhLYwFMtlfRSaFAgvAuckGir+3tyvjyOvWzAgUOCd3Mtvzq/C0KbyClu2cY2gT3zB6fcMxOyPW5aqQXw3m2XEsQ0ksxqSmoqOfHRTR/MGmZrVFdMOOxu0VOkFrfPYsBbtYJpvpILTZiFJG6wl1GN6x8neAerk048GyUuTL0hxlKK2Im/Fwjd8OyOgMBjsqGpRRP1z2yJzdKQcqenNV4hwVqWjWDXSGjNJzSXJGdf/Zj1OVrDJoeDahoCUiKtizII4M1+6ysP1IpvRfSzzsMbp6yk/8WDtjSI9MczPp+9XNOJENq7FSgyKbeOBwIDAQAB";
	/** 商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2 */
	public static final String SIGN_TYPE = "RSA2";
	
	/** 系统商编号 */
	public static final String SYS_SERVICE_PROVIDER_ID = "2088702240751910";
//	public static final String SYS_SERVICE_PROVIDER_ID = "2088721399296424";
	
	/** 销售产品码 */
	public static final String PRODUCT_CODE = "FAST_INSTANT_TRADE_PAY";
	
	/** 后台通知地址 */
	public static final String NOTIFY_URL = "http://39.105.24.21:80/Red_packet/alipayNotify";
	
//	public static final String FRONT_URL = "http://39.105.24.21:80/Red_packet/notify/";
	
	public static final String QR_PATH = "C:/apache-tomcat-8.5.24/webapps/QR/";
//	public static final String QR_PATH = "/Users/zqs/Documents/";
	
	public static final String QR_URL = "http://39.105.24.21:80/QR/";
	
	
}
