package com.educational.material.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educational.material.transactions.interfaces.NavigationLinkTransaction;
import com.educational.material.vo.NavigationVO;
import com.educational.material.vo.ResponseVO;

@RestController
@CrossOrigin(origins = {"http://localhost:4201", "http://localhost:4200"}, methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
public class NavigationLinkController {
	
	@Autowired private NavigationLinkTransaction navigationLinkTransaction;
	
	@GetMapping(value = "/nav/link/{status}")
	public ResponseVO getAllNavigationLink(@PathVariable("status") String status){
		ResponseVO responseVO = new ResponseVO();
		List<NavigationVO> navigationVO = navigationLinkTransaction.getAllNavigationLink(status);
		responseVO.setPayload(navigationVO);
		return responseVO;
	}
	
	@GetMapping(value = "/nav/links")
	public ResponseVO getNavigationLinkByLogedInUser(){
		ResponseVO responseVO = new ResponseVO();
		List<NavigationVO> navigationVO = navigationLinkTransaction.getNavigationLinkByLogedInUser();
		responseVO.setPayload(navigationVO);
		System.out.println("navigationVO ================> " + navigationVO);
		return responseVO;
	}
	
	@PostMapping("/add/nav")
	public ResponseVO createNavigationLink(@RequestBody NavigationVO userVO) {
		ResponseVO responseVO = new ResponseVO();
		navigationLinkTransaction.createNavigationLink(userVO);
		responseVO.setPayload(userVO);
		return responseVO;
	}
	
	@GetMapping("/get/nav/{navId}")
	public ResponseVO getNavigationByNavId(@PathVariable("navId") Integer navId) {
		ResponseVO responseVO = new ResponseVO();
		NavigationVO navigationVO = navigationLinkTransaction.getNavigationByNavId(navId);
		responseVO.setPayload(navigationVO);
		return responseVO;
	}
	
	@DeleteMapping("/delete/nav/{navId}")
	public ResponseVO deleteNavigationByNavId(@PathVariable("navId") Integer navId) {
		ResponseVO responseVO = new ResponseVO();
		 navigationLinkTransaction.deleteNavigationByNavId(navId);
		responseVO.setMes(navId + "Deleted successuly!");
		return responseVO;
	}
	
	@PutMapping("/update/nav")
	public ResponseVO updateNavigationByNavId(@RequestBody NavigationVO navigationVO) {
		ResponseVO responseVO = new ResponseVO();
		System.out.println("NavigationVO ===Updated Navigation link==========> " + navigationVO);

		 navigationLinkTransaction.updateNavigationLink(navigationVO);
		responseVO.setMes(navigationVO + " Data updated successuly!");
		return responseVO;
	}
	
	
	
}
