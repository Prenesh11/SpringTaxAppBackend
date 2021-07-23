package com.incometax.controller;

import com.incometax.domain.IncomeTaxRequest;
import com.incometax.domain.IncomeTaxResponse;
import com.incometax.service.IncomeTaxService;
import org.springframework.web.bind.annotation.*;

/**
 * IncomeTaxController, this class is used as a central controller to expose all the service endpoint need
 * for a customer.
 *
 * @author  Prenesh Naidoo
 * @version 1.0
 * @since  2021
 */


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
