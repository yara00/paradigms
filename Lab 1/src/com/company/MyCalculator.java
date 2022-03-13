package com.company;


import java.util.Scanner;
import java.util.function.*;
public class MyCalculator extends Calculator<Double, Integer>{
    class DoubleToIntegerConverter implements Converter<Double, Integer> {
        @Override public Integer convertTo(Double v) { return v.intValue(); }
    }

    class IntegerAdder implements Processor<Integer> {
        @Override public Integer process(Integer v1, Integer v2) { return v1 + v2; }
    }
    class IntegerSubtractor implements Processor<Integer> {
        @Override public Integer process(Integer v1, Integer v2) { return v1 - v2; }
    }
    class IntegerMultiplier implements Processor<Integer> {
        @Override public Integer process(Integer v1, Integer v2) { return v1 * v2; }
    }

    private DoubleToIntegerConverter myConverter = new DoubleToIntegerConverter();
    private final OutputPrinter<Integer> printer;
    public MyCalculator(OutputPrinter<Integer> printer) {
        this.printer = printer;
    }
    public void add(InputProvider<Double> input1, InputProvider<Double> input2) {
        process(input1, input2, myConverter, new IntegerAdder(), printer);
    }

    public void subtract(InputProvider<Double> input1, InputProvider<Double> input2) {
        process(input1, input2, myConverter, new IntegerSubtractor(), printer);
    }
    public void multiply(InputProvider<Double> input1, InputProvider<Double> input2) {
        process(input1, input2, myConverter, new IntegerMultiplier(), printer);
    }
}

/*
public class MyCalculator extends Calculator<Double, Integer> {

    Function<Double, Integer> DoubleToIntegerConverter = a -> (a.intValue());

    Consumer<Integer> display = a -> System.out.println(a);

    BinaryOperator<Integer> IntegerMultiplication = (x, y) -> x * y;
    BinaryOperator<Integer> IntegerAddition = (x, y) -> x + y;
    BinaryOperator<Integer> IntegerSubtraction = (x, y) -> x - y;

    public void add(double x, double y) {
       display.accept(IntegerAddition.apply(DoubleToIntegerConverter.apply(x), DoubleToIntegerConverter.apply(y)));
    }
    public void subtract(double x, double y) {
        display.accept(IntegerSubtraction.apply(DoubleToIntegerConverter.apply(x), DoubleToIntegerConverter.apply(y)));
    }
    public void multiply(double x, double y) {
        display.accept(IntegerMultiplication.apply(DoubleToIntegerConverter.apply(x), DoubleToIntegerConverter.apply(y)));
    }

    public static void main(String[] args) {
        MyCalculator myCalculator = new MyCalculator();
        Scanner scanner = new Scanner(System.in);
        Supplier<Double> supplier = () ->  scanner.nextDouble();

        System.out.println("Add--------------");
        myCalculator.add(supplier.get(),supplier.get());

        System.out.println("Subtract---------");
        myCalculator.subtract(supplier.get(), supplier.get());

        System.out.println("Multiply---------");
        myCalculator.multiply(supplier.get(),supplier.get());

        System.out.println("Positive Input Validation--------");
        Predicate<Double> predicate = (a) -> a >= 0;
        System.out.println(predicate.test(supplier.get()));
        System.out.println(predicate.test(supplier.get()));
    }
}

 */


