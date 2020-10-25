package Ebay.EbayAssign;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class èbay {


	@Test
	public void TestFlipkartSearch() throws InterruptedException, IOException {
		

		System.setProperty("webdriver.chrome.driver","C:\\Users\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	
		driver.get("https://www.ebay.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		String title = driver.getTitle();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("iphone");
		driver.findElement(By.xpath("//input[@id='gh-btn']")).click();
		List<WebElement> data = driver.findElements(By.xpath("//span[@class='s-item__price']"));
		
		
		String product_price;
		int int_product_price;
		HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
		for(int i=0;i<data.size();i++) {
			
			product_price = data.get(i).getText();
			product_price = product_price.replaceAll("[^0-9]", "");
			int_product_price = Integer.parseInt(product_price);
			map_final_products.put(int_product_price,"Price");
			System.out.println(product_price);
		}
		
		
		Set<Integer> allkeys = map_final_products.keySet();
		ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);
		
		Collections.sort(array_list_values_product_prices);
		
		
		int high_price = array_list_values_product_prices.get(array_list_values_product_prices.size()-1);
		System.out.println(high_price);
		
		List<WebElement> HighestPrice = driver.findElements(By.xpath("//div[@class='s-item__info clearfix']"));
		 
		System.out.println("total no of value"+HighestPrice.size());
	        for (WebElement product : HighestPrice) {
	        	
	        	System.out.println(((WebElement) HighestPrice).getText());
	            System.out.println("<======================================>");
	        }
	        
	        File file = new File ("D:\\Eclipse_Workplace\\EbayAssign\\ebay.txt");
			
			FileWriter fw = new FileWriter(file);
			
			BufferedWriter writer = new  BufferedWriter(fw);
			
			writer.write(title);
			writer.newLine();
			writer.write(high_price);
			writer.newLine();
			writer.write("second Line");
			
			System.out.println("Data enterd");
			writer.close();
		
				
	
	
	}
 
}



