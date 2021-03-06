package com.honji.recommendation.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;


/**
 * 微信接入相关配置属性
 */
@Data
@ConfigurationProperties(WxMpProperties.PREFIX)
public class WxMpProperties {
  public static final String PREFIX = "wx.mp";

  /**
   * 设置微信公众号的appid
   */
  private String appId;

  /**
   * 设置微信公众号的app secret
   */
  private String secret;

  /**
   * 设置微信公众号的token
   */
  private String token;

  /**
   * 设置微信公众号的EncodingAESKey
   */
  private String aesKey;

  /**
   * 存储策略, memory, redis
   */
  private ConfigStorage configStorage = new ConfigStorage();


  @Data
  public static class ConfigStorage implements Serializable {

    private StorageType type = StorageType.memory;

    private RedisProperties redis = new RedisProperties();

  }

  public enum StorageType {
    memory, redis
  }
}
