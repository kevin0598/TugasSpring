package id.wilayah.TugasSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.wilayah.TugasSpring.dto.KabupatenDto;
import id.wilayah.TugasSpring.entity.KabupatenEntity;
import id.wilayah.TugasSpring.entity.ProvinsiEntity;
import id.wilayah.TugasSpring.repository.KabupatenRepository;
import id.wilayah.TugasSpring.repository.ProvinsiRepository;

@Service
@Transactional
public class KabupatenServiceImpl implements KabupatenService {
	@Autowired
	ProvinsiRepository provinsiRepo;
	
	@Autowired
	KabupatenRepository kabupatenRepository;

	@Override
	public List<KabupatenEntity> getAll() {		
		List<KabupatenEntity> kabupatenEntities=kabupatenRepository.findAll();
		return kabupatenEntities;
	}

	@Override
	public KabupatenEntity kabupatenEntity(KabupatenDto Dto) {
		KabupatenEntity kabupatenEntity=convertToPersonEntity(Dto);
		ProvinsiEntity provinsiEntity=provinsiRepo.findByKodeProvinsi(Dto.getKodeProvinsi());
		kabupatenEntity.setEntity(provinsiEntity);
		kabupatenEntity.setStatus("Active");
		kabupatenRepository.save(kabupatenEntity);
		return kabupatenEntity;
	}
	
	public KabupatenEntity convertToPersonEntity(KabupatenDto Dto) {
		KabupatenEntity kabupatenEntity=new KabupatenEntity();
		kabupatenEntity.setKodeKabupaten(Dto.getKodeProvinsi()+"."+Dto.getKodeKabupaten());
		kabupatenEntity.setNamaKabupaten(Dto.getNamaKabupaten());
		return kabupatenEntity;
	}

	@Override
	public KabupatenEntity updateKabupaten(Integer id, KabupatenDto Dto) {
		KabupatenEntity kabupatenEntity=kabupatenRepository.findById(id).get();
		kabupatenEntity.setKodeKabupaten(Dto.getKodeProvinsi()+"."+Dto.getKodeKabupaten());
		kabupatenEntity.setNamaKabupaten(Dto.getNamaKabupaten());		
		kabupatenRepository.save(kabupatenEntity);
		return kabupatenEntity;
	}
	
	

	@Override
	public KabupatenEntity delete(Integer id) {
		KabupatenEntity kabupatenEntity=kabupatenRepository.findById(id).get();
		kabupatenEntity.setStatus("Deleted");
		kabupatenRepository.save(kabupatenEntity);
		return kabupatenEntity;
	}

	@Override
	public List<KabupatenEntity> getbyid(String kodeString) {
		List<KabupatenEntity> kabupatenEntity=kabupatenRepository.findKabupatenEntity(kodeString);
		return kabupatenEntity;
	}
	
	@Override	
	public KabupatenEntity getbykode(String kodeString) {
		KabupatenEntity kabupatenEntity = kabupatenRepository.findByKodeKabupaten(kodeString);
		return kabupatenEntity;
	}

	@Override
	public KabupatenEntity getId(Integer id) {
		KabupatenEntity kabupatenEntities=kabupatenRepository.findById(id).get();		
		return kabupatenEntities;
	}

	@Override
	public List<KabupatenEntity> getStatus(String status) {
		List<KabupatenEntity> kabupatenEntity=kabupatenRepository.findStatus(status);
		return kabupatenEntity;
	}
	
}
