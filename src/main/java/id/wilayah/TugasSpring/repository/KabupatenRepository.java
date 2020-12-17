package id.wilayah.TugasSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.wilayah.TugasSpring.entity.KabupatenEntity;

@Repository
public interface KabupatenRepository extends JpaRepository<KabupatenEntity, Integer>  {
	@Query(value="delete from kabupaten where id=?",nativeQuery = true)
	List<KabupatenEntity> delete(Integer id);
	@Query(value="select * from kabupaten where entity_kode_provinsi=?",nativeQuery = true)
	List<KabupatenEntity> findKabupatenEntity(String KodeProvinsi);
	
	@Query(value="SELECT entity_kode_provinsi FROM kabupaten WHERE id=?",nativeQuery = true)
	String findByEntity2(Integer id);
	
	@Query(value="SELECT entity_kode_provinsi FROM kabupaten WHERE kode_kabupaten=?",nativeQuery = true)
	String findByEntity(String string);
	
	KabupatenEntity findByKodeKabupaten(String kodeKabupaten);
	
}
