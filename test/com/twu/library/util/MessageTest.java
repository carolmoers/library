package com.twu.library.util;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class MessageTest {
    @Test
    public void showWelcomeMessageTest(){
        Message message = new Message();
        String welcomeMessage = message.showWelcomeMessage();

        assertThat("Welcome to the Library!\n", is(equalTo(welcomeMessage)) );
    }

    @Test
    public void showInputDataMessageTest(){
        Message message = new Message();
        String inputDataMessage = message.showInputDataMessage();

        assertThat("\nWhat you would like to do (1-2)? ", is(equalTo(inputDataMessage)) );
    }
}

