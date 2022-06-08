package com.azadi.model.enums;

public enum ProductType  implements  Convertible<Long> {

    PERSONAL(0L),
    HOME(1L),
    KITCHEN(2L);

    private final Long value;

    ProductType(Long value){
        this.value=value;
    }
    @Override
    public Long getValue() {
        return value;
    }

    public static ProductType findByLabel(String byLabel) {
        for(ProductType r:ProductType.values()) {
            if (r.getValue().toString().equals(byLabel))
                return r;
        }
        return null;
    }

}
