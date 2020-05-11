package com.seasunny.talkerspace.oss.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "oss")
@PropertySource(value = "oss.properties")
public class OssBeanProp {

	private String accessKeyId;
	
	private String accessKeySercret;
	
	private String roleArn;
	
	private Long DurationSeconds;
	
	private String roleSessionName;

	public String getAccessKeyId() {
		return accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public String getAccessKeySercret() {
		return accessKeySercret;
	}

	public void setAccessKeySercret(String accessKeySercret) {
		this.accessKeySercret = accessKeySercret;
	}

	public String getRoleArn() {
		return roleArn;
	}

	public void setRoleArn(String roleArn) {
		this.roleArn = roleArn;
	}

	public Long getDurationSeconds() {
		return DurationSeconds;
	}

	public void setDurationSeconds(Long durationSeconds) {
		DurationSeconds = durationSeconds;
	}

	public String getRoleSessionName() {
		return roleSessionName;
	}

	public void setRoleSessionName(String roleSessionName) {
		this.roleSessionName = roleSessionName;
	}

	@Override
	public String toString() {
		return "OssBeanProp [accessKeyId=" + accessKeyId + ", accessKeySercret=" + accessKeySercret + ", roleArn="
				+ roleArn + ", DurationSeconds=" + DurationSeconds + ", roleSessionName=" + roleSessionName + "]";
	} 
	
	
	
}
