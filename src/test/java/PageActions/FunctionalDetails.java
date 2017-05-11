package PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Setup.Setup.driver;
import static org.junit.Assert.assertEquals;

/**
 * Created by grodrigu on 27/04/17.
 */
public abstract class FunctionalDetails {

    public String getMessage(WebDriver driver, String id) {

        String message;
        message = driver.findElement(By.id(id)).getText();
        return message;

    }

    public String getTotalValueChecked() {

        List<WebElement> FindBody = driver.findElements(By.xpath("//*[@id=\"container\"]/table/tbody"));
        String fullText;
        ArrayList<String> textValues = new ArrayList<>();
        String pattern = "[$](([1-9]+\\.?\\d*)|([0]\\.\\d*)|[0])";
        Pattern patternCompiled = Pattern.compile(pattern);
        Matcher matcher;
        int index = 0;
        Double doubleValue = 0.00;
        Double totalValue = 0.00;


        fullText = FindBody.get(0).getText();
        matcher = patternCompiled.matcher(fullText);

            while (matcher.find()) {

                textValues.add(matcher.group());
            }

            for (String valueText : textValues) {

                String newValueText = valueText.substring(1);
                textValues.set(index, newValueText);
                index++;
            }
            for (int i = 0; i < textValues.size(); i++) {

                if (i != (textValues.size() - 1)) {

                    doubleValue = doubleValue + Double.parseDouble(textValues.get(i).toString());

                } else {

                    totalValue = Double.parseDouble(textValues.get(i).toString());
                }
            }

             DecimalFormat df = new DecimalFormat("#.##");

             doubleValue = Double.valueOf(df.format(doubleValue));

             assertEquals(doubleValue,totalValue);

        String total = "$" + Double.toString(totalValue);

        return total;

    }

        String getLastIDRow(WebDriver driver, String className) {

        String fullText;
        ArrayList<String> textValues = new ArrayList<>();
        String pattern = "[#]([1-9])\\d+";
        Pattern patternCompiled = Pattern.compile(pattern);
        Matcher matcher;
        int index = 0;

        String idNameText = null;

        WebElement element = driver.findElements(By.className(className)).get(0);

        fullText = element.getText();

        matcher = patternCompiled.matcher(fullText);

        while (matcher.find()) {

            textValues.add(matcher.group());
        }

        for (String valueText : textValues) {

            String newValueText = valueText.substring(1);
            idNameText = "order_"+newValueText;
            index++;
        }

       return idNameText;
    }

}