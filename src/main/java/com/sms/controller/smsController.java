package com.sms.controller;
import com.sms.payload.SmsRequest;
import com.sms.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class smsController {

    private final TwilioService twilioService;

    @Autowired
    public smsController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    //   http://localhost:8080/send-sms
    @PostMapping("/send-sms")
    public void sendSms(@RequestBody SmsRequest smsRequest) {
        twilioService.sendSms(smsRequest.getToPhoneNumber(), smsRequest.getMessage());
    }
}
