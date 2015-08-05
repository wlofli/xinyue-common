package com.xinyue.manage.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * author lzc2015年7月31日上午10:57:55
 */
@Component
public class SerivalNumber {
//	private static final String SERICAL_NUMBER = "XXXX"; // 流水号格式
    private static SerivalNumber sericalnumber = null;
    private  int number;
    
    static{
    	SerivalNumber.getInstance();
    }
    
//    public SerivalNumber(){
//    }
    
    /**
     * 取得SerivalNumber的单例实现
     * 
     * @return
     */
    public static SerivalNumber getInstance() {
    	
        if (sericalnumber == null) {
            synchronized (SerivalNumber.class) {
                if (sericalnumber == null) {
                    sericalnumber = new SerivalNumber();
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
		SerivalNumber sericalnumber = SerivalNumber.getInstance();
		for (int i = 0; i <10000 ; i++) {
			System.out.println(sericalnumber.generaterNextNumber());
		}
		
		
	}

}
