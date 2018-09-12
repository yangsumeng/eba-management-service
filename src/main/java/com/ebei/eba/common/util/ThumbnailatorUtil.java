package com.ebei.eba.common.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;
import net.coobird.thumbnailator.geometry.Positions;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 
 * @Description : 缩略图
 * @time 创建时间 : 2015-6-17
 * @author : fanghui
 * @Copyright (c) 2015 一碑科技
 * @version
 */
public final class ThumbnailatorUtil {
	private static final Logger logger = Logger.getLogger(FileUploadDownloadUtil.class);
	/**
	 * 
	* Description : 转换目录。将一个目录下的图片全部转化缩略图到另外一个目录。 （图片按比例缩略，实际尺寸可能不是width或者height,但分辨率一定有一个为它们）
	* @param fromDir 源目录
	* @param toDir 目标目录
	* @param width 转化后的宽
	* @param height 高
	* @param suffix 文件名后缀
	* @throws Exception 
	* void
	* @throws     
	* @author : fanghui
	 */
//	public static void xferDir(String fromDir,String toDir,int width, int height,String suffix) throws Exception{
//
//		//获取目录下的文件列表，遍历
//		File[] files = FileUtil.readListFileByDir(fromDir);
//		for (File file : files) {
//			//如果文件为目录，则递归
//			String path = file.getPath();
//			if(file.isDirectory()){
//				String toNewDir = toDir+File.separator+file.getName();
//				xferDir(path, toNewDir, width, height,suffix);
//			}else{
//				//为文件时，只有格式为图片格式时才进行缩略
//				try {
//					xferFile(path, toDir, width, height, suffix,1);
//				} catch (Exception e) {
//					logger.debug("file:"+path+"error:"+e.getMessage());
//					throw e;
//				}
//			}
//		}
//	}
	
	
	/**
	 * 
	* Description : 单个文件转化
	* @param fromfile
	* @param toDir
	* @param width
	* @param height
	* @param suffix
	* @throws Exception
	* void
	* @throws     
	* @author : fanghui
	 */
	public static void xferFile(String fromfile,String toDir,int width, int height,String suffix,int overflowCut) throws Exception{
		File file = new File(fromfile);
		String fileName = file.getName();
		String[] namestrs = fileName.split("\\.");
		String picSuffix = namestrs[namestrs.length-1];
		//为文件时，只有格式为图片格式时才进行缩略。同事文件名称不能包含后缀
		if("jpgpngjpeggif".indexOf(picSuffix.toLowerCase())!=-1&&fileName.indexOf(suffix)==-1){
			File newDir = new File(toDir);
			if(!newDir.exists()) newDir.mkdir();
			//缩略后的文件，在文件名加上suffix
			String tofile = toDir+File.separator+namestrs[namestrs.length-2]+suffix+"."+picSuffix;
			if(overflowCut==1){
				xferFileOverFlowHide(fromfile, tofile, width, height);
			}else{
				Thumbnails.of(file).forceSize(width, height).toFile(tofile);
			}
			
		}
	}
	
	/**
	 * 
	* Description : 不加后缀的情况
	* @param fromDir
	* @param toDir
	* @param width
	* @param height
	* @throws Exception
	* void
	* @throws     
	* @author : fanghui
	 */
//	public static void xferDir(String fromDir,String toDir,int width, int height) throws Exception{
//		xferDir(fromDir, toDir, width, height,"");
//	}
	
	/**
	 * 
	* Description : 同目录复制，必须加后缀
	* @param dir
	* @param width
	* @param height
	* @param suffix
	* @throws Exception
	* void
	* @throws     
	* @author : fanghui
	 */
//	public static void xferDir(String dir,int width, int height,String suffix) throws Exception{
//		xferDir(dir, dir, width, height,suffix);
//	}
	
	/**
	 * 
	* Description : 转化文件溢出裁剪
	* @param fromfile
	* @param tofile
	* @param width
	* @param height
	* @throws Exception
	* void
	* @throws     
	* @author : fanghui
	 */
	public static void xferFileOverFlowHide(String fromfile , String tofile , int width, int height) throws Exception{
		BufferedImage image = ImageIO.read(new File(fromfile));  
		Builder<BufferedImage> builder = null;  
		
		int imageWidth = image.getWidth();  
		int imageHeitht = image.getHeight();  
		//看图片是不是需要的图片比例，是直接缩略，否则设置裁剪
		if ((float)height / width != (float)imageWidth / imageHeitht) {  
		    if (imageWidth > imageHeitht) {  
		        image = Thumbnails.of(fromfile).height(height).asBufferedImage();  
		    } else {  
		        image = Thumbnails.of(fromfile).width(width).asBufferedImage();  
		    }  
		    builder = Thumbnails.of(image).sourceRegion(Positions.CENTER, width, height).size(width, height);  
		} else {  
		    builder = Thumbnails.of(image).size(width, height);  
		}  
		builder.outputQuality(0.35f).toFile(tofile); 
	}
	
	
	public static void main(String[] args) {
		try {
			xferFile("F:\\100_0414", "F:\\100_0414_bak", 1080, 756,"_bak1",'0');
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}  
		
		
	}

}
