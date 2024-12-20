package vn.edu.iuh.fit.www_final_ck.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import vn.edu.iuh.fit.www_final_ck.models.DienThoai;

import java.util.List;

public interface DienThoaiRepository extends JpaRepository<DienThoai, Long>, CrudRepository<DienThoai, Long> {

    List<DienThoai> findByTenDienThoaiContainingOrDiaChiContaining(String tenDienThoai, String diaChi);
}