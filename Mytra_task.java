package com.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mytra_task {

	static WebDriver driver;

	public static void browserlaunch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ram kumar\\Desktop\\New folder\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/kids?f=Categories%3ATshirts%3A%3AGender%3Aboys%2Cboys%20girls&plaEnabled=false");
	}
	
	private static void getAllProducts() {
		List<WebElement> allProducts = driver.findElements(By.xpath("//li[@class='product-base']//a//div[2]//h3[@class='product-brand']"));
		for( WebElement product : allProducts) {
			System.out.println(product.getText());
			}
		System.out.println("Total no of products: " + allProducts.size() );
	}
	
	public static void minandmaxPrice() {
		List<WebElement> allPrices = driver.findElements(By.xpath("//li[@class='product-base']//a//div[2]//div//span[@class='product-discountedPrice']"));
		List<Integer> allPriceList = new ArrayList<Integer>();
		for (WebElement price : allPrices) {
			String priceText = price.getText().replace("Rs. ", "" );
			Integer priceValue = Integer.valueOf(priceText);
			allPriceList.add(priceValue);	
		}
		System.out.println("*******************************************");
		System.out.println("Min Value: " + Collections.min(allPriceList));
		System.out.println("Max Value: " + Collections.max(allPriceList));
	}
		
		
	public static void main(String[] args) {
		browserlaunch();
		getAllProducts();
		minandmaxPrice();
	}
}