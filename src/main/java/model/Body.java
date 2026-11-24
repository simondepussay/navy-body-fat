package model;

import java.io.Serializable;
//JavaBeans

public class Body implements Serializable {
  private String gender;                    // "male" / "female"
  private double height, neck, waist, hip;  // cm
  private double fatPercent;                // 体脂肪率（%）
  private String category;                  // 判定
  private String image;                     // 判定の画像ファイル名

  public String getGender() { return this.gender; }
  public void setGender(String gender) { this.gender = gender; }
  public double getHeight() { return this.height; }
  public void setHeight(double height) { this.height = height; }
  public double getNeck() { return this.neck; }
  public void setNeck(double neck) { this.neck = neck; }
  public double getWaist() { return this.waist; }
  public void setWaist(double waist) { this.waist = waist; }
  public double getHip() { return this.hip; }
  public void setHip(double hip) { this.hip = hip; }
  public double getFatPercent() { return this.fatPercent; }
  public void setFatPercent(double fatPercent) { this.fatPercent = fatPercent; }
  public String getCategory() { return this.category; }
  public void setCategory(String category) { this.category = category; }
  public String getImage() { return this.image; }
  public void setImage(String image) { this.image = image; }
}
