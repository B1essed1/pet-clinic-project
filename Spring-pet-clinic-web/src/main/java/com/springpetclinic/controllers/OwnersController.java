package com.springpetclinic.controllers;

import com.springpetclinic.model.Owner;

import com.springpetclinic.repository.OwnerRepository;
import com.springpetclinic.service.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;



@Slf4j
@Controller
public class OwnersController
{
    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";

    private  final OwnerService ownerService;
    private final OwnerRepository ownerRepository;


    public OwnersController(OwnerService ownerService, OwnerRepository ownerRepository) {
        this.ownerService = ownerService;
        this.ownerRepository = ownerRepository;
    }
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }


    @RequestMapping("/owners/find")
    public String findOwners(Model model)
    {
        model.addAttribute("owner", Owner.builder().build());
        log.debug("#################################"+Owner.builder().build());
        return "owners/findOwners";
    }




    @GetMapping("/owners")
    public String processFindForm(Owner owner, BindingResult result, Model model){
        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            log.debug("nuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuul");
            log.error("nuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuul");
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        log.debug("shiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiit :  "+ owner.getLastName());

        // find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike(owner.getLastName());
        log.debug("waaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa: " + results );
        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }
    }
    @GetMapping("/owners/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject( ownerService.findByID(ownerId));
        log.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return mav;
    }

    @RequestMapping({"/owners/index","/owners/index.html"})
    public  String ownersList(Model model)
    {
        model.addAttribute("owners",ownerService.findAll());
        return "owners/index";
    }

    @GetMapping("owners/new")
    public String initCreationForm(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("owners/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            Owner savedOwner =  ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    @GetMapping("owners/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model) {
        model.addAttribute(ownerService.findByID(ownerId));
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("owners/{ownerId}/edit")
    public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, @PathVariable Long ownerId) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            owner.setId(ownerId);
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

}
