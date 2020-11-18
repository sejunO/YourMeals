-- 회원
DROP TABLE IF EXISTS oi_user RESTRICT;

-- 레시피
DROP TABLE IF EXISTS oi_recipe RESTRICT;

-- 주문
DROP TABLE IF EXISTS oi_order RESTRICT;

-- 재료
DROP TABLE IF EXISTS oi_material RESTRICT;

-- 공지사항
DROP TABLE IF EXISTS oi_notice RESTRICT;

-- 요리유형
DROP TABLE IF EXISTS oi_category RESTRICT;

-- 레시피재료
DROP TABLE IF EXISTS oi_recipe_material RESTRICT;

-- 레시피요리유형
DROP TABLE IF EXISTS oi_recipe_category RESTRICT;

-- 팔로잉
DROP TABLE IF EXISTS oi_follow RESTRICT;

-- 댓글
DROP TABLE IF EXISTS oi_comment RESTRICT;

-- 상품
DROP TABLE IF EXISTS oi_product RESTRICT;

-- 레시피단계
DROP TABLE IF EXISTS oi_recipe_step RESTRICT;

-- 공지사항분류
DROP TABLE IF EXISTS oi_notice_type RESTRICT;

-- QNA
DROP TABLE IF EXISTS oi_qna RESTRICT;

-- 난이도
DROP TABLE IF EXISTS oi_level RESTRICT;

-- 게시글좋아요
DROP TABLE IF EXISTS oi_board_like RESTRICT;

-- 장바구니
DROP TABLE IF EXISTS oi_basket RESTRICT;

-- 환불
DROP TABLE IF EXISTS oi_refund RESTRICT;

-- 신고
DROP TABLE IF EXISTS oi_report RESTRICT;

-- 배송사
DROP TABLE IF EXISTS oi_delivery_company RESTRICT;

-- 결제방법
DROP TABLE IF EXISTS oi_payment RESTRICT;

-- 계좌이체
DROP TABLE IF EXISTS oi_account_transfer RESTRICT;

-- 카카오페이
DROP TABLE IF EXISTS oi_kakaopay RESTRICT;

-- 주문항목
DROP TABLE IF EXISTS oi_order_list RESTRICT;

-- 신고유형
DROP TABLE IF EXISTS oi_report_type RESTRICT;

-- 회원
CREATE TABLE oi_user (
  uno      INTEGER      NOT NULL COMMENT '사용자번호', -- 사용자번호
  name     VARCHAR(50)  NOT NULL COMMENT '이름', -- 이름
  nick     VARCHAR(50)  NOT NULL COMMENT '닉네임', -- 닉네임
  email    VARCHAR(40)  NOT NULL COMMENT '이메일', -- 이메일
  password VARCHAR(50)  NOT NULL COMMENT '암호', -- 암호
  point    INTEGER      NOT NULL COMMENT '포인트', -- 포인트
  postno   VARCHAR(6)   NULL     COMMENT '우편번호', -- 우편번호
  addr     VARCHAR(255) NULL     COMMENT '기본주소', -- 기본주소
  det_addr VARCHAR(255) NULL     COMMENT '상세주소', -- 상세주소
  photo    VARCHAR(255) NULL     COMMENT '사진', -- 사진
  utype    INTEGER      NOT NULL COMMENT '회원유형' -- 회원유형
)
COMMENT '회원';

-- 회원
ALTER TABLE oi_user
  ADD CONSTRAINT PK_oi_user -- 회원 기본키
    PRIMARY KEY (
      uno -- 사용자번호
    );

-- 회원 유니크 인덱스
CREATE UNIQUE INDEX UIX_oi_user
  ON oi_user ( -- 회원
    nick ASC,  -- 닉네임
    email ASC  -- 이메일
  );

ALTER TABLE oi_user
  MODIFY COLUMN uno INTEGER NOT NULL AUTO_INCREMENT COMMENT '사용자번호';

-- 레시피
CREATE TABLE oi_recipe (
  rno     INTEGER      NOT NULL COMMENT '레시피번호', -- 레시피번호
  uno     INTEGER      NOT NULL COMMENT '사용자번호', -- 사용자번호
  title   VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
  content MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
  photo   VARCHAR(255) NULL     COMMENT '사진', -- 사진
  hits    INTEGER      NOT NULL COMMENT '조회수', -- 조회수
  rcmd    INTEGER      NOT NULL COMMENT '추천수', -- 추천수
  cdt     DATETIME     NOT NULL DEFAULT now()
   COMMENT '작성일', -- 작성일
  mdt     DATETIME     NULL     COMMENT '수정일', -- 수정일
  min     INTEGER      NOT NULL COMMENT '조리시간', -- 조리시간
  lno     INTEGER      NOT NULL COMMENT '난이도번호' -- 난이도번호
)
COMMENT '레시피';

-- 레시피
ALTER TABLE oi_recipe
  ADD CONSTRAINT PK_oi_recipe -- 레시피 기본키
    PRIMARY KEY (
      rno -- 레시피번호
    );

ALTER TABLE oi_recipe
  MODIFY COLUMN rno INTEGER NOT NULL AUTO_INCREMENT COMMENT '레시피번호';

-- 주문
CREATE TABLE oi_order (
  odno     INTEGER      NOT NULL COMMENT '주문번호', -- 주문번호
  uno      INTEGER      NOT NULL COMMENT '사용자번호', -- 사용자번호
  odt      DATETIME     NOT NULL DEFAULT now() COMMENT '주문일자', -- 주문일자
  pno      INTEGER      NOT NULL COMMENT '결제방법번호', -- 결제방법번호
  dcno     INTEGER      NOT NULL COMMENT '배송사번호', -- 배송사번호
  transno  VARCHAR(20)  NULL     COMMENT '운송장번호', -- 운송장번호
  memo     MEDIUMTEXT   NULL     COMMENT '배송메모', -- 배송메모
  postno   VARCHAR(6)   NOT NULL COMMENT '배송지우편번호', -- 배송지우편번호
  addr     VARCHAR(255) NOT NULL COMMENT '배송지기본주소', -- 배송지기본주소
  det_addr VARCHAR(255) NOT NULL COMMENT '배송지상세주소', -- 배송지상세주소
  stat     INTEGER      NOT NULL COMMENT '주문상태' -- 주문상태
)
COMMENT '주문';

-- 주문
ALTER TABLE oi_order
  ADD CONSTRAINT PK_oi_order -- 주문 기본키
    PRIMARY KEY (
      odno -- 주문번호
    );

ALTER TABLE oi_order
  MODIFY COLUMN odno INTEGER NOT NULL AUTO_INCREMENT COMMENT '주문번호';

-- 재료
CREATE TABLE oi_material (
  mno  INTEGER      NOT NULL COMMENT '재료번호', -- 재료번호
  name VARCHAR(255) NOT NULL COMMENT '재료이름' -- 재료이름
)
COMMENT '재료';

-- 재료
ALTER TABLE oi_material
  ADD CONSTRAINT PK_oi_material -- 재료 기본키
    PRIMARY KEY (
      mno -- 재료번호
    );

ALTER TABLE oi_material
  MODIFY COLUMN mno INTEGER NOT NULL AUTO_INCREMENT COMMENT '재료번호';

-- 공지사항
CREATE TABLE oi_notice (
  nono    INTEGER      NOT NULL COMMENT '공지사항번호', -- 공지사항번호
  ntno    INTEGER      NOT NULL COMMENT '공지사항분류번호', -- 공지사항분류번호
  title   VARCHAR(255) NOT NULL COMMENT '제목', -- 제목
  content MEDIUMTEXT   NOT NULL COMMENT '내용', -- 내용
  rdt     DATETIME     NOT NULL DEFAULT now() COMMENT '등록일' -- 등록일
)
COMMENT '공지사항';

-- 공지사항
ALTER TABLE oi_notice
  ADD CONSTRAINT PK_oi_notice -- 공지사항 기본키
    PRIMARY KEY (
      nono -- 공지사항번호
    );

ALTER TABLE oi_notice
  MODIFY COLUMN nono INTEGER NOT NULL AUTO_INCREMENT COMMENT '공지사항번호';

-- 요리유형
CREATE TABLE oi_category (
  cno  INTEGER     NOT NULL COMMENT '요리유형번호', -- 요리유형번호
  name VARCHAR(50) NOT NULL COMMENT '유형명' -- 유형명
)
COMMENT '요리유형';

-- 요리유형
ALTER TABLE oi_category
  ADD CONSTRAINT PK_oi_category -- 요리유형 기본키
    PRIMARY KEY (
      cno -- 요리유형번호
    );

ALTER TABLE oi_category
  MODIFY COLUMN cno INTEGER NOT NULL AUTO_INCREMENT COMMENT '요리유형번호';

-- 레시피재료
CREATE TABLE oi_recipe_material (
  mno INTEGER NOT NULL COMMENT '재료번호', -- 재료번호
  rno INTEGER NOT NULL COMMENT '레시피번호' -- 레시피번호
)
COMMENT '레시피재료';

-- 레시피재료
ALTER TABLE oi_recipe_material
  ADD CONSTRAINT PK_oi_recipe_material -- 레시피재료 기본키
    PRIMARY KEY (
      mno, -- 재료번호
      rno  -- 레시피번호
    );

-- 레시피요리유형
CREATE TABLE oi_recipe_category (
  rno INTEGER NOT NULL COMMENT '레시피번호', -- 레시피번호
  cno INTEGER NOT NULL COMMENT '요리유형번호' -- 요리유형번호
)
COMMENT '레시피요리유형';

-- 레시피요리유형
ALTER TABLE oi_recipe_category
  ADD CONSTRAINT PK_oi_recipe_category -- 레시피요리유형 기본키
    PRIMARY KEY (
      rno, -- 레시피번호
      cno  -- 요리유형번호
    );

-- 팔로잉
CREATE TABLE oi_follow (
  follower  INTEGER NOT NULL COMMENT '팔로워', -- 팔로워
  following INTEGER NOT NULL COMMENT '팔로잉대상' -- 팔로잉대상
)
COMMENT '팔로잉';

-- 팔로잉
ALTER TABLE oi_follow
  ADD CONSTRAINT PK_oi_follow -- 팔로잉 기본키
    PRIMARY KEY (
      follower,  -- 팔로워
      following  -- 팔로잉대상
    );

-- 댓글
CREATE TABLE oi_comment (
  cno     INTEGER    NOT NULL COMMENT '댓글번호', -- 댓글번호
  uno     INTEGER    NOT NULL COMMENT '사용자번호', -- 사용자번호
  rno     INTEGER    NOT NULL COMMENT '레시피번호', -- 레시피번호
  content MEDIUMTEXT NULL     COMMENT '댓글내용', -- 댓글내용
  cdt     DATETIME   NOT NULL DEFAULT now() COMMENT '작성일', -- 작성일
  mdt     DATETIME   NULL     COMMENT '수정일' -- 수정일
)
COMMENT '댓글';

-- 댓글
ALTER TABLE oi_comment
  ADD CONSTRAINT PK_oi_comment -- 댓글 기본키
    PRIMARY KEY (
      cno -- 댓글번호
    );

ALTER TABLE oi_comment
  MODIFY COLUMN cno INTEGER NOT NULL AUTO_INCREMENT COMMENT '댓글번호';

-- 상품
CREATE TABLE oi_product (
  pno      INTEGER      NOT NULL COMMENT '상품번호', -- 상품번호
  mno      INTEGER      NOT NULL COMMENT '재료번호', -- 재료번호
  content  VARCHAR(255) NOT NULL COMMENT '내용', -- 내용
  stock    INTEGER      NOT NULL COMMENT '재고', -- 재고
  price    INTEGER      NOT NULL COMMENT '단위가격', -- 단위가격
  discount INTEGER      NOT NULL COMMENT '할인금액' -- 할인금액
)
COMMENT '상품';

-- 상품
ALTER TABLE oi_product
  ADD CONSTRAINT PK_oi_product -- 상품 기본키
    PRIMARY KEY (
      pno -- 상품번호
    );

ALTER TABLE oi_product
  MODIFY COLUMN pno INTEGER NOT NULL AUTO_INCREMENT COMMENT '상품번호';

-- 레시피단계
CREATE TABLE oi_recipe_step (
  rsno    INTEGER      NOT NULL COMMENT '레시피단계번호', -- 레시피단계번호
  rno     INTEGER      NOT NULL COMMENT '레시피번호', -- 레시피번호
  step    INTEGER      NOT NULL COMMENT '순서', -- 순서
  photo   VARCHAR(255) NULL     COMMENT '사진', -- 사진
  content MEDIUMTEXT   NOT NULL COMMENT '내용' -- 내용
)
COMMENT '레시피단계';

-- 레시피단계
ALTER TABLE oi_recipe_step
  ADD CONSTRAINT PK_oi_recipe_step -- 레시피단계 기본키
    PRIMARY KEY (
      rsno -- 레시피단계번호
    );

-- 레시피단계 유니크 인덱스
CREATE UNIQUE INDEX UIX_oi_recipe_step
  ON oi_recipe_step ( -- 레시피단계
    rno ASC,  -- 레시피번호
    step ASC  -- 순서
  );

ALTER TABLE oi_recipe_step
  MODIFY COLUMN rsno INTEGER NOT NULL AUTO_INCREMENT COMMENT '레시피단계번호';

-- 공지사항분류
CREATE TABLE oi_notice_type (
  ntno INTEGER     NOT NULL COMMENT '공지사항분류번호', -- 공지사항분류번호
  name VARCHAR(50) NOT NULL COMMENT '분류명' -- 분류명
)
COMMENT '공지사항분류';

-- 공지사항분류
ALTER TABLE oi_notice_type
  ADD CONSTRAINT PK_oi_notice_type -- 공지사항분류 기본키
    PRIMARY KEY (
      ntno -- 공지사항분류번호
    );

ALTER TABLE oi_notice_type
  MODIFY COLUMN ntno INTEGER NOT NULL AUTO_INCREMENT COMMENT '공지사항분류번호';

-- QNA
CREATE TABLE oi_qna (
  qnano   INTEGER    NOT NULL COMMENT 'QNA번호', -- QNA번호
  uno     INTEGER    NOT NULL COMMENT '사용자번호', -- 사용자번호
  content MEDIUMTEXT NOT NULL COMMENT '내용', -- 내용
  cdt     DATETIME   NOT NULL DEFAULT  now() COMMENT '작성일', -- 작성일
  secret  INTEGER    NOT NULL COMMENT '비밀글여부', -- 비밀글여부
  answer  MEDIUMTEXT NULL     COMMENT '답변내용', -- 답변내용
  adt     DATETIME   NULL     COMMENT '답변일' -- 답변일
)
COMMENT 'QNA';

-- QNA
ALTER TABLE oi_qna
  ADD CONSTRAINT PK_oi_qna -- QNA 기본키
    PRIMARY KEY (
      qnano -- QNA번호
    );

ALTER TABLE oi_qna
  MODIFY COLUMN qnano INTEGER NOT NULL AUTO_INCREMENT COMMENT 'QNA번호';

-- 난이도
CREATE TABLE oi_level (
  lno INTEGER NOT NULL COMMENT '난이도번호', -- 난이도번호
  lv  INTEGER NOT NULL COMMENT '난이도' -- 난이도
)
COMMENT '난이도';

-- 난이도
ALTER TABLE oi_level
  ADD CONSTRAINT PK_oi_level -- 난이도 기본키
    PRIMARY KEY (
      lno -- 난이도번호
    );

ALTER TABLE oi_level
  MODIFY COLUMN lno INTEGER NOT NULL AUTO_INCREMENT COMMENT '난이도번호';

-- 게시글좋아요
CREATE TABLE oi_board_like (
  uno INTEGER  NOT NULL COMMENT '사용자번호', -- 사용자번호
  rno INTEGER  NOT NULL COMMENT '레시피번호', -- 레시피번호
  rdt DATETIME NOT NULL DEFAULT now() COMMENT '등록일' -- 등록일
)
COMMENT '게시글좋아요';

-- 게시글좋아요
ALTER TABLE oi_board_like
  ADD CONSTRAINT PK_oi_board_like -- 게시글좋아요 기본키
    PRIMARY KEY (
      uno, -- 사용자번호
      rno  -- 레시피번호
    );

-- 장바구니
CREATE TABLE oi_basket (
  bkno   INTEGER NOT NULL COMMENT '장바구니번호', -- 장바구니번호
  pno    INTEGER NOT NULL COMMENT '상품번호', -- 상품번호
  amount INTEGER NOT NULL COMMENT '개수', -- 개수
  uno    INTEGER NOT NULL COMMENT '사용자번호' -- 사용자번호
)
COMMENT '장바구니';

-- 장바구니
ALTER TABLE oi_basket
  ADD CONSTRAINT PK_oi_basket -- 장바구니 기본키
    PRIMARY KEY (
      bkno -- 장바구니번호
    );

ALTER TABLE oi_basket
  MODIFY COLUMN bkno INTEGER NOT NULL AUTO_INCREMENT COMMENT '장바구니번호';

-- 환불
CREATE TABLE oi_refund (
  odno INTEGER    NOT NULL COMMENT '주문번호', -- 주문번호
  rdt  DATETIME   NOT NULL DEFAULT now() COMMENT '접수일', -- 접수일
  rsn  MEDIUMTEXT NULL     COMMENT '환불사유', -- 환불사유
  pdt  DATETIME   NOT NULL COMMENT '처리일', -- 처리일
  stat INTEGER    NOT NULL COMMENT '처리상태' -- 처리상태
)
COMMENT '환불';

-- 환불
ALTER TABLE oi_refund
  ADD CONSTRAINT PK_oi_refund -- 환불 기본키
    PRIMARY KEY (
      odno -- 주문번호
    );

-- 신고
CREATE TABLE oi_report (
  rpno     INTEGER    NOT NULL COMMENT '신고번호', -- 신고번호
  reporter INTEGER    NOT NULL COMMENT '신고자', -- 신고자
  attacker INTEGER    NOT NULL COMMENT '피신고자', -- 피신고자
  rtno     INTEGER    NOT NULL COMMENT '신고유형번호', -- 신고유형번호
  content  MEDIUMTEXT NOT NULL COMMENT '내용', -- 내용
  rdt      DATETIME   NOT NULL DEFAULT now() COMMENT '신고일', -- 신고일
  stat     INTEGER    NOT NULL COMMENT '처리상태' -- 처리상태
)
COMMENT '신고';

-- 신고
ALTER TABLE oi_report
  ADD CONSTRAINT PK_oi_report -- 신고 기본키
    PRIMARY KEY (
      rpno -- 신고번호
    );

ALTER TABLE oi_report
  MODIFY COLUMN rpno INTEGER NOT NULL AUTO_INCREMENT COMMENT '신고번호';

-- 배송사
CREATE TABLE oi_delivery_company (
  dcno INTEGER     NOT NULL COMMENT '배송사번호', -- 배송사번호
  name VARCHAR(50) NOT NULL COMMENT '배송사' -- 배송사
)
COMMENT '배송사';

-- 배송사
ALTER TABLE oi_delivery_company
  ADD CONSTRAINT PK_oi_delivery_company -- 배송사 기본키
    PRIMARY KEY (
      dcno -- 배송사번호
    );

ALTER TABLE oi_delivery_company
  MODIFY COLUMN dcno INTEGER NOT NULL AUTO_INCREMENT COMMENT '배송사번호';

-- 결제방법
CREATE TABLE oi_payment (
  pno  INTEGER     NOT NULL COMMENT '결제방법번호', -- 결제방법번호
  name VARCHAR(50) NOT NULL COMMENT '결제방법명' -- 결제방법명
)
COMMENT '결제방법';

-- 결제방법
ALTER TABLE oi_payment
  ADD CONSTRAINT PK_oi_payment -- 결제방법 기본키
    PRIMARY KEY (
      pno -- 결제방법번호
    );

ALTER TABLE oi_payment
  MODIFY COLUMN pno INTEGER NOT NULL AUTO_INCREMENT COMMENT '결제방법번호';

-- 계좌이체
CREATE TABLE oi_account_transfer (
  odno    INTEGER     NOT NULL COMMENT '주문번호', -- 주문번호
  name    VARCHAR(50) NOT NULL COMMENT '사용자명', -- 사용자명
  account VARCHAR(20) NOT NULL COMMENT '계좌번호', -- 계좌번호
  tdt     DATETIME    NOT NULL DEFAULT now() COMMENT '입금날짜', -- 입금날짜
  bname   VARCHAR(50) NOT NULL COMMENT '은행명' -- 은행명
)
COMMENT '계좌이체';

-- 계좌이체
ALTER TABLE oi_account_transfer
  ADD CONSTRAINT PK_oi_account_transfer -- 계좌이체 기본키
    PRIMARY KEY (
      odno -- 주문번호
    );

-- 카카오페이
CREATE TABLE oi_kakaopay (
  odno    INTEGER     NOT NULL COMMENT '주문번호', -- 주문번호
  name    VARCHAR(50) NOT NULL COMMENT '사용자명', -- 사용자명
  account VARCHAR(20) NOT NULL COMMENT '계좌번호', -- 계좌번호
  tdt     DATETIME    NOT NULL DEFAULT now() COMMENT '입금날짜' -- 입금날짜
)
COMMENT '카카오페이';

-- 카카오페이
ALTER TABLE oi_kakaopay
  ADD CONSTRAINT PK_oi_kakaopay -- 카카오페이 기본키
    PRIMARY KEY (
      odno -- 주문번호
    );

-- 주문항목
CREATE TABLE oi_order_list (
  olno     INTEGER NOT NULL COMMENT '주문항목번호', -- 주문항목번호
  odno     INTEGER NOT NULL COMMENT '주문번호', -- 주문번호
  pno      INTEGER NOT NULL COMMENT '상품번호', -- 상품번호
  amount   INTEGER NOT NULL COMMENT '개수', -- 개수
  discount INTEGER NOT NULL COMMENT '할인금액', -- 할인금액
  price    INTEGER NOT NULL COMMENT '단위가격' -- 단위가격
)
COMMENT '주문항목';

-- 주문항목
ALTER TABLE oi_order_list
  ADD CONSTRAINT PK_oi_order_list -- 주문항목 기본키
    PRIMARY KEY (
      olno -- 주문항목번호
    );

-- 주문항목 유니크 인덱스
CREATE UNIQUE INDEX UIX_oi_order_list
  ON oi_order_list ( -- 주문항목
    odno ASC, -- 주문번호
    pno ASC   -- 상품번호
  );

ALTER TABLE oi_order_list
  MODIFY COLUMN olno INTEGER NOT NULL AUTO_INCREMENT COMMENT '주문항목번호';

-- 신고유형
CREATE TABLE oi_report_type (
  rtno INTEGER     NOT NULL COMMENT '신고유형번호', -- 신고유형번호
  name VARCHAR(50) NOT NULL COMMENT '신고유형명' -- 신고유형명
)
COMMENT '신고유형';

-- 신고유형
ALTER TABLE oi_report_type
  ADD CONSTRAINT PK_oi_report_type -- 신고유형 기본키
    PRIMARY KEY (
      rtno -- 신고유형번호
    );

ALTER TABLE oi_report_type
  MODIFY COLUMN rtno INTEGER NOT NULL AUTO_INCREMENT COMMENT '신고유형번호';

-- 레시피
ALTER TABLE oi_recipe
  ADD CONSTRAINT FK_oi_user_TO_oi_recipe -- 회원 -> 레시피
    FOREIGN KEY (
      uno -- 사용자번호
    )
    REFERENCES oi_user ( -- 회원
      uno -- 사용자번호
    );

-- 레시피
ALTER TABLE oi_recipe
  ADD CONSTRAINT FK_oi_level_TO_oi_recipe -- 난이도 -> 레시피
    FOREIGN KEY (
      lno -- 난이도번호
    )
    REFERENCES oi_level ( -- 난이도
      lno -- 난이도번호
    );

-- 주문
ALTER TABLE oi_order
  ADD CONSTRAINT FK_oi_user_TO_oi_order -- 회원 -> 주문
    FOREIGN KEY (
      uno -- 사용자번호
    )
    REFERENCES oi_user ( -- 회원
      uno -- 사용자번호
    );

-- 주문
ALTER TABLE oi_order
  ADD CONSTRAINT FK_oi_delivery_company_TO_oi_order -- 배송사 -> 주문
    FOREIGN KEY (
      dcno -- 배송사번호
    )
    REFERENCES oi_delivery_company ( -- 배송사
      dcno -- 배송사번호
    );

-- 주문
ALTER TABLE oi_order
  ADD CONSTRAINT FK_oi_payment_TO_oi_order -- 결제방법 -> 주문
    FOREIGN KEY (
      pno -- 결제방법번호
    )
    REFERENCES oi_payment ( -- 결제방법
      pno -- 결제방법번호
    );

-- 공지사항
ALTER TABLE oi_notice
  ADD CONSTRAINT FK_oi_notice_type_TO_oi_notice -- 공지사항분류 -> 공지사항
    FOREIGN KEY (
      ntno -- 공지사항분류번호
    )
    REFERENCES oi_notice_type ( -- 공지사항분류
      ntno -- 공지사항분류번호
    );

-- 레시피재료
ALTER TABLE oi_recipe_material
  ADD CONSTRAINT FK_oi_recipe_TO_oi_recipe_material -- 레시피 -> 레시피재료
    FOREIGN KEY (
      rno -- 레시피번호
    )
    REFERENCES oi_recipe ( -- 레시피
      rno -- 레시피번호
    );

-- 레시피재료
ALTER TABLE oi_recipe_material
  ADD CONSTRAINT FK_oi_material_TO_oi_recipe_material -- 재료 -> 레시피재료
    FOREIGN KEY (
      mno -- 재료번호
    )
    REFERENCES oi_material ( -- 재료
      mno -- 재료번호
    );

-- 레시피요리유형
ALTER TABLE oi_recipe_category
  ADD CONSTRAINT FK_oi_category_TO_oi_recipe_category -- 요리유형 -> 레시피요리유형
    FOREIGN KEY (
      cno -- 요리유형번호
    )
    REFERENCES oi_category ( -- 요리유형
      cno -- 요리유형번호
    );

-- 레시피요리유형
ALTER TABLE oi_recipe_category
  ADD CONSTRAINT FK_oi_recipe_TO_oi_recipe_category -- 레시피 -> 레시피요리유형
    FOREIGN KEY (
      rno -- 레시피번호
    )
    REFERENCES oi_recipe ( -- 레시피
      rno -- 레시피번호
    );

-- 팔로잉
ALTER TABLE oi_follow
  ADD CONSTRAINT FK_oi_user_TO_oi_follow2 -- 회원 -> 팔로잉
    FOREIGN KEY (
      follower -- 팔로워
    )
    REFERENCES oi_user ( -- 회원
      uno -- 사용자번호
    );

-- 팔로잉
ALTER TABLE oi_follow
  ADD CONSTRAINT FK_oi_user_TO_oi_follow -- 회원 -> 팔로잉2
    FOREIGN KEY (
      following -- 팔로잉대상
    )
    REFERENCES oi_user ( -- 회원
      uno -- 사용자번호
    );

-- 댓글
ALTER TABLE oi_comment
  ADD CONSTRAINT FK_oi_user_TO_oi_comment -- 회원 -> 댓글
    FOREIGN KEY (
      uno -- 사용자번호
    )
    REFERENCES oi_user ( -- 회원
      uno -- 사용자번호
    );

-- 댓글
ALTER TABLE oi_comment
  ADD CONSTRAINT FK_oi_recipe_TO_oi_comment -- 레시피 -> 댓글
    FOREIGN KEY (
      rno -- 레시피번호
    )
    REFERENCES oi_recipe ( -- 레시피
      rno -- 레시피번호
    );

-- 상품
ALTER TABLE oi_product
  ADD CONSTRAINT FK_oi_material_TO_oi_product -- 재료 -> 상품
    FOREIGN KEY (
      mno -- 재료번호
    )
    REFERENCES oi_material ( -- 재료
      mno -- 재료번호
    );

-- 레시피단계
ALTER TABLE oi_recipe_step
  ADD CONSTRAINT FK_oi_recipe_TO_oi_recipe_step -- 레시피 -> 레시피단계
    FOREIGN KEY (
      rno -- 레시피번호
    )
    REFERENCES oi_recipe ( -- 레시피
      rno -- 레시피번호
    );

-- QNA
ALTER TABLE oi_qna
  ADD CONSTRAINT FK_oi_user_TO_oi_qna -- 회원 -> QNA
    FOREIGN KEY (
      uno -- 사용자번호
    )
    REFERENCES oi_user ( -- 회원
      uno -- 사용자번호
    );

-- 게시글좋아요
ALTER TABLE oi_board_like
  ADD CONSTRAINT FK_oi_user_TO_oi_board_like -- 회원 -> 게시글좋아요
    FOREIGN KEY (
      uno -- 사용자번호
    )
    REFERENCES oi_user ( -- 회원
      uno -- 사용자번호
    );

-- 게시글좋아요
ALTER TABLE oi_board_like
  ADD CONSTRAINT FK_oi_recipe_TO_oi_board_like -- 레시피 -> 게시글좋아요
    FOREIGN KEY (
      rno -- 레시피번호
    )
    REFERENCES oi_recipe ( -- 레시피
      rno -- 레시피번호
    );

-- 장바구니
ALTER TABLE oi_basket
  ADD CONSTRAINT FK_oi_product_TO_oi_basket -- 상품 -> 장바구니
    FOREIGN KEY (
      pno -- 상품번호
    )
    REFERENCES oi_product ( -- 상품
      pno -- 상품번호
    );

-- 장바구니
ALTER TABLE oi_basket
  ADD CONSTRAINT FK_oi_user_TO_oi_basket -- 회원 -> 장바구니
    FOREIGN KEY (
      uno -- 사용자번호
    )
    REFERENCES oi_user ( -- 회원
      uno -- 사용자번호
    );

-- 환불
ALTER TABLE oi_refund
  ADD CONSTRAINT FK_oi_order_TO_oi_refund -- 주문 -> 환불
    FOREIGN KEY (
      odno -- 주문번호
    )
    REFERENCES oi_order ( -- 주문
      odno -- 주문번호
    );

-- 신고
ALTER TABLE oi_report
  ADD CONSTRAINT FK_oi_user_TO_oi_report2 -- 회원 -> 신고
    FOREIGN KEY (
      reporter -- 신고자
    )
    REFERENCES oi_user ( -- 회원
      uno -- 사용자번호
    );

-- 신고
ALTER TABLE oi_report
  ADD CONSTRAINT FK_oi_user_TO_oi_report -- 회원 -> 신고2
    FOREIGN KEY (
      attacker -- 피신고자
    )
    REFERENCES oi_user ( -- 회원
      uno -- 사용자번호
    );

-- 신고
ALTER TABLE oi_report
  ADD CONSTRAINT FK_oi_report_type_TO_oi_report -- 신고유형 -> 신고
    FOREIGN KEY (
      rtno -- 신고유형번호
    )
    REFERENCES oi_report_type ( -- 신고유형
      rtno -- 신고유형번호
    );

-- 계좌이체
ALTER TABLE oi_account_transfer
  ADD CONSTRAINT FK_oi_order_TO_oi_account_transfer -- 주문 -> 계좌이체
    FOREIGN KEY (
      odno -- 주문번호
    )
    REFERENCES oi_order ( -- 주문
      odno -- 주문번호
    );

-- 카카오페이
ALTER TABLE oi_kakaopay
  ADD CONSTRAINT FK_oi_order_TO_oi_kakaopay -- 주문 -> 카카오페이
    FOREIGN KEY (
      odno -- 주문번호
    )
    REFERENCES oi_order ( -- 주문
      odno -- 주문번호
    );

-- 주문항목
ALTER TABLE oi_order_list
  ADD CONSTRAINT FK_oi_order_TO_oi_order_list -- 주문 -> 주문항목
    FOREIGN KEY (
      odno -- 주문번호
    )
    REFERENCES oi_order ( -- 주문
      odno -- 주문번호
    );

-- 주문항목
ALTER TABLE oi_order_list
  ADD CONSTRAINT FK_oi_product_TO_oi_order_list -- 상품 -> 주문항목
    FOREIGN KEY (
      pno -- 상품번호
    )
    REFERENCES oi_product ( -- 상품
      pno -- 상품번호
    );