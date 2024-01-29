package com.flight.util;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.flight.service.ReservationServiceImpl;

import jakarta.mail.MessagingException;

import jakarta.mail.internet.MimeMessage;


@Component
public class EmailUtil {
	
//	for tha we have to create javamaillsender object
	@Autowired
	private JavaMailSender sender;
	
	Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

	
//	public void sendItinerary(String toAddress, String filePath) {
		public void sendItinerary(String toAddress) {
		MimeMessage message = sender.createMimeMessage();
//		if we have attachment the mimeHelper set true
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject("e-Ticket");
			
			messageHelper.setText("Please find attachment");
			
//			FileSystemResource file = new FileSystemResource(new File(filePath));
//			messageHelper.addAttachment(file.getFilename(),file);
			
			sender.send(message);
		} catch (MessagingException e) {
			System.out.println("not sending mail to the email");
			LOGGER.error("Exception inside() send itenary"+e);
		}
		
	}

}
