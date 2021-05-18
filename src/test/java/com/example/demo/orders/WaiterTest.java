package com.example.demo.orders;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaiterTest {
    @Test
    void test() {
        //given
        Waiter waiter = new Waiter();
        //when
        waiter.addOrder("Lasagne", "2", 25);
        //then
        assertEquals(true, waiter.checkOrderListSize(1));
    }

    @Test
    void test1() {
        //given
        Waiter waiter = new Waiter();
        //when
        waiter.addOrder("Lasagne", "2", 25);
        //then
        assertEquals(true, waiter.checkOrderDetails2("Lasagne"));

    }

    @Test
    void test2() {
        //given
        Waiter waiter = new Waiter();
        //then
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> waiter.addOrder("Lasagne", "2", -25));
       assertEquals(RuntimeException.class,exception.getClass());
       assertEquals("Price cant be lower than 0",exception.getMessage());

    }
}