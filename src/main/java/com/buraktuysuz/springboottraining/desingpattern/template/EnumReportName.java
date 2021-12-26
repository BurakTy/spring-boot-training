package com.buraktuysuz.springboottraining.desingpattern.template;

public enum EnumReportName {

    CATEGORY_REPORT("Kategoriler"),
    PRODUCT_REPORT("Ürünler");

    private String reportName;
    EnumReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportName() {
        return reportName;
    }

    @Override
    public String toString() {
        return reportName;
    }
}
