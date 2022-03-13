package com.company;

public interface Converter<T, K> {
    K convertTo(T v);
}
