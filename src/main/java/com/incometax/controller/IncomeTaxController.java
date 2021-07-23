package com.incometax.controller;

import com.incometax.domain.IncomeTaxRequest;
import com.incometax.domain.IncomeTaxResponse;
import com.incometax.service.IncomeTaxService;
import org.springframework.web.bind.annotation.*;

@RestController
public class IncomeTaxController {


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "calculateIncomeTax", produces="application/json", method = RequestMethod.POST)
    public IncomeTaxResponse calculateIncomeTax(@RequestBody IncomeTaxRequest incomeTaxRequest)
    {
        IncomeTaxService incomeTaxService = new IncomeTaxService();
        return incomeTaxService.calculateTax(incomeTaxRequest);
    }
}
