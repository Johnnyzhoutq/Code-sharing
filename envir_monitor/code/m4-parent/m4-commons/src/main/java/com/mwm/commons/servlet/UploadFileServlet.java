package com.mwm.commons.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mwm.commons.commonConst.ExceptionConst;
import com.mwm.commons.exception.MwmRuntimeException;
import com.mwm.commons.util.FileUtil;
import com.mwm.commons.util.StringUtil;

public class UploadFileServlet extends HttpServlet {
	private static Logger log = LoggerFactory.getLogger(UploadFileServlet.class);
	/**
	 * Constructor of the object.
	 */
	public UploadFileServlet() {
		super();
	}
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); 
	}
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.flush();
		out.close();
	}

	/**
	 * 
	 * 需要传入的参数：type 类型; objId 主体对象ID
	 * 文件存储的路径为：type/yyyyMMdd/objId/objId+yyyyMMddHHmmss.jpg
	 * 返回值: JSON格式 code 处理结果状态， msg，处理消息
	 */
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		log.info("upload start file");
		
		request.setCharacterEncoding("utf-8");
		String from = request.getParameter("from") == null?"":request.getParameter("from").toLowerCase().trim();
		InputStream in = null;
		Map paramMap = new HashMap();
	
		DiskFileItemFactory factory = new DiskFileItemFactory();

		//文件大于1M则保存到临时空间
		factory.setSizeThreshold(1024 * 1024);

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(30 * 1024 * 1024);
		List<FileItem> list = new ArrayList();
		List<Map> itemList = new ArrayList();
		try {
			list = (List<FileItem>) upload.parseRequest(request);
		} catch (FileUploadException e1) {
			Map retMap = new HashMap();
			retMap.put("code", ExceptionConst.RET_CODE_ERRO_SYS_EXCEPTION);
			retMap.put("msg", e1.getMessage());	
			response.getWriter().println(JSONObject.fromObject(retMap));
			response.flushBuffer();
			return;
		}
		

		String nowTime = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String fileType = "";
		for (FileItem item : list) {
			String name = item.getFieldName();
			if (item.isFormField()) {					
				String value = item.getString();
				paramMap.put(name, value);
			}else {
				paramMap.put(name, item.getInputStream());
				String imgName = item.getName();
				imgName = imgName.substring(imgName.lastIndexOf("\\")+1);
				if(StringUtil.isEmpty(imgName)){
					new MwmRuntimeException(601,"文件名称不能为空");
					return;
				}
				fileType = imgName.substring(imgName.lastIndexOf(".")+1);
				paramMap.put("_imgName", imgName);
				paramMap.put("_fileType", fileType);
				//校验文件格式
				this.validateFileParam(fileType);
				
			}
		}
		
		log.debug("paramMap:{}",paramMap);
	
		String type = paramMap.get("type") == null?"":paramMap.get("type").toString().toLowerCase();
		if(type.contains("excel")){
			type = "excel";
		}else if(type.contains("mp3") || type.contains("audio/mpeg")){
			type = "mp3";
		}else if(type.contains("pdf")){
			type = "pdf";
		}else if(type.contains("doc")){
			type = "doc";
		}
		String objId = paramMap.get("objId") == null?"":paramMap.get("objId").toString();
	
		/*MWMUser mwmUser = (MWMUser) request.getSession().getAttribute("USER");
		if(mwmUser==null){
			throw new MwmRuntimeException("数据异常");
		}*/
		
		String imgUrl = FileUtil.makeTimePath(true);
		imgUrl = imgUrl+/*mwmUser.getId()+*/ File.separator;
		String imgFileName = paramMap.get("_imgName").toString();
		
		String prePath = "";
		if(type.equals("excel")){
			
		}else if(type.equals("mp3")){
			/*prePath = ConfigUtil.getValue(Const.MP3_PATH);*/
		}else{
			throw new MwmRuntimeException("不支持的数据格式");
		}
		
		String filePath = prePath
				 + imgUrl;

		FileUtil.mkdirs(filePath);

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
			log.debug("class assign:{},{}",tmpIn.getClass().isAssignableFrom(InputStream.class),tmpIn.getClass());
			if(tmpIn instanceof InputStream){
				in = (InputStream)tmpIn;
				break;
			}
		}
		if(in == null){
			throw new MwmRuntimeException(601,"无法获取到上传的文件");
		}
		//in = (InputStream) (paramMap.get("file") == null?paramMap.get("imgFile"):paramMap.get("file"));
		while ((length = in.read(buf)) != -1) {
			out.write(buf, 0, length);
		}
		in.close();
		out.close();
		
	//	user.setImgUrl(imgUrl+"/"+imgFileName);
		String saveFilePath = /*ConfigUtil.getValue(Const.MP3_DOMAIN)+*/imgUrl+imgFileName;
		/*String saveFilePath = ConfigUtil.getValue(Const.MP3_DOMAIN)+imgUrl+imgFileName;*/
		paramMap.put("filePath", saveFilePath);
		Map retMap = new HashMap();
		retMap.put("code", ExceptionConst.RET_CODE_SUCCESS);
		retMap.put("msg", ExceptionConst.RET_MSG_SUCCESS);
		retMap.put("data", saveFilePath);
		retMap.put("error", 0);
		retMap.put("url", saveFilePath);
		log.debug("返回结果:{}",JSONObject.fromObject(retMap));
		if(from.equals("kindeditor")){
			response.getWriter().println(JSONObject.fromObject(retMap));
		}else{
			response.getWriter().println(JSONObject.fromObject(retMap));
		}
		response.flushBuffer();
		return;
		
	}
	
	private void validateFileParam(String fileType){
		if(StringUtil.isEmpty(fileType)){
			new MwmRuntimeException(601,"文件格式异常！");
		}
		Set<String> fileTypeSet = new HashSet<String>(){
			{add("BMP");add("JPG");add("JPEG");add("PNG");add("GIF");add("XLS");add("MP3");}
		};
		
		if(!fileTypeSet.contains(fileType.toUpperCase())){
			new MwmRuntimeException(601,"文件格式异常！");
		}
		
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
