package com.company.Lambda.completable_future;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class Discount {


    public enum Code {
        /**
         * 折扣信息
         */
        NONE(0), SILVER(5), GOLD(10), PLATINUM(15), DIAMOND(20);

        private final int percentage;

        Code(int percentage) {
            this.percentage = percentage;
        }
    }

    public static void main(String[] args) {
        Shop shop = new Shop("稻香村");
        String res = shop.getPriceCode("随意搭配");
        System.out.println(res);
    }
}
