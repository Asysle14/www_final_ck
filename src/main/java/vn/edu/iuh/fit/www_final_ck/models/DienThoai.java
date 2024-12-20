package vn.edu.iuh.fit.www_final_ck.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dien_thoai")
public class DienThoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ma_dien_thoai", nullable = false)
    private Long maDienThoai;

    @Size(max = 50)
    @NotNull
    @Column(name = "ten_dien_thoai", nullable = false, length = 50)
    private String tenDienThoai;

    @Size(max = 50)
    @NotNull
    @Column(name = "dia_chi", nullable = false, length = 50)
    private String diaChi;

    @Size(max = 50)
    @NotNull
    @Column(name = "gia_von", nullable = false, length = 50)
    private String giaVon;

    @Size(max = 50)
    @NotNull
    @Column(name = "loai", nullable = false, length = 50)
    private String loai;

    @Size(max = 50)
    @NotNull
    @Column(name = "nha_cung_cap", nullable = false, length = 50)
    private String nhaCungCap;

}