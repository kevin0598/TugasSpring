package id.wilayah.TugasSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.wilayah.TugasSpring.entity.DesaEntity;

public interface DesaRepository extends JpaRepository<DesaEntity, Integer> {
	@Query(value = "select kode_kabupaten from desa where id=?", nativeQuery = true)
	String findKabupaten(Integer id);

	@Query(value = "select * from desa where status=?", nativeQuery = true)
	List<DesaEntity> findStatus(String string);

	@Query(value = "select kode_provinsi from desa where id=?", nativeQuery = true)
	String findProvinsi(Integer id);

	@Query(value = "select kode_kecamatan from desa where id=?", nativeQuery = true)
	String findKecamatan(Integer id);

	@Query(value = "select * from desa where kode_provinsi=?", nativeQuery = true)
	List<DesaEntity> findBykodeProvinsi(String Kode);

	@Query(value = "select * from desa where kode_kabupaten=?", nativeQuery = true)
	List<DesaEntity> findBykodeKabupaten(String Kode);

	@Query(value = "select * from desa where kode_kecamatan=?", nativeQuery = true)
	List<DesaEntity> findBykodeKecamatan(String Kode);

	DesaEntity findByKodeDesa(String kode);
}
