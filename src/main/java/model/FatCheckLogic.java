package model;

public class FatCheckLogic {
  public void execute(Body body) {
    double height = body.getHeight();
    double neck = body.getNeck();
    double waist = body.getWaist();
    double hip = body.getHip();
    boolean isMale = "male".equals(body.getGender());

    // 米海軍式（Navy）の体脂肪率を算出して設定（単位：cm）
    double fat;
    if (isMale) {
      fat = 495 / (1.0324 - 0.19077 * Math.log10(waist - neck)
                          + 0.15456 * Math.log10(height)) - 450;
    } else {
      fat = 495 / (1.29579 - 0.35004 * Math.log10(waist + hip - neck)
                           + 0.22100 * Math.log10(height)) - 450;
    }
    fat = Math.round(fat * 10) / 10.0; // 小数第1位まで
    body.setFatPercent(fat);

    // 体脂肪率から判定して設定（男女で基準が違う、画像は共通）
    double athleteMax = isMale ? 14 : 21; // これ未満：アスリート
    double normalMax  = isMale ? 25 : 32; // これ未満：標準
    double pocchariMax = isMale ? 30 : 38; // これ未満：ぽっちゃり、以上：肥満

    if (fat < athleteMax) {
      body.setCategory("アスリート");
      body.setImage("athlete.png");
    } else if (fat < normalMax) {
      body.setCategory("標準");
      body.setImage("normal.png");
    } else if (fat < pocchariMax) {
      body.setCategory("ぽっちゃり");
      body.setImage("pocchari.png");
    } else {
      body.setCategory("肥満");
      body.setImage("himan.png");
    }
  }
}
