package demo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * @auther coderJiang
 * @date 2017/7/7
 */
public class ImageMaker {

    private BufferedImage bufferedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
    private Font font;
    private Random random = new Random();
    static Random ran = new Random();

    public static void main(String[] args) {

        ImageMaker test = new ImageMaker();

        //获取系统中可用的字体的名字
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontName = e.getAvailableFontFamilyNames();
        for (int i = 0; i < fontName.length; i++) {
            for(int j = 0; j < 10; j++){
                test.makeFile(String.valueOf(j), "D:/demo/" + j  + "-" + i + "-" + j + ".jpg", fontName[i], new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB));
            }
        }
    }

    private void makeFile(String str, String fullPath, String font, BufferedImage bufferedImage) {

        this.bufferedImage = bufferedImage;

        // 设置字体
        this.initFont(font);

        // 开始写字
        this.draw(str);

        // 保存图片
        this.save(fullPath);

    }

    private void save(String fullPath) {
        File outputfile = new File(fullPath);
        try {
            ImageIO.write(this.bufferedImage, "jpg", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void draw(String message) {
        Graphics2D graphics = this.bufferedImage.createGraphics();
        try {
            graphics.setColor(Color.white);
            graphics.setFont(this.font);
            graphics.drawString(message, 50, 50);
        } finally {
            graphics.dispose();
        }

    }

    private void initFont(String fontName) {
        this.font = new Font(fontName, Font.PLAIN, random.nextInt(20) + 20);
    }


}
