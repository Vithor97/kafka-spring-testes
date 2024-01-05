package com.vimti.kafkatestes.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerService {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message, String topicName) {
        logger.info("Antes de enviar a mensagem(service antes do send)");
        CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send(topicName, message);
        send.whenComplete((result, ex) -> {
            if (ex != null) {
                logger.error("Erro ao enviar a mensagem: " + ex.getMessage());
            } else {
                logger.info("Mensagem enviada ao kafka com sucesso na service: " + result.getProducerRecord().value());
            }
        });

        logger.info("Service-Depois de enviar a mensagem (service depois do send)");
    }
}
