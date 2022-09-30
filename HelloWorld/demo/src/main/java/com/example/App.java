package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class App {


    public static void main(String[] args) {
        
		System.setProperty("webdriver.chrome.driver","D:\\Bruno HDD\\Arquivos Pessoais\\Workshop Testes Automatizados\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "http://google.com/";

        driver.get(baseUrl);

        WebElement inputGoogle = driver.findElement(By.name("q"));

        inputGoogle.clear();
        inputGoogle.sendKeys("Hello World!");
        inputGoogle.sendKeys(Keys.RETURN);
       
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        driver.close();
       
    }

}