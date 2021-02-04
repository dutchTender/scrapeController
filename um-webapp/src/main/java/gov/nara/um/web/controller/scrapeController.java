package gov.nara.um.web.controller;




import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseStatus;


import gov.nara.um.persistence.model.User;

import gov.nara.um.util.UmMappings;

@Controller
@RequestMapping(value = UmMappings.scrape)

// we will rename this as the scrapeController
// request body will be json with local or aws file path
public class scrapeController {



    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void scrape(@RequestBody final User resource) {
       // createInternal(resource);
        // this will return a response json with the scraped metadata
        // need to create metadata model DTO and set it as return object
    }




}
