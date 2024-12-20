package vn.edu.iuh.fit.www_final_ck.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
            model.addAttribute("listDienThoai", dienThoaiService.findByTenDienThoai(keyword));
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
    public String addDienThoai(DienThoai dienThoai) {
        dienThoaiService.save(dienThoai);
        return "redirect:/dienthoai/list";
    }

    @GetMapping("/edit")
    public String editDienThoai( Long id, Model model) {
        DienThoai dienThoai = dienThoaiService.findById(id);
        model.addAttribute("dienThoai", dienThoai);
        return "dienthoai/edit";
    }

    @PostMapping("/edit")
    public String updateDienThoai(DienThoai dienThoai) {
        dienThoaiService.update(dienThoai);
        return "redirect:/dienthoai/list";
    }

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
