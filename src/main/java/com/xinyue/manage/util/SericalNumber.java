package com.xinyue.manage.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * author lzc2015年7月31日上午10:57:55
 */
@Component
public class SericalNumber {
//	private static final String SERICAL_NUMBER = "XXXX"; // 流水号格式
    private static SericalNumber sericalnumber = null;
    private  int number;
    
    static{
    	SericalNumber.getInstance();
    }
    
//    public SericalNumber(){
//    }
    
    /**
     * 取得SericalNumber的单例实现
     * 
     * @return
     */
    public static SericalNumber getInstance() {
    	
        if (sericalnumber == null) {
            synchronized (SericalNumber.class) {
                if (sericalnumber == null) {
                    sericalnumber = new SericalNumber();
                    sericalnumber.number = 0;
                }
            }
        }
        return sericalnumber;
    }
 
    /**
     * 生成下一个编号
     */
    public synchronized String generaterNextNumber() {
        String id = null;
        number++;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmss");
//        if (sno == null) {
//            id = formatter.format(date) + "0001";
//        } else {
//            DecimalFormat df = new DecimalFormat("0000");
            id = formatter.format(date) + String.format("%02d", number);
//                    + df.format(number + Integer.parseInt(sno.substring(14, 18)));
//        }
        if(number == 99){
        	number = 0;
        }
        return id;
    }
	
    
    public static void main(String[] args) {
		SericalNumber sericalnumber = SericalNumber.getInstance();
		for (int i = 0; i <10000 ; i++) {
			System.out.println(sericalnumber.generaterNextNumber());
		}
		
		
	}

}
