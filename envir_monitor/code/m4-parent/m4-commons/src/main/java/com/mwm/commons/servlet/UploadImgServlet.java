package com.mwm.commons.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.StringUtil;
import com.mwm.commons.commonConst.Const;
import com.mwm.commons.commonConst.ExceptionConst;
import com.mwm.commons.exception.MwmRuntimeException;
import com.mwm.commons.util.ConfigUtil;
import com.mwm.commons.util.DateJsonValueProcessor;
import com.mwm.commons.util.FileUtil;
import com.mwm.commons.util.StringDefaultValueProcessor;
import com.mwm.commons.util.WebUtil;

public class UploadImgServlet extends HttpServlet {
	private static Logger log = LoggerFactory.getLogger(UploadImgServlet.class);
	
	JsonConfig jsonConfig = new JsonConfig(); 
	{
		jsonConfig.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(java.sql.Timestamp.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(int.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(Integer.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(double.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(Double.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(float.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(Float.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(long.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(Long.class, new DateJsonValueProcessor());
		jsonConfig.registerJsonValueProcessor(BigDecimal.class, new DateJsonValueProcessor());
		jsonConfig.registerDefaultValueProcessor(String.class, new StringDefaultValueProcessor());
	}
	
	public UploadImgServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.flush();
		out.close();
	}

	/**
	 * 图片上传通用接口
	 * 需要传入的参数：type 类型; objId 主体对象ID
	 * 文件存储的路径为：type/yyyyMMdd/objId/objId+yyyyMMddHHmmss.jpg
	 * 返回值: JSON格式 code 处理结果状态， msg，处理消息
	 */
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取文件流
		request.setCharacterEncoding("utf-8");
		String from = request.getParameter("from") == null?"":request.getParameter("from").toLowerCase().trim();
		InputStream in = null;
		Map paramMap = new HashMap();
	
		DiskFileItemFactory factory = new DiskFileItemFactory();

		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		String maxUploadSize = Const.IMG_MAX_SIZE;
		maxUploadSize = StringUtil.isEmpty(maxUploadSize)?"50":maxUploadSize;
		upload.setSizeMax(Integer.parseInt(maxUploadSize) * 1024 * 1024);
		List<FileItem> list = new ArrayList();
		List<Map> itemList = new ArrayList();
		try {
			list = (List<FileItem>) upload.parseRequest(request);
		} catch (FileUploadException e1) {
			throw new MwmRuntimeException("图片上传失败");
		}

		String fileType = "";
		for (FileItem item : list) {
			String name = item.getFieldName();
			if (item.isFormField()) {					
				String value = item.getString();
				paramMap.put(name, value);
			}else {
				paramMap.put(name, item.getInputStream());
				String imgName = item.getName();
				imgName = imgName.substring(imgName.lastIndexOf("//")+1);
				if(StringUtil.isEmpty(imgName)){
					throw new MwmRuntimeException("文件名称不能为空");
				}
				fileType = imgName.substring(imgName.lastIndexOf(".")+1);
				paramMap.put("_imgName", imgName);
				paramMap.put("_fileType", fileType);
				//校验文件格式
				this.validateFileParam(fileType);
			}
		}
		fileType = fileType.toLowerCase();
		
		//文件时间目录以及文件名
		String type = paramMap.get("type") == null?"":paramMap.get("type").toString().toLowerCase();
		String imgUrl = FileUtil.makeTimePath(true);
		imgUrl = imgUrl.replace("\\", "/");
		String imgFileName = RandomStringUtils.randomAlphabetic(8)+"_b." + fileType;

		//文件上传目录
		String filePath="";
		if(Const.IS_IN_PROJECT_DIR.equalsIgnoreCase("Y")){//测试状态则将文件发布到应用的跟目录下，方便测试
			filePath = WebUtil.getWebRoot(request) + Const.DEFAULT_UPLOAD_DIR + imgUrl;
		}else{
			filePath =Const.IMG_FILE_PATH + imgUrl;
		}
		FileUtil.mkdirs(filePath);
		
		//将文件传到文件夹下
		File imgFile = new File(filePath,imgFileName);
		if(imgFile.exists()){
			imgFile.delete();
		}
		imgFile.createNewFile();
		OutputStream out = new FileOutputStream(imgFile);
		int length = 0;
		byte[] buf = new byte[1024];
		for(Object key:paramMap.keySet()){
			Object tmpIn = paramMap.get(key.toString());
			if(tmpIn instanceof InputStream){
				in = (InputStream)tmpIn;
				break;
			}
		}
		if(in == null){
			throw new MwmRuntimeException("无法获取到上传的文件");
		}
		while ((length = in.read(buf)) != -1) {
			out.write(buf, 0, length);
		}
		in.close();
		out.close();
		
		//压缩出大中小
		if(isImg(fileType)){
			log.debug("resize start");
			//ImageSizer.resize(new File(filePath + imgFileName), new File(filePath + imgFileName.replace("_b." + fileType, "_m." + fileType)), 800, 400,fileType);
			//ImageSizer.resize(new File(filePath + imgFileName), new File(filePath + imgFileName.replace("_b." + fileType, "_s." + fileType)), 160, 240,fileType);
		}
		
		//图片保存的地址
		String saveFilePath = (Const.IS_IN_PROJECT_DIR.equalsIgnoreCase("Y")?(getBasePath(request) + Const.DEFAULT_UPLOAD_DIR):Const.IMG_URL_DOMAIN)+imgUrl+imgFileName;
		
		paramMap.put("filePath", saveFilePath);
		Map retMap = new HashMap();
		retMap.put("code", ExceptionConst.RET_CODE_SUCCESS);
		retMap.put("msg", ExceptionConst.RET_MSG_SUCCESS);
		retMap.put("data", saveFilePath);
		retMap.put("url", saveFilePath);
		retMap.put("error", 0);
		
		log.debug("返回结果:{}",JSONObject.fromObject(retMap));
		if(from.equals("kindeditor")){
			response.getWriter().println(JSONObject.fromObject(retMap,jsonConfig));
		}else{
			response.getWriter().println(JSONObject.fromObject(retMap,jsonConfig));
		}
		response.flushBuffer();
		return;
	}
	
	private boolean isImg(String fileType){
		Set<String> fileTypeSet = new HashSet<String>(){
			{add("BMP");add("JPG");add("JPEG");add("PNG");add("GIF");}
		};
		return fileTypeSet.contains(fileType.toUpperCase());
	}
	
	private void validateFileParam(String fileType){
		if(StringUtil.isEmpty(fileType)){
			new MwmRuntimeException("文件格式异常！");
		}
		Set<String> fileTypeSet = new HashSet<String>(){
			{add("BMP");add("JPG");add("JPEG");add("PNG");add("GIF");}
		};
		if(!fileTypeSet.contains(fileType.toUpperCase())){
			new MwmRuntimeException("文件格式异常！");
		}
	}

	private String getBasePath(ServletRequest request) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String path = httpRequest.getContextPath();
		if(Const.IS_DEPLOY_WITH_CONTEXT.equalsIgnoreCase("false")){
			path = "";
		}
		if(Const.IS_DEPLOY_WITH_CONTEXT.equalsIgnoreCase("true")){
			//return path+"/";
		}
		String port = request.getServerPort() == 80?"":String.valueOf(request.getServerPort());
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ (StringUtils.isEmpty(port) ? "":(":" + port)) 
			    + (StringUtils.isEmpty(path) ? "/":(path + "/"));
		return basePath;
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
