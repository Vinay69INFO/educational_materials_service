package com.educational.material.transactions.interfaces;

import java.util.List;

import com.educational.material.vo.NavigationVO;

public interface NavigationLinkTransaction {
	
	public List<NavigationVO> getAllNavigationLink(String status);
	
	public void createNavigationLink(NavigationVO navigationVO);
	
	public List<NavigationVO> getNavigationLinkByLogedInUser();
	
	public NavigationVO getNavigationByNavId(Integer navId);
	
	public void deleteNavigationByNavId(Integer navId);

	public void updateNavigationLink(NavigationVO navigationVO);


}
