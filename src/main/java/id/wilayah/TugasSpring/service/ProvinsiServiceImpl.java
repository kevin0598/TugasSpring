package id.wilayah.TugasSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.wilayah.TugasSpring.dto.ProvinsiDto;
import id.wilayah.TugasSpring.entity.ProvinsiEntity;
import id.wilayah.TugasSpring.repository.ProvinsiRepository;

@Service
@Transactional
public class ProvinsiServiceImpl implements ProvinsiService {

	@Autowired
	ProvinsiRepository provinsiRepository;

	@Override
	public ProvinsiEntity insertProvinsi(ProvinsiDto Dto) {
		ProvinsiEntity provinsiEntity = convertToPersonEntity(Dto);
		provinsiEntity.setStatus("Active");
		provinsiRepository.save(provinsiEntity);
		return provinsiEntity;
	}

	@Override
	public List<ProvinsiEntity> getAll() {
		List<ProvinsiEntity> provinsiEntity = provinsiRepository.findAll();
		return provinsiEntity;
	}

	public ProvinsiEntity convertToPersonEntity(ProvinsiDto Dto) {
		ProvinsiEntity provinsiEntity = new ProvinsiEntity();
		provinsiEntity.setKodeProvinsi(Dto.getKodeProvinsi());
		provinsiEntity.setNamaProvinsi(Dto.getNamaProvinsi());
		return provinsiEntity;
	}

	@Override
	public ProvinsiEntity updateProvinsi(Integer id, ProvinsiDto Dto) {
		ProvinsiEntity provsinEntity = provinsiRepository.findById(id).get();
		provsinEntity.setKodeProvinsi(Dto.getKodeProvinsi());
		provsinEntity.setNamaProvinsi(Dto.getNamaProvinsi());
		provinsiRepository.save(provsinEntity);
		return provsinEntity;
	}

	@Override
	public ProvinsiEntity deleteProvinsi(Integer id) {
		ProvinsiEntity provinsiEntity = provinsiRepository.findById(id).get();
		provinsiEntity.setStatus("Deleted");
		provinsiRepository.save(provinsiEntity);
		return provinsiEntity;
	}

	@Override
	public ProvinsiEntity getbyid(String kodeProvinsi) {
		ProvinsiEntity provinsiEntities = provinsiRepository.findByKodeProvinsi(kodeProvinsi);
		return provinsiEntities;
	}

	@Override
	public List<ProvinsiEntity> getStatus(String status) {
		List<ProvinsiEntity> provinsiEntities = provinsiRepository.findStatus(status);
		return provinsiEntities;
	}

}
