package com.company;

public interface Processor<T> {
    T process(T v1, T v2);
}
