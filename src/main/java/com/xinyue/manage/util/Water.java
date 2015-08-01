package com.xinyue.manage.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

/**
 * author lzc2015年7月31日上午10:57:55
 */
@Component()
public class Water {
//	private static final String SERIAL_NUMBER = "XXXX"; // 流水号格式
    private static Water water = null;
    private  int number;
    
    static{
    	Water.getInstance();
    }
    
//    public Water(){
//    }
    
    /**
     * 取得Water的单例实现
     * 
     * @return
     */
    public static Water getInstance() {
    	
        if (water == null) {
            synchronized (Water.class) {
                if (water == null) {
                    water = new Water();
                    water.number = 0;
                }
            }
        }
        return water;
    }
 
    /**
     * 生成下一个编号
     */
    public synchronized String generaterNextNumber() {
        String id = null;
        number++;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssS");
//        if (sno == null) {
//            id = formatter.format(date) + "0001";
//        } else {
//            DecimalFormat df = new DecimalFormat("0000");
            id = formatter.format(date) + String.format("%04d", number);
//                    + df.format(number + Integer.parseInt(sno.substring(14, 18)));
//        }
        if(number == 9999){
        	number = 0;
        }
        return id;
    }
	
    
    public static void main(String[] args) {
		Water water = Water.getInstance();
		String idString = water.generaterNextNumber();
		for (int i = 0; i <10000 ; i++) {
//			System.out.println("time ======================= " + System.currentTimeMillis());
			System.out.println(water.generaterNextNumber());
//			idString = water.generaterNextNumber(idString);
		}
		
		
	}

}
