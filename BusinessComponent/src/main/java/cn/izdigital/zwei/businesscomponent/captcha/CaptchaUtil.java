package cn.izdigital.zwei.businesscomponent.captcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 验证码图片生成器
 */
public class CaptchaUtil {

	/**
	 * 验证码长度
	 */
	private final int randCodeLength = 4;
	
	/**
	 * 验证码类型
	 */
	private final int randCodeType = 5;
	
	/**
     * 定义图形大小(宽)
     */
    private static final int width = 100;
    
    /**
     * 定义图形大小(高)
     */
    private static final int height = 34;
    
    /**
     * 干扰线的长度=1.414*lineWidth
     */
    private static final int lineWidth = 10;
    
    /**
     * 干扰线数量
     */
    private static final int count = 200;
    
    /**
     * 验证码存入session的名称
     */
    public static final String SESSION_KEY_OF_CAPTCHA_CODE = "captchaCode";
	
    /**
     * @return 验证码图片
     */
	public BufferedImage createImage(String captchaCode) {
		// 在内存中创建图象
		final BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
        final Graphics2D graphics = (Graphics2D) image.getGraphics();
        // 设定背景颜色
        graphics.setColor(Color.WHITE); // ---1.Color.WHITE为白色
        graphics.fillRect(0, 0, width, height);//填充衍射
        // 设定边框颜色
        graphics.setColor(new Color(0, 0, 0));
        graphics.drawRect(0, 0, width - 1, height - 1);
        final Random random = new Random();
        // 随机产生干扰线，使图象中的认证码不易被其它程序探测到
        for (int i = 0; i < count; i++) {
            graphics.setColor(getRandColor(150, 200)); // ---3.

            final int x = random.nextInt(width - lineWidth - 1) + 1; // 保证画在边框之内
            final int y = random.nextInt(height - lineWidth - 1) + 1;
            final int xl = random.nextInt(lineWidth);
            final int yl = random.nextInt(lineWidth);
            graphics.drawLine(x, y, x + xl, y + yl);
        }
        for (int i = 0; i < captchaCode.length(); i++) {
            // 将认证码显示到图象中,调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
            graphics.setColor(new Color(20 + random.nextInt(130), 20 + random.nextInt(130), 20 + random.nextInt(130)));
            // 设置字体颜色
            graphics.setColor(Color.BLACK);
            // 设置字体样式
            graphics.setFont(new Font("Times New Roman", Font.BOLD, 24));
            // 设置字符，字符间距，上边距
            graphics.drawString(String.valueOf(captchaCode.charAt(i)), (23 * i) + 8, 26);
        }
        // 图象生效
        graphics.dispose();
		return image;
	}

	/**
	 * 生成随机验证码
	 * @return 随机码
	 */
	public String createCaptchaCode() {
		switch (randCodeType) {
		case 1:
			return RandCodeImageEnum.NUMBER_CHAR.generateStr(randCodeLength);
		case 2:
			return RandCodeImageEnum.LOWER_CHAR.generateStr(randCodeLength);
		case 3:
			return RandCodeImageEnum.UPPER_CHAR.generateStr(randCodeLength);
		case 4:
			return RandCodeImageEnum.LETTER_CHAR.generateStr(randCodeLength);
		case 5:
			return RandCodeImageEnum.ALL_CHAR.generateStr(randCodeLength);
		default:
			return RandCodeImageEnum.NUMBER_CHAR.generateStr(randCodeLength);
		}
	}

	/**
	 * 描述：根据给定的数字生成不同的颜色
	 * 
	 * @param 这是以数字型来设置颜色，颜色模式是指使用三种基色：红、绿、蓝，通过三种颜色的调整得出其它各种颜色，这三种基色的值范围为0～255
	 * @param 这是以数字型来设置颜色，颜色模式是指使用三种基色：红、绿、蓝，通过三种颜色的调整得出其它各种颜色，这三种基色的值范围为0～255
	 * @return 描述：返回颜色
	 */
	private Color getRandColor(int fc, int bc) { // 取得给定范围随机颜色
		final Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}

		final int r = fc + random.nextInt(bc - fc);
		final int g = fc + random.nextInt(bc - fc);
		final int b = fc + random.nextInt(bc - fc);

		return new Color(r, g, b);
	}

}
