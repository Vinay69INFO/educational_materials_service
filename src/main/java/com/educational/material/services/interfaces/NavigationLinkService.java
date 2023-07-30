package com.educational.material.services.interfaces;

import java.util.List;

import com.educational.material.vo.NavigationVO;

public interface NavigationLinkService {
	public List<NavigationVO> getAllNavigationLink(String status);
	
	public void createNavigationLink(NavigationVO navigationVO);
	
	public NavigationVO getNavigationVOByTitle(String title);

	public List<NavigationVO> getNavigationLinkByLogedInUser();

	public NavigationVO getNavigationByNavId(Integer navId);

	public void deleteNavigationByNavId(Integer navId);

	public void updateNavigationLink(NavigationVO navigationVO);

}
