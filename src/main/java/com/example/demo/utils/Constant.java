package com.example.demo.utils;

public class Constant {
	public static String loginUrl="/index.html";
	public static String NULL_URI="/404.html";
	public static String STUDENT_INDEX="/student-index.html";
	public static String MY_SCORE="/my-score.html";
	public static String SCORE="/mygrade.html";
	public static String ERROR_URI="/error";
	public static String AESSET="/assets/";
	public static String LOGIN_URI="/user/login";
	//学生登录请求地址
	public static String STUDENT_LOGIN_URL="/user/studentLogin";
	//学生退出请求地址
	public static String STUDENT_LOGINOUT_URL="/user/studentloginOut";
	//查询我的总成绩
	public static String GET_MY_SCORE_COUNT="/score/getMyScore";
	//查询我的成绩
	public static String GET_MY_SCORE="/score/getMyScoreInfo";
	//统一返回码--成功
	public static String SUCCESS_RETUEN_CODE="0";
	//统一返回码--失败
	public static String FAILURE_RETUEN_CODE="-9999";
	//统一返回码--已存在
	public static String HASE_RETUEN_CODE="1";
	public static int Announcing = 0;// Announcing 表示正在发布，
	public static int Chooseing = 1;// Chooseing表示正在选课，
	public static int Teaching = 2;// Teaching表示正在上课，
	public static int Uploading = 3;// Uploading表示正在上传成绩，
	public static int Checking = 4; // Checking表示学生可以查看自己的成绩；
}
