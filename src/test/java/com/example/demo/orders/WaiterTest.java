package com.example.demo.orders;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaiterTest {
    @Test
    void test0() {
        //given
        Waiter waiter = new Waiter("1");
        //when
        waiter.addOrder("1","Lasagne", "2", 25);
        //then
        assertEquals(true, waiter.checkOrderListSize(1));
    }

    @Test
    void test1() {
        //given
        Waiter waiter = new Waiter("1");
        //when
        waiter.addOrder("1","Lasagne", "2", 25);
        //then
        assertEquals(true, waiter.checkOrderDetails("Lasagne"));

    }

    @Test
    void test2() {
        //given
        Waiter waiter = new Waiter("1");
        //then
        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> waiter.addOrder("1","Lasagne", "2", -25));
        assertEquals(RuntimeException.class, exception.getClass());
        assertEquals("Price cant be lower than 0", exception.getMessage());

    }

    @Test
    void test3() {
        Waiter waiter = new Waiter("1");
        waiter.addOrder("1","Lasagne", "2", 25);

        waiter.endOrder("1");
        assertTrue(waiter.checkOrderListSize(0));
    }
}