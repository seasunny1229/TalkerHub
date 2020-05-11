package com.seasunny.talkerspace.oss.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import com.seasunny.talkerspace.oss.bean.OssBeanProp;
import com.seasunny.talkerspace.oss.bean.StsBean;

@RestController
public class StsController {
	
	private static final String REGION_ID = "cn-hangzhou";
	private static final String STS_API_VERSION = "2015-04-01";
	
	@Autowired
	private OssBeanProp ossBeanProp;

	@GetMapping("sts/test")
	public String test() {		
		return "sts test success!";
	}
	
	
	@GetMapping("sts/getsts")
	public StsBean getSts() throws ServerException, ClientException {
		
		System.out.println(ossBeanProp.toString());
	
		// 创建一个 Aliyun Acs Client, 用于发起 OpenAPI 请求
		IClientProfile profile = DefaultProfile.getProfile(REGION_ID, ossBeanProp.getAccessKeyId(), ossBeanProp.getAccessKeySercret());
		DefaultAcsClient client = new DefaultAcsClient(profile);
	
		
		// 创建一个 AssumeRoleRequest 并设置请求参数
		final AssumeRoleRequest request = new AssumeRoleRequest();
		
		request.setVersion(STS_API_VERSION);
		request.setMethod(MethodType.POST);
		request.setProtocol(ProtocolType.HTTPS);

		request.setRoleArn(ossBeanProp.getRoleArn());
		request.setRoleSessionName(ossBeanProp.getRoleSessionName());
		request.setPolicy("{\n" + 
				"  \"Statement\": [\n" + 
				"    {\n" + 
				"      \"Action\": [\n" + 
				"        \"oss:PutObject\",\n" + 
				"        \"oss:ListParts\",\n" + 
				"        \"oss:AbortMultipartUpload\"\n" + 
				"      ],\n" + 
				"      \"Effect\": \"Allow\",\n" + 
				"      \"Resource\": [\"acs:oss:*:*:seasunny1229-training/training/*\"]\n" + 
				"    }\n" + 
				"  ],\n" + 
				"  \"Version\": \"1\"\n" + 
				"}");
		request.setDurationSeconds(ossBeanProp.getDurationSeconds());
		
		// 发起请求，并得到response
		final AssumeRoleResponse response = client.getAcsResponse(request);
		
		// 返回
		StsBean stsBean = new StsBean();
		stsBean.setStatusCode("200");
		stsBean.setAccessKeyId(response.getCredentials().getAccessKeyId());
		stsBean.setAccessKeySecret(response.getCredentials().getAccessKeySecret());
		stsBean.setSecurityToken(response.getCredentials().getSecurityToken());
		stsBean.setExpiration(response.getCredentials().getExpiration());
		
		return stsBean;
	}
	
	/**
	 * 读取配置文件
	 * @param path
	 * @return
	 */
	public static String readJson(String path){
        //从给定位置获取文件
        File file = new File(path);
        BufferedReader reader = null;
        //返回值,使用StringBuffer
        StringBuffer data = new StringBuffer();
        //
        try {
            reader = new BufferedReader(new FileReader(file));
            //每次读取文件的缓存
            String temp = null;
            while((temp = reader.readLine()) != null){
                data.append(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭文件流
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data.toString();
    }
	
}
