package vn.edu.iuh.fit.www_final_ck.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.www_final_ck.models.DienThoai;
import vn.edu.iuh.fit.www_final_ck.services.DienThoaiService;

@Controller
@RequestMapping("/dienthoai")
public class DienThoaiController {

    private final DienThoaiService dienThoaiService;


    public DienThoaiController(DienThoaiService dienThoaiService) {
        this.dienThoaiService = dienThoaiService;
    }

    @GetMapping("/list")
    public String getAllDienThoai(Model model) {
        model.addAttribute("listDienThoai", dienThoaiService.findAll());
        return "dienthoai/list";
    }

    @GetMapping("/search")
    public String searchDienThoai(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        if (keyword != null && !keyword.isEmpty()) {
            model.addAttribute("listDienThoai", dienThoaiService.findByTenDienThoaiOrDiaChi(keyword));
        } else {
            model.addAttribute("listDienThoai", dienThoaiService.findAll());
        }
        model.addAttribute("keyword", keyword);
        return "dienthoai/list";
    }

    @GetMapping("/add")
    public String addDienThoai() {
        return "dienthoai/add";
    }

    @PostMapping("/add")
    public ModelAndView addDienThoai(ModelAndView modelAndView, DienThoai dienThoai) {
        if (dienThoai.getTenDienThoai() == null || dienThoai.getTenDienThoai().isEmpty()) {
            modelAndView.addObject("error", "Tên Điện Thoại không được để trống");
            modelAndView.setViewName("dienthoai/add");
            return modelAndView;
        }
        if (dienThoai.getDiaChi() == null || dienThoai.getDiaChi().isEmpty()) {
            modelAndView.addObject("error", "Địa Chỉ không được để trống");
            modelAndView.setViewName("dienthoai/add");
            return modelAndView;
        }
        if (dienThoai.getGiaVon() == null ) {
            modelAndView.addObject("error", "Giá Vốn phải lớn hơn 100,000");
            modelAndView.setViewName("dienthoai/add");
            return modelAndView;
        }
        if (dienThoai.getLoai() == null || dienThoai.getLoai().isEmpty()) {
            modelAndView.addObject("error", "Loại không được để trống");
            modelAndView.setViewName("dienthoai/add");
            return modelAndView;
        }
        if (dienThoai.getNhaCungCap() == null || dienThoai.getNhaCungCap().isEmpty()) {
            modelAndView.addObject("error", "Nhà Cung Cấp không được để trống");
            modelAndView.setViewName("dienthoai/add");
            return modelAndView;
        }

        dienThoaiService.save(dienThoai);
        modelAndView.setViewName("redirect:/dienthoai/list");
        return modelAndView;
    }

    @GetMapping("/edit")
    public String editDienThoai( Long id, Model model) {
        DienThoai dienThoai = dienThoaiService.findById(id);
        model.addAttribute("dienThoai", dienThoai);
        return "dienthoai/edit";
    }

    @PostMapping("/edit")
    public ModelAndView updateDienThoai(ModelAndView modelAndView, DienThoai dienThoai) {
        if (dienThoai.getTenDienThoai() == null || dienThoai.getTenDienThoai().isEmpty()) {
            modelAndView.addObject("error", "Tên Điện Thoại không được để trống");
            modelAndView.setViewName("dienthoai/edit");
            return modelAndView;
        }
        if (dienThoai.getDiaChi() == null || dienThoai.getDiaChi().isEmpty()) {
            modelAndView.addObject("error", "Địa Chỉ không được để trống");
            modelAndView.setViewName("dienthoai/edit");
            return modelAndView;
        }
        if (dienThoai.getGiaVon() == null ) {
            modelAndView.addObject("error", "Giá Vốn phải lớn hơn 100,000");
            modelAndView.setViewName("dienthoai/edit");
            return modelAndView;
        }
        if (dienThoai.getLoai() == null || dienThoai.getLoai().isEmpty()) {
            modelAndView.addObject("error", "Loại không được để trống");
            modelAndView.setViewName("dienthoai/edit");
            return modelAndView;
        }
        if (dienThoai.getNhaCungCap() == null || dienThoai.getNhaCungCap().isEmpty()) {
            modelAndView.addObject("error", "Nhà Cung Cấp không được để trống");
            modelAndView.setViewName("dienthoai/edit");
            return modelAndView;
        }

        dienThoaiService.update(dienThoai);
        modelAndView.setViewName("redirect:/dienthoai/list");
        return modelAndView;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/delete")
    public String deleteDienThoai( Long id, Model model) {
        dienThoaiService.deleteById(id);
        return "redirect:/dienthoai/list";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public String user() {
        return "user";
    }



}
