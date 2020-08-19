package com.exam.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    //添加内容
    /**
     * 将Object 转化成 String类型
     *
     * @param object
     * @return
     */
    public static String obj2Str(Object object) {
        return (object == null) ? "" : object.toString();
    }

    public static String obj2Str(Object object,String defValue) {
        if (object == null){
            return defValue;
        }

        return object.toString().length()>0 ? object.toString(): defValue;
    }

    /**
     * 将Object 转化成 Double类型
     *
     * @param object
     * @return
     */
    public static Double obj2Double(Object object) {
        Double valueBef = new Double(object.toString());
        return valueBef;
    }

    /**
     * 将Object 转化成 Integer类型
     *
     * @param object
     * @return
     */
    public static Integer obj2Int(Object object) {
        int result = 0;
        if (object == null) {
            return 0;
        }
        try {
            result = Integer.parseInt(String.valueOf(object));
        } catch (Exception e) {

        }
        return result;
    }
    public static Integer obj2Int(Object object,int defValue) {
        int result = defValue;
        if (object == null) {
            return defValue;
        }
        try {
            result = Integer.parseInt(String.valueOf(object));
        } catch (Exception e) {

        }
        return result;
    }

    public static Integer obj2Integer(Object object) {
        int result = 0;
        if (object == null) {
            return null;
        }
        try {
            result = Integer.parseInt(String.valueOf(object));
        } catch (Exception e) {
            return null;
        }
        return result;
    }

    /**
     * 将Object 转化成 Integer类型
     *
     * @param object
     * @return
     */
    public static Long obj2Long(Object object) {
        try {
            return Long.valueOf(String.valueOf(object));
        }catch (Exception e){
            return 0L;
        }
    }

    /**
     * 获得一个uuid
     *
     * @return uuid
     */
    public static String getUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }
    /**
     * 判断是否为手机号码
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        if (mobiles == null ){
            return false;
        }
        try {
            String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
            if (mobiles.length() != 11) {
                return false;
            } else {
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(mobiles);
                boolean isMatch = m.matches();
                return isMatch;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
      return false;
    }
    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getNowDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }
    /**
     * 获取当前时间
     *
     * @return datetime
     */
    public static Date getDate() {
        Date day = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now = df.format(day);
        Date date = null;
        try {
            date = df.parse(now);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getNowDateYMD() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间
    }

    /**
     * 生成uuid
     */
    public static String getuuid(){
        String uuid = UUID.randomUUID().toString();
        String suuid = uuid.replaceAll("-", "");
        return suuid;
    }




    /**
     * 文件大小转换
     */
    public static String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;

        if (size >= gb) {
            return String.format("%.1f GB", (float) size / gb);
        } else if (size >= mb) {
            double f = (double) size / mb;
            return String.format(f > 100 ? "%.0f MB" : "%.1f MB", f);
        } else if (size >= kb) {
            double f = (double) size / kb;
            return String.format(f > 100 ? "%.0f KB" : "%.1f KB", f);
        } else
            return String.format("%d B", size);
    }

    /**
     * 拼接路径
     */
    public static String joint(String filePath,String fileName){
        if (filePath.equals("/")&&fileName.equals("")){
            return "/";
        }else {
            String s = filePath + fileName + "/";
            return s;
        }

    }

    public static Long getVersionByNo(Long no) throws Exception{
        String s = String.valueOf(no);
        if (s.length() != 12){
            return Long.valueOf(getDates()+"0000");
        }
        String s1 = String.valueOf(Long.valueOf(s.substring(8, 12)) + 1);
        if (s1.length()<2){
            s1 = "000"+s1;
        }else if (s1.length() <3){
            s1 = "00"+s1;
        }else if (s1.length() <4){
            s1 = "0"+s1;
        }
        return Long.valueOf(getDates() + s1);
    }

    public static String getDates(){
        Calendar now = Calendar.getInstance();
        String year = String.valueOf(now.get(Calendar.YEAR));
        String mou = String.valueOf(now.get(Calendar.MONTH)+1);
        if (mou.length() <2){
            mou = "0"+mou;
        }
        String day = String.valueOf(now.get(Calendar.DAY_OF_MONTH));
        if (day.length() <2){
            day = "0"+day;
        }
        return year+mou+day;
    }

    public static String [] formatFileName(String filename){
       String[] arg =  new String [2];
        if (filename.contains(".")){
            arg[0] = filename.substring(0, filename.lastIndexOf("."));
            arg[1] = filename.substring(filename.lastIndexOf(".")+1,filename.length());
            return arg;
        }
        return null;
    }

    /**
     * 将对象转换成json字符串
     * @param object
     * @return
     */
    public static String obj2Json(Object object){
        Gson gs =  new Gson();
        String objectStr = gs.toJson(object);
        return objectStr;
    }

    /**
     * 将字符串转换成json对象
     * @return
     */
    public static<T>  T json2Obj(String json , Class<T> tClass){
        try {
            Gson gs =  new Gson();
            T objectStr = (T) gs.fromJson(json, (Type) tClass);
            return objectStr;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String getWxPayOrdrID(){
        StringBuilder sb = new StringBuilder();

        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH )+1;
        int date = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        int msecond  = c.get(Calendar.MILLISECOND);

        sb.append(year);
        sb.append(month <10? "0"+month: month);
        sb.append(date <10? "0"+date: date);
        sb.append(hour <10? "0"+hour: hour);
        sb.append(minute <10? "0"+minute: minute);
        sb.append(second <10? "0"+second: second);
        sb.append(msecond <10? "00"+msecond: (msecond <100? "0"+msecond:msecond+""));
        sb.append(getRandNum(4));
        return sb.toString();
    }

    public static String getRandNum(int charCount) {
        String charValue = "";
        for (int i = 0; i < charCount; i++) {
            char c = (char) (randomInt(0, 10) + '0');
            charValue += String.valueOf(c);
        }
        return charValue;
    }
    public static int randomInt(int from, int to) {
        Random r = new Random();
        return from + r.nextInt(to - from);
    }

    /**
     * 将字符串转换成json对象
     * @return
     */
    public static<T>  List<T> json2List(String json , Class<T> tClass){
        JSONArray arr = JSONArray.parseArray(json);
        List list = JSONArray.toJavaObject(arr, List.class);
        List<T> result = new ArrayList<T>();
        for (int i = 0; i < list.size(); i++) {
            JSONObject JSON = (JSONObject) list.get(i);
            T obj =  JSONObject.toJavaObject(JSON,tClass);
            result.add(obj);
        }
        return result;
    }

    public static boolean isEmpty(String str){

        if (str != null && str != "undefined" && str != "null" && str.length() >0){
            return false;
        }
        return true;
    }
    public static boolean isEmptys(String... args){
        for (String item: args) {
            boolean empty = isEmpty(item);
            if (empty){
                return true;
            }
        }
        return false;
    }

    public static boolean isNull(Object object){
        if (object != null){
            return false;
        }
        return true;
    }

    public static boolean isNullS(Object... objects){
        for (Object item: objects) {
            if (isNull(item)){
                return true;
            }
        }
        return false;
    }

    public static Long newID(Long id,Long add){

//       Long ids = id/10000;
       Long ids = id;

       return id+add;
    }


}
