package id.wilayah.TugasSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.wilayah.TugasSpring.dto.DesaDto;
import id.wilayah.TugasSpring.entity.DesaEntity;
import id.wilayah.TugasSpring.entity.KabupatenEntity;
import id.wilayah.TugasSpring.entity.KecamatanEntity;
import id.wilayah.TugasSpring.entity.ProvinsiEntity;
import id.wilayah.TugasSpring.repository.DesaRepository;
import id.wilayah.TugasSpring.repository.KabupatenRepository;
import id.wilayah.TugasSpring.repository.KecamatanRepository;
import id.wilayah.TugasSpring.repository.ProvinsiRepository;

@Service
@Transactional
public class DesaServiceImpl implements DesaService{
	@Autowired
	KabupatenRepository kabupaten;
	
	@Autowired
	KecamatanRepository kecamatan;
	
	@Autowired
	ProvinsiRepository provinsi;
	
	@Autowired
	DesaRepository desa;

	@Override
	public List<DesaEntity> getAll() {
		List<DesaEntity> desaEntities=desa.findAll();
		return desaEntities;
	}

	@Override
	public DesaEntity post(DesaDto Dto) {
		DesaEntity desaEntity=convertDesaEntity(Dto);
		ProvinsiEntity provinsiEntity=provinsi.findByKodeProvinsi(Dto.getKodeProvinsi());
		KabupatenEntity kabupatenEntity=kabupaten.findByKodeKabupaten(Dto.getKodeKabupaten());
		KecamatanEntity kecamatanEntity=kecamatan.findBykodeKecamatan(Dto.getKodeKecamatan());
		desaEntity.setKodeKabupaten(kabupatenEntity);
		desaEntity.setKodeKecamatan(kecamatanEntity);
		desaEntity.setKodeProvinsi(provinsiEntity);
		desa.save(desaEntity);
		return desaEntity;
	}

	@Override
	public DesaEntity update(Integer id, DesaDto Dto) {
		DesaEntity desaEntity=desa.findById(id).get();
		desaEntity.setKodeDesa(Dto.getKodeKecamatan()+"."+Dto.getKodeDesa());
		desaEntity.setNamaDesa(Dto.getNamaDesa());		
		desa.save(desaEntity);
		return desaEntity;	
	}

	@Override
	public DesaEntity delete(Integer id) {
		DesaEntity desaEntity=desa.findById(id).get();
		desa.delete(desaEntity);
		return desaEntity;
	}

	@Override
	public DesaEntity getById(Integer id) {
		DesaEntity desaEntity=desa.findById(id).get();
		return desaEntity;
	}

	@Override
	public DesaEntity getByKodeDesa(String kode) {
		DesaEntity desaEntity=desa.findByKodeDesa(kode);
		return desaEntity;
	}

	@Override
	public List<DesaEntity> getByKodeKecamatan(String kode) {
		List<DesaEntity> desaEntities = desa.findBykodeKecamatan(kode);
		return desaEntities;
	}

	@Override
	public List<DesaEntity> getByKodeKabupaten(String kode) {
		List<DesaEntity> desaEntities = desa.findBykodeKabupaten(kode);
		return desaEntities;
	}

	@Override
	public List<DesaEntity> getByKodeProvinsi(String kode) {
		List<DesaEntity> desaEntities = desa.findBykodeProvinsi(kode);
		return desaEntities;
	}
	
	public DesaEntity convertDesaEntity(DesaDto Dto) {
		DesaEntity desaEntity=new DesaEntity();
		desaEntity.setKodeDesa(Dto.getKodeKecamatan()+"."+Dto.getKodeDesa());
		desaEntity.setNamaDesa(Dto.getNamaDesa());		
		return desaEntity;
	}

}
