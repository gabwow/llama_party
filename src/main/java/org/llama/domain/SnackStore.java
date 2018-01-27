package org.llama.domain;

import java.util.Map;

@FunctionalInterface
public interface SnackStore{
    static final int SNACK_INDEX = 0;
    static final int COST_INDEX = 1;
    public Map<String, Integer> getSnackPrices();
}
