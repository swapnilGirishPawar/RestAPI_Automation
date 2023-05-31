package airlines;

import utils.excelUtils;

import java.io.IOException;

public class testClass {
    public static void main(String[] args) throws IOException {
        System.out.println(excelUtils.getExcelDataListAsMap("createAirlineData", "Sheet1"));
    }
}
