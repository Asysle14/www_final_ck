package vn.edu.iuh.fit.www_final_ck.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.www_final_ck.models.DienThoai;
import vn.edu.iuh.fit.www_final_ck.repositories.DienThoaiRepository;

import java.util.List;

@Service
public class DienThoaiService {
    private final DienThoaiRepository dienThoaiRepository;

    public DienThoaiService(DienThoaiRepository dienThoaiRepository) {
        this.dienThoaiRepository = dienThoaiRepository;
    }

    public DienThoai save(DienThoai dienThoai) {
        return dienThoaiRepository.save(dienThoai);
    }

    public DienThoai update(DienThoai dienThoai) {
        return dienThoaiRepository.save(dienThoai);
    }

    public boolean deleteById(Long id) {
        if (dienThoaiRepository.existsById(id)) {
            dienThoaiRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<DienThoai> findAll() {
        return dienThoaiRepository.findAll(Sort.by("giaVon").and(Sort.by("nhaCungCap")));
    }

    public DienThoai findById(Long id) {
        return dienThoaiRepository.findById(id).orElseThrow(() -> new RuntimeException("DienThoai with id " + id + " does not exist"));
    }

    public List<DienThoai> findByTenDienThoaiOrDiaChi(String keyword) {
        return dienThoaiRepository.findByTenDienThoaiContainingOrDiaChiContaining(keyword, keyword);
    }





}
