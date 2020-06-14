package com.example.RvGuide.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RvGuide.bean.AlgorithmBean;
import com.example.RvGuide.dao.AlgorithmRepository;
import com.example.RvGuide.model.AlgorithmEntity;

@Service
public class AlgorithmServiceImpl implements AlgorithmService {

	@Autowired
	AlgorithmRepository algorithmRepository;

	@Override
	public void saveAlgorithm(AlgorithmBean algorithmBean) {
		AlgorithmEntity algorithmEntity = new AlgorithmEntity();
		BeanUtils.copyProperties(algorithmBean, algorithmEntity);
		algorithmRepository.save(algorithmEntity);
	}

	@Override
	public void updateAlgorithm(AlgorithmBean algorithmBean) {
		System.out.println("Inside update updateAlgorithm");
		System.out.println("ID-----------> "+algorithmBean.getAlgorithm_id());
		AlgorithmEntity algorithmEntity = algorithmRepository.getAlgorithmbyId(algorithmBean.getAlgorithm_id());
		algorithmEntity.setAlgorithm_data(algorithmBean.getAlgorithm_data());
		algorithmEntity.setTitle(algorithmBean.getTitle());
		algorithmRepository.save(algorithmEntity);
		System.out.println("going out update updateAlgorithm");
	}

	@Override
	public List<AlgorithmBean> getAlgorithmByEmail(String email) {
		System.out.println(" Inside servImpl");
		List<AlgorithmEntity> algorithmEntityList = algorithmRepository.getAlgorithmByEmail(email);
		System.out.println("algorithmEntityList  --->" + algorithmEntityList);
		List<AlgorithmBean> algorithmBeanList = new ArrayList<>();
		for (AlgorithmEntity algoEntity : algorithmEntityList) {
			AlgorithmBean algoBean = new AlgorithmBean();
			BeanUtils.copyProperties(algoEntity, algoBean);
			algorithmBeanList.add(algoBean);
		}
		System.out.println("Printing algo List obj --->" + algorithmBeanList);
		return algorithmBeanList;

	}

	@Override
	public AlgorithmBean getAlgorithmById(int id) {
		System.out.println("Inside getAlgorithmById");
		AlgorithmEntity entity = algorithmRepository.getAlgorithmbyId(id);
		AlgorithmBean bean = new AlgorithmBean();
		BeanUtils.copyProperties(entity, bean);
		System.out.println("Returning getAlgorithmById");
		return bean;
	}

	@Override
	public void deleteAlgorithm(AlgorithmBean algorithmBean) {
		System.out.println("Deleting ID ---->  "+algorithmBean.getAlgorithm_id());
		AlgorithmEntity algorithmEntity = new AlgorithmEntity();
		BeanUtils.copyProperties(algorithmBean, algorithmEntity);
		algorithmRepository.delete(algorithmEntity);

	}

}
