package br.unifor.poo.tiozeiros.images;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by andre on 28/11/16.
 */
public class ManipulateImg {

    private static BufferedImage resizeImage(BufferedImage originalImage, int type){
        int imgWidth = 150;
        int imgHeight = 150;
        BufferedImage resizedImage = new BufferedImage(imgWidth, imgHeight, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, imgWidth, imgHeight, null);
        g.dispose();

        return resizedImage;
    }
}
