package com.emprenet.emprenet.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarConfirmacionPago(String destino, String nombre, double total) {

        try {

            MimeMessage mensaje = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true, "UTF-8");

            helper.setTo(destino);
            helper.setSubject("Pago confirmado - EmpreNet");

            helper.setText(
                    "<h2>Hola " + nombre + " 👋</h2>" +
                            "<p>Tu pago fue procesado correctamente 🎉</p>" +
                            "<h3>Total: S/ " + total + "</h3>" +
                            "<p>Gracias por comprar en EmpreNet 🚀</p>",
                    true
            );

            mailSender.send(mensaje);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}