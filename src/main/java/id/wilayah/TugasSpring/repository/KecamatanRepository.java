package id.wilayah.TugasSpring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import id.wilayah.TugasSpring.entity.KecamatanEntity;

public interface KecamatanRepository extends JpaRepository<KecamatanEntity, Integer> {
	@Query(value = "select kode_kabupaten from kecamatan where id=?", nativeQuery = true)
	String findKabupaten(Integer id);

	@Query(value = "select kode_provinsi from kecamatan where id=?", nativeQuery = true)
	String findProvinsi(Integer id);

	@Query(value = "select kode_kabupaten from kecamatan where kode_kecamatan=?", nativeQuery = true)
	String findKecamatan(String string);

	KecamatanEntity findBykodeKecamatan(String Kode);

	@Query(value = "select * from kecamatan where status=?", nativeQuery = true)
	List<KecamatanEntity> findStatus(String string);

	@Query(value = "SELECT kode_kecamatan FROM kecamatan WHERE kode_kecamatan=?", nativeQuery = true)
	String findByEntity(String string);

	@Query(value = "select * from kecamatan where kode_provinsi=?", nativeQuery = true)
	List<KecamatanEntity> findBykodeProvinsi(String Kode);

	@Query(value = "select * from kecamatan where kode_kabupaten=?", nativeQuery = true)
	List<KecamatanEntity> findBykodeKabupaten(String Kode);
}
