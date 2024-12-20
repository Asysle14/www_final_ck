package vn.edu.iuh.fit.www_final_ck.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "loai_dien_thoai")
public class LoaiDienThoai {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    //TODO [Reverse Engineering] generate columns from DB
}