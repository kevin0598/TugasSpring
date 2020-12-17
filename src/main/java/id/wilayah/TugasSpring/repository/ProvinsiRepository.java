package id.wilayah.TugasSpring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.wilayah.TugasSpring.entity.ProvinsiEntity;

@Repository
public interface ProvinsiRepository extends JpaRepository<ProvinsiEntity, Integer> {	
	@Query(value="SELECT kode_provinsi FROM `provinsi` WHERE kode_provinsi=?",nativeQuery = true)
	String findByEntity(String string);
	
	ProvinsiEntity findByKodeProvinsi(String kodeProvinsi);
}