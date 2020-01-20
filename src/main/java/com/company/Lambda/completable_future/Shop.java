package com.company.Lambda.completable_future;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class Shop {

    private String name;

    public Shop() {
    }

    public Shop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice(String product) {
        return calculatePrice(product);

    }

    public Future<Double> getPriceAsync(String product) {
       /* CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        new Thread(()->{
            try {
                double price = calculatePrice(product);
                completableFuture.complete(price);
            } catch (Exception e) {
                completableFuture.completeExceptionally(e);
            }
        }).start();
        return completableFuture;*/
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        delay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }


    public void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> findPrices(List<Shop> shops, String product) {
        return shops.stream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }

    public List<String> findPricesSyncs(List<Shop> shops, String product) {
        return shops.parallelStream()
                .map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        Shop shop = new Shop();

        long start = System.nanoTime();
        /*Future<Double> future = shop.getPriceAsync("my friends are xxx and xxx");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationTime + " msecs");
        shop.delay();
        try {
            double price = future.get();
            System.out.printf("price is %.2f%n", price);
        } catch (Exception e) {
            e.printStackTrace();
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");

        start = System.nanoTime();
        double testPrice = shop.getPrice("my friends are xxx and xxx");
        shop.delay();
        System.out.printf("price is %.2f%n", testPrice);
        retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");*/


        List<Shop> shops = Arrays.asList(new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"));

        System.out.println("---------------------------------------------------");
        //阻塞、同步
        start = System.nanoTime();
        System.out.println(shop.findPrices(shops, "myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");

        //非阻塞、异步
        start = System.nanoTime();
        System.out.println(shop.findPricesSyncs(shops, "myPhone27S"));
        duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("syncs done in " + duration + " msecs");

        System.out.println("--------------------------------------------------");

        start = System.nanoTime();
        List<CompletableFuture<String>> futures = shops.stream()
                .map(shop1 -> CompletableFuture.supplyAsync(()->
                    String.format("%s price is %.2f", shop.getName(), shop.getPrice("myPhone27S"))
                )).collect(Collectors.toList());


        List<String> list =futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
        duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("CompletableFuture done in " + duration + " msecs");
        System.out.println(list);
    }
}
