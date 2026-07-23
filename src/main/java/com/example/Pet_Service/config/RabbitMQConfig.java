package com.example.Pet_Service.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String PET_EXCHANGE = "pet.exchange";
    public static final String PET_CREATED_QUEUE = "pet.created.queue";
    public static final String PET_CREATED_ROUTING_KEY = "pet.created";

    @Bean
    TopicExchange petExchange() {
        return new TopicExchange(PET_EXCHANGE);
    }

    @Bean
    Queue petCreatedQueue() {
        return new Queue(PET_CREATED_QUEUE, true);
    }

    @Bean
    Binding binding(Queue petCreatedQueue, TopicExchange petExchange) {
        return BindingBuilder.bind(petCreatedQueue)
                .to(petExchange)
                .with(PET_CREATED_ROUTING_KEY);
    }

    @Bean
    MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}