package com.oijoa.web;

import java.io.File;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import com.oijoa.domain.Follow;
import com.oijoa.domain.User;
import com.oijoa.service.FollowService;
import com.oijoa.service.UserService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
@RequestMapping("/mypage/user")
@SessionAttributes("loginUser")
public class MyUserController {
  @Autowired ServletContext servletContext; // 메서드의 파라미터로 못 받는다.
  @Autowired UserService userService;
  @Autowired FollowService followService;

  @GetMapping("detail")
  public void detail(@ModelAttribute("loginUser") User loginUser, Model model) throws Exception {
    User user = userService.get(loginUser.getUserNo());
    if (user == null) {
      throw new Exception("로그인 정보가 존재하지 않습니다.");
    }
    model.addAttribute("user", user);
  }

  @PostMapping("update")
  public String update(User user) throws Exception {
    int count = userService.update(user);
    if(count == 0) {
      throw new Exception("정보 수정에 실패하였습니다.");
    }
    return "redirect:detail";
  }

  @GetMapping("detailPassword")
  public void detailPassword(@ModelAttribute("loginUser") User loginUser, Model model) throws Exception {
    User user = userService.get(loginUser.getUserNo());
    if (user == null) {
      throw new Exception("로그인 정보가 존재하지 않습니다.");
    } 
    model.addAttribute("user", user);
  }

  @PostMapping("updatePassword")
  public String updatePassword(User user) throws Exception {
    int count = userService.update(user);
    if(count == 0) {
      throw new Exception("비밀번호 변경이 실패하였습니다.");
    }
    return "redirect:detail";
  }

  @GetMapping("detailPhoto")
  public void detailPhoto(@ModelAttribute("loginUser") User loginUser, Model model) throws Exception {
    User user = userService.get(loginUser.getUserNo());
    if (user == null) {
      throw new Exception("로그인 정보가 존재하지 않습니다.");
    } 
    model.addAttribute("user", user);
  }

  @PostMapping("updatePhoto")
  public String updatePhoto(int userNo, MultipartFile photoFile) throws Exception {

    User user = new User();
    user.setUserNo(userNo);

    // 회원 사진 파일 저장
    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String saveFilePath = servletContext.getRealPath("/upload/" + filename);
      photoFile.transferTo(new File(saveFilePath));
      user.setPhoto(filename);

      // 회원 사진의 썸네일 이미지 파일 생성하기
      generatePhotoThumbnail(saveFilePath);
    }

    if (user.getPhoto() == null) {
      throw new Exception("사진을 선택하지 않았습니다.");
    }

    userService.update(user);
    return "redirect:detail";
  }

  private void generatePhotoThumbnail(String saveFilePath) {
    try {
      Thumbnails.of(saveFilePath)
      .size(30, 30)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_30x30";
        }
      });

      Thumbnails.of(saveFilePath)
      .size(120, 120)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_120x120";
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @GetMapping("followerList")
  public void followerList(@ModelAttribute("loginUser") User loginUser, Model model) throws Exception {
    List<Follow> list = followService.FollowerList(loginUser.getUserNo());
    model.addAttribute("followerList", list);
  }

  @GetMapping("followingList")
  public void followingList(@ModelAttribute("loginUser") User loginUser, Model model) throws Exception {
    List<Follow> list = followService.FollowingList(loginUser.getUserNo());
    model.addAttribute("followingList", list);
  }
}
