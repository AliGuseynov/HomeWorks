package service;

public class ItemService {
    private static ReceiptService receiptService;

    public static void setReceiptService(ReceiptService receiptService) {
        ItemService.receiptService = receiptService;
    }
}
