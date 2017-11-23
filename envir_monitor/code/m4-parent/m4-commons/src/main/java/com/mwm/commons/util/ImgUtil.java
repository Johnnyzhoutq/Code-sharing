package com.mwm.commons.util;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImgUtil {

	public static String getLoad(String url) {
		// TODO 被注释需要修改
		return null;
		// return Util.getImgLoadUrl(url);
	}
	
	public static void main(String[] args){
		try {
			ImgUtil.coverSquareImgByPath("d:/3.jpg",400,400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void coverSquareImgByPath(String path,int width, int height) throws IOException{
		File  file = new File(path);
		String prePath = path.substring(0, path.lastIndexOf("."));
		ImageIO.write(createSquareImg(file, 640, 960), "png", new File(prePath+"-sq.png"));
	}
	
	public static void coverCircularImgByPath(String path,int width) throws IOException{
		File  file = new File(path);
		String prePath = path.substring(0, path.lastIndexOf("."));
		ImageIO.write(createCircularImg(file,width), "png", new File(prePath+"-r.png"));
		
	}
	
	public static void coverSquareImgByPath(String path,int width) throws IOException{
		File  file = new File(path);
		String prePath = path.substring(0, path.lastIndexOf("."));
		ImageIO.write(createSquareImg(file,width), "png", new File(prePath+"-sq.png"));
		
	}

	/**
	 * 将图片以中心点裁剪成圆形（取宽或者高最小为圆形直径），并且压缩到指定宽度
	 * @param inImg  需要处理的图片文件
	 * @param compressWidth  压缩后的宽度
	 * @return
	 * @throws IOException
	 */
	public static BufferedImage createCircularImg(File inImg, int compressWidth) throws IOException {
		BufferedImage bi1 = ImageIO.read(inImg);

		// 根据需要是否使用 BufferedImage.TYPE_INT_ARGB
		int width = bi1.getHeight() > bi1.getWidth() ? bi1.getWidth() : bi1.getHeight();
		Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, width,
				width);
		BufferedImage bi2 = new BufferedImage(width, width,
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = bi2.createGraphics();
		g2.setComposite(AlphaComposite.Clear);
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC, 1.0f));
		g2.setClip(shape);
		// 使用 setRenderingHint 设置抗锯齿
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
		g2.drawImage(bi1, (bi1.getWidth()-width)/-2,(bi1.getHeight()-width)/-2,null);
		g2.dispose();
		
		
		bi1 = new BufferedImage(compressWidth, compressWidth, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = bi1.createGraphics();  
	    g2d.drawImage(bi2.getScaledInstance(compressWidth, compressWidth, Image.SCALE_SMOOTH), 0, 0, null);  
	    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,1.0f)); //透明度设置开始    
	    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER)); //透明度设置 结束

		return bi1;
	}
	
	/**
	 * 将图片以中心点裁剪成正方形（取宽或者高最小为边长），并且压缩到指定宽度
	 * @param inImg  需要处理的图片文件
	 * @param compressWidth  压缩后的宽度
	 * @return
	 * @throws IOException
	 */
	public static BufferedImage createSquareImg(File inImg, int compressWidth) throws IOException {
		BufferedImage bi1 = ImageIO.read(inImg);

		// 根据需要是否使用 BufferedImage.TYPE_INT_ARGB
		

		int width = bi1.getHeight() > bi1.getWidth() ? bi1.getWidth() : bi1.getHeight();
		Rectangle2D.Double shape = new Rectangle2D.Double(0, 0, width,
				width);
		BufferedImage bi2 = new BufferedImage(width, width,
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = bi2.createGraphics();
		g2.setComposite(AlphaComposite.Clear);
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC, 1.0f));
		g2.setClip(shape);
		// 使用 setRenderingHint 设置抗锯齿
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
		g2.drawImage(bi1, (bi1.getWidth()-width)/-2,(bi1.getHeight()-width)/-2,null);
		g2.dispose();
		
		
		bi1 = new BufferedImage(compressWidth, compressWidth, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = bi1.createGraphics();  
	    g2d.drawImage(bi2.getScaledInstance(compressWidth, compressWidth, Image.SCALE_SMOOTH), 0, 0, null);  
	    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,1.0f)); //透明度设置开始    
	    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER)); //透明度设置 结束

		return bi1;
	}
	
	@Deprecated
	public static BufferedImage createSquareImg(File inImg, int compressWidth, int compressHeight) throws IOException {
		BufferedImage bi1 = ImageIO.read(inImg);

		// 根据需要是否使用 BufferedImage.TYPE_INT_ARGB
		

		//int width = bi1.getHeight() > bi1.getWidth() ? bi1.getWidth() : bi1.getHeight();
		int width = bi1.getWidth();
		int height = bi1.getHeight();
		//压缩图比
        float desRate = (float) (compressWidth/(compressHeight*1.0));
        float srcRate = (float) (width/height*1.0);
        int _width = -1;
        int _height = -1;
        if( bi1.getWidth()/bi1.getHeight() > desRate){
        		//使用高压缩
        	//如果图片比压缩还小就不动了
        	if(height < compressHeight){
        		_height = height;
        	}else{
        		_height = compressHeight;
        	}
        	_width = (int) (srcRate*_height);
        }else{
        	//使用宽压缩
        	if(width < compressWidth){
        		_width = width;
        	}else{
        		_width = compressWidth;
        	}
        	_height = (int)(_width/srcRate);
        	
        }
		Rectangle2D.Double shape = new Rectangle2D.Double(0, 0, _width,
				_height);
		BufferedImage bi2 = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2 = bi2.createGraphics();

		g2.setComposite(AlphaComposite.Clear);
		
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC, 1.0f));
		g2.setClip(shape);
		// 使用 setRenderingHint 设置抗锯齿
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
		g2.drawImage(bi2, 0,0,null);
		g2.dispose();
		

		return bi2;
	}
}
