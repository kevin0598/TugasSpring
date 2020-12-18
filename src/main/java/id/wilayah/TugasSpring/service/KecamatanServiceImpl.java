package id.wilayah.TugasSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import id.wilayah.TugasSpring.dto.KecamatanDto;
import id.wilayah.TugasSpring.entity.KabupatenEntity;
import id.wilayah.TugasSpring.entity.KecamatanEntity;
import id.wilayah.TugasSpring.entity.ProvinsiEntity;
import id.wilayah.TugasSpring.repository.KabupatenRepository;
import id.wilayah.TugasSpring.repository.KecamatanRepository;
import id.wilayah.TugasSpring.repository.ProvinsiRepository;

@Service
@Transactional
public class KecamatanServiceImpl implements KecamatanService {
	@Autowired
	ProvinsiRepository repo3;

	@Autowired
	KabupatenRepository repo2;

	@Autowired
	KecamatanRepository repo;

	@Override
	public List<KecamatanEntity> getAll() {
		List<KecamatanEntity> kecamatanEntity = repo.findAll();
		return kecamatanEntity;
	}

	@Override
	public KecamatanEntity insert(KecamatanDto Dto) {

		KecamatanEntity kecamatanEntity = convertToPersonEntity(Dto);
		ProvinsiEntity provinsiEntity = repo3.findByKodeProvinsi(Dto.getKodeProvinsi());
		KabupatenEntity kabupatenEntity = repo2.findByKodeKabupaten(Dto.getKodeKabupaten());
		kecamatanEntity.setKodeProvinsi(provinsiEntity);
		kecamatanEntity.setKodeKabupaten(kabupatenEntity);
		kecamatanEntity.setStatus("Active");
		repo.save(kecamatanEntity);
		return kecamatanEntity;
	}

	public KecamatanEntity convertToPersonEntity(KecamatanDto dto) {
		KecamatanEntity kecamatanEntity = new KecamatanEntity();
		kecamatanEntity.setKodeKecamatan(dto.getKodeKabupaten() + "." + dto.getKodeKecamatan());
		kecamatanEntity.setNamaKecamatan(dto.getNamaKecamatan());
		return kecamatanEntity;
	}

	@Override
	public KecamatanEntity update(Integer id, KecamatanDto Dto) {
		KecamatanEntity kecamatanEntity = repo.findById(id).get();
		kecamatanEntity.setKodeKecamatan(Dto.getKodeKabupaten() + "." + Dto.getKodeKecamatan());
		kecamatanEntity.setNamaKecamatan(Dto.getNamaKecamatan());
		repo.save(kecamatanEntity);
		return kecamatanEntity;
	}

	@Override
	public KecamatanEntity delete(Integer id) {
		KecamatanEntity kecamatanEntity = repo.findById(id).get();
		kecamatanEntity.setStatus("Deleted");
		repo.save(kecamatanEntity);
		return kecamatanEntity;
	}

	@Override
	public List<KecamatanEntity> getKodeProvinsi(String kode) {
		List<KecamatanEntity> kecamatanEntity = repo.findBykodeProvinsi(kode);
		return kecamatanEntity;
	}

	@Override
	public List<KecamatanEntity> getKodeKabupaten(String kode) {
		List<KecamatanEntity> kecamatanEntity = repo.findBykodeKabupaten(kode);
		return kecamatanEntity;
	}

	@Override
	public KecamatanEntity getKodeKecamatan(String kode) {
		KecamatanEntity kecamatanEntity = repo.findBykodeKecamatan(kode);
		return kecamatanEntity;
	}

	@Override
	public KecamatanEntity getById(Integer id) {
		KecamatanEntity kecamatanEntity = repo.findById(id).get();
		return kecamatanEntity;
	}

	@Override
	public List<KecamatanEntity> getStatus(String status) {
		List<KecamatanEntity> kecamatanEntity = repo.findStatus(status);
		return kecamatanEntity;
	}

}
