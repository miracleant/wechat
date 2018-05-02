package util;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelGrabber;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil {

	public static BufferedImage change2jpg(File f) {
		try {
			java.awt.Image i = Toolkit.getDefaultToolkit().createImage(f.getAbsolutePath());
			PixelGrabber pg = new PixelGrabber(i, 0, 0, -1, -1, true);
			pg.grabPixels();
			int width = pg.getWidth(), height = pg.getHeight();
			final int[] RGB_MASKS = { 0xFF0000, 0xFF00, 0xFF };
			final ColorModel RGB_OPAQUE = new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]);
			DataBuffer buffer = new DataBufferInt((int[]) pg.getPixels(), pg.getWidth() * pg.getHeight());
			WritableRaster raster = Raster.createPackedRaster(buffer, width, height, width, RGB_MASKS, null);
			BufferedImage img = new BufferedImage(RGB_OPAQUE, raster, false, null);
			return img;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void resizeImage(File srcFile, int width,int height, File destFile) {
		try {
			if(!destFile.getParentFile().exists())
				destFile.getParentFile().mkdirs();
			Image i = ImageIO.read(srcFile);
			i = resizeImage(i, width, height);
			ImageIO.write((RenderedImage) i, "jpg", destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Image resizeImage(Image srcImage, int width, int height) {
		try {

			BufferedImage buffImg = null;
			buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			buffImg.getGraphics().drawImage(srcImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);

			return buffImg;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

/**
* 妯′豢澶╃尗鏁寸珯j2ee 鏁欑▼ 涓篽ow2j.cn 鐗堟潈鎵�鏈�
* 鏈暀绋嬩粎鐢ㄤ簬瀛︿範浣跨敤锛屽垏鍕跨敤浜庨潪娉曠敤閫旓紝鐢辨寮曡捣涓�鍒囧悗鏋滀笌鏈珯鏃犲叧
* 渚涜喘涔拌�呭涔狅紝璇峰嬁绉佽嚜浼犳挱锛屽惁鍒欒嚜琛屾壙鎷呯浉鍏虫硶寰嬭矗浠�
*/	
