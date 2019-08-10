package enums.csv.file.formats;

public enum ReceiptBankDefaultCSV {
    RECEIPT_ID("Receipt ID"),
    TYPE("Type"),
    DATE("Date"),
    DUE_DATE("Due Date"),
    INVOICE_NUMBER("Invoice Number"),
    SUPPLIER("Supplier"),
    CATEGORY("Category"),
    CUSTOMER("Customer"),
    PROJECT("Project"),
    PROJECT_2("Project 2"),
    PAYMENT_METHOD("Payment Method"),
    BANK_ACCOUNT("Bank Account"),
    VAT("VAT"),
    TOTAL("Total"),
    CURRENCY("Currency"),
    VAT_GBP("VAT (GBP)"),
    TOTAL_GBP("Total (GBP)"),
    STATUS("Status"),
    NOTE("Note"),
    DESCRIPTION("Description");

    private String name;


    ReceiptBankDefaultCSV(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
