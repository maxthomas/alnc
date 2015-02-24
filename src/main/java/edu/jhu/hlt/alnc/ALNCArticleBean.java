/*
 * Copyright 2012-2015 Johns Hopkins University HLTCOE. All rights reserved.
 * See LICENSE in the project root directory.
 */
package edu.jhu.hlt.alnc;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class representing a bean for a NewsArticle object. This is the basic element of the ALNC corpus.
 * <br/>
 * <br/>
 * This class is an implementation of the Jackson ObjectMapping protocol. 
 */
public class ALNCArticleBean {

  @JsonProperty
  private String city;
  @JsonProperty
  private String domain;
  @JsonProperty
  private String content;
  @JsonProperty
  private String state;
  @JsonProperty
  private String date;
  @JsonProperty(value="article-number")
  private int articleNumber;
  
  /**
   * 
   */
  public ALNCArticleBean() {

  }

  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * @return the domain
   */
  public String getDomain() {
    return domain;
  }

  /**
   * @return the content
   */
  public String getContent() {
    return content;
  }

  /**
   * @return the state
   */
  public String getState() {
    return state;
  }

  /**
   * @return the date
   */
  public String getDate() {
    return date;
  }

  /**
   * @return the articleNumber
   */
  public int getArticleNumber() {
    return articleNumber;
  }

  /**
   * @param city the city to set
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * @param domain the domain to set
   */
  public void setDomain(String domain) {
    this.domain = domain;
  }

  /**
   * @param content the content to set
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * @param state the state to set
   */
  public void setState(String state) {
    this.state = state;
  }

  /**
   * @param date the date to set
   */
  public void setDate(String date) {
    this.date = date;
  }

  /**
   * @param articleNumber the articleNumber to set
   */
  public void setArticleNumber(int articleNumber) {
    this.articleNumber = articleNumber;
  }
}
