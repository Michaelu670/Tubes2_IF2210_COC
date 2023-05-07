package org.app.Report;


import com.itextpdf.text.*;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.io.IOException;


@AllArgsConstructor
public class SalesReport extends AbstractReport {

    @Setter
    private static String fileName = "SalesReport.pdf";
    private final static String title = "Sales Report";

    public void writeReport()
            throws DocumentException, IOException {
        Document salesReport = initFile(fileName);
        salesReport.open();
        addMetaData(salesReport,title);
        initTitle(salesReport,title);
        for (int i = 0; i < listOfReport.size(); i++){
            addBill(salesReport,i);
        }
        salesReport.close();
    }






}
