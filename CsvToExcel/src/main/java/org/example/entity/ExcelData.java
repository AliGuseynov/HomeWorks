package org.example.entity;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExcelData {
    private String id;

    private String storeName;

    private String percent;

    private String amount;

    private String  clientAmount;

}
