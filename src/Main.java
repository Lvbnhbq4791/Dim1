import image.*;

import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
public class Main {
    public static void main(String[] args) throws IOException {
        TexColorSchema cvet1 = new ColorSchem();
        TexColorSchema cvet = new ColorSchema();
        TexConver simVol = new Convert();
        simVol.setTextColorSchema(cvet1);
        File file = new File("D:/50.png");
        BufferedImage image = ImageIO.read(file);
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] mas = new int[width][height];
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                Color color = new Color(image.getRGB(x,y));
                int blue = color.getBlue();
                int red = color.getRed();
                int green = color.getGreen();
                int grey = (int) (red * 0.299 + green * 0.587 + blue * 0.114);
                mas[x][y] = grey;
            }
        }
        String [][] forr = simVol.convert(width,height,mas,cvet);
        String textSimvol;
        StringBuilder sb = new StringBuilder();
        for (int o = 0; o <height; o++) {
            for (int k = 0; k <width; k++) {
                sb.append(forr[k][o]);
                if (k == width - 1) {
                    sb.append("\n");
                }
            }
        }
        textSimvol = sb.toString();
        System.out.println(textSimvol);
        System.out.println("Состояние");
    }
}

