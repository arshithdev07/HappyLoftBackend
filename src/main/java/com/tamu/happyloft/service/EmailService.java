package com.tamu.happyloft.service;

import com.tamu.happyloft.dto.ResetPasswordDto;
import com.tamu.happyloft.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

/**
 * Created by arshi on 4/21/2020.
 */
@Service
public class EmailService {

    @Autowired
    JavaMailSender emailSender;

    @Autowired
    UserService userService;

    public void sendResetPasswordMessage(String toEmail) throws MessagingException, IOException {

        User user = userService.fetchUserDetails(toEmail);

        ResetPasswordDto resetPasswordDto = new ResetPasswordDto();
        resetPasswordDto.setEmail(user.getEmail());
        resetPasswordDto.setCurrentPassword(user.getPassword());

        String generatedString = RandomStringUtils.randomAlphanumeric(8);

        resetPasswordDto.setNewPassword(generatedString);
        userService.changePassword(resetPasswordDto);

        String subject = "Temporary Password";

        String text = "<span> Temporary password to login: <b>" + generatedString + " </b></span>"
                +"<br/><br/><span>Please change your password once you login.</span>";

        MimeMessage msg = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setTo(toEmail);

        helper.setSubject(subject);

        helper.setText(text, true);

        emailSender.send(msg);

    }

    public void exchangeRequestServiceInformation(User existingRequester, User existingServiceCreator, com.tamu.happyloft.model.Service service) throws MessagingException {

        String subject = "Information of the requester for service ID - " + service.getId();

        String text = "<span><b>Here are the details of the person who requested to perform your service: </b></span>"
                +"<br/><br/>"
                +"<span>Name - " + existingRequester.getFirstName() + " " + existingRequester.getLastName()+"</span><br/>"
                +"<span>Email - " + existingRequester.getEmail() +"</span><br/>";

        if(null != existingRequester.getContact() && !existingRequester.getContact().isEmpty()) {
            text += "<span>Contact - " + existingRequester.getContact() +"</span><br/>";
        }

        if(null != existingRequester.getBio() && !existingRequester.getBio().isEmpty()) {
            text += "<span>Bio - " + existingRequester.getBio() +"</span><br/><br/>";
        }

        text += "<span>Please contact the requester to discuss further details.</span>";

        MimeMessage msg = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);

        helper.setTo(existingServiceCreator.getEmail());

        helper.setSubject(subject);

        helper.setText(text, true);

        emailSender.send(msg);

        String subject1 = "Information of the service ";

        String text1 = "<span><b>Here are the details of the service creator you requested to perform: </b></span>"
                +"<br/><br/>"
                +"<span>Name - " + existingServiceCreator.getFirstName() + " " + existingServiceCreator.getLastName()+"</span><br/>"
                +"<span>Email - " + existingServiceCreator.getEmail() +"</span><br/>";

        if(null != existingServiceCreator.getContact() && !existingServiceCreator.getContact().isEmpty()) {
            text1 += "<span>Contact - " + existingServiceCreator.getContact() +"</span><br/><br/>";
        }

        text1 += "<span>Please contact the above person to discuss further details.</span>";

        MimeMessage msg1 = emailSender.createMimeMessage();
        MimeMessageHelper helper1 = new MimeMessageHelper(msg1, true);

        helper1.setTo(existingRequester.getEmail());

        helper1.setSubject(subject1);

        helper1.setText(text1, true);

        emailSender.send(msg1);
    }


}
