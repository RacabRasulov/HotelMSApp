package com.example.hoteldemoapp.hotel.enums;

public enum PaymentMethod {

    CASH("Nağd ödəniş"),
    CARD("Kartla ödəniş (POS terminal)"),
    BANK_TRANSFER("Bank köçürməsi"),
    ONLINE_CARD("Onlayn kartla ödəniş (linklə və ya saytdan)"),
    POST_TERMINAL("Resepşn post terminalı ilə ödəniş"),
    MOBILE_PAYMENT("Mobil ödəniş (Apple Pay, Google Pay və s.)"),
    COMPANY_ACCOUNT("Şirkət hesabı vasitəsilə ödəniş"),
    VOUCHER("Kupon və ya Voucher vasitəsilə"),
    DEPOSIT("Əvvəlcədən depozit kimi ödənilmiş məbləğ"),
    COMPLIMENTARY("Pulsuz / Hədiyyə (otel tərəfindən ödənilib)"),
    OTHER("Digər ödəniş üsulu");

    private final String description;

    PaymentMethod(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

