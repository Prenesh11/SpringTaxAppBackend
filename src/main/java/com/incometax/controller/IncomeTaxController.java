package com.incometax.controller;

import com.incometax.domain.IncomeTaxRequest;
import com.incometax.domain.IncomeTaxResponse;
import com.incometax.service.IncomeTaxService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncomeTaxController {


    @RequestMapping(value = "calculateIncomeTax", method = RequestMethod.POST)
    public IncomeTaxResponse calculateIncomeTax(@RequestBody IncomeTaxRequest incomeTaxRequest)
    {
        IncomeTaxService incomeTaxService = new IncomeTaxService();
        return incomeTaxService.calculateTax(incomeTaxRequest);
    }
}
