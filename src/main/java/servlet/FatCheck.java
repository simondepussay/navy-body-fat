package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Body;
import model.FatCheckLogic;

@WebServlet("/FatCheck")
public class FatCheck extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // フォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/fatCheck.jsp");
    dispatcher.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // リクエストパラメータを取得
    request.setCharacterEncoding("UTF-8"); //文字列を取得する際に必須
    String gender = request.getParameter("gender"); // 性別
    String height = request.getParameter("height"); // 身長
    String neck = request.getParameter("neck");     // 首回り
    String waist = request.getParameter("waist");   // 腹囲
    String hip = request.getParameter("hip");       // ヒップ（女性のみ）

    // 入力値をプロパティに設定
    Body body = new Body();
    body.setGender(gender);
    body.setHeight(Double.parseDouble(height));
    body.setNeck(Double.parseDouble(neck));
    body.setWaist(Double.parseDouble(waist));
    if ("female".equals(gender)) {
      body.setHip(Double.parseDouble(hip));
    }

    // 体脂肪率を計算し結果を設定
    FatCheckLogic fatCheckLogic = new FatCheckLogic();
    fatCheckLogic.execute(body);

    // リクエストスコープに保存
    request.setAttribute("body", body);

    // フォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/fatCheckResult.jsp");
    dispatcher.forward(request, response);
  }
}
