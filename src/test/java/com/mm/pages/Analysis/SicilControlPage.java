package com.mm.pages.Analysis;

import com.mm.pages.BasePage;
import com.mm.utulities.BrowserUtils;
import com.mm.utulities.Database;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SicilControlPage extends BasePage {

    @FindBy(xpath = "//a[text()=' Sicil No ']")
    private WebElement sicilNoFilter;

    @FindBy(xpath = "//input[@placeholder='Sicil No']")
    private WebElement sicilNoFilterInputBox;

    @FindBy(xpath = "//tr[1]/td[6]")
    private WebElement sicilNoValueBox;

    @FindBy(xpath = "//span[contains(text(),'Yerine Bağlan')]")
    private WebElement impersonateButton;

    @FindBy(xpath = "//a[@id='impersonate-fletum']")
    private WebElement impersonateLogin;

    @FindBy(xpath = "//a[@id='analysisTab']")
    private WebElement analysisTab;

    @FindBy(xpath = "//a[contains(text(),'KPI Paneli')]")
    private WebElement kpiDashboardTabOptn;

    @FindBy(xpath = "//iframe")
    private WebElement kpiDashboardIframe;

    @FindBy(xpath = "//span[contains(text(),'Hakediş Ekranı')]")
    private WebElement paymentScreenTab;

    @FindBy(xpath = "//table")
    private WebElement paymentScreenTable;

    @FindBy(xpath = "//ul[@class='pagination pagination-sm']/li/a")
    private List<WebElement> paginationButtons;

    @FindBy(xpath = "//a[@id='setting-wheel']")
    private WebElement settingsWheel;

    @FindBy(xpath = "//a[@title='Logout']")
    private WebElement logoutBtn;



    public Map<String, String> getDataFromDataBase() {
        String query = "SELECT \n" +
                "    ItemId,\n" +
                "    MAX(CASE WHEN AttributeId = 4291 THEN ValueShortString END) AS Position,\n" +
                "    MAX(CASE WHEN AttributeId = 4283 THEN ValueDecimal END) AS SicilNo,\n" +
                "    MAX(CASE WHEN AttributeId = 4280 THEN ValueShortString END) AS MağazaKodu\n" +
                "FROM ItemValues\n" +
                "WHERE AttributeId IN (4291, 4283, 4280)\n" +
                "GROUP BY ItemId\n" +
                "HAVING MAX(CASE WHEN AttributeId = 4291 THEN ValueShortString END) LIKE '%aza Müdürü%';";

        // Map to hold att2_Decimal and att3_ShortString pairs
        Map<String, String> valueMap = new HashMap<>();

        // Veritabanı bağlantısını almak için Database sınıfını kullan
        try (Connection conn = Database.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Sonuç setinde iterasyon yap
            while (rs.next()) {
                // att2_Decimal ve att3_ShortString değerlerini al
                String sicilNo = rs.getInt("SicilNo") + "";
                String storeCode = rs.getString("MağazaKodu");

                // Her iki değer de null değilse map'e ekle
                if (sicilNo != null && storeCode != null) {
                    valueMap.put(sicilNo, storeCode);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(valueMap.entrySet());
        return valueMap;
    }

    public void verifySicilNumbersHasCorrectStoreCode(Map<String,String> map) {
        SoftAssert softAssert = new SoftAssert();
        int i = 1;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("Sicil No:  " + entry.getKey());
            driver.get("https://mediamarkt-ui.efectura.com/UserManage");
            sicilNoFilter.click();
            sicilNoFilterInputBox.sendKeys(entry.getKey());
            BrowserUtils.wait(2);
            sicilNoValueBox.click();
            impersonateButton.click();
            impersonateLogin.click();
            BrowserUtils.wait(1);
            analysisTab.click();
            kpiDashboardTabOptn.click();
            driver.switchTo().frame(kpiDashboardIframe);
            paymentScreenTab.click();
            BrowserUtils.wait(3);
            List<String> storeCodeValues = getColumnData2(paymentScreenTable);
            System.out.println("Tablodan çekilen code değerleri");
            System.out.println(i + " " + storeCodeValues.toString() + "\n--------------------------------------------");
            i++;
            boolean allMatch = storeCodeValues.stream().allMatch(s -> s.equals(map.get(entry.getKey())));
            softAssert.assertTrue(allMatch, entry.getKey() + " sicil nosu ile " + map.get(entry.getKey()) + " kodu eşleşmedi.");

//            for (int i = 1; i < paginationButtons.size(); i++) {
//                Assert.assertTrue(allMatch);
//                BrowserUtils.scrollToBottom(driver);
//                BrowserUtils.wait(2);
//                paginationButtons.get(i).click();
//            }
            driver.switchTo().defaultContent();
            logout();
        }
        softAssert.assertAll();
    }


    public static List<String> getColumnData(WebElement table, String header) {
        List<String> columnData = new ArrayList<>();

        // Get all headers (th > div > span)
        List<WebElement> headers = table.findElements(By.xpath(".//thead/tr/th/div/span"));

        // Find the index of the desired header
        int columnIndex = -1;
        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).getText().trim().equals(header)) {
                columnIndex = i + 1; // XPath indexes start from 1
                break;
            }
        }

        if (columnIndex == -1) {
            throw new RuntimeException("Header not found: " + header);
        }

        // Get all rows
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        // Extract data from the specified column
        for (WebElement row : rows) {
            WebElement cell = row.findElement(By.xpath(".//td[" + columnIndex + "]"));
            columnData.add(cell.getText().trim());
        }

        return columnData;
    }

    public static List<String> getColumnData2(WebElement table) {
        List<String> columnData = new ArrayList<>();
        List<WebElement> storeCodes = table.findElements(By.xpath("//tbody/tr/td[7]"));

        BrowserUtils.wait(2);
        // Extract data from the specified column
        for (WebElement storeCode : storeCodes) {
            String cell = storeCode.getText();
            columnData.add(cell.trim());
            if (columnData.size() == 2) {
                break;
            }
        }
        return columnData;
    }


    public void logout() {
        settingsWheel.click();
        logoutBtn.click();
    }

}
