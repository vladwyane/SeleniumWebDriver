import org.openqa.selenium.By;


public class HomePage {
    String url = "http://automationpractice.com";
    By inputSearch = By.id("search_query_top");
    By searchButton = By.name("submit_search");
    By ajaxProduct =  By.cssSelector("li.ajax_block_product");
}
