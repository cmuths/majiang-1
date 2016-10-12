package com.hejinwei.majiang.dal.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.codehaus.xfire.client.Client;
import org.codehaus.xfire.client.XFireProxy;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.service.binding.ObjectServiceFactory;
import org.codehaus.xfire.transport.http.CommonsHttpMessageSender;
import org.codehaus.xfire.transport.http.EasySSLProtocolSocketFactory;
import org.codehaus.xfire.util.dom.DOMOutHandler;

import com.hejinwei.majiang.dal.bo.Info;
import com.hejinwei.majiang.dal.bo.Obj;
import com.hejinwei.majiang.dal.bo.OneInfo;
import com.hejinwei.majiang.dal.bo.OutputInfo;
import com.hejinwei.majiang.dal.bo.OutputResult;
import com.hejinwei.majiang.dal.bo.OutputRows;
import com.hejinwei.majiang.dal.bo.PersonInfo;
import com.hejinwei.majiang.dal.bo.Row;
import com.hejinwei.majiang.dal.helper.ServiceInf;
import com.hejinwei.majiang.dal.mybatis.model.FacePhoto;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.thoughtworks.xstream.io.xml.DomDriver;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class FaceUtil {

	public static final String SERVICE_URL = "https://api.nciic.com.cn/nciic_ws/services/";

	/**
	 * 将一个输入流转化为字符串
	 */
	public static String getStreamString(String path) throws Exception {
		File file = new File(path);
		long fileSize = file.length();
		if(fileSize > 1024 * 100){
			//对图片进行压缩
		}
		InputStream tInputStream = new FileInputStream(file);
		BufferedReader tBufferedReader = null;
		if (tInputStream != null) {
			try {
				tBufferedReader = new BufferedReader(new InputStreamReader(
						tInputStream));
				StringBuffer tStringBuffer = new StringBuffer();
				String sTempOneLine = new String("");
				while ((sTempOneLine = tBufferedReader.readLine()) != null) {
					tStringBuffer.append(sTempOneLine);
				}
				return tStringBuffer.toString();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				tBufferedReader.close();
				tInputStream.close();
			}
		}
		return null;
	}

	// 把XML文件转为对象
	public static <T> T toBean(String xmlStr, Class<T> cls) {
		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(cls);
		@SuppressWarnings("unchecked")
		T t = (T) xstream.fromXML(xmlStr);
		return t;
	}

	// 把对象转化为XML
	public static String ObjToXML(Obj obj, String imagePath, String flag)
			throws Exception {
		XStream xstream = new XStream(new DomDriver("utf8"));
		PersonInfo p = new PersonInfo();
		List<Info> infos = new ArrayList<Info>();
		Info info = new Info();
		info.setSbm("test");
		infos.add(info);
		p.setInfo(infos);

		List<Row> rows = new ArrayList<Row>();
		Row row1 = new Row();
		row1.setGmsfhm("公民身份号码");
		row1.setXm("姓名");
		row1.setXp("相片");
		rows.add(row1);

		if (obj != null) {
			Row row2 = new Row();
			if ("0".equals(flag)) {
				row2.setGmsfhm("411522198801273017");
				row2.setXm("邹庆源");
			} else {
				row2.setGmsfhm(obj.getUserId());
				row2.setXm(obj.getUserName());
			}
			row2.setXp(encodeBase64(imagePath + "/" + obj.getUserId() + ".jpg"));
			row2.setFsd("000000");
			row2.setYwlx("01");
			rows.add(row2);
		}
		p.setRow(rows);
		xstream.processAnnotations(p.getClass());
		StringWriter sw = new StringWriter();
		xstream.marshal(p, new CompactWriter(sw));
		String s = sw.toString();
		return s;
	}

	public static List<String> onlyObj(String path) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(path), "UTF-8"));
		String line = "";
		List<String> list = new ArrayList<String>();
		while ((line = br.readLine()) != null) {
			list.add(line);
		}
		br.close();
		return list;
	}

	// 读取一行数据,返回所有对象
	public static List<Obj> readline(String path) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(path), "UTF-8"));
		String line = "";
		String[] args = new String[2];
		;
		List<Obj> list = new ArrayList<Obj>();
		while ((line = br.readLine()) != null) {
			args = line.split(",");
			Obj obj = new Obj(args[0], args[1], args[1]);
			list.add(obj);
		}
		br.close();
		return list;
	}

	// 对图片进行base64位编码
	public static String encodeBase64(String path) throws Exception {
		InputStream ins = new FileInputStream(new File(path));
		byte[] data = new byte[ins.available()];
		ins.read(data);
		ins.close();
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}

	public static String GetImageStr(String path) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(path);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

	public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] bytes = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(bytes);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// 字符串写到文件中
	public static void StringIntoFile(String result, String path) {
		FileWriter fw = null;
		File f = new File(path + "/result.txt");
		try {
			if (!f.exists()) {
				f.createNewFile();
			}
			fw = new FileWriter(f);
			BufferedWriter out = new BufferedWriter(fw);
			out.write(result, 0, result.length() - 1);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}

	// 对象转换
	public static FacePhoto toTestByOutput(OutputResult ro) {
		List<OutputRows> rows = ro.getRows();
		OutputInfo info = rows.get(0).getInfo();
		List<OneInfo> in = info.getOneInfo();
		FacePhoto test = new FacePhoto();
		for (OneInfo i : in) {
			// 姓名结果
			if (i.getResult_gmsfhm() != null && i.getResult_gmsfhm() != "") {
				test.setSfz(i.getResult_gmsfhm());
			} else if (i.getResult_xm() != null && i.getResult_xm() != "") {
				test.setXm(i.getResult_xm());
			} else if(i.getXp()  != null && i.getXp()  != ""){
				test.setXp(i.getResult_fx());
				test.setScore(i.getResult_fs());
			}if(i.getErrormesage() != null && i.getErrormesage() != ""){
				test.setXp(i.getErrormesage());
			}
		}
		return test;
	}

	// 请求接口数据
	public static String executeClient(String serviceName, String condition)
			throws MalformedURLException {
		long time = System.currentTimeMillis();
		String license = "<z?zDK)Q6#&mBBSMR]^=/Eag/D9b7q)r?k&w-h:yM7/Dcz/FK >^6%+O?c>iWjRjYl?o4s?x-68bWuCa^oEzVrEwSw?x?vQbcZ^uJrGgUuKfZq7/?vc7Yk\\qDz?x*l;d6x/u?h?v`}JxKv\\q@b3f?vEi]qV[Rw4aa$?.7zb&?g1f?jWg^wXkQq1h?vaLBaA.`3?x;&$^FBMND86W>O-**i?g9/?d?/?v6t[xEfHx^y?x?v]fPkaCWbWzCd@lW;?xc=?g?g;a?g?g?v1p@jNhXsRxUc]l@lEx?x-kQrO[?j=v>c?jBe@;@nXaLnUuCnSi?x?vaCCmM[Ot^eCzKgPt@gc4Ro4a?vQeZf`8An?x5m3m%j&k)qdIO/RnGga4?x?v?jRxZ[JrTcOmQlZ[JvG/`5Oz1h?v/zb`Wpb\\ReRiQc[p?x";
		ProtocolSocketFactory easy = new EasySSLProtocolSocketFactory();
		Protocol protocol = new Protocol("https", easy, 443);
		Protocol.registerProtocol("https", protocol);
		Service serviceModel = new ObjectServiceFactory().create(
				ServiceInf.class, "NciicServices", null, null);
		ServiceInf service = (ServiceInf) new XFireProxyFactory().create(
				serviceModel, SERVICE_URL + serviceName);
		Client client = ((XFireProxy) Proxy.getInvocationHandler(service))
				.getClient();
		client.addOutHandler(new DOMOutHandler());
		client.setProperty(CommonsHttpMessageSender.GZIP_ENABLED, Boolean.TRUE);
		client.setProperty(CommonsHttpMessageSender.HTTP_TIMEOUT, "0");
		String result = null;
		try {
			result = service.nciicCompare(license, condition);// nciicCompare
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		time = System.currentTimeMillis() - time;
		System.out.println("------out time -----" + time);
		return result;
	}
}
