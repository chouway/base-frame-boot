package com.base.framework.common.utils;

import javax.net.ssl.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @Title: HttpUtil
 */
public class HttpPubUtil {
	//通讯方式post
	public static final String METHOD_POST = "POST";

	//通讯编码UTF-8
	public static final String CHAT_UTF8 = "UTF-8";

	//通讯方式 http
	public static final String URL_HTTP = "HTTP";

	//通讯方式 https
	public static final String URL_HTTPS = "HTTPS";

	public static Map<String,String> getJsonHearders(){
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type","application/json");
		return headers;
	}

	/**
	 * http utf-8 请求
	 * @param urlStr
	 * @param requestMessage
	 * @param headers
	 * @return
     * @throws Exception
     */
	public static String httpReq(String urlStr, String requestMessage, Map<String,String> headers) throws Exception {
		return request(urlStr, requestMessage, URL_HTTP, CHAT_UTF8, headers);
	}

	public static String request(String urlStr, String requestMessage, String urlType, String chartSet, Map<String,String> headers) throws Exception {
		if ("HTTPS".equals(urlType)) {
			return requestHttps(urlStr,requestMessage,chartSet,headers);
		}
		String result = "";
		URL url = new URL(urlStr);
		HttpURLConnection conn = null;
		OutputStream writer = null;
		InputStream inputStream = null;
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(60000);
			conn.setReadTimeout(60000);
			conn.setUseCaches(false);

			//消息头
			if(headers==null){
				conn.setRequestProperty("Content-Type", "text/xml");
			}else{
				for (Entry<String, String> entry : headers.entrySet()) {
					conn.setRequestProperty(entry.getKey(), entry.getValue());
				}
			}

			conn.setRequestMethod(METHOD_POST);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			System.out.println("------------------向外发送" + "请求------------------");
			System.out.println("请求URL:" + url);
			Map<String, List<String>> requestProperties = conn.getRequestProperties();
//			System.out.println("消息头："  + requestProperties);
			System.out.println("请求报文体：" + requestMessage);
			System.out.println("-------------------------------------------------------------");
			writer = conn.getOutputStream();

			if(chartSet==null ||chartSet.trim().length()==0){
				chartSet = "UTF-8";
			}
			writer.write(requestMessage.getBytes(chartSet));
			String responseStr = "", sCurrentLine = "";
			if (conn.getResponseCode() == 200) {
				inputStream = conn.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, chartSet));

				while ((sCurrentLine = reader.readLine()) != null) {
					responseStr = responseStr + sCurrentLine;
				}
			}else{
				System.out.println("error resp code==>" + conn.getResponseCode());
				System.out.println("error resp msg==>" + conn.getResponseMessage());
				throw new Exception("error resp code【" + conn.getResponseCode() + "】,msg【"+ conn.getResponseMessage() + "】");
			}
			System.out.println("响应内容：" + responseStr);
			if (!"".equals(responseStr)) {
				result = responseStr;
			}
		} catch (IOException e) {
			throw e;
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
			try {
				if (writer != null) {
					writer.flush();
					writer.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}



	private static String requestHttps( String urlStr, String message, String charSet,Map<String,String> headers) {
		String result = "";
		try {
			TrustManager tm = new X509TrustManager() {
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}

				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}

				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			};
			HostnameVerifier hv = new HostnameVerifier() {
				public boolean verify(String urlHostName, SSLSession session) {
					return urlHostName.equals(session.getPeerHost());
				}
			};
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, new TrustManager[] { tm }, null);

			HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
			HttpsURLConnection.setDefaultHostnameVerifier(hv);
			HttpsURLConnection conn = (HttpsURLConnection) (new URL(urlStr)).openConnection();
			conn.setRequestMethod(METHOD_POST);
			conn.setRequestProperty("Charset", charSet);
			//消息头
			if(headers==null){
				conn.setRequestProperty("Content-Type", "text/xml");
			}else{
				for (Entry<String, String> entry : headers.entrySet()) {
					conn.setRequestProperty(entry.getKey(), entry.getValue());
				}
			}
			conn.setDoInput(true);
			conn.setDoOutput(true);
			System.out.println("------------------向外发送" + "请求------------------");
			System.out.println("请求URL:" + urlStr);
			Map<String, List<String>> requestProperties = conn.getRequestProperties();
			System.out.println("消息头："  + requestProperties);
			System.out.println("请求报文体：" + message);
			System.out.println("-------------------------------------------------------------");
			OutputStream urlOutputStream = conn.getOutputStream();
			urlOutputStream.write(message.getBytes(charSet));
			urlOutputStream.close();


			String responseStr = "", sCurrentLine = "";
			if (conn.getResponseCode() == 200) {
				InputStream inputStream = conn.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, charSet));

				while ((sCurrentLine = reader.readLine()) != null) {
					responseStr = responseStr + sCurrentLine;
				}
				result = responseStr;
			}else{
				System.out.println("error resp code==>" + conn.getResponseCode());
				System.out.println("error resp msg==>" + conn.getResponseMessage());
				throw new Exception("error resp code【" + conn.getResponseCode() + "】,msg【"+ conn.getResponseMessage() + "】");
			}
			System.out.println("响应内容：" + responseStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
