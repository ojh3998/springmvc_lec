package com.min.app13.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.min.app13.dto.BbsDto;
import com.min.app13.service.IBbsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BbsController {

  private final IBbsService bbsService;
  
  @RequestMapping(value="/bbs/registBbs.do", method=RequestMethod.POST)
  public String registBbs(BbsDto bbsDto, RedirectAttributes redirectAttributes) {
    redirectAttributes.addFlashAttribute("msg", bbsService.registBbs(bbsDto));
    return "redirect:/bbs/list.do";
  }
  
  @RequestMapping(value="/bbs/list.do")
  public String list(HttpServletRequest request, Model model) {
    
    return "bbs/list";
  }
  
}