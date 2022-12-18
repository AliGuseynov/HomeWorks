package service;

import model.Receipt;
import repo.ItemRepo;
import repo.ReceiptRepo;
import repo.impl.ReceiptRepoImpl;

import java.util.List;

public class ReceiptService {

    ReceiptRepo receiptRepo = new ReceiptRepoImpl();

    ItemRepo item;

    public ReceiptService(ItemRepo item) {
        this.item = item;
    }

    public void addReceipt(String numbers) {





        receiptRepo.addReceipt(numbers);
    }

    // Getter
    public List<Receipt> getReceipts() {
        return receiptRepo.findAllReceipt();
    }
}
