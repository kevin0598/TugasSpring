package id.wilayah.TugasSpring.service;

import java.util.List;

import id.wilayah.TugasSpring.dto.ProvinsiDto;
import id.wilayah.TugasSpring.entity.ProvinsiEntity;

public interface ProvinsiService {
	ProvinsiEntity insertProvinsi(ProvinsiDto Dto);	
	List<ProvinsiEntity> getAll();
	ProvinsiEntity updateProvinsi(Integer id,ProvinsiDto Dto);
	ProvinsiEntity deleteProvinsi(Integer id);
	ProvinsiEntity getbyid(String kodeProvinsi);
}
