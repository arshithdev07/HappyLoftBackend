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
}
