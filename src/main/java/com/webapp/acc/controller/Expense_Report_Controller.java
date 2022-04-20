package com.webapp.acc.controller;

//import com.webapp.acc.service.ReportService;
import com.webapp.acc.service.SpendingService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.print.attribute.standard.Media;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

@Controller
public class Expense_Report_Controller {
    private final SpendingService service;

    public Expense_Report_Controller(SpendingService service) {
        this.service = service;
    }


    @GetMapping("/Expense_report")
    public ResponseEntity<byte[]> generateReport() throws FileNotFoundException, JRException {
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(service.getAllSpendings(null));
        JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Expense_report.jrxml"));
        HashMap<String, Object> map = new HashMap<>();

        JasperPrint report = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);
        //JasperExportManager.exportReportToPdfFile(report, "acc_report.pdf");

        byte[] data = JasperExportManager.exportReportToPdf(report);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=acc_report.pdf");
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data);
    }

}
