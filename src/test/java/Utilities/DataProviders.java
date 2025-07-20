package Utilities;

import org.testng.annotations.DataProvider;

import java.util.List;

public class DataProviders {

    @DataProvider(name = "amazonSearchData")
    public  static Object[][] getAmazonSeacrhData(){
        List<Object[]> rowOfData =ExcelUtility.getTestData("src/test/resources/baby.xlsx","Sheet1");
        Object[][] result=new Object[rowOfData.size()][];
        for(int i=0;i<rowOfData.size();i++){
            result[i]=rowOfData.get(i);


        }
        return result;


    }
}
