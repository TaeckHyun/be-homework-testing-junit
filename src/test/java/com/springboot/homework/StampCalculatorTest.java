package com.springboot.homework;

import com.springboot.helper.StampCalculator;
import com.springboot.order.entity.Order;
import com.springboot.order.entity.OrderCoffee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StampCalculatorTest {
    @Test
    @DisplayName("실습1: 스탬프 카운트 계산 단위 테스트")
    public void calculateStampCountTest() {
        // TODO 여기에 테스트 케이스를 작성해주세요.
        int nowCount = 5;
        int earned = 3;

        int actual = StampCalculator.calculateStampCount(nowCount, earned);

        int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("실습1: 주문 후 누적 스탬프 카운트 계산 단위 테스트")
    public void calculateEarnedStampCountTest(){
        // TODO 여기에 테스트 케이스를 작성해주세요.
        // given
        Order order = new Order();
        OrderCoffee orderCoffee1 = new OrderCoffee();
        OrderCoffee orderCoffee2 = new OrderCoffee();

        orderCoffee1.setQuantity(3);
        orderCoffee2.setQuantity(5);

        // when
        order.setOrderCoffees(List.of(orderCoffee1, orderCoffee2));

        int expected = orderCoffee1.getQuantity() + orderCoffee2.getQuantity();

        int actual = StampCalculator.calculateEarnedStampCount(order);

        // then
        assertEquals(expected, actual);
    }
}
