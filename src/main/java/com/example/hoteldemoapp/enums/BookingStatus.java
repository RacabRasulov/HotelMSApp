package com.example.hoteldemoapp.enums;

public enum BookingStatus {

    RESERVED("Rezerv olunub, amma hələ gəlməyib"),
    PREPAID("Rezervasiya təsdiqlənib, öncədən ödəniş edilib"),
    CHECKED_IN("Qonaq otelə daxil olub"),
    IN_HOUSE("Qonaq hazırda oteldə qalır"),
    CHECKED_OUT("Qonaq çıxıb, ödəniş tamamlanıb"),
    NO_SHOW("Rezervasiya edilib, amma gəlməyib"),
    CANCELLED_BY_CUSTOMER("Qonaq tərəfindən ləğv edilib"),
    CANCELLED_BY_HOTEL("Otel tərəfindən ləğv edilib"),
    OVERDUE("Çıxış vaxtı keçib, hələ çıxmayıb"),
    PENDING_APPROVAL("Qəbul gözləyir (əlavə təsdiq tələb olunur)");

    private final String description;

    BookingStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}


