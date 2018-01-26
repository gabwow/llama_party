package org.llama.domain;

import java.util.Map;

@FunctionalInterface
public interface SnackStore{
    public Map<String, Integer> getSnackPrices();
}
