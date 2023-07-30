package com.educational.material.transactions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.educational.material.services.interfaces.NavigationLinkService;
import com.educational.material.transactions.interfaces.NavigationLinkTransaction;
import com.educational.material.vo.NavigationVO;

@Component
public class NavigationLinkTransactionImpli implements NavigationLinkTransaction{

	@Autowired NavigationLinkService navigationLinkService;
	
	@Override
	public List<NavigationVO> getAllNavigationLink(String status) {
		List<NavigationVO> navigationVO = navigationLinkService.getAllNavigationLink(status);
		return navigationVO;
	}

	@Override
	public void createNavigationLink(NavigationVO navigationVO) {
		navigationLinkService.createNavigationLink(navigationVO);
		
	}

	@Override
	public List<NavigationVO> getNavigationLinkByLogedInUser() {
		List<NavigationVO> navigationVOs = navigationLinkService.getNavigationLinkByLogedInUser();
		return navigationVOs;
	}

	@Override
	public NavigationVO getNavigationByNavId(Integer navId) {
		NavigationVO navigationVOs = navigationLinkService.getNavigationByNavId(navId);
		return navigationVOs;
	}

	@Override
	public void deleteNavigationByNavId(Integer navId) {
		 navigationLinkService.deleteNavigationByNavId(navId);
	}

	@Override
	public void updateNavigationLink(NavigationVO navigationVO) {
		navigationLinkService.updateNavigationLink(navigationVO);
		
	}

}
