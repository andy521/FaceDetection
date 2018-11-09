package com.wrlus.facedetection.api.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.baidu.ai.aip.utils.GsonUtils;
import com.baidu.ai.aip.utils.HttpUtil;

@Service
public class FaceDetectionServiceImpl implements FaceDetectionService {

	@Override
	public String getAuthToken() {
		InputStream inputStream = getClass().getResourceAsStream("/config/BaiduAPIConfig.properties");
		Properties properties = new Properties();
		// 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        try {
        	properties.load(inputStream);
        	String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + properties.getProperty("APIKey")
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + properties.getProperty("SecretKey");
        
            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            //返回结果示例
            System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
	}

	@Override
	public String faceDetect() {
		// 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/detect";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("image", "027d8308a2ec665acb1bdf63e513bcb9");
            map.put("face_field", "faceshape,facetype");
            map.put("image_type", "FACE_TOKEN");

            String param = GsonUtils.toJson(map);
            String accessToken = getAuthToken();

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}

}
