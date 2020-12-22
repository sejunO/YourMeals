package com.oijoa.web.admin;

import java.io.File;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import com.oijoa.domain.Product;
import com.oijoa.domain.User;
import com.oijoa.service.ProductService;
import com.oijoa.service.UserService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
@RequestMapping("/admin")
public class AdminController {
  @Autowired
  ProductService productService;

  @Autowired
  ServletContext servletContext;
  @Autowired
  UserService userService;

  @GetMapping("index")
  public void index(Model model) throws Exception {
    model.addAttribute("userList", userService.list());
  }

  @GetMapping("userDetail")
  public String list(int no, HttpSession session) throws Exception {
    session.setAttribute("thisUser", userService.get(no));
    return "redirect:index";
  }

  @PostMapping("userUpdate")
  public String update(User user, HttpSession session) throws Exception {
    userService.update(user);
    session.setAttribute("thisUser", user);
    return "redirect:index";
  }

  @RequestMapping("productList")
  public void list(Model model) throws Exception {
    model.addAttribute("list", productService.list(null));
  }

  @RequestMapping("productAdd")
  public String add(String title, String content, int price, int stock, int discount,
      MultipartFile photoFile) throws Exception {
    Product product = new Product();
    product.setTitle(title);
    product.setContent(content);
    product.setDiscount(discount);
    product.setPrice(price);
    product.setStock(stock);


    String filename = UUID.randomUUID().toString();
    String saveFilePath = servletContext.getRealPath("/upload/" + filename);
    photoFile.transferTo(new File(saveFilePath));

    product.setPhoto(filename);
    generatePhotoThumbnail(saveFilePath);


    productService.add(product);
    return "redirect:productList";
  }

  @GetMapping("productDetail")
  public String productDetail(int no, HttpSession session) throws Exception {
    session.setAttribute("thisProduct", productService.get(no));
    return "redirect:index";
  }

  @RequestMapping("productForm")
  public void form() throws Exception {}

  private void generatePhotoThumbnail(String saveFilePath) {
    try {
      Thumbnails.of(saveFilePath).size(80, 80).outputFormat("jpg").crop(Positions.CENTER)
          .toFiles(new Rename() {
            @Override
            public String apply(String name, ThumbnailParameter param) {
              return name + "_80x80";
            }
          });

      Thumbnails.of(saveFilePath).size(200, 200).outputFormat("jpg").crop(Positions.CENTER)
          .toFiles(new Rename() {
            @Override
            public String apply(String name, ThumbnailParameter param) {
              return name + "_200x200";
            }
          });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
