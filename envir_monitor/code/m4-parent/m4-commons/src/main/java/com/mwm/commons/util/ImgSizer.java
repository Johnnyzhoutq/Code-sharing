package com.mwm.commons.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * 图像压缩工具
 * 
 * @author lhj
 *
 */
public class ImgSizer {

	private static Logger log = LoggerFactory.getLogger(ImgSizer.class);

	/**
	 * 压缩图片方法
	 * 
	 * @param oldFile
	 *            将要压缩的图片
	 * @param width
	 *            不能超过的最大压缩宽
	 * @param height
	 *            不能超过的最大压缩长
	 * @param quality
	 *            压缩清晰度 <b>建议为1.0</b>
	 * @param smallIcon
	 *            压缩图片后,添加的扩展名
	 * @return
	 * @throws IOException
	 */
	@Deprecated
	public static void imageZip(File oldFile, File destFile, String format, int maxWidth, int maxHeight, float quality)
			throws IOException {
		FileOutputStream out = null;
		try {
			// 文件不存在时
			if (!oldFile.exists())
				return;
			/** 对服务器上的临时文件进行处理 */
			Image srcFile = ImageIO.read(oldFile);
			int new_w = 0, new_h = 0;
			// 获取图片的实际大小 高度
			int h = (int) srcFile.getHeight(null);
			// 获取图片的实际大小 宽度
			int w = (int) srcFile.getWidth(null);
			// 为等比缩放计算输出的图片宽度及高度
			if ((((double) w) > (double) maxWidth) || (((double) h) > (double) maxHeight)) {
				// 为等比缩放计算输出的图片宽度及高度
				double rateW = ((double) srcFile.getWidth(null)) / (double) maxWidth * 1.0;
				double rateH = ((double) srcFile.getHeight(null)) / (double) maxHeight * 1.0;
				// 根据缩放比率大的进行缩放控制
				// double rate = rateW > rateH ? rateW : rateH;
				double rate;
				char zipType;
				if (rateW > rateH) {
					rate = rateW;
					zipType = 'W';
				} else {
					rate = rateH;
					zipType = 'H';
				}
				new_w = (int) (((double) srcFile.getWidth(null)) / rate);
				new_h = (int) (((double) srcFile.getHeight(null)) / rate);

				double rate2 = 0;
				if (zipType == 'W' && new_h > maxHeight) {
					rate = (double) new_h / (double) maxHeight * 1.0;
				} else if (zipType == 'H' && new_w > maxWidth) {
					rate = (double) new_w / (double) maxWidth * 1.0;
				}
				if (rate2 != 0) {
					new_w = (int) (((double) new_w) / rate);
					new_h = (int) (((double) new_h) / rate);
				}
			} else {
				new_w = w;
				new_h = h;
			}

			if (new_w < 1)
				throw new IllegalArgumentException("image width " + new_w + " is out of range");
			if (new_h < 1)
				throw new IllegalArgumentException("image height " + new_h + " is out of range");

			/** 宽,高设定 */
			BufferedImage tag = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
			tag.getGraphics().drawImage(srcFile, 0, 0, new_w, new_h, null);

			out = new FileOutputStream(destFile);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
			JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(tag);
			/** 压缩质量 */
			jep.setQuality(quality, true);
			encoder.encode(tag, jep);
			out.close();
			srcFile.flush();
		} catch (Exception e) {
			log.error("image zip error:{}", e);
		} finally {
			if (out != null)
				out.close();
		}
	}

	public static final MediaTracker tracker = new MediaTracker(new Component() {
		private static final long serialVersionUID = 1234162663955668507L;
	});

	/**
	 * 方法二 * @param originalFile 原图像
	 * 
	 * @param resizedFile
	 *            压缩后的图像
	 * @param width
	 *            图像宽
	 * @param format
	 *            图片格式 jpg, png, gif(非动画)
	 * @throws IOException
	 */
	@Deprecated
	public static void resize(File originalFile, File resizedFile, int width, String format) throws IOException {
		FileInputStream fis = null;
		ByteArrayOutputStream byteStream = null;
		try {
			if (format != null && "gif".equals(format.toLowerCase())) {
				resize(originalFile, resizedFile, width, 1);
				return;
			}
			fis = new FileInputStream(originalFile);
			byteStream = new ByteArrayOutputStream();
			int readLength = -1;
			int bufferSize = 1024;
			byte bytes[] = new byte[bufferSize];
			while ((readLength = fis.read(bytes, 0, bufferSize)) != -1) {
				byteStream.write(bytes, 0, readLength);
			}
			byte[] in = byteStream.toByteArray();
			fis.close();
			byteStream.close();

			Image inputImage = Toolkit.getDefaultToolkit().createImage(in);
			waitForImage(inputImage);
			int imageWidth = inputImage.getWidth(null);
			if (imageWidth < 1)
				throw new IllegalArgumentException("image width " + imageWidth + " is out of range");
			int imageHeight = inputImage.getHeight(null);
			if (imageHeight < 1)
				throw new IllegalArgumentException("image height " + imageHeight + " is out of range");

			// Create output image.
			int height = -1;
			double scaleW = (double) imageWidth / (double) width;
			double scaleY = (double) imageHeight / (double) height;
			if (scaleW >= 0 && scaleY >= 0) {
				if (scaleW > scaleY) {
					height = -1;
				} else {
					width = -1;
				}
			}
			Image outputImage = inputImage.getScaledInstance(width, height, java.awt.Image.SCALE_DEFAULT);
			checkImage(outputImage);
			encode(new FileOutputStream(resizedFile), outputImage, format);
		} catch (Exception e) {
			log.error("image resize error:{}", e);
		} finally {
			try {
				if (byteStream != null) {
					byteStream.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		try {
			String src = "/Users/a1/Downloads/imgs/";

			log.debug("压缩方法2开始");
			for (int i = 0; i < 522; i++) {
				BufferedImage originalImage = ImageIO.read(new File(src + i + ".jpg"));
				Thumbnails.of(originalImage)
						.scale(Math.max(640.0 / originalImage.getWidth(), 960.0 / originalImage.getHeight()))
						.toFile(src.replace("imgs", "imgs-2") + i + ".jpg");

			}
			log.debug("压缩方法2结束");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//

	}


	/**
	 * 方法二 * @param originalFile 原图像
	 * 
	 * @param resizedFile
	 *            压缩后的图像
	 * @param width
	 *            图像宽
	 * @param format
	 *            图片格式 jpg, png, gif(非动画)
	 * @throws IOException
	 */
	@Deprecated
	public static void resize(File originalFile, File resizedFile, int width, int height, String format)
			throws IOException {
		FileInputStream fis = null;
		ByteArrayOutputStream byteStream = null;
		log.debug("resize input");
		try {
			if (format != null && "gif".equals(format.toLowerCase())) {
				resize(originalFile, resizedFile, width, 1);
				return;
			}
			fis = new FileInputStream(originalFile);
			byteStream = new ByteArrayOutputStream();
			int readLength = -1;
			int bufferSize = 1024;
			byte bytes[] = new byte[bufferSize];
			while ((readLength = fis.read(bytes, 0, bufferSize)) != -1) {
				byteStream.write(bytes, 0, readLength);
			}
			byte[] in = byteStream.toByteArray();
			fis.close();
			byteStream.close();

			Image inputImage = Toolkit.getDefaultToolkit().createImage(in);
			waitForImage(inputImage);
			int imageWidth = inputImage.getWidth(null);
			if (imageWidth < 1)
				throw new IllegalArgumentException("image width " + imageWidth + " is out of range");
			int imageHeight = inputImage.getHeight(null);
			if (imageHeight < 1)
				throw new IllegalArgumentException("image height " + imageHeight + " is out of range");

			// Create output image.
			// 原图比
			log.debug("原图片大小----{}---{}", imageWidth, imageHeight);
			double srcRate = imageWidth / imageHeight;
			// 压缩图比
			double desRate = width / height;
			int _width = -1;
			int _height = -1;
			if (srcRate > desRate) {
				// 使用高压缩
				// 如果图片比压缩还小就不动了
				if (imageHeight < height) {
					_height = imageHeight;
				} else {
					_height = height;
				}

			} else {
				// 使用宽压缩
				if (imageWidth < width) {
					_width = imageWidth;
				} else {
					_width = width;
				}

			}
			log.debug("图片处理后的结果----{}---{}", _width, _height);

			Image outputImage = inputImage.getScaledInstance(_width, _height, java.awt.Image.SCALE_SMOOTH);
			checkImage(outputImage);
			encode(new FileOutputStream(resizedFile), outputImage, format);
		} catch (Exception e) {
			log.error("image resize error:{}", e);
		} finally {
			try {
				if (byteStream != null) {
					byteStream.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/** Checks the given image for valid width and height. */
	private static void checkImage(Image image) {
		waitForImage(image);
		int imageWidth = image.getWidth(null);
		if (imageWidth < 1)
			throw new IllegalArgumentException("image width " + imageWidth + " is out of range");
		int imageHeight = image.getHeight(null);
		if (imageHeight < 1)
			throw new IllegalArgumentException("image height " + imageHeight + " is out of range");
	}

	/**
	 * Waits for given image to load. Use before querying image
	 * height/width/colors.
	 */
	private static void waitForImage(Image image) {
		try {
			tracker.addImage(image, 0);
			tracker.waitForID(0);
			tracker.removeImage(image, 0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/** Encodes the given image at the given quality to the output stream. */
	private static void encode(OutputStream outputStream, Image outputImage, String format) throws java.io.IOException {
		try {
			int outputWidth = outputImage.getWidth(null);
			if (outputWidth < 1)
				throw new IllegalArgumentException("output image width " + outputWidth + " is out of range");
			int outputHeight = outputImage.getHeight(null);
			if (outputHeight < 1)
				throw new IllegalArgumentException("output image height " + outputHeight + " is out of range");

			// Get a buffered image from the image.
			BufferedImage bi = new BufferedImage(outputWidth, outputHeight, BufferedImage.TYPE_INT_RGB);
			Graphics2D biContext = bi.createGraphics();
			biContext.drawImage(outputImage, 0, 0, null);

			ImageIO.write(bi, format, outputStream);
			outputStream.flush();
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

	/**
	 * 缩放gif图片
	 * 
	 * @param originalFile
	 *            原图片
	 * @param resizedFile
	 *            缩放后的图片
	 * @param newWidth
	 *            宽度
	 * @param quality
	 *            缩放比例 (等比例)
	 * @throws IOException
	 */
	@Deprecated
	private static void resize(File originalFile, File resizedFile, int newWidth, float quality) throws IOException {
		if (quality < 0 || quality > 1) {
			throw new IllegalArgumentException("Quality has to be between 0 and 1");
		}
		ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());
		Image i = ii.getImage();
		Image resizedImage = null;
		int iWidth = i.getWidth(null);
		int iHeight = i.getHeight(null);
		if (iWidth > iHeight) {
			resizedImage = i.getScaledInstance(newWidth, (newWidth * iHeight) / iWidth, Image.SCALE_SMOOTH);
		} else {
			resizedImage = i.getScaledInstance((newWidth * iWidth) / iHeight, newWidth, Image.SCALE_SMOOTH);
		}
		// This code ensures that all the pixels in the image are loaded.
		Image temp = new ImageIcon(resizedImage).getImage();
		// Create the buffered image.
		BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null), temp.getHeight(null),
				BufferedImage.TYPE_INT_RGB);
		// Copy image to buffered image.
		Graphics g = bufferedImage.createGraphics();
		// Clear background and paint the image.
		g.setColor(Color.white);
		g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
		g.drawImage(temp, 0, 0, null);
		g.dispose();
		// Soften.
		float softenFactor = 0.05f;
		float[] softenArray = { 0, softenFactor, 0, softenFactor, 1 - (softenFactor * 4), softenFactor, 0, softenFactor,
				0 };
		Kernel kernel = new Kernel(3, 3, softenArray);
		ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
		bufferedImage = cOp.filter(bufferedImage, null);
		// Write the jpeg to a file.
		FileOutputStream out = new FileOutputStream(resizedFile);
		// Encodes image as a JPEG data stream
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bufferedImage);
		param.setQuality(quality, true);
		encoder.setJPEGEncodeParam(param);
		encoder.encode(bufferedImage);
	}

	/**
	 * 图片缩放(图片等比例缩放为指定大小，空白部分以白色填充)
	 * 
	 * @param srcBufferedImage
	 *            源图片
	 * @param destFile缩放后的图片文件
	 * @param destHeight
	 * @param destWidth
	 */
	public static void zoom(BufferedImage srcBufferedImage, File destFile, String format, int destHeight,
			int destWidth) {
		try {
			int imgWidth = destWidth;
			int imgHeight = destHeight;
			int srcWidth = srcBufferedImage.getWidth();
			int srcHeight = srcBufferedImage.getHeight();
			double scaleW = destWidth * 1.0 / srcWidth;
			double scaleH = destHeight * 1.0 / srcHeight;
			if (scaleW >= scaleH) {
				double imgWidth1 = scaleH * srcWidth;
				double imgHeight1 = scaleH * srcHeight;
				imgWidth = (int) imgWidth1;
				imgHeight = (int) imgHeight1;
			} else {
				double imgWidth1 = scaleW * srcWidth;
				double imgHeight1 = scaleW * srcHeight;
				imgWidth = (int) imgWidth1;
				imgHeight = (int) imgHeight1;
			}
			BufferedImage destBufferedImage = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
			Graphics2D graphics2D = destBufferedImage.createGraphics();
			graphics2D.setBackground(Color.WHITE);
			graphics2D.clearRect(0, 0, destWidth, destHeight);
			graphics2D.drawImage(srcBufferedImage.getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH),
					(destWidth / 2) - (imgWidth / 2), (destHeight / 2) - (imgHeight / 2), null);
			graphics2D.dispose();
			ImageIO.write(destBufferedImage, format, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 压缩图片成jpg格式，压缩到某个边达到最小值即可
	 * 
	 * @param inFile
	 *            需要压缩的图片文件
	 * @param outFile
	 *            压缩后的图片文件
	 * @param maxWidth
	 *            最小宽度
	 * @param maxHeight
	 *            最小高度
	 * @throws IOException
	 */
	public static void scanImgByMinSize(File inFile, File outFile, int maxWidth, int maxHeight) throws IOException {
		BufferedImage originalImage = ImageIO.read(inFile);
		ImgSizer.scanImgFormart(inFile, outFile,
				Math.max(maxWidth * 1.0 / originalImage.getWidth(), maxHeight * 1.0 / originalImage.getHeight()),
				"jpg");
	}

	/**
	 * 压缩图片成指定格式
	 * 
	 * @param inFile
	 *            需要压缩的图片文件
	 * @param outFile
	 *            压缩后输出的图片文件
	 * @param scale
	 *            压缩率
	 * @param formart
	 *            压缩后的图片格式
	 * @throws IOException
	 */
	public static void scanImgFormart(File inFile, File outFile, double scale, String formart) throws IOException {
		Thumbnails.of(inFile).scale(scale).outputFormat(formart).toFile(outFile);
	}
	
	
	/**
	 * 旋转图片
	 * @param inFile
	 * @param outFile
	 * @param rotate 旋转角度 正数顺时针旋转，负数逆时针旋转
	 * @throws IOException
	 */
	public static void rotateImg(File inFile, File outFile, float rotate) throws IOException{
		Thumbnails.of(inFile).rotate(rotate).toFile(outFile);
	}
	
	/**
	 * 输出水印到图像上
	 * @param inFile 需要处理的图片文件
	 * @param outFile 转换后的文件
	 * @param point 水印位置
	 * @param waterImg 水印图
	 * @param opacity 水印透明度
	 * @throws IOException
	 */
	public static void watermarkImg(File inFile, File outFile, Positions point, BufferedImage waterImg, float opacity) throws IOException{
		Thumbnails.of(inFile).watermark(point, waterImg, opacity).toFile(outFile);
	}
	
	/**
	 * 图片裁切
	 * @param x1 选择区域左上角的x坐标
	 * @param y1 选择区域左上角的y坐标
	 * @param width 选择区域的宽度
	 * @param height 选择区域的高度
	 * @param sourcePath 源图片路径
	 * @param descpath 裁切后图片的保存路径
	 * @throws IOException 
	 */
	public static void cut(String sourcePath, String descpath ,int x1, int y1, int width, int height) throws IOException {
		Thumbnails.of(sourcePath).sourceRegion(x1,y1,width,height).toFile(descpath);
	}

}
