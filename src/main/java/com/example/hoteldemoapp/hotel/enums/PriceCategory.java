package com.example.hoteldemoapp.hotel.enums;

public enum PriceCategory {

    /**
     * Standart günlərdə tətbiq olunan əsas qiymət.
     */
    STANDARD,

    /**
     * Bayram və xüsusi tədbirlər günlərində tətbiq olunan yüksək tarifli qiymət.
     */
    HOLIDAY,

    /**
     * Mövsümə əsaslanan endirimli qiymət (yaz, yay, payız, qış).
     */
    SEASONAL_DISCOUNT,

    /**
     * Şəhid və qazi ailələri üçün nəzərdə tutulmuş xüsusi endirimli qiymət.
     */
    DISCOUNTED_FOR_MARTYR_OR_VETERAN,

    /**
     * Korporativ müştərilər üçün tətbiq olunan qiymət.
     */
    CORPORATE,

    /**
     * Dövlət qurumları və ya təşkilatlar üçün tətbiq olunan qiymət.
     */
    GOVERNMENT_AGENCY,

    /**
     * Erkən rezervasiya edənlər üçün tətbiq olunan endirimli qiymət.
     */
    EARLY_BOOKING,

    /**
     * Last minute, yəni son dəqiqə rezervasiyalar üçün tətbiq olunan qiymət.
     */
    LAST_MINUTE,

    /**
     * Loyalty (sadiq) müştərilər üçün xüsusi qiymət.
     */
    LOYAL_CUSTOMER,

    /**
     * Sosial həssas qruplar (əlillər, aztəminatlı ailələr və s.) üçün endirimli qiymət.
     */
    SOCIAL_ASSISTANCE,

    /**
     * Admin və ya daxili istifadə üçün - sistem daxilində istifadə edilə bilər.
     */
    INTERNAL_USE_ONLY

}
