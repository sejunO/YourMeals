package com.oijoa.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.oijoa.dao.AccountTransferDao;
import com.oijoa.dao.BasketDao;
import com.oijoa.dao.BoardDao;
import com.oijoa.dao.BoardLikeDao;
import com.oijoa.dao.CategoryDao;
import com.oijoa.dao.CommentDao;
import com.oijoa.dao.DeliveryCompanyDao;
import com.oijoa.dao.FollowDao;
import com.oijoa.dao.NoticeDao;
import com.oijoa.dao.NoticeTypeDao;
import com.oijoa.dao.OrderDao;
import com.oijoa.dao.OrderListDao;
import com.oijoa.dao.PaymentDao;
import com.oijoa.dao.ProductDao;
import com.oijoa.dao.QnADao;
import com.oijoa.dao.RecipeDao;
import com.oijoa.dao.UserDao;
import com.oijoa.dao.mariadb.AccountTransferDaoImpl;
import com.oijoa.dao.mariadb.BasketDaoImpl;
import com.oijoa.dao.mariadb.BoardDaoImpl;
import com.oijoa.dao.mariadb.BoardLikeDaoImpl;
import com.oijoa.dao.mariadb.CategoryDaoImpl;
import com.oijoa.dao.mariadb.CommentDaoImpl;
import com.oijoa.dao.mariadb.DeliveryCompanyDaoImpl;
import com.oijoa.dao.mariadb.FollowDaoImpl;
import com.oijoa.dao.mariadb.NoticeDaoImpl;
import com.oijoa.dao.mariadb.NoticeTypeDaoImpl;
import com.oijoa.dao.mariadb.OrderDaoImpl;
import com.oijoa.dao.mariadb.OrderListDaoImpl;
import com.oijoa.dao.mariadb.PaymentDaoImpl;
import com.oijoa.dao.mariadb.ProductDaoImpl;
import com.oijoa.dao.mariadb.QnADaoImpl;
import com.oijoa.dao.mariadb.RecipeDaoImpl;
import com.oijoa.dao.mariadb.UserDaoImpl;
import com.oijoa.service.AccountTransferService;
import com.oijoa.service.BasketService;
import com.oijoa.service.BoardLikeService;
import com.oijoa.service.BoardService;
import com.oijoa.service.CategoryService;
import com.oijoa.service.CommentService;
import com.oijoa.service.DefaultAccountTransferService;
import com.oijoa.service.DefaultBasketService;
import com.oijoa.service.DefaultBoardLikeService;
import com.oijoa.service.DefaultBoardService;
import com.oijoa.service.DefaultCategoryService;
import com.oijoa.service.DefaultCommentService;
import com.oijoa.service.DefaultDeliveryCompanyService;
import com.oijoa.service.DefaultFollowService;
import com.oijoa.service.DefaultNoticeService;
import com.oijoa.service.DefaultNoticeTypeService;
import com.oijoa.service.DefaultOrderListService;
import com.oijoa.service.DefaultOrderService;
import com.oijoa.service.DefaultPaymentService;
import com.oijoa.service.DefaultProductService;
import com.oijoa.service.DefaultQnaService;
import com.oijoa.service.DefaultRecipeService;
import com.oijoa.service.DefaultUserService;
import com.oijoa.service.DeliveryCompanyService;
import com.oijoa.service.FollowService;
import com.oijoa.service.NoticeService;
import com.oijoa.service.NoticeTypeService;
import com.oijoa.service.OrderListService;
import com.oijoa.service.OrderService;
import com.oijoa.service.PaymentService;
import com.oijoa.service.ProductService;
import com.oijoa.service.QnaService;
import com.oijoa.service.RecipeService;
import com.oijoa.service.UserService;
import com.oijoa.util.SqlSessionFactoryProxy;

@WebListener
public class DataHandlerListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // 시스템에서 사용할 객체를 준비한다.
    try {
      // Mybatis 객체 준비
      SqlSessionFactoryProxy sqlSessionFactory =
          new SqlSessionFactoryProxy(new SqlSessionFactoryBuilder()
              .build(Resources.getResourceAsStream("com/oijoa/conf/mybatis-config.xml")));

      // DAO 구현체 생성
      BoardDao boardDao = new BoardDaoImpl(sqlSessionFactory);
      AccountTransferDao accountTransferDao = new AccountTransferDaoImpl(sqlSessionFactory);
      BasketDao basketDao = new BasketDaoImpl(sqlSessionFactory);
      BoardLikeDao boardLikeDao = new BoardLikeDaoImpl(sqlSessionFactory);
      CategoryDao categoryDao = new CategoryDaoImpl(sqlSessionFactory);
      CommentDao commentDao = new CommentDaoImpl(sqlSessionFactory);
      DeliveryCompanyDao deliveryCompanyDao = new DeliveryCompanyDaoImpl(sqlSessionFactory);
      FollowDao followDao = new FollowDaoImpl(sqlSessionFactory);
      // KakaopayDao kakopayDao = new KakaopayDaoImpl(sqlSessionFactory);
      // LevelDao levelDao = new LevelDaoImpl(sqlSessionFactory);
      // MaterialDao materialDao = new MaterialDaoImpl(sqlSessionFactory);
      // MemberDao memberDao = new MemberDaoImpl(sqlSessionFactory);
      NoticeDao noticeDao = new NoticeDaoImpl(sqlSessionFactory);
      NoticeTypeDao noticeTypeDao = new NoticeTypeDaoImpl(sqlSessionFactory);
      OrderDao orderDao = new OrderDaoImpl(sqlSessionFactory);
      OrderListDao orderListDao = new OrderListDaoImpl(sqlSessionFactory);
      ProductDao productDao = new ProductDaoImpl(sqlSessionFactory);
      RecipeDao recipeDao = new RecipeDaoImpl(sqlSessionFactory);
      QnADao qnaDao = new QnADaoImpl(sqlSessionFactory);
      PaymentDao paymentDao = new PaymentDaoImpl(sqlSessionFactory);
      // RecipeStepDao recipeStepDao = new RecipeStepDaoImpl(sqlSessionFactory);
      // RefundDao refundDao = new RefundDaoImpl(sqlSessionFactory);
      // ReportDao reportDao = new ReportDaoImpl(sqlSessionFactory);
      // ReportTypeDao reportTypeDao = new ReportTypeDaoImpl(sqlSessionFactory);
      UserDao userDao = new UserDaoImpl(sqlSessionFactory);


      // Service 구현체 생성
      BoardService boardService = new DefaultBoardService(boardDao);
      AccountTransferService accountTransferService =
          new DefaultAccountTransferService(accountTransferDao);
      BasketService basketService = new DefaultBasketService(basketDao);
      BoardLikeService boardLikeService = new DefaultBoardLikeService(boardLikeDao);
      CategoryService categoryService = new DefaultCategoryService(categoryDao);
      CommentService commentService = new DefaultCommentService(commentDao);
      DeliveryCompanyService deliveryCompanyService =
          new DefaultDeliveryCompanyService(deliveryCompanyDao);
      FollowService followService = new DefaultFollowService(followDao);

      // KakaoPayService kakaoPayService = new DefaultKakaoPayService(kakaoPayDao);
      // LevelService levelService = new DefaultLevelService(levelDao);
      // MaterialService materialService = new DefaultMaterialService(materialDao);
      // MemberService memberService = new DefaultMemberService(memberDao);
      NoticeService noticeService = new DefaultNoticeService(noticeDao);
      NoticeTypeService noticeTypeService = new DefaultNoticeTypeService(noticeTypeDao);

      OrderService orderService = new DefaultOrderService(orderDao);
      OrderListService orderListService = new DefaultOrderListService(orderListDao);
      ProductService productService = new DefaultProductService(productDao);
      RecipeService recipeService = new DefaultRecipeService(recipeDao);
      QnaService qnaService = new DefaultQnaService(qnaDao);
      PaymentService paymentService = new DefaultPaymentService(paymentDao);

      // RecipeStepService RecipeStepService = new DefaultRecipeStepService(RecipeStepDao);
      // RefundService refundService = new DefaultRefundService(refundDao);
      // ReportService reportService = new DefaultReportService(reportDao);
      // ReportTypeService reportTypeService = new DefaultReportTypeService(reportTypeDao);
      UserService userService = new DefaultUserService(userDao);

      // 다른 객체가 사용할 수 있도록 context 맵 보관소에 저장해둔다.
      ServletContext ctx = sce.getServletContext();
      ctx.setAttribute("boardService", boardService);
      ctx.setAttribute("accountTransferService", accountTransferService);
      ctx.setAttribute("basketService", basketService);
      ctx.setAttribute("boardLikeService", boardLikeService);
      ctx.setAttribute("categoryService", categoryService);
      ctx.setAttribute("commentService", commentService);
      ctx.setAttribute("deliveryCompanyService", deliveryCompanyService);
      ctx.setAttribute("followService", followService);

      // ctx.setAttribute("kakopayService", kakopayService);
      // ctx.setAttribute("levelService", levelService);
      // ctx.setAttribute("materialService", materialService);
      // ctx.setAttribute("memberService", memberService);
      ctx.setAttribute("noticeService", noticeService);
      ctx.setAttribute("noticeTypeService", noticeTypeService);

      ctx.setAttribute("orderService", orderService);
      ctx.setAttribute("productService", productService);
      ctx.setAttribute("recipeService", recipeService);
      ctx.setAttribute("orderListService", orderListService);
      ctx.setAttribute("qnaService", qnaService);
      ctx.setAttribute("paymentService", paymentService);

      // ctx.setAttribute("recipeStepService", recipeStepService);
      // ctx.setAttribute("refundService", refundService);
      // ctx.setAttribute("reportService", reportService);
      // ctx.setAttribute("reportTypeService", reportTypeService);
      ctx.setAttribute("userService", userService);


    } catch (Exception e) {
      System.out.println("Mybatis 및 DAO, 서비스 객체 준비 중 오류 발생!");
      e.printStackTrace();
    }
  }

}
