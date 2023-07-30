package com.educational.material.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educational.material.entity.NavigationEntity;
import com.educational.material.entity.SellerEntity;
import com.educational.material.repository.NavigationLinkRepo;
import com.educational.material.repository.SellerRepo;
import com.educational.material.services.interfaces.NavigationLinkService;
import com.educational.material.vo.NavigationVO;

@Service
public class NavigationLinkServicesImpli implements NavigationLinkService{
	@Autowired private NavigationLinkRepo navigationLinkRepo; 
	@Autowired private SellerRepo sellerRepo;
		
	
	@Override
	public List<NavigationVO> getAllNavigationLink(String status) {
		List<NavigationEntity> navigationEntity = navigationLinkRepo.getAllNavigationLinkByStatus(status);
		return getNavigationVO(navigationEntity);
	}

	private List<NavigationVO> getNavigationVO(List<NavigationEntity> entitys ) {
		List<NavigationVO> VOs = entitys.stream().map(entity ->  
				new NavigationVO(entity.getNavId(), entity.getNavTitle(), entity.getNavUrl(), entity.getNavStatus(),
						entity.getCreatedBy(), entity.getCreatedTimeStamp(), entity.getLastUpdatedBy(), entity.getLastUpdatedTimeStamp())
			).collect(Collectors.toList());
		
		return VOs;
	}
	
	/*
	 * 
	 * NavigationVO navigationVO = new NavigationVO();
		navigationVO.setTitle(entity.getTitle());
		navigationVO.setNavigationLink(entity.getLinked_to_nav_id());
		navigationVO.setNavStatus(entity.getNav_status());
		
	 * List<Employee> employees = persons.stream() .filter(p ->
	 * p.getLastName().equals("l1")) .map(p -> new Employee(p.getName(),
	 * p.getLastName(), 1000)) .collect(Collectors.toList());
	 */

	@Override
	public void createNavigationLink(NavigationVO navigationVO) {
		NavigationEntity navigationEntity = getNavigationEntity(navigationVO);
		
		navigationLinkRepo.save(navigationEntity);
	
	}
	


	private NavigationEntity getNavigationEntity(NavigationVO navigationVO) {
		System.out.println("NavigationVO:======> " + navigationVO);
			SellerEntity sellerEntity = sellerRepo.getById(1);
			System.out.println("sellerRepo: ===================> " + sellerEntity);
		NavigationEntity entity = new NavigationEntity();
		entity.setSellerEntity(sellerEntity);
		entity.setNavTitle(navigationVO.getNavTitle());
		entity.setNavUrl(navigationVO.getNavUrl());
		entity.setNavStatus("P");
		entity.setCreatedBy(sellerEntity.getSellerId());
		entity.setCreatedTimeStamp(LocalDateTime.now());
		return entity;
	}

	@Override
	public NavigationVO getNavigationVOByTitle(String title) {
		NavigationEntity navigationEntity = navigationLinkRepo.getNavigationEntityByTtile(title);
		
		return getNavigationVO(navigationEntity);
	}

	private NavigationVO getNavigationVO(NavigationEntity navigationEntity) {
		NavigationVO navigationVO = new NavigationVO();
		System.out.println("======================>  " + navigationEntity);
		navigationVO.setNavId(navigationEntity.getNavId());
		navigationVO.setNavTitle(navigationEntity.getNavTitle());
		navigationVO.setNavUrl(navigationEntity.getNavUrl());
		navigationVO.setNavStatus(navigationEntity.getNavStatus());
		return navigationVO;
	}

	@Override
	public List<NavigationVO> getNavigationLinkByLogedInUser() {
		List<NavigationEntity> navigationEntity = navigationLinkRepo.getNavigationLinkByLogedInUser(1l);
		return getNavigationVO(navigationEntity);
	}

	@Override
	public NavigationVO getNavigationByNavId(Integer navId) {
		NavigationEntity navigationEntity = navigationLinkRepo.getById(navId);
		return getNavigationVO(navigationEntity);
	}

	@Override
	public void deleteNavigationByNavId(Integer navId) {
		navigationLinkRepo.deleteById(navId);
	}

	@Override
	public void updateNavigationLink(NavigationVO navigationVO) {
		int navId = navigationLinkRepo.updateNavigationLink(1, navigationVO.getNavId(), navigationVO.getNavTitle(), navigationVO.getNavUrl(), LocalDateTime.now());
		//navigationLinkRepo.save(navigationEntity);
		//navigationLinkRepo
		
	}
	
	

}
